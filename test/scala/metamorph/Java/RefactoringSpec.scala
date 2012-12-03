package metamorph.Java

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar
import metamorph.model.NewImport
import java.io.{PrintWriter, StringWriter}


class RefactoringSpec extends FlatSpec with ShouldMatchers with MockitoSugar {
  it should "allow imports to be added" in {
    val originalSource = new SourceCodeString("class X {}")

    val reader = new SourceCodeReader(originalSource)
    val model = reader.read

    val changeSet = new ChangeSet(model)

    changeSet.add(new NewImport("metamorph.foo"))

    val writer = new SourceCodeReWriter(originalSource)

    val sw: StringWriter = new StringWriter
    val output: PrintWriter = new PrintWriter(sw)
    writer.rewrite(changeSet, output)

    sw.toString should equal("import metamorph.foo;\nclass X {}")
  }
}
