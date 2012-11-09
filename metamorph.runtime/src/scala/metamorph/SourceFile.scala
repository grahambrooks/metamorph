package metamorph

class SourceFile(_name: String, contents: String) extends SourceCode {
  def name: String = _name

  def this(name: String) = this(name, "")

  def containing(text: String): SourceFile = {
    val sf: SourceFile = new SourceFile(name, text)
    sources(name) = sf
    return sf
  }

  def getContents = contents
}
