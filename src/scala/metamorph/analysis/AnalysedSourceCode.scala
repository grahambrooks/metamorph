package metamorph.analysis

import metamorph.BucketSet
import metamorph.model.{CodeModel, BlockDeclaration, MethodDeclaration}

class AnalysedCodeModel {
  var duplicateMethods:List[MethodDeclaration] = List()
  var duplicateBlocks: List[BlockDeclaration] = List()
}

class AnalysedSourceCode(val methodBuckets: BucketSet[MethodDeclaration], val blockBuckets: BucketSet[BlockDeclaration]) {
  var analysedModels: List[AnalysedCodeModel] = Nil

  def modelsWithDuplicateBlocks: List[CodeModel] = {
    var result : List[CodeModel] = List()

    methodBuckets.eachDuplicate(dup =>
      dup.foreach(md => result = result ++ List(md.codeModel))
    )

    result
  }
}
