package CodeR.CSharp.Parser

import org.scalatest.FlatSpec
import CodeR.CSharp.csParser
import org.antlr.runtime.{CommonTokenStream, ANTLRStringStream}
import org.antlr.runtime.tree.CommonTree

trait ParserSpec extends FlatSpec {

  final class IntoWord {}

  final class ParsesWord(source: String) {

    def testParser(text: String): csParser = {
      val input = new ANTLRStringStream(text)

      val tokenStream = new CommonTokenStream(new PreProcessor(input))

      return new csParser(tokenStream)
    }

    def printNode(node: CommonTree, depth: Int) {
      for (d <- 0 to depth * 3) {
        print(' ')
      }

      if (node == null)
        println("<NULL>")
      else {
        println(node.getText)

        for (i <- 0 to node.getChildCount - 1) {
          printNode(node.getChild(i).asInstanceOf[CommonTree], depth + 1)
        }
      }
    }


    def printTree(scope: AnyRef) {
      if (scope != null)
        printNode(scope.asInstanceOf[CommonTree], 0)
      else
        println("No tree available")
    }


    def into(testFun: => Unit) {
      it should source in {

        printTree(testParser(source).primary_expression_part.getTree)

        testFun
      }
    }
  }

  final class ParserWord {
    def parses(source: String): ParsesWord = {
      new ParsesWord(source)
    }
  }

  final class AstTree {
    def token(name: String): AstTree = {
      return null
    }
  }

  protected val parser = new ParserWord
  //  protected val ast = new AstTree
}
