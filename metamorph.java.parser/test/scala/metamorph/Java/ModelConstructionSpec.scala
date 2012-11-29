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

  it should "add classes to global namespace if a namespace is not specified" in {
    val model = processSource("class foo {}")

    model.globalNamespace.classes.size should equal(1)
    model.globalNamespace.classes("foo").name should equal("foo")

  }

  it should "add method declarations to the enclosing class" in {
    val model = processSource("class foo { void bar(); }")

    model.globalNamespace.classes("foo").methods.size should equal(1)
    model.globalNamespace.classes("foo").methods("bar").name should equal("bar")
  }

  it should "add method calls found inside method declarations" in {
    val model = processSource("class foo { void bar() { frodo(); } }")

    model.globalNamespace.classes("foo").methods("bar").methodCalls.size should equal(1)
    model.globalNamespace.classes("foo").methods("bar").methodCalls("frodo").name should equal("frodo")

  }

  def processSource(text: String): MorphModel = {
    val processor = new DefaultJavaFileProcessor

    val input = new ANTLRInputStream(text)

    val visitor: MorphVisitor = new MorphVisitor
    processor.visitSource(input, visitor)

    return visitor.model
  }
}
