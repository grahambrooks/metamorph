package metamorph

class ConsoleReportWriter extends ReportWriter {
  def println(message: String, args: Any*) {
    Console.printf(message, args: _*)
    Console.println()
  }
}
