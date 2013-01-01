package metamorph

import io.Source

object AbsolutePath {
  val Invalid = new AbsolutePath() {
    def source = {
      throw new UnsupportedOperationException
    }
  }

  def fromString(s: String) = new AbsolutePath {
    val path = s

    def source = Source.fromFile(s)
  }
}

abstract class AbsolutePath {
  def source: Source
}
