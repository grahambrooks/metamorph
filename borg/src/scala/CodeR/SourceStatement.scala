package CodeR

import org.antlr.runtime.Token

object SourceStatement {
  def fromToken(t: Token): SourceStatement = {
    if (t == null)
      return null
    return new SourceStatement(t.getLine, t.getCharPositionInLine, t.getText)
  }
}

class SourceStatement(line: Int, charPositionInLine: Int, text: String) extends SourceLocation {
  def getLine: Int = line

  def getStartCharacterOffset: Int = charPositionInLine

  def getEndCharacterOffset: Int = charPositionInLine + text.length
}
