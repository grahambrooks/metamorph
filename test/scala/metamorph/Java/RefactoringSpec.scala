package metamorph.Java

import org.scalatest.FunSpec
import metamorph.model.NewImport
import java.io.{PrintWriter, StringWriter}


class RefactoringSpec extends FunSpec {
  describe("Refactoring imports") {
    it("allows imports to be added to importless code") {
      val originalSource = new SourceCodeString("class X {}")

      val reader = new SourceCodeReader(originalSource)
      val model = reader.read

      val changeSet = new ChangeSet(model)

      changeSet.add(new NewImport("metamorph.foo"))

      val writer = new SourceCodeReWriter(originalSource)

      val sw: StringWriter = new StringWriter
      val output: PrintWriter = new PrintWriter(sw)
      writer.rewrite(changeSet, output)

      assert(sw.toString === "import metamorph.foo;" +
        "\nclass X {}" +
        "\n")
    }

    it("adds new imports after existing imports") {
      val originalSource = new SourceCodeString("import metamorph.foo;" +
        "\n" +
        "\nclass X {}")

      val reader = new SourceCodeReader(originalSource)
      val model = reader.read

      val changeSet = new ChangeSet(model)

      changeSet.add(new NewImport("metamorph.bar"))

      val writer = new SourceCodeReWriter(originalSource)

      val sw: StringWriter = new StringWriter
      val output: PrintWriter = new PrintWriter(sw)
      writer.rewrite(changeSet, output)

      assert(sw.toString === "import metamorph.bar;" +
        "\nimport metamorph.foo;" +
        "\n" +
        "\nclass X {}" +
        "\n")

    }
  }
}
