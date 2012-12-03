package metamorph.Java

import org.antlr.v4.runtime.CharStream
import io.Source

trait SourceCode {
  def getSource: Source

  def getInputStream: CharStream
}