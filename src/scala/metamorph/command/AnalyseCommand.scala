package metamorph.command

import metamorph._
import analysis.{AnalysedSourceCode, SourceProvider, SourceCodeAnalyser}
import Java.{SourceCode, SourceCodeFile}
import java.io._
import model.CodeModel
import reporting._
import java.nio.charset.MalformedInputException
import metamorph.MorphConfig


class AnalyseCommand extends MorphCommand {
  val JavaFilePattern: String = ".*\\.java"

  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
    if (config.sources.size != 1) {
      console.writeLine("Analysis works best for a single collection of source files.")
    }
    val analyser = new SourceCodeAnalyser

    val analysedSource = analyser.analyse(sourceProvider(config, console))

    writeReports(config, analysedSource, config.outputPath)

  }

  def sourceProvider(config: MorphConfig, console: ConsoleWriter): SourceProvider = {
    new SourceProvider {
      def each(function: (SourceCode) => Any) {
        config.sources foreach {
          case (name, path) => {
            val source = new ContentSource(name, new RootPath(path))

            scanFiles(path, console, p => {
              Logger.trace("Processing source file %s", p.getAbsolutePath)

              val originalSource = new SourceCodeFile(source, p)

              function(originalSource)
            })
          }
        }
      }
    }
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


  private def writeReports(config: MorphConfig, analysedSource: AnalysedSourceCode, outputPath: String) {

    val reportSite = new ReportSite(outputPath)

    reportSite.copyAssets()

    reportSite.writeIndex(indexStreamWriter => {
      new AnalysisIndexHtml(config, analysedSource, indexStreamWriter)
    })

    analysedSource.analysedModels.foreach(m => {
      if (m.duplicate)
        writeDuplicateModelReport(m, analysedSource.modelBuckets(m.modelSignature).bucket.filter(p => p != m), reportSite)
      else
        writeModelReport(m, reportSite)
    })
  }

  def writeDuplicateModelReport(model: CodeModel, duplicates: List[CodeModel], reportSite: ReportSite) {
    try {
      Logger.trace("Writing analysis report for %s:%s", model.sourceCode.sourceName, model.sourceCode.absolutePath.toString)

      reportSite.writeCodeModelAnalysis(model.sourceCode, codeModelWriter => {
        new DuplicateCodeModelHtml(model, duplicates, codeModelWriter)
      })
    }
    catch {
      case mie: MalformedInputException => Logger.error("Failed writing report for %s %s", model.sourceCode.name, mie.getMessage)
    }

  }

  def writeModelReport(acm: CodeModel, reportSite: ReportSite) {
    try {
      Logger.trace("Writing analysis report for %s:%s", acm.sourceCode.sourceName, acm.sourceCode.absolutePath.toString)

      reportSite.writeCodeModelAnalysis(acm.sourceCode, codeModelWriter => {
        new CodeModelHtml(acm, codeModelWriter)
      })
    }
    catch {
      case mie: MalformedInputException => Logger.error("Failed writing report for %s %s", acm.sourceCode.name, mie.getMessage)
    }
  }
}
