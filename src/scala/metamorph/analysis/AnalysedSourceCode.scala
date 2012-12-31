package metamorph.analysis

import metamorph.BucketSet
import metamorph.model.{CodeModel, BlockDeclaration, MethodDeclaration}

class AnalysedCodeModel(val codeModel: CodeModel) {
  def isDuplicateLine(lineNumber: Int): Boolean =
    duplicateMethods.foldLeft(false)((a, b) => if (b.span.containsLine(lineNumber)) true else a) ||
      duplicateBlocks.foldLeft(false)((a, b) => if (b.span.containsLine(lineNumber)) true else a)

  var duplicateMethods: List[MethodDeclaration] = List()
  var duplicateBlocks: List[BlockDeclaration] = List()

  def addDuplicate(dup: MethodDeclaration) {
    duplicateMethods = duplicateMethods ::: List(dup)
  }

  def addDuplicate(dup: BlockDeclaration) {
    duplicateBlocks = duplicateBlocks ::: List(dup)
  }
}

class AnalysedSourceCode(val methodBuckets: BucketSet[MethodDeclaration], val blockBuckets: BucketSet[BlockDeclaration]) {
  var analysedModels: List[AnalysedCodeModel] = Nil

  def modelsWithDuplicateBlocks: List[CodeModel] = {
    var result: List[CodeModel] = List()

    var tmp = Map[String,  AnalysedCodeModel]()

    methodBuckets.eachDuplicate(dup =>
      dup.foreach(md => {

        val key: String = md.codeModel.sourceCode.getFilename
        if (tmp.contains(key)) {
          tmp(md.codeModel.sourceCode.getFilename).addDuplicate(md)
        } else {
          val m = new AnalysedCodeModel(md.codeModel)
          m.addDuplicate(md)
          analysedModels = analysedModels ::: List(m)
          tmp = tmp ++ Map(md.codeModel.sourceCode.getFilename -> m)
        }

        result = result ++ List(md.codeModel)
      })
    )

    blockBuckets.eachDuplicate(dup =>
      dup.foreach(dupBlock => {
        if (tmp.contains(dupBlock.codeModel.sourceCode.getFilename)) {
          tmp(dupBlock.codeModel.sourceCode.getFilename).addDuplicate(dupBlock)
        } else {
          val m = new AnalysedCodeModel(dupBlock.codeModel)
          m.addDuplicate(dupBlock)
          analysedModels = analysedModels ::: List(m)
          tmp = tmp ++ Map(dupBlock.codeModel.sourceCode.getFilename -> m)
        }

      }))

    result
  }

  def duplicateMethod(md: MethodDeclaration) {
    var tmp = Map[String,  AnalysedCodeModel]()
    val key: String = md.codeModel.sourceCode.getFilename
    if (tmp.contains(key)) {
      tmp(md.codeModel.sourceCode.getFilename).addDuplicate(md)
    } else {
      val m = new AnalysedCodeModel(md.codeModel)
      m.addDuplicate(md)
      analysedModels = analysedModels ::: List(m)
      tmp = tmp ++ Map(md.codeModel.sourceCode.getFilename -> m)
    }
  }

  def duplicateBlock(dupBlock: BlockDeclaration) {
    var tmp = Map[String, AnalysedCodeModel]()
    if (tmp.contains(dupBlock.codeModel.sourceCode.getFilename)) {
      tmp(dupBlock.codeModel.sourceCode.getFilename).addDuplicate(dupBlock)
    } else {
      val m = new AnalysedCodeModel(dupBlock.codeModel)
      m.addDuplicate(dupBlock)
      analysedModels = analysedModels ::: List(m)
      tmp = tmp ++ Map(dupBlock.codeModel.sourceCode.getFilename -> m)
    }
  }
}
