package metamorph.java

import _root_.java.io.IOException
import org.antlr.v4.runtime.{CommonTokenStream, ANTLRFileStream, ANTLRInputStream}
import metamorph.metamorph.parsing.PrintingListener

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
    val tree = parser.compilationUnit

    PrintingListener.toStringTree(tree, parser)
  }

  def visitSource[T](input: ANTLRInputStream, visitor: JavaBaseVisitor[T]): T = {
    val parser = new JavaParser(new CommonTokenStream(new JavaLexer(input)))

    visitor.visit(parser.compilationUnit())
  }
}