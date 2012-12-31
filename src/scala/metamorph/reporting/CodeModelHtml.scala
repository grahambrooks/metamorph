package metamorph.reporting

import java.io.Writer
import io.Source
import metamorph.analysis.AnalysedCodeModel

class CodeModelHtml(val analysedCodeModel: AnalysedCodeModel, val output: Writer) extends Html {
  val currentPath = analysedCodeModel.codeModel.sourceCode.branchPath + '/' + analysedCodeModel.codeModel.sourceCode.getName
  html {
    head {
      title(analysedCodeModel.codeModel.sourceCode.getName)
      output.write("<link rel=\"stylesheet\" href=\"http://yandex.st/highlightjs/7.3/styles/default.min.css\">\n" +
        "<script src=\"" +
        relativePath(currentPath, "highlight.pack.js") +
        "\"></script>\n" +
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
        "    #duplicate {\n" +
        "      background-color: red;\n" +
        "    }\n" +
        "  </style>")
    }
    body {
      h1(analysedCodeModel.codeModel.sourceCode.getName)
      a(relativePath(currentPath, "index.html"), "Index")

      val x = Source.fromFile(analysedCodeModel.codeModel.sourceCode.getFilename)

      var lineNumber = 1
      var writingDuplicates = false
      output.write("<table>\n")
      openCodeRow(writingDuplicates)

      x.getLines().foreach(line => {
        val duplicateLine = analysedCodeModel.isDuplicateLine(lineNumber)

        if (duplicateLine != writingDuplicates) {
          closeCodeRow()
          writingDuplicates = duplicateLine
          openCodeRow(writingDuplicates)
        }

        output.write(line + "\n")
        lineNumber = lineNumber + 1
      })

      closeCodeRow()
      output.write("</table>\n")

    }
  }


  def openCodeRow(duplicateLine: Boolean) {
    output.write("<tr>\n")
    if (duplicateLine)
      output.write("    <th>Duplicate</th>\n")
    else
      output.write("    <th>Unique</th>\n")
    output.write("    <td class=\"java")
    if (duplicateLine)
      output.write(" duplicate")
    output.write("\">\n" +
      "      <pre><code>")
  }

  def closeCodeRow() {
    output.write("</code>\n" +
      "      </pre>\n" +
      "    </td>\n" +
      "    </tr>")
  }
}
