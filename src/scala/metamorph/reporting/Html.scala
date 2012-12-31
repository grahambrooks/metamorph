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

  def a(href:String) {
    a(href, href)
  }
  def a(href:String, text: String) {
    output.write("<a href='%s'>%s</a>".format(href, text))
  }

  def relativePath(currentPath: String, targetPath: String): String = {
    currentPath.foldLeft("")((x, c) => {
      if (c == '/') x + "../" else x
    }) + targetPath
  }

}
