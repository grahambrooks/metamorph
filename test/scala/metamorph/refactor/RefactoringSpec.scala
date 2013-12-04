package metamorph.refactor

import org.scalatest.FunSpec
import metamorph.model.{CodeModel, ImportSpec}
import java.io.{PrintWriter, StringWriter}
import metamorph.Java._

class RefactoringSpec extends FunSpec {
  describe("Refactoring imports") {
    it("allows imports to be added to importless code") {
      val originalSource = new SourceCodeString("class X {}")

      val changeSet = new ChangeSet(modelFromSource(originalSource))

      changeSet.add(new ImportSpec("metamorph.foo"))

      val result = applyChanges(originalSource, changeSet)

      assert(result === "import metamorph.foo;" +
        "\nclass X {}" +
        "\n")
    }

    it("adds new imports before existing imports") {
      val originalSource = new SourceCodeString("import metamorph.foo;" +
        "\n" +
        "\nclass X {}")

      val changeSet = new ChangeSet(modelFromSource(originalSource))

      changeSet.add(new ImportSpec("metamorph.bar"))

      val result = applyChanges(originalSource, changeSet)

      assert(result === "import metamorph.bar;" +
        "\nimport metamorph.foo;" +
        "\n" +
        "\nclass X {}" +
        "\n")

    }
  }

  describe("Refactoring Package") {
    it("allows addition of a package") {
      val originalSource = new SourceCodeString("class X {}")

      val changeSet = new ChangeSet(modelFromSource(originalSource))

      changeSet.setPackage(new PackageSpec("metamorph.foo"))

      val result = applyChanges(originalSource, changeSet)

      assert(result === "package metamorph.foo;" +
        "\nclass X {}" +
        "\n")
    }

    it("allows replacement of a package") {
      val originalSource = new SourceCodeString("\n\npackage some.name;\n\nclass X {}\n")

      val changeSet = new ChangeSet(modelFromSource(originalSource))

      changeSet.setPackage(new PackageSpec("metamorph.foo"))

      val result = applyChanges(originalSource, changeSet)

      assert(result === "\n\npackage metamorph.foo;" +
        "\n\nclass X {}" +
        "\n")
    }
  }


  protected def applyChanges(originalSource: SourceCodeString, changeSet: ChangeSet): String = {
    val writer = new SourceCodeReWriter(originalSource)

    val sw: StringWriter = new StringWriter
    val output: PrintWriter = new PrintWriter(sw)
    writer.rewrite(changeSet, output)
    sw.toString
  }

  def modelFromSource(originalSource: SourceCodeString): CodeModel = {
    val reader = new AntlrSourceCodeReader(originalSource)
    reader.read
  }
}
