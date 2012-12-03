package metamorph.model

class CodeModel {
  var importInsertionPoint = 0
  var packageDeclaration: PackageDeclaration = null

  var imports: List[Import] = Nil

  def add(im: Import) {
    imports = imports ::: List(im)
    importInsertionPoint = im.endLineNumber
  }

  def packageLine: Int = if (packageDeclaration == null) 0 else packageDeclaration.importToken.getLine
}
