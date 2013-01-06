package metamorph.parsing

import org.antlr.v4.runtime.misc.Utils
import scala.StringBuilder
import org.antlr.v4.runtime.tree.{Tree, TerminalNode, ErrorNode, RuleNode}
import org.antlr.v4.runtime.{Parser, Token}

object PrintingListener {
  def toStringTree(t: Tree, recognizer: Parser): String = toStringTree(t, if (recognizer != null) recognizer.getRuleNames else null)

  def toStringTree(t: Tree, ruleNames: Array[String]): String = {

    if (t.getChildCount == 0) return Utils.escapeWhitespace(getNodeText(t, ruleNames), false)

    val buf = new StringBuilder
    buf.append("(")

    buf.append(Utils.escapeWhitespace(getNodeText(t, ruleNames), false))
    buf.append(' ')

    for (i <- 0 to t.getChildCount -1) {
      if (i > 0) buf.append(' ')
      buf.append(toStringTree(t.getChild(i), ruleNames))
    }

    buf.append(")")
    buf.toString()
  }

  def getNodeText(t: Tree, recognizer: Parser): String = getNodeText(t, if (recognizer != null) recognizer.getRuleNames else null)

  def getNodeText(t: Tree, ruleNames: Array[String]): String = {
    if (ruleNames != null) {
      if (t.isInstanceOf[RuleNode]) {
        val ruleIndex = (t.asInstanceOf[RuleNode]).getRuleContext.getRuleIndex
        return ruleNames(ruleIndex)
      } else if (t.isInstanceOf[ErrorNode[_ <: Token]]) {
        return t.toString
      } else if (t.isInstanceOf[TerminalNode[_ <: Token]]) {
        val symbol = (t.asInstanceOf[TerminalNode[_]]).getSymbol

        if (symbol.isInstanceOf[Token]) {
          return (symbol.asInstanceOf[Token]).getText
        }
      }
    }

    val payload = t.getPayload
    if (payload.isInstanceOf[Token]) {
      (payload.asInstanceOf[Token]).getText
    } else {
      t.getPayload.toString
    }
  }
}
