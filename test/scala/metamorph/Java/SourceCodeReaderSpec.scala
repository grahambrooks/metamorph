package metamorph.Java

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.path.FunSpec

class SourceCodeReaderSpec extends FunSpec with ShouldMatchers {
  describe("Source Code Reader") {
    it("recognises imports") {
      val originalSource = new SourceCodeString("import metamorph.foo.bar;")

      val reader = new SourceCodeReader(originalSource)

      val model = reader.read

      val importDecl = model.imports(0)

      importDecl.qualifiedName should equal("metamorph.foo.bar")
    }

    it("recognises package declarations") {
      val originalSource = new SourceCodeString("\n\n\npackage metamorph.foo.bar;")

      val reader = new SourceCodeReader(originalSource)

      val model = reader.read

      assert(model.packageDeclaration != null)
      assert(model.packageDeclaration.importToken.getLine === 4)
      assert(model.packageDeclaration.qualifiedName.name === "metamorph.foo.bar")
    }

    it("Identifies named methods") {
      val originalSource = new SourceCodeString("class X { void foo() {}; }")

      val reader = new SourceCodeReader(originalSource)

      val model = reader.read

      assert(model.methods != Nil)
      assert(model.methods.size === 1)

      assert(model.methods(0).name === "foo")

    }
  }
}