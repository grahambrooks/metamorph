package CodeR

import org.antlr.runtime.Token

class CatchToken(ct: Token, ob : Token, cb: Token) {
  val catchStatement = SourceStatement.fromToken(ct)
  val closingBrace = SourceStatement.fromToken(cb)
  var openingBrace = SourceStatement.fromToken(ob)
  def line : Int = catchStatement.getLine
}
