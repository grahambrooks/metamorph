package metamorph.analysis

import metamorph.model.{BlockDeclaration, MethodDeclaration, CodeModel}
import metamorph.{Signature, BucketSet}

class SourceCodeAnalyser {

  def analyse(models: List[CodeModel]): AnalysedSourceCode = {
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
      case (sig: Signature, methodDecl: MethodDeclaration) => printf("Duplicate Methods shared by similar types %s", methodDecl.getName)
    }

    new AnalysedSourceCode(bucketMethods(models), bucketBlocks(models))
  }

  private def bucketMethods(models: List[CodeModel]): BucketSet[MethodDeclaration] = {
    val methodBuckets = new BucketSet[MethodDeclaration]
    models foreach (model => {
      model.methods foreach (method => methodBuckets.add(method.syntaxSignature, method))
    })
    methodBuckets
  }

  private def bucketBlocks(models: List[CodeModel]): BucketSet[BlockDeclaration] = {
    val blockBuckets = new BucketSet[BlockDeclaration]
    models foreach (model => {
      model.blocks foreach (block => blockBuckets.add(block.signature, block))
    })
    blockBuckets
  }

}
