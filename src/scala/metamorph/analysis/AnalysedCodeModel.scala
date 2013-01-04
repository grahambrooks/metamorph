package metamorph.analysis

import metamorph.model.{BlockDeclaration, MethodDeclaration, CodeModel}

/**
 * Created with IntelliJ IDEA.
 * User: abalcarc
 * Date: 1/4/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
class AnalysedCodeModel(val codeModel: CodeModel, duplicate: Boolean) {

  var duplicateMethods: List[MethodDeclaration] = List()
  var duplicateBlocks: List[BlockDeclaration] = List()

  def isDuplicateLine(lineNumber: Int): Boolean =
    duplicate ||
      duplicateMethods.foldLeft(false)((a, b) => if (b.span.containsLine(lineNumber)) true else a) ||
      duplicateBlocks.foldLeft(false)((a, b) => if (b.span.containsLine(lineNumber)) true else a)


  def addDuplicate(dup: MethodDeclaration) {
    duplicateMethods = duplicateMethods ::: List(dup)
  }

  def addDuplicate(dup: BlockDeclaration) {
    duplicateBlocks = duplicateBlocks ::: List(dup)
  }
}
