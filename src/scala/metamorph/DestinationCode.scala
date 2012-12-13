package metamorph

import java.io.Writer

trait DestinationCode {
  def getWriter : Writer
}
