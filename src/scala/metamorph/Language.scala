package metamorph

import refactor.CodeChange

trait Language {
  def refactoringParser(changes: List[CodeChange]): RefactoringParser
  def parser : Parser
}
