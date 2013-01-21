package metamorph

import Java.SourceCode
import model.CodeModel

trait Parser {
  def parse(code: SourceCode) : CodeModel
}
