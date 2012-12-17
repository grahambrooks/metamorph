package metamorph

trait Logger {
  def fatal(text: String, xs: Any*)

  def error(text: String, xs: Any*)

  def debug(text: String, xs: Any*)

  def trace(text: String, xs: Any*)
}

object Logger {
  val default: Logger = new Logger() {
    def fatal(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def error(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def debug(text: String, xs: Any*) {}

    def trace(text: String, xs: Any*) {}
  }

  val verbose: Logger = new Logger() {
    def fatal(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def error(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def debug(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def trace(text: String, xs: Any*) {}
  }

  val debug: Logger = new Logger {
    def fatal(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def error(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def debug(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }

    def trace(text: String, xs: Any*) {
      Console.print(text.format(xs: _*))
    }
  }
}
