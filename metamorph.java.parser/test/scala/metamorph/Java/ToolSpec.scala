package metamorph.Java

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito.verify

class ToolSpec extends FlatSpec with ShouldMatchers with MockitoSugar {
  it should "be instantiable" in {
    new Tool(null)
  }

  it should "process each file specified on the command line" in {
    val mockProcessor = mock[JavaFileProcessor]
    val tool = new Tool(mockProcessor)

    val args = Array("foo", "bar")

    tool.run(args)

    verify(mockProcessor).processFile("foo")
    verify(mockProcessor).processFile("bar")
  }
}
