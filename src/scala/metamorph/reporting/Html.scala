package metamorph.reporting

trait Html {
  val stringBuffer = new StringBuilder

  private def tagIt(tag: String, content: String) {
    stringBuffer.append('<')
    stringBuffer.append(tag)
    stringBuffer.append('>')
    stringBuffer.append(content)
    stringBuffer.append('<')
    stringBuffer.append('/')
    stringBuffer.append(tag)
    stringBuffer.append('>')
    stringBuffer.append('\n')
  }

  def tag(tag: String) {
    stringBuffer.append('<')
    stringBuffer.append(tag)
    stringBuffer.append('>')
  }

  def etag(tag: String) {
    stringBuffer.append('<')
    stringBuffer.append('/')
    stringBuffer.append(tag)
    stringBuffer.append('>')
    stringBuffer.append('\n')
  }

  def head(fun: => Unit) {
    tag("head")
    fun
    etag("head")
  }

  def body(fun: => Unit) {
    tag("body")
    fun
    etag("body")
  }

  def html(fun: => Unit) {
    tag("html")
    fun
    etag("html")
  }

  def title(s: String) {
    tagIt("title", s)
  }

  def h1(s: String) {
    tagIt("h1", s)
  }

  def h2(s: String) {
    tagIt("h2", s)
  }

  def p(s: String) {
    tagIt("p", s)
  }

  def render(): String = {
    stringBuffer.toString()
  }
}
