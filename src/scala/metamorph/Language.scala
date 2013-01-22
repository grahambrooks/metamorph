package metamorph

import parsing.{ParserFactory, RefactoringParser}
import refactor.CodeChange

trait Language {
  def refactoringParser(changes: List[CodeChange]): RefactoringParser
  def parser : ParserFactory
}
