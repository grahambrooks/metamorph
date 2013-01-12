package metamorph.analysis

import org.antlr.v4.runtime.tree.ParseTree
import metamorph.Java.JavaParser.{MethodDeclarationContext, ExpressionContext}

class CodeStatistics {
  var complexity: Int = 0
}

object CodeStatistics {
  def fromTree(tree: ParseTree): CodeStatistics = {
    val stats = new CodeStatistics()

    if (tree != null) {
      if (tree.isInstanceOf[MethodDeclarationContext]) {
        stats.complexity = stats.complexity + 1
      }

      if (tree.isInstanceOf[ExpressionContext]) {
        stats.complexity = stats.complexity + (tree.asInstanceOf[ExpressionContext]).complexity
      }

      for (i <- 0 until tree.getChildCount) {
        val child: ParseTree = tree.getChild(i)

        stats.complexity = stats.complexity + fromTree(child).complexity
      }
    }
    stats
  }
}
