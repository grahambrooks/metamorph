package metamorph

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar


class ToolSpec extends FunSpec with ShouldMatchers with MockitoSugar {

  describe("The tool") {
    it("is instantiable") {
      //      new Tool(null, )
    }

    it("process each file specified on the command line") {
      //      val mockProcessor = mock[SourceCodeFileProcessor]
      //      val tool = new Tool(mockProcessor)
      //
      //      val args = Array("foo", "bar")
      //
      //      tool.run(args)
      //
      //      verify(mockProcessor).processFile("foo")
      //      verify(mockProcessor).processFile("bar")
    }

    it("calls report for 'similarities'") {
      val mockProcessor = mock[SourceCodeFileProcessor]
    }
  }
}