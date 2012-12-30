package metamorph.command

import metamorph._
import metamorph.Java.{SourceCodeReader, SourceCodeFile}
import model.{BlockDeclaration, MethodDeclaration, CodeModel}
import java.io.File
import metamorph.MorphConfig
import reporting.Html

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

    val blockBuckets = bucketBlocks(models)

    class HtmlReport extends Html {

      html {
        head {
          title("This is a report")
        }
        body {

          methodBuckets.eachDuplicate(methods => {

            h1(methods(0).name)

            p("Has " + methods.size + " duplicates")

          })

          h1("Duplicate Blocks")
          blockBuckets.eachDuplicate(blocks => {
            h2("Duplicate block")
            blocks.foreach(block =>{
              p(block.source.getFilename + " at " + block.span)

            }
            )
          })
        }
      }
    }

    val report = new HtmlReport

    print(report.render())



    //    val html = new ConsoleReportWriter(methodBuckets)
    //
    //    html.generate()


  }

  private def reportDuplicates(methods: Bucket[MethodDeclaration], writer: ReportWriter) {
    writer.methodSummary(methods(0).name, methods.size)
    methods foreach (method => {
      writer.methodDetail(method.source.getFilename)
    })
  }

  private def bucketMethods(models: List[CodeModel]): BucketSet[MethodDeclaration] = {
    val methodBuckets = new BucketSet[MethodDeclaration]
    models foreach (model => {
      model.methods foreach (method => methodBuckets.add(method.syntaxSignature, method))
    })
    methodBuckets
  }

  private def bucketBlocks(models: List[CodeModel]) : BucketSet[BlockDeclaration] = {
    val blockBuckets = new BucketSet[BlockDeclaration]
    models foreach (model => {
      model.blocks foreach (block => blockBuckets.add(block.signature, block))
    })
    blockBuckets
  }
}
