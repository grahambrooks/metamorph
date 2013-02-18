package metamorph.model

import org.antlr.v4.runtime.Token

class QualifiedNameDeclaration(val nameTokens: List[Token]) {

  def name = nameTokens.foldLeft("") {
    (acc, n) => if (acc == "") n.getText else acc + "." + n.getText
  }
}
