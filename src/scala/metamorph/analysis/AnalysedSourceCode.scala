package metamorph.analysis

import metamorph.{Signature, BucketSet}
import metamorph.model.{CodeModel, BlockDeclaration, MethodDeclaration}

class AnalysedSourceCode(val modelBuckets: BucketSet[CodeModel], val methodBuckets: BucketSet[MethodDeclaration], val blockBuckets: BucketSet[BlockDeclaration]) {
  var analysedModels: List[AnalysedCodeModel] = Nil

  def updateAnalysis: List[CodeModel] = {
    var result: List[CodeModel] = List()

    var tmp = Map[Signature, AnalysedCodeModel]()

    addDuplicateModelsToAnalysedModelList

    addModelsWithDuplicateMethdsToAnalysedModels(tmp, result)

    addModelsWithDuplicateBlocksToAnalysedModelList(tmp)

    result
  }


  def addModelsWithDuplicateBlocksToAnalysedModelList(_tmp: Map[Signature, AnalysedCodeModel]) {
    var tmp: Map[Signature, AnalysedCodeModel] = _tmp
    blockBuckets.eachDuplicate(dup =>
      dup.foreach(dupBlock => {
        if (tmp.contains(dupBlock.codeModel.sourceCode.signature)) {
          tmp(dupBlock.codeModel.sourceCode.signature).addDuplicate(dupBlock)
        } else {
          val m = new AnalysedCodeModel(dupBlock.codeModel, modelBuckets.hasDuplicatesFor(dupBlock.codeModel.modelSignature))
          m.addDuplicate(dupBlock)
          analysedModels = analysedModels ::: List(m)
          tmp = tmp ++ Map(dupBlock.codeModel.sourceCode.signature -> m)
        }

      }))
  }

  def addModelsWithDuplicateMethdsToAnalysedModels(_tmp: Map[Signature, AnalysedCodeModel], _result: List[CodeModel]) {
    var tmp: Map[Signature, AnalysedCodeModel] = _tmp
    var result: List[CodeModel] = _result
    methodBuckets.eachDuplicate(dup =>
      dup.foreach(md => {

        val key = md.codeModel.sourceCode.signature
        if (tmp.contains(key)) {
          tmp(md.codeModel.sourceCode.signature).addDuplicate(md)
        } else {
          val m = new AnalysedCodeModel(md.codeModel, modelBuckets.hasDuplicatesFor(md.codeModel.modelSignature))
          m.addDuplicate(md)
          analysedModels = analysedModels ::: List(m)
          tmp = tmp ++ Map(md.codeModel.sourceCode.signature -> m)
        }

        result = result ++ List(md.codeModel)
      })
    )
  }

  def addDuplicateModelsToAnalysedModelList {
    modelBuckets.eachDuplicate(bucket => {
      bucket foreach (model => {
        analysedModels = analysedModels ::: List(new AnalysedCodeModel(model, true))
      })
    })
  }
}
