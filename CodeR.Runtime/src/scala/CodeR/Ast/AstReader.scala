package CodeR.Ast

import java.io.{BufferedReader, Reader}
trait AstNode{
  def `type`: Int
}
class AstReader(input: Reader) {
  val buffer = new BufferedReader(input)
  class SimpleAstNode extends  AstNode{
    def `type` = 0
  }
  def read(): AstNode = {
    buffer.readLine()
    null
  }

}
