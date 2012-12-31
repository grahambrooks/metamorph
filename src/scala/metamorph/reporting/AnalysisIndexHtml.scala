package metamorph.reporting

import metamorph.BucketSet
import metamorph.model.{BlockDeclaration, MethodDeclaration}
import java.io.OutputStreamWriter

class AnalysisIndexHtml(val methodBuckets: BucketSet[MethodDeclaration], val blockBuckets: BucketSet[BlockDeclaration], val output: OutputStreamWriter) extends Html {
  html {
    head {
      title("This is a report")
      output.write("<link rel=\"stylesheet\" href=\"http://yandex.st/highlightjs/7.3/styles/default.min.css\">\n" +
        "<link rel=\"stylesheet\" href=\"" + "site.css" + "\">" +
        "<script src=\"highlight.pack.js\"></script>\n" +
        "<script>hljs.initHighlightingOnLoad();</script>\n")
    }
    body {

      methodBuckets.eachDuplicate(methods => {
        h2(methods(0).name)

        p("Has " + methods.size + " duplicates")

        ul {
          methods.foreach(method => {
            li("")
            a(method.source.branchPath + '/' + method.source.getName + ".html")
          })
        }
      })



      h1("Duplicate Blocks")
      blockBuckets.eachDuplicate(blocks => {
        h2("Duplicate block of %d lines".format(blocks(0).lineCount))
        ul {
          blocks.foreach(block => {
            li("")
            a(block.source.branchPath + '/' + block.source.getName + ".html")
            p(" at " + block.span)
          })
        }

        /*        output.write("<table>\n")
                output.write("<tr>\n" +
                  "    <th>File with Duplicates</th>\n" +
                  "    <td class=\"java\">\n" +
                  "      <pre><code>")

                val x = Source.fromFile(blocks(0).source.getFilename)

                x.getLines().foreach(line => {
                  output.write(line + "\n")
                })
                output.write("</code>\n" +
                  "      </pre>\n" +
                  "    </td>\n" +
                  "    </tr>")
                output.write("</table>\n")
                */
      })
    }
  }
}
