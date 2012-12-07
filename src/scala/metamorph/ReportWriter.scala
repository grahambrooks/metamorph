package metamorph

trait ReportWriter {
  def println(message: String, args: Any*)
}
