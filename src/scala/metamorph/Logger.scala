package metamorph

trait Logger {
  def fatal(text: String, xs: Any*)

  def error(text: String, xs: Any*)

  def debug(text: String, xs: Any*)

  def trace(text: String, xs: Any*)
}

object Logger extends Logger {
  var current = default

  val default: Logger = new Logger() {
    def fatal(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def error(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def debug(text: String, xs: Any*) {}

    def trace(text: String, xs: Any*) {}
  }

  val verbose: Logger = new Logger() {
    def fatal(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def error(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def debug(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def trace(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }
  }

  val debug: Logger = new Logger {
    def fatal(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def error(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def debug(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }

    def trace(text: String, xs: Any*) {
      Console.println(text.format(xs: _*))
    }
  }

  def fatal(text: String, xs: Any*) {
    current.fatal(text, xs: _*)
  }

  def error(text: String, xs: Any*) {
    current.error(text, xs: _*)
  }

  def debug(text: String, xs: Any*) {
    current.debug(text, xs: _*)
  }

  def trace(text: String, xs: Any*) {
    current.trace(text, xs: _*)
  }
}
