package metamorph.Java

import metamorph.model.CodeModel

object CodeReader {
  def apply(code: SourceCode) : CodeReader = new AntlrSourceCodeReader(code)
}

trait CodeReader {
  def read: CodeModel
}
