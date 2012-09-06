package CodeR

object ConsoleWriter {
  def tick {}

}

class ConsoleWriter {
  def Error(message: String, args: Any*) {}

  def WriteSeparator(separator: Char) {
    for (i <- 0 to 80)
      Console.print(separator)
    Console.println()
  }

  def WriteLine() {
    Console.println()
  }

  def WriteLine(message: String, args: Any*) {
    Console.printf(message, args: _*)
    Console.println()
  }
}
