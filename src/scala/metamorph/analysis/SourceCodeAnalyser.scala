package metamorph.analysis

import metamorph.model.{BlockDeclaration, MethodDeclaration, CodeModel}
import metamorph.{Signature, BucketSet}

class SourceCodeAnalyser {

  def analyse(models: List[CodeModel]): AnalysedSourceCode = {
    val modelBuckets = new BucketSet[CodeModel]

    models.foreach(model => modelBuckets.add(model.modelSignature, model))

    val typeBuckets = new BucketSet[CodeModel]()

    models.foreach(cm => typeBuckets.add(cm.typeSignature, cm))

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

    val methodBuckets = new BucketSet[MethodDeclaration]
    val blockBuckets = new BucketSet[BlockDeclaration]
    models foreach (model => {
      if (!modelBuckets.hasDuplicatesFor(model.modelSignature)) {
        model.methods foreach (method => methodBuckets.add(method.syntaxSignature, method))
        model.blocks foreach (block => blockBuckets.add(block.signature, block))
      }
    })

    val analysedSource = new AnalysedSourceCode(modelBuckets, methodBuckets, blockBuckets)
    analysedSource.updateAnalysis
    analysedSource
  }

}
