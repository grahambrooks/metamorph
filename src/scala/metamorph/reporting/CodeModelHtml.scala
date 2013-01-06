package metamorph.reporting

import java.io.Writer
import metamorph.Paths
import metamorph.model.CodeModel

class CodeModelHtml(val analysedCodeModel: CodeModel, val output: Writer) extends Html {
  val currentPath = Paths.join(analysedCodeModel.sourceCode.branchPath, analysedCodeModel.sourceCode.sourceName, analysedCodeModel.sourceCode.name)

  object LineType extends Enumeration {
    type LineType = Value
    val duplicate, unique, unknown = Value
  }

  html {
    head {
      title(analysedCodeModel.sourceCode.name)

      link(href = currentPath.relativePathTo("prettify.css"), rel = "stylesheet")
      link(href = currentPath.relativePathTo("sunburst.css"), rel = "stylesheet")
      script(src = currentPath.relativePathTo("prettify.js"))
      link(rel = "stylesheet", href = currentPath.relativePathTo("site.css"))
    }
    body(onload = "prettyPrint()", fun = {
      h1(analysedCodeModel.sourceCode.name)
      p("Scanned path = " + currentPath.toString)
      a(currentPath.relativePathTo("index.html"), "Index")

      val x = analysedCodeModel.sourceCode.source

      var lineNumber = 1
      var writingDuplicates = LineType.unknown
      output.write("<table>\n")
      openCodeRow(writingDuplicates)

      x.getLines().foreach(line => {
        val duplicateLine = if (analysedCodeModel.isDuplicateLine(lineNumber)) LineType.duplicate else LineType.unique

        if (duplicateLine != writingDuplicates) {
          if (writingDuplicates != LineType.unknown) {
            closeCodeRow(duplicateLine)
            writingDuplicates = duplicateLine
            openCodeRow(writingDuplicates)
          }
          else
            writingDuplicates = duplicateLine

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

  def openCodeRow(duplicateLine: LineType.LineType) {
    output.write("<tr>\n")
    if (duplicateLine == LineType.duplicate) {
      output.write("    <th class=\"duplicate\">Duplicate</th>\n")
    } else {
      output.write("    <th></th>\n")
    }

    output.write("    <td>")
    output.write("<pre class=\"prettyprint\"><code class=\"prettyprint language-java\">")

  }

  def closeCodeRow(duplicate: LineType.LineType) {
    output.write("</code>\n" +
      "      </pre>\n" +
      "    </td>\n")
    if (duplicate == LineType.duplicate)
      output.write("    <td width=\"200px\" class=\"duplicate\"> Some metrics will go here</td>")
    else
      output.write("    <td width=\"200px\"></td>")

    output.write("    </tr>")
  }
}