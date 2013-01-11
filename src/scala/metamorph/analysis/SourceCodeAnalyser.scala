package metamorph.analysis

import metamorph.model.{BlockDeclaration, MethodDeclaration, CodeModel}
import metamorph.{Signature, BucketSet}
import metamorph.Java.SourceCodeReader


/**
 * The SourceCodeAnalyser takes a list of code models built from source code files and produces a an AnalysedSourceCode
 * model based on the automated observations made on the source.
 */
class SourceCodeAnalyser {

  def analyse(provider: SourceProvider): AnalysedSourceCode = {
    var models = List[CodeModel]()

    provider.each(sourceCode => {
      val reader = new SourceCodeReader(sourceCode)

      val model = reader.read

      models = models ::: List(model)
    })

    internalAnalyse(models)
  }

  def internalAnalyse(models: List[CodeModel]): AnalysedSourceCode = {
    val modelBuckets = new BucketSet[CodeModel]

    models.foreach(model => modelBuckets.add(model.modelSignature, model))

//    findSimilarTypesByMethod(models)

    val methodBuckets = new BucketSet[MethodDeclaration]
    val blockBuckets = new BucketSet[BlockDeclaration]

    models foreach (model => {
      if (!modelBuckets.hasDuplicatesFor(model.modelSignature)) {
        model.methods foreach (method => methodBuckets.add(method.syntaxSignature, method))
        model.blocks foreach (block => blockBuckets.add(block.signature, block))
      }
    })

    markDuplicateModels(modelBuckets)

    updateModelMethodDuplicates(methodBuckets)

    updateModelBlockDuplicates(blockBuckets)

    val analysedSource = new AnalysedSourceCode(models, modelBuckets, methodBuckets, blockBuckets)
    analysedSource
  }


  private def updateModelBlockDuplicates(blockBuckets: BucketSet[BlockDeclaration]) {
    // Update code model list of duplicate blocks
    blockBuckets.eachDuplicate(dup =>
      dup.foreach(dupBlock => {
        dupBlock.codeModel.addDuplicate(dupBlock)
      }))
  }

  private def updateModelMethodDuplicates(methodBuckets: BucketSet[MethodDeclaration]) {
    // Update the code model with the list of duplicate methods
    methodBuckets.eachDuplicate(dup =>
      dup.foreach(md => {
        md.codeModel.addDuplicate(md)
      })
    )
  }

  private def markDuplicateModels(modelBuckets: BucketSet[CodeModel]) {
    modelBuckets.eachDuplicate(bucket => {
      bucket foreach (model => {
        model.duplicate = true
      })
    })
  }

  private def findSimilarTypesByMethod(models: List[CodeModel]) {
    val typeBuckets = buildTypeBucket(models)

    var duplicateMethods = Map[Signature, MethodDeclaration]()

    typeBuckets.duplicates().foreach(bucketWithDuplicates => {
      // Find a common subset of methods shared between each of the identified duplicates
      duplicateMethods = duplicateMethods ++ bucketWithDuplicates.bucket.foldLeft(Map[Signature, MethodDeclaration]()) {
        (map, cm) => {
          map ++ cm.methods.foldLeft(Map[Signature, MethodDeclaration]()) {
            (m, method) => if (m.contains(method.syntaxSignature)) m else Map(method.syntaxSignature -> method) ++ m
          }
        }
      }
    })

    duplicateMethods.foreach {
      case (sig: Signature, methodDeclaration: MethodDeclaration) => printf("Duplicate Methods shared by similar types %s\n", methodDeclaration.getName)
    }
  }

  private def buildTypeBucket(models: List[CodeModel]): BucketSet[CodeModel] = {
    val typeBuckets = new BucketSet[CodeModel]()

    models.foreach(cm => typeBuckets.add(cm.typeSignature, cm))
    typeBuckets
  }
}
