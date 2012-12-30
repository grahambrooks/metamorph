package metamorph.model

import metamorph.Signature

class CodeModel {
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
}
