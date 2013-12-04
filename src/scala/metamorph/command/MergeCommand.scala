package metamorph.command

import java.io.File
import metamorph.Java.{AntlrSourceCodeReader, SourceCodeFile}
import metamorph.model.{MethodDeclaration, CodeModel}
import metamorph._
import reporting.ReportWriter
import util._
import metamorph.MorphConfig

class MergeCommand extends MorphCommand {
  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
    var models: List[CodeModel] = Nil

    config.sources foreach {
      case (name, path) => {
        val contentSource = new ContentSource(name, new RootPath(path))
        scanFiles(path, console, p => {
          Logger.trace("Processing source file %s", p.getAbsolutePath)

          val originalSource = new SourceCodeFile(contentSource, p)

          val reader = new AntlrSourceCodeReader(originalSource)

          val model = reader.read

          models = models ::: List(model)
        })
      }
    }

    analyse(models, reportWriter)
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

  private def analyse(models: List[CodeModel], writer: ReportWriter) {
    val methodBuckets = bucketMethods(models)

    writer.duplicateMethodBlock(writer => methodBuckets.eachDuplicate(methods => reportDuplicates(methods, writer)))


    //    val html = new ConsoleReportWriter(methodBuckets)
    //
    //    html.generate()


  }

  private def reportDuplicates(methods: Bucket[MethodDeclaration], writer: ReportWriter) {
    writer.methodSummary(methods(0).name, methods.size)
    methods foreach (method => {
      writer.methodDetail(method.getName)
    })
  }

  private def bucketMethods(models: List[CodeModel]): BucketSet[MethodDeclaration] = {
    val methodBuckets = new BucketSet[MethodDeclaration]
    models foreach (model => {
      model.methods foreach (method => methodBuckets.add(method.syntaxSignature, method))
    })
    methodBuckets
  }
}
