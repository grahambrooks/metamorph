package metamorph.Java

import org.antlr.v4.runtime.Token

class TextSpan(val start: Token, val stop: Token) {
  def lineCount: Int = stop.getLine - start.getLine
  override def toString = "(%d,%d)-(%d,%d)".format(start.getLine, start.getCharPositionInLine, stop.getLine, stop.getCharPositionInLine)
}
