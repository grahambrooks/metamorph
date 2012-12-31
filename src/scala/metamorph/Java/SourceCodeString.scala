package metamorph.Java

import org.antlr.v4.runtime.ANTLRInputStream
import io.Source

class SourceCodeString(text: String) extends SourceCode {
  def getInputStream = new ANTLRInputStream(text)

  def getSource = Source.fromString(text)

  def getFilename = "STRING"
  def getName = "STRING"

  def branchPath = {
    throw new UnsupportedOperationException
  }
}
