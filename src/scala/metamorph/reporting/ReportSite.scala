package metamorph.reporting

import java.io.{Writer, FileOutputStream, File, OutputStreamWriter}
import io.Source
import metamorph.Java.SourceCode

class ReportSite(val reportingPath: String) {

  val reportingFile: File = new File(reportingPath)

  def preRequisites() {
    if (!reportingFile.isDirectory) {
      reportingFile.mkdir()
    }
  }

  def copyAssets() {
    preRequisites()

    copyAsset("/metamorph/highlight.pack.js", reportingFile.getPath + "/highlight.pack.js")

    copyAsset("/metamorph/site.css", reportingFile.getPath + "/site.css")
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

  def makePaths(path: String) {
    new File(reportingPath + path).mkdirs
  }

  def writeCodeModelAnalysis(sourceCode: SourceCode, function: (Writer) => Any) {
    makePaths(sourceCode.branchPath)

    val output = new OutputStreamWriter(new FileOutputStream(reportingFile.getPath + '/' + sourceCode.branchPath + '/' + sourceCode.getName + ".html"))

    function(output)
    output.close()

  }
}
