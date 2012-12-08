package metamorph

import org.clapper.scalasti.StringTemplateGroup
import java.io.File

class HtmlReportWriter extends ReportWriter {
  val group = new StringTemplateGroup("metamorph")
  val template = group.template("metamorph/templates/duplicate")
  def methodDetail(methodName: String) {}

  def methodSummary(methodName: String, methodCount: Int) {}

  def duplicateClassBlock(function: (ReportWriter) => Any) {}

  def duplicateMethodBlock(function: (ReportWriter) => Any) {}

  def WriteReport(reportFile: File) {

  }
}
