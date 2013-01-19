package metamorph

import io.Source
import model.CodeModel
import refactor.CodeChange

trait Parser {
  def refactor(source: Source, changes:List[CodeChange]): CodeModel = null
}
