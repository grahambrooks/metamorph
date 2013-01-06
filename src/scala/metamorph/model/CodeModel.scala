package metamorph.model

import metamorph.Signature
import metamorph.Java.SourceCode

class CodeModel(val sourceCode: SourceCode) {
  var duplicate: Boolean = false
  var modelSignature: Signature = null
  var typeSignature: Signature = null
  var importInsertionPoint = 0
  var packageDeclaration: PackageDeclaration = null
  var imports: List[ImportDeclaration] = Nil
  var methods: List[MethodDeclaration] = Nil
  var blocks: List[BlockDeclaration] = Nil
  var typeDeclaration: TypeDeclaration = null

  def add(im: ImportDeclaration) {
    imports = imports ::: List(im)
    importInsertionPoint = im.endLineNumber
  }

  def add(md: MethodDeclaration) {
    methods = methods ::: List(md)
  }

  def add(bd: BlockDeclaration) {
    blocks = blocks ::: List(bd)
  }

  def packageLine: Int = if (packageDeclaration == null) 0 else packageDeclaration.importToken.getLine

  def signature: Signature = modelSignature

  def name: String = sourceCode.name

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
