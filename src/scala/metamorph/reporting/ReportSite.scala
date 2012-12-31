package metamorph.reporting

import java.io.{FileOutputStream, File, OutputStreamWriter}
import io.Source

class ReportSite(val reportingPath: String) {
  val reportingFile: File = new File(reportingPath)

  def preRequisites() {
    if (!reportingFile.isDirectory) {
      reportingFile.mkdir()
    }
  }

  def copyAssets() {
    preRequisites()

    val sourcePath: String = "/metamorph/highlight.pack.js"
    val destinationPath: String = reportingFile.getPath + "/highlight.pack.js"

    copyAsset(sourcePath, destinationPath)
  }


  def copyAsset(sourcePath: String, destinationPath: String) {
    val stream = getClass.getResourceAsStream(sourcePath)
    val input = Source.fromInputStream(stream)

    val output = new OutputStreamWriter(new FileOutputStream(destinationPath))
    input.getLines().foreach(line => {
      output.write(line)
      output.write('\n')
    })
    output.close()
    input.close()
  }

  def writeIndex(fun: (OutputStreamWriter) => Any) {
    preRequisites()

    val output = new OutputStreamWriter(new FileOutputStream(reportingFile.getPath + "/index.html"))

    fun(output)
    output.close()
  }
}
