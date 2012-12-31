package metamorph.command

import metamorph._
import analysis.SourceCodeAnalyser
import metamorph.Java.{SourceCodeReader, SourceCodeFile}
import model.CodeModel
import java.io._
import reporting.{CodeModelHtml, ReportSite, AnalysisIndexHtml}
import metamorph.MorphConfig

class AnalyseCommand extends MorphCommand {
  val JavaFilePattern: String = ".*\\.java"

  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
    if (config.sources.size != 1) {
      console.writeLine("Analysis works best for a single collection of source files.")
    }
    var models: List[CodeModel] = Nil

    config.sources foreach {
      case (name, path) => {
        scanFiles(path, console, p => {
          Logger.trace("Processing source file %s", p.getAbsolutePath)

          val originalSource = new SourceCodeFile(path, p)

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

      val scanner = new DirectoryScanner(root.getCanonicalPath, JavaFilePattern)

      scanner eachFile function
    }
    catch {
      case ae: Exception => console Error ae.getMessage
    }
  }

  private def analyse(models: List[CodeModel], outputPath: String) {
    val analyser = new SourceCodeAnalyser
    val analysedSource = analyser.analyse(models)

    val reportSite = new ReportSite(outputPath)

    reportSite.copyAssets()

    reportSite.writeIndex(indexStreamWriter => {
      new AnalysisIndexHtml(analysedSource.methodBuckets, analysedSource.blockBuckets, indexStreamWriter)
    })

    analysedSource.modelsWithDuplicateBlocks.foreach(codeModel => {
      reportSite.writeCodeModelAnalysis(codeModel.sourceCode, codeModelWriter => {
        new CodeModelHtml(codeModel, codeModelWriter)
      })
    })
  }
}
