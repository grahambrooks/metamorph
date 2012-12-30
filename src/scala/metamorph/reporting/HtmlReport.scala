package metamorph.reporting

trait Html {
  val stringBuffer = new StringBuilder

  def head(fun: => Unit) {
    stringBuffer.append("<head>")
    fun
    stringBuffer.append("<head>")
  }

  def body(fun: => Unit) {
    stringBuffer.append("<body>")
    fun
    stringBuffer.append("</body>")

  }

  def html(fun: => Unit) {
    stringBuffer.append("<html>")
    fun
    stringBuffer.append("</html>")
  }

  def title(s: String) {
    stringBuffer.append("<title>" + s + "</title>")
  }

  def h1(s: String) {
    stringBuffer.append("<h1>" + s + "</h1>")
  }

  def render(): String = {
    stringBuffer.toString()
  }
}

class HtmlReport extends Html {

  html {
    head {
      title("This is a report")
    }
    body {
      for (a <- 1 to 3)
        h1("You know you want to!")
    }
  }
}
