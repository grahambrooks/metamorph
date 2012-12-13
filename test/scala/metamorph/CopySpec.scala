package metamorph

import Java._
import org.scalatest.FunSpec


class CopySpec extends FunSpec {
  describe("Copy") {
    it("copies from Source to Destination updating package name") {
      val originalSource = new SourceCodeString("package metamorph.foo;\n")

      val targetSource = new DestinationCodeString()

      val merge = new Merge(Map("metamorph.foo" -> "metamorph.foo.bar"))

      merge.copy(originalSource, targetSource)

      assert(targetSource.toString === "package metamorph.foo.bar;\n")

    }
  }
}
