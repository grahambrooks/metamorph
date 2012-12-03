package metamorph.model

import org.antlr.v4.runtime.Token

class ImportDeclaration(importToken: Token, _qualifiedName: List[Token]) {

  def qualifiedName = _qualifiedName.foldLeft("") {
    (acc, n) => if (acc == "") n.getText else acc + "." + n.getText
  }

  def endLineNumber = {
    _qualifiedName.last.getLine
  }
}
