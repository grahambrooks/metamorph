package metamorph.parsing

import metamorph.Java.SourceCode

trait RefactoringParser {
  def refactor(source: SourceCode)
}
