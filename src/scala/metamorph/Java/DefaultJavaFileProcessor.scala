package metamorph.Java

import org.antlr.v4.runtime.{CommonTokenStream, ANTLRInputStream}
import metamorph.SourceCodeFileProcessor

final class DefaultJavaFileProcessor extends SourceCodeFileProcessor {

  def visitSource[T](input: ANTLRInputStream, visitor: JavaBaseVisitor[T]): T = {
    val parser = new JavaParser(new CommonTokenStream(new JavaLexer(input)))

    visitor.visit(parser.compilationUnit())
  }
}