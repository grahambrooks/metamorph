package metamorph

trait ReportWriter {
  def methodDetail(methodName: String)
  def methodSummary(methodName: String, methodCount: Int)

  def duplicateClassBlock(function: (ReportWriter) => Any)
  def duplicateMethodBlock(function: (ReportWriter) => Any)
}
