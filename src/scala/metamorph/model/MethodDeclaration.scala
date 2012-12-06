package metamorph.model

import org.antlr.v4.runtime.Token
import metamorph.Java.TextSpan

class MethodDeclaration(val nameToken: Token, val span: TextSpan) {

  def name:String = nameToken.getText
}
