package metamorph.Java

import _root_.java.io.IOException
import org.antlr.v4.runtime.{Token, CommonTokenStream, ANTLRFileStream, ANTLRInputStream}
import metamorph.parsing.PrintingListener
import java.util

final class DefaultJavaFileProcessor extends JavaFileProcessor {

  def processFile(filename: String) {
    try {
      sourceToAst(new ANTLRFileStream(filename))
    }
    catch {
      case e: IOException => {
        e.printStackTrace
      }
    }
  }

  def sourceToAst(input: ANTLRInputStream): String = {
    val parser = new JavaParser(new CommonTokenStream(new JavaLexer(input)))
    parser.parserActions = new JavaParserActions {
      def importDeclaration(importToken: Token, nameTokens: util.List[Token]) {}

      def packageDeclaration(packageToken: Token, nameTokens: util.List[Token]) {}

      def methodDeclaration(methodNameToken: Token) {}
    }
    val tree = parser.compilationUnit

    PrintingListener.toStringTree(tree, parser)
  }

  def visitSource[T](input: ANTLRInputStream, visitor: JavaBaseVisitor[T]): T = {
    val parser = new JavaParser(new CommonTokenStream(new JavaLexer(input)))

    visitor.visit(parser.compilationUnit())
  }
}