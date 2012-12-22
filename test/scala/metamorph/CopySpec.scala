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
    ignore("Still in development") {

      it("copies identical sources into a single destination source") {
        val sources = List(
          new SourceCodeString("package metamorph.foo;\n" +
            "class A {\n" +
            "   void commonMethod() {}\n" +
            "\n" +
            "   distinctMethod() {\n" +
            "      return 1;\n" +
            "   }\n" +
            "}\n"),
          new SourceCodeString("package metamorph.foo;\n" +
            "class A {\n" +
            "   void commonMethod() {}\n" +
            "\n" +
            "   distinctMethod() {\n" +
            "      return 2;\n" +
            "   }\n" +
            "}\n")
        )


        val destination = new DestinationCodeString()

        val merge = new Merge(Map("metamorph.foo" -> "metamorph.foo.bar"))

        merge.merge(sources, destination)

        assert(destination.toString === "package metamorph.foo.bar;\n" +
          "class A {\n" +
          "   void commonMethod() {}\n" +
          "\n" +
          "}\n")
      }
    }
  }
}
