package metamorph.reporting

import java.io.{FileOutputStream, File, OutputStreamWriter}

class ReportSite(val reportingPath: String) {
  val reportingFile: File = new File(reportingPath)

  def preRequisites() {
    if (!reportingFile.isDirectory) {
      reportingFile.mkdir()
    }

  }

  def writeIndex(fun: (OutputStreamWriter) => Any) {
    preRequisites()

    val output = new OutputStreamWriter(new FileOutputStream(reportingFile.getPath + "/index.html"))

    fun(output)
    output.close()
  }
}
