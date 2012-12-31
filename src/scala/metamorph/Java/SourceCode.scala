package metamorph.Java

import org.antlr.v4.runtime.CharStream
import io.Source

trait SourceCode {
  def branchPath: String

  def getFilename: String

  def getSource: Source
  def getName:String

  def getInputStream: CharStream
}
