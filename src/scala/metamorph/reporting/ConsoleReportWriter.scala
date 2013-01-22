package metamorph.reporting

import metamorph.util.ConsoleWriter

class ConsoleReportWriter extends ConsoleWriter with ReportWriter {

  def duplicateClassBlock(function: (ReportWriter) => Any) {
    writeSeparator('_')
    writeLine("Duplicate Classes")
    function(this)
  }

  def duplicateMethodBlock(function: (ReportWriter) => Any) {
    writeSeparator('_')
    writeLine("Duplicate Methods")
    function(this)
  }


  def println(message: String, args: Any*) {
    Console.printf(message, args: _*)
    Console.println()
  }

  def methodDetail(methodName: String) {
    writeLine("Method: %s", methodName)
  }

  def methodSummary(methodName: String, methodCount: Int) {
    writeLine()
    writeLine("%s had %d duplicates", methodName, (methodCount - 1))
  }
}
