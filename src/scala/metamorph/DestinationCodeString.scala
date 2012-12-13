package metamorph

import java.io.{Writer, StringWriter}

class DestinationCodeString extends DestinationCode {
  val text = new StringWriter
  def getWriter: Writer = {
    text
  }

  override def toString = text.toString
}
