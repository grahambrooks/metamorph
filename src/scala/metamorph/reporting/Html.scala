package metamorph.reporting

import java.io.Writer

trait Html {
  val output: Writer

  private def tagIt(tag: String, content: String) {
    output.write('<')
    output.write(tag)
    output.write('>')
    output.write(content)
    output.write('<')
    output.write('/')
    output.write(tag)
    output.write('>')
    output.write('\n')
  }

  def tag(tag: String) {
    output.write('<')
    output.write(tag)
    output.write('>')
  }

  def tag(tag: String, clazz: String) {
    output.write('<')
    output.write(tag)
    output.write(" class=\"%s\"".format(clazz))
    output.write('>')
  }

  def etag(tag: String) {
    output.write('<')
    output.write('/')
    output.write(tag)
    output.write('>')
    output.write('\n')
  }

  def head(fun: => Unit) {
    tag("head")
    fun
    etag("head")
  }

  def link(rel: String = "", href: String = "") {
    output.write("<link rel=\"%s\" href=\"%s\">".format(rel, href))
  }

  def script(src: String = null, content: String = null) {
    if (src != null) {
      output.write("<script src=\"%s\"></script>\n".format(src))
    } else if (content != null) {
      output.write("<script>%s</script>\n".format(content))
    }
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

  def div(clazz: String, fun: => Unit) {
    tag("div", clazz)
    fun
    etag("div")
  }

  def ul(fun: => Unit) {
    tag("ul")
    fun
    etag("ul")
  }

  def li(s: String) {
    tagIt("li", s)
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

  def a(href: String) {
    a(href, href)
  }

  def a(href: String, text: String) {
    output.write("<a href='%s'>%s</a>".format(href, text))
  }

  def th(content: String, clazz: String = null): String = {
    if (clazz == null) "<th class=\"%s\">%s</th>\n".format(clazz, content) else "<th>%s</th>\n".format(content)
  }
}
