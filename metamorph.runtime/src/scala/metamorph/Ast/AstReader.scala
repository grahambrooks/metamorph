package metamorph.Ast

import java.io.{BufferedReader, Reader}
import org.antlr.runtime.{ANTLRReaderStream, ANTLRInputStream, CommonTokenStream}

class AstReader(input: Reader) {
  val buffer = new BufferedReader(input)
  val lexer = new AstLexer(new ANTLRReaderStream(input))
  val parser = new AstParser(new CommonTokenStream(lexer))

  def read(): AstNode = {
    parser.ast_node()
  }

}
