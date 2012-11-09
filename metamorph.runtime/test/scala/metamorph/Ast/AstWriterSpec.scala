package metamorph.Ast

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.antlr.runtime.{Token, CommonToken}
import java.io.StringWriter
import org.antlr.runtime.tree.CommonTree

class AstWriterSpec extends FlatSpec with ShouldMatchers {

  class TestToken(`type`: Int) extends CommonToken(`type`: Int) {

    def this(`type`: Int, _line: Int, _charPositionInLine: Int, _text: String, _index: Int, _start: Int, _stop: Int) = {
      this(`type`)
      line = _line
      charPositionInLine = _charPositionInLine
      text = _text
      index = _index
      start = _start
      stop = _stop
    }
  }

  class TestTree(token: Token) extends CommonTree(token) {
    def this() = this(null)
  }

  it should "Write a single token" in {
    val token = new TestToken(1, 2, 3, "foo", 4, 5, 6)
    val buffer: StringWriter = new StringWriter()
    val writer = new AstWriter(buffer)

    writer.writeToken(token)

    buffer.toString should equal("type:1 line:2 charPositionInLine:3 text:\"foo\" index:4")
  }

  it should "write an empty node" in {
    val tree = new TestTree
    val buffer = new StringWriter()
    val writer = new AstWriter(buffer)

    writer.writeTree(tree)

    buffer.toString should equal("")
  }

  it should "write a single element node" in {
    val token = new TestToken(1, 2, 3, "foo", 4, 5, 6)
    val tree = new TestTree(token)

    val buffer = new StringWriter()
    val writer = new AstWriter(buffer)

    writer.writeTree(tree)

    buffer.toString should equal("(type:1 line:2 charPositionInLine:3 text:\"foo\" index:4)")
  }

  it should "write an element and child node" in {
    val tree = new TestTree(new TestToken(1, 2, 3, "foo", 4, 5, 6))
    tree.addChild(new TestTree(new TestToken(2, 2, 3, "bar", 4, 5, 6)))

    val buffer = new StringWriter()
    val writer = new AstWriter(buffer)

    writer.writeTree(tree)

    buffer.toString should equal("(type:1 line:2 charPositionInLine:3 text:\"foo\" index:4" +
      "\n   (type:2 line:2 charPositionInLine:3 text:\"bar\" index:4))")
  }


  it should "write an element and two child node" in {
    val tree = new TestTree(new TestToken(1, 2, 3, "foo", 4, 5, 6))
    tree.addChild(new TestTree(new TestToken(2, 2, 3, "bar", 4, 5, 6)))
    tree.addChild(new TestTree(new TestToken(3, 2, 3, "boo", 4, 5, 6)))

    val buffer = new StringWriter()
    val writer = new AstWriter(buffer)

    writer.writeTree(tree)

    buffer.toString should equal("(type:1 line:2 charPositionInLine:3 text:\"foo\" index:4" +
      "\n   (type:2 line:2 charPositionInLine:3 text:\"bar\" index:4)" +
      "\n   (type:3 line:2 charPositionInLine:3 text:\"boo\" index:4))")
  }
}
