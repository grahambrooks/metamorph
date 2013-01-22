package metamorph

import org.antlr.runtime.Token

trait QueryResults {
  def printSummaryToConsole()

  def errorProcessingFile(filename: String)

  def emptyCatchFound(ct: Token, ob: Token, token1: Token)

  def catchFound(token: Token)

  def processingFile(filename: String)

}
