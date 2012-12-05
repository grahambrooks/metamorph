package metamorph.model

import org.antlr.v4.runtime.Token

class MethodDeclaration(val nameToken: Token) {

  def name:String = nameToken.getText
}
