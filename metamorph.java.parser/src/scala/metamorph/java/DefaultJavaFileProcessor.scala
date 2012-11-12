package metamorph.java

import _root_.java.io.IOException
import metamorph.parsing.PrintingListener
import org.antlr.v4.runtime.{CommonTokenStream, ANTLRFileStream, ANTLRInputStream}

final class DefaultJavaFileProcessor extends JavaFileProcessor {
  def processFile(filename: String) {
    var input: ANTLRInputStream = null
    try {
      input = new ANTLRFileStream(filename)
      return sourceToAst(input)
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

    return PrintingListener.toStringTree(tree, parser)
  }
}