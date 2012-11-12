package metamorph.Java

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar
import metamorph.java.{MorphVisitor, DefaultJavaFileProcessor}
import org.antlr.v4.runtime.ANTLRInputStream
import metamorph.model.MorphModel

class ModelConstructionSpec extends FlatSpec with ShouldMatchers with MockitoSugar {

  it should "add a namespace for a package declaration" in {
    val model = processSource("package metamorph.java;")

    model.namespaces.size should equal(1)
    model.namespaces("metamorph.java").name should equal("metamorph.java")
  }

  it should "add a class to the defined namespace" in {
    val model = processSource("package metamorph.java; class foo {}")

    model.namespaces.size should equal(1)
    model.namespaces("metamorph.java").classes.size should equal(1)
    model.namespaces("metamorph.java").classes("foo").name should equal("foo")
  }

  def processSource(text: String): MorphModel = {
    val processor = new DefaultJavaFileProcessor

    val input = new ANTLRInputStream(text)

    val visitor: MorphVisitor = new MorphVisitor
    processor.visitSource(input, visitor)

    return visitor.model
  }
}
