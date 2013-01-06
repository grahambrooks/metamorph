package metamorph.analysis

import metamorph.Java.SourceCode

trait SourceProvider {
  def each(function: (SourceCode) => Any)
}
