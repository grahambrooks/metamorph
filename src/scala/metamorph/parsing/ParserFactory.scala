package metamorph.parsing

import metamorph.Java.SourceCode
import metamorph.model.CodeModel

trait ParserFactory {
  def parse(code: SourceCode) : CodeModel
}
