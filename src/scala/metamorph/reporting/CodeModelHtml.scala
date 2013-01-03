package metamorph.reporting

import java.io.Writer
import metamorph.analysis.AnalysedCodeModel
import metamorph.Paths

class CodeModelHtml(val analysedCodeModel: AnalysedCodeModel, val output: Writer) extends Html {
  val currentPath = Paths.join(analysedCodeModel.codeModel.sourceCode.branchPath, analysedCodeModel.codeModel.sourceCode.sourceName, analysedCodeModel.codeModel.sourceCode.name)
  html {
    head {
      title(analysedCodeModel.codeModel.sourceCode.name)

      link(rel = "stylesheet", href = currentPath.relativePathTo("site.css"))
      link(href = currentPath.relativePathTo("prettify.css"), rel = "stylesheet")
      link(href = currentPath.relativePathTo("sunburst.css"), rel = "stylesheet")
      script(src = currentPath.relativePathTo("prettify.js"))
    }
    body(onload = "prettyPrint()", fun = {
      h1(analysedCodeModel.codeModel.sourceCode.name)
      p("Scanned path = " + currentPath.toString)
      a(currentPath.relativePathTo("index.html"), "Index")

      val x = analysedCodeModel.codeModel.sourceCode.source

      var lineNumber = 1
      var writingDuplicates = false
      output.write("<table>\n")
      openCodeRow(writingDuplicates)

      x.getLines().foreach(line => {
        val duplicateLine = analysedCodeModel.isDuplicateLine(lineNumber)

        if (duplicateLine != writingDuplicates) {
          writingDuplicates = duplicateLine
          closeCodeRow(!writingDuplicates)
          openCodeRow(writingDuplicates)
        }

        output.write("\n" + line)
        lineNumber = lineNumber + 1
      })
      output.write("</code></pre>")
      closeCodeRow(writingDuplicates)
      output.write("</table>\n")


      //      script(content="SyntaxHighlighter.all();")
    })
  }

  def openCodeRow(duplicateLine: Boolean) {
    output.write("<tr>\n")
    if (duplicateLine) {
      output.write("    <th class=\"duplicate\">Duplicate</th>\n")
    } else {
      output.write("    <th></th>\n")
    }

    output.write("    <td>")
    output.write("<pre class=\"prettyprint\"><code class=\"prettyprint language-java\">")

  }

  def closeCodeRow(duplicate: Boolean) {
    output.write("</code>\n" +
      "      </pre>\n" +
      "    </td>\n")
    if (duplicate)
      output.write("    <td width=\"200px\" class=\"duplicate\"> Some metrics will go here</td>")
    else
      output.write("    <td width=\"200px\"></td>")

    output.write("    </tr>")
  }
}