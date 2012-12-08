package metamorph

object ConsoleWriter {
  def tick {}

}

class ConsoleWriter {
  def Error(message: String, args: Any*) {}

  def writeSeparator(separator: Char) {
    for (i <- 0 to 80)
      Console.print(separator)
    Console.println()
  }

  def writeLine() {
    Console.println()
  }

  def writeLine(message: String, args: Any*) {
    Console.printf(message, args: _*)
    Console.println()
  }
}
