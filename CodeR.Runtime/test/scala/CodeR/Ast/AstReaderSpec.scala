package CodeR.Ast

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import java.io.StringReader

class AstReaderSpec extends FlatSpec with ShouldMatchers {
  it should "read a single item" in {
    val text = "type:1 line:2 charPositionInLine:3 text:\"foo\" index:4"

    val stringReader = new StringReader(text)

    val reader = new AstReader(stringReader)

    val element = reader.read()

    element.`type` should equal(1)
  }
}
