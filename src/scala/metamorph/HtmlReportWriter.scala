package metamorph
import scala.collection.JavaConverters._
import model.MethodDeclaration
import org.clapper.scalasti.StringTemplateGroup
import java.io.File
import collection.immutable.HashMap

class HtmlReportWriter(val duplicateMethods: BucketSet[MethodDeclaration]) extends ReportWriter {
  def methodDetail(methodName: String) {}

  def methodSummary(methodName: String, methodCount: Int) {}

  def duplicateClassBlock(function: (ReportWriter) => Any) {}

  def duplicateMethodBlock(function: (ReportWriter) => Any) {}

  def WriteReport(reportFile: File) {


  }

  def generate() {
//    val group = new StringTemplateGroup("metamorph")
//    val template = group.template("metamorph/templates/html/duplicate")
//
//    var m = new java.util.ArrayList[java.util.HashMap[String, String]()
//
//    duplicateMethods.eachDuplicate(bucket =>{
//      HashMap("name" -> bucket(0).name, "instances" -> {
//        bucket foreach (md => {})
//      })
//
//      m.add(
//        HashMap("path" -> bucket)
//        new HashMap
//      )
//    })
//
//    template.setAttribute("duplicateCount", duplicateMethods.duplicates.size)
//    template.setAttribute("dupMethods", duplicateMethods.duplicates.asJava)
//
//    print(template.toString())
  }
}
