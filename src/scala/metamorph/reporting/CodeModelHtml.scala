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
        "<link rel=\"stylesheet\" href=\"" + relativePath(currentPath, "site.css") + "\">" +
        "<script src=\"" + relativePath(currentPath, "highlight.pack.js") + "\"></script>\n" +
        "<script>hljs.initHighlightingOnLoad();</script>\n")
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
      output.write("    <th class=\"duplicate\">Duplicate</th>\n")
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
