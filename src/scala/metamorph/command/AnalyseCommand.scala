package metamorph.command

import metamorph._
import analysis.SourceCodeAnalyser
import metamorph.Java.{SourceCodeReader, SourceCodeFile}
import model.{BlockDeclaration, MethodDeclaration, CodeModel}
import java.io._
import reporting.AnalysisHtmlReport
import metamorph.MorphConfig

class AnalyseCommand extends MorphCommand {
  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
    if (config.sources.size != 1) {
      console.writeLine("Analysis works best for a single collection of source files.")
    }
    var models: List[CodeModel] = Nil

    config.sources foreach {
      case (name, path) => {
        scanFiles(path, console, p => {
          Logger.trace("Processing source file %s", p.getAbsolutePath)

          val originalSource = new SourceCodeFile(p)

          val reader = new SourceCodeReader(originalSource)

          val model = reader.read

          models = models ::: List(model)
        })
      }
    }

    analyse(models, config.outputPath)
  }

  def scanFiles(pathOrFilename: String, console: ConsoleWriter, function: (File) => Any) {
    try {
      Logger.trace("Scanning %s", pathOrFilename)
      val root = new File(pathOrFilename)

      val scanner = new DirectoryScanner(root.getCanonicalPath, ".*\\.java")

      scanner eachFile function
    }
    catch {
      case ae: Exception => console Error ae.getMessage
    }
  }

  private def analyse(models: List[CodeModel], outputPath: String) {

    val analyser = new SourceCodeAnalyser

    val analysedSource = analyser.analyse(models)

    val output = new OutputStreamWriter(new FileOutputStream(outputPath))
    new AnalysisHtmlReport(analysedSource.methodBuckets, analysedSource.blockBuckets, output)
    output.close()
  }

}
