package CodeR.Java

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar
import org.antlr.v4.runtime.ANTLRInputStream
import java.io.{PrintWriter, StringWriter}

class DefaultJavaFileProcessorSpec extends FlatSpec with ShouldMatchers with MockitoSugar {
  it should "generate a text representation of AST" in {
    processSource("") should equal("(compilationUnit <EOF>)\n")
  }

  it should "generate a text representation of AST for class declaration" in {
    processSource("class foo {}") should equal("(compilationUnit (typeDeclaration (classDeclaration class foo (classBody { }))) <EOF>)\n")
  }

  def processSource(text: String) : String = {
    val processor = new DefaultJavaFileProcessor
    val input = new ANTLRInputStream(text)
    val writer = new StringWriter()
    val out = new PrintWriter(writer)
    processor.sourceToAst(input, out)
    print(writer.toString)
    return writer.toString
  }
}
