package metamorph.reporting

import metamorph.BucketSet
import metamorph.model.{BlockDeclaration, MethodDeclaration}
import io.Source
import java.io.OutputStreamWriter

class AnalysisHtmlReport(val methodBuckets: BucketSet[MethodDeclaration], val blockBuckets: BucketSet[BlockDeclaration], val output: OutputStreamWriter) extends Html {
  html {
    head {
      title("This is a report")
      output.write("<link rel=\"stylesheet\" href=\"http://yandex.st/highlightjs/7.3/styles/default.min.css\">\n" +
        "<script src=\"highlight.pack.js\"></script>\n" +
        "<script>hljs.initHighlightingOnLoad();</script>\n")
      output.write("<style>\n" +
        "    body {\n" +
        "      font: small Arial, sans-serif;\n" +
        "    }\n" +
        "    h1 {\n" +
        "      font: bold Arial, sans-serif;\n" +
        "      margin-top: 2em;\n" +
        "      margin-bottom: 0.5em;\n" +
        "    }\n" +
        "    h2 {\n" +
        "      font: bold 100% Arial, sans-serif;\n" +
        "      margin-top: 2em;\n" +
        "      margin-bottom: 0.5em;\n" +
        "    }\n" +
        "    table {\n" +
        "      width: 100%; padding: 0; border-collapse: collapse;\n" +
        "    }\n" +
        "    th {\n" +
        "      width: 12em;\n" +
        "      padding: 0; margin: 0;\n" +
        "    }\n" +
        "    td {\n" +
        "      padding-bottom: 1em;\n" +
        "    }\n" +
        "    td, th {\n" +
        "      vertical-align: top;\n" +
        "      text-align: left;\n" +
        "    }\n" +
        "    pre {\n" +
        "      margin: 0; font-size: medium;\n" +
        "    }\n" +
        "    #switch {\n" +
        "      overflow: auto; width: 67em;\n" +
        "      list-style: none;\n" +
        "      padding: 0; margin: 0;\n" +
        "    }\n" +
        "    #switch li {\n" +
        "      float: left; width: 12em;\n" +
        "      padding: 0.1em; margin: 0.1em 1em 0.1em 0;\n" +
        "      background: #EEE;\n" +
        "      cursor: pointer;\n" +
        "    }\n" +
        "    #switch li.current {\n" +
        "      background: #CCC;\n" +
        "    }\n" +
        "    .test {\n" +
        "      color: #888;\n" +
        "      font-weight: normal;\n" +
        "      margin: 2em 0 0 0;\n" +
        "    }\n" +
        "    .test var {\n" +
        "      font-style: normal;\n" +
        "    }\n" +
        "    .passed {\n" +
        "      color: green;\n" +
        "    }\n" +
        "    .failed {\n" +
        "      color: red;\n" +
        "    }\n" +
        "    .code {\n" +
        "      font: medium monospace;\n" +
        "    }\n" +
        "    .code .keyword {\n" +
        "      font-weight: bold;\n" +
        "    }\n" +
        "  </style>")
    }
    body {

      methodBuckets.eachDuplicate(methods => {
        h1(methods(0).name)

        p("Has " + methods.size + " duplicates")

        ul {
          methods.foreach(method => {
            li(method.source.getFilename)
          })
        }
      })



      h1("Duplicate Blocks")
      blockBuckets.eachDuplicate(blocks => {
        h2("Duplicate block of %d lines".format(blocks(0).lineCount))
        blocks.foreach(block => {
          p(block.source.getFilename + " at " + block.span)
        })

        output.write("<table>\n")
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

      })


    }
  }
}
