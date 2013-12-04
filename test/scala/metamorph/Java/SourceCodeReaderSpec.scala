package metamorph.Java

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

class SourceCodeReaderSpec extends FunSpec with ShouldMatchers {
  describe("Source Code Reader") {
    it("recognises imports") {
      val originalSource = new SourceCodeString("import metamorph.foo.bar;")

      val reader = new AntlrSourceCodeReader(originalSource)

      val model = reader.read

      val importDecl = model.imports(0)

      importDecl.qualifiedName should equal("metamorph.foo.bar")
    }

    it("recognises package declarations") {
      val originalSource = new SourceCodeString("\n\n\npackage metamorph.foo.bar;")

      val reader = new AntlrSourceCodeReader(originalSource)

      val model = reader.read

      assert(model.packageDeclaration != null)
      assert(model.packageDeclaration.importToken.getLine === 4)
      assert(model.packageDeclaration.qualifiedName.name === "metamorph.foo.bar")
    }

    it("Identifies named methods") {
      val originalSource = new SourceCodeString("class X { void foo() {}; }")

      val reader = new AntlrSourceCodeReader(originalSource)

      val model = reader.read

      assert(model.methods != Nil)
      assert(model.methods.size === 1)

      assert(model.methods(0).name === "foo")
    }

    it("Captures the method start and stop locations from the original source") {
      val originalSource = new SourceCodeString("class X {" +
        "\n void foo() {" +
        "\n" +
        "\n  }; }")

      val reader = new AntlrSourceCodeReader(originalSource)

      val model = reader.read

      assert(model.methods(0).span.start.getLine === 2)
      assert(model.methods(0).span.start.getCharPositionInLine === 1)
      assert(model.methods(0).span.stop.getLine === 4)
      assert(model.methods(0).span.stop.getCharPositionInLine === 2)
    }

    it("provides a signature for a method") {
      val originalSource = new SourceCodeString("class X {" +
        "\n void foo() {" +
        "\n" +
        "\n  }; }")

      val reader = new AntlrSourceCodeReader(originalSource)

      val model = reader.read

      model.methods(0).signature
    }

    it("supports comments at the end of the file terminated with EOF") {
      val originalSource = new SourceCodeString("class X {" +
        "\n void foo() {" +
        "\n" +
        "\n  }; } // End of class")

      val reader = new AntlrSourceCodeReader(originalSource)
      reader.read
    }

    it("supports multiple classes within a single compilation unit") {
      val originalSource = new SourceCodeString("class X {" +
        "\n}" +
        "\n" +
        "class Y {}")

      val reader = new AntlrSourceCodeReader(originalSource)
      val model = reader.read

      assert(model.typeDeclarations.size == 2)
    }

    it("supports nested classes") {
      val originalSource = new SourceCodeString("class X {" +
        "\n   class Y {" +
        "\n   }" +
        "\n}")

      val reader = new AntlrSourceCodeReader(originalSource)
      val model = reader.read

      assert(model.typeDeclarations.size == 2)
    }
  }
}