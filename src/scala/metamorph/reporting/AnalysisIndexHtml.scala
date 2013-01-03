package metamorph.reporting

import metamorph.{MorphConfig, BucketSet}
import metamorph.model.{BlockDeclaration, MethodDeclaration}
import java.io.OutputStreamWriter

class AnalysisIndexHtml(config: MorphConfig, val methodBuckets: BucketSet[MethodDeclaration], val blockBuckets: BucketSet[BlockDeclaration], val output: OutputStreamWriter) extends Html {
  html {
    head {
      title("This is a report")
      output.write("<link rel=\"stylesheet\" href=\"http://yandex.st/highlightjs/7.3/styles/default.min.css\">\n" +
        "<link rel=\"stylesheet\" href=\"" + "site.css" + "\">" +
        "<script src=\"highlight.pack.js\"></script>\n" +
        "<script>hljs.initHighlightingOnLoad();</script>\n")
    }
    body {
      h1("Metamorph code analysis summary")
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

      h2("Analysis summary")
      output.write("<table>")
      output.write("<tr><th><h2>Duplicate Methods</h2></th><td>Duplicate methods are identified using a hash built from the method text. White space is ignored.</td></tr>")
      methodBuckets.eachDuplicate(methods => {
        output.write("<tr><th>%s (x%d duplicates) of %d lines</th>".format(methods(0).name, methods.size - 1, methods(0).lineCount))
        output.write("<td>")

        methods.foreach(method => {
          a(method.source.sourceName + '/' + method.source.branchPath.join(method.source.name + ".html").toString)
          output.write("<br/>")
        })
        output.write("</td></tr>")
      })

      output.write("<tr><th><h2>Duplicate Blocks</h2></th><td>Blocks are identified by using a hash of all the text including the surrounding braces {}.</td></tr>")

      blockBuckets.eachDuplicate(blocks => {
        output.write("<tr><th>Duplicate block of %d lines</th>".format(blocks(0).lineCount))
        output.write("<td>")
        blocks.foreach(block => {
          a(block.source.sourceName + '/' + block.source.branchPath.join(block.source.name + ".html").toString)
          output.write(" at %s<br/>".format(block.span))
        })
        output.write("</td></tr>")
      })
      output.write("<table>")
    }
  }
}
