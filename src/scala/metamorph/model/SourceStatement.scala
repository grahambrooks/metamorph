package metamorph.model

import org.antlr.runtime.Token
import metamorph.model.SourceLocation

object SourceStatement {
  def fromToken(t: Token): SourceStatement = {
    if (t == null)  null else new SourceStatement(t.getLine, t.getCharPositionInLine, t.getText)
  }
}

class SourceStatement(line: Int, charPositionInLine: Int, text: String) extends SourceLocation {
  def getLine: Int = line

  def getStartCharacterOffset: Int = charPositionInLine

  def getEndCharacterOffset: Int = charPositionInLine + text.length
}
