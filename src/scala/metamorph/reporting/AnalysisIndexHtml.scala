package metamorph.reporting

import metamorph.MorphConfig
import java.io.OutputStreamWriter
import java.util.Date
import metamorph.analysis.AnalysedSourceCode

class AnalysisIndexHtml(config: MorphConfig, val source: AnalysedSourceCode, val output: OutputStreamWriter) extends Html {
  html {
    head {
      title("Metamorph code analysis report: " + new Date().toString)
      link(rel = "stylesheet", href = "site.css")
    }
    body(fun = {
      banner

      warnings()

      duplicateMethods()

      duplicateBlocks()
    })
  }


  def banner {
    h1("Metamorph code analysis summary")

    output.write("<a href=\"#duplicate-methods\">Duplicate Methods</a> ")
    output.write("<a href=\"#duplicate-blocks\">Duplicate Blocks</a>")

    div("summary", {
      h2("Analysis performed on " + new java.util.Date())

      output.write("<table>")
      config.sources.foreach {
        case (name, path) => {
          output.write("<tr><th>%s</th><td>%s</td></tr>".format(name, path))
        }
      }
      output.write("</table>")
    })
  }

  def duplicateBlocks() {
    output.write("<tr><th class=\"duplicate\"><h2><a name='duplicate-blocks'>Duplicate Blocks</a></h2></th><td>Blocks are identified by using a hash of all the text including the surrounding braces {}.</td></tr>")

    source.blockBuckets.eachDuplicate(blocks => {
      output.write("<tr><th>Duplicate block of %d lines</th>".format(blocks(0).lineCount))
      output.write("<td class=\"duplicate\">")
      blocks.foreach(block => {
        a(block.source.sourceName + '/' + block.source.branchPath.join(block.source.name + ".html").toString, block.source.sourceName + '/' + block.source.branchPath.join(block.source.name).toString)
        output.write(" at %s<br/>".format(block.span))
      })
      output.write("</td></tr>")
    })
    output.write("<table>")
  }

  def duplicateMethods() {
    h2("<a name='duplicate-methods'>Analysis summary</a>")

    p(source.methodBuckets.getDuplicateCount + " Duplicate methods identified")
    output.write("<table>")
    output.write("<tr><th class=\"duplicate\"><h2>Duplicate Methods</h2></th><td class=\"duplicate\">Duplicate methods are identified using a hash built from the method text. White space is ignored.</td></tr>")
    source.methodBuckets.eachDuplicate(methods => {
      output.write("<tr><th class=\"duplicate\">%s (x%d duplicates) of %d lines</th>".format(methods(0).name, methods.size - 1, methods(0).lineCount))
      output.write("<td class=\"duplicate\">")

      methods.foreach(method => {
        a(method.source.sourceName + '/' + method.source.branchPath.join(method.source.name + ".html").toString, method.source.sourceName + '/' + method.source.branchPath.join(method.source.name).toString)
        output.write("<br/>")
      })
      output.write("</td></tr>")
    })
  }

  def warnings() {
    h2("Warnings")

    output.write("<table class=\"panel\">")
    source.warnings.foreach(warning => output.write("<tr><td><span class=\"emph\">%s</span></td><td>%s</td></tr>".format(warning.model.name, warning.message)))
    output.write("</table>")

    h2("Duplicate source files")

    output.write("<table>")
    output.write("<tr><th class=\"duplicate\"><h2>%d duplicate files</h2></th><td class=\"duplicate\">Duplicates identified as syntactically identical.</td></tr>".format(source.modelBuckets.getDuplicateCount))
    source.modelBuckets.eachDuplicate(models => {

      output.write("<tr><th class=\"duplicate\">%s</th><td class='duplicate'>".format(models(0).name))

      models.foreach(model => {
        a(model.sourceCode.sourceName + '/' + model.sourceCode.branchPath.join(model.sourceCode.name + ".html").toString, model.sourceCode.sourceName + '/' + model.sourceCode.branchPath.join(model.sourceCode.name).toString)
        output.write("<br/>")
      })
      output.write("</td></tr>")
    })
    output.write("</table>")
  }
}
