package CodeR.Ast

import java.io.Writer
import org.antlr.runtime.tree.CommonTree
import org.antlr.runtime.Token

class AstWriter(output: Writer) {
  def writeTree(tree: CommonTree) {
    writeTree(tree, 0)
  }

  def writeTree(node: CommonTree, indent: Int) {
    if (node.getToken != null) {
      writeIndent(indent)
      output.write("(")
      writeToken(node.getToken)

      if (node.getChildCount > 0) {
        for (t <- node.getChildren.toArray) {
          writeTree(t.asInstanceOf[CommonTree], indent + 1)
        }
      }
      output.write(")")
    }
  }

  def writeIndent(indent: Int) {
    if (indent > 0) {
      output.write("\n")

      for (i <- 1 to indent * 3) {
        output.write(" ")
      }
    }
  }

  def writeToken(token: Token) {
    output.write("type:" + token.getType +
      " line:" + token.getLine +
      " charPositionInLine:" + token.getCharPositionInLine +
      " text:" + "\"" + token.getText + "\"" +
      " index:" + token.getTokenIndex)
  }
}
