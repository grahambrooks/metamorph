package metamorph.model

class CodeModel {
  var importInsertionPoint = 0

  var imports: List[Import] = Nil
  def add(im: Import) {
    imports = imports ::: List(im)
    importInsertionPoint = im.endLineNumber
  }
}
