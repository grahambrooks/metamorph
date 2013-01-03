package metamorph.reporting

import java.io.Writer
import metamorph.analysis.AnalysedCodeModel
import metamorph.Paths

class CodeModelHtml(val analysedCodeModel: AnalysedCodeModel, val output: Writer) extends Html {
  val currentPath = Paths.join(analysedCodeModel.codeModel.sourceCode.branchPath, analysedCodeModel.codeModel.sourceCode.sourceName, analysedCodeModel.codeModel.sourceCode.name)
  html {
    head {
      title(analysedCodeModel.codeModel.sourceCode.name)

      link(rel = "stylesheet", href = "http://yandex.st/highlightjs/7.3/styles/default.min.css")
      link(rel = "stylesheet", href = currentPath.relativePathTo("site.css"))
      script(src = currentPath.relativePathTo("highlight.pack.js"))
      script(content = "hljs.initHighlightingOnLoad();")
    }
    body {
      h1(analysedCodeModel.codeModel.sourceCode.name)
      p("Scanned path = " + currentPath.toString)
      a(currentPath.relativePathTo("index.html"), "Index")

      val x = analysedCodeModel.codeModel.sourceCode.absolutePath.source

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
    if (duplicateLine) {
      output.write("    <th class=\"duplicate\">Duplicate</th>\n")
    } else {
      output.write("    <th></th>\n")
    }
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
