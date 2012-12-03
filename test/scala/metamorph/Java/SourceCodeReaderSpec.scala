package metamorph.Java

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class SourceCodeReaderSpec extends FlatSpec with ShouldMatchers {
  it should "reader recognises imports" in {
    val originalSource = new SourceCodeString("import metamorph.foo.bar;")

    val reader = new SourceCodeReader(originalSource)

    val model = reader.read

    val importDecl = model.imports(0)

    importDecl.qualifiedName should equal("metamorph.foo.bar")

  }
}
