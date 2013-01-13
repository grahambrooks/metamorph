package metamorph.reporting

import java.io.Writer
import metamorph.Paths
import metamorph.model.CodeModel

class CodeModelHtml(val model: CodeModel, val output: Writer) extends Html {
  val currentPath = Paths.join(model.sourceCode.branchPath, model.sourceCode.sourceName, model.sourceCode.name)

  object LineType extends Enumeration {
    type LineType = Value
    val duplicate, unique, unknown = Value
  }

  html {
    head {
      title(model.sourceCode.name)

      link(href = currentPath.relativePathTo("prettify.css"), rel = "stylesheet")
      link(href = currentPath.relativePathTo("sunburst.css"), rel = "stylesheet")
      script(src = currentPath.relativePathTo("prettify.js"))
      link(rel = "stylesheet", href = currentPath.relativePathTo("site.css"))
    }
    body(onload = "prettyPrint()", fun = {
      div(clazz = "content", {
        div(clazz = "banner", {
          div(clazz = "header", {
            h1(model.sourceCode.name)
            p("Scanned path = " + currentPath.toString)
            a(currentPath.relativePathTo("index.html"), "Index")
          })

          div(clazz = "stats panel", {
            output.write(" <ul>\n")
            output.write(statsItem("Code size", 0, 0, 100))
            output.write(statsItem("Cyclomatic complexity", 0, model.stats.complexity, 100))
            output.write(statsItem("Methods", 0, 0, 100))
            output.write(statsItem("Depth in inheritance tree", 0, 0, 100))
            output.write(statsItem("Afferant coupling", 0, 0, 100))
            output.write(statsItem("Efferant coupling", 0, 0, 100))
          })
        })

        div(clazz = "code-block", {
          val x = model.sourceCode.source

          var lineNumber = 1
          var writingDuplicates = LineType.unknown
          output.write("<table>\n")
          openCodeRow(writingDuplicates)

          x.getLines().foreach(line => {
            val duplicateLine = if (model.isDuplicateLine(lineNumber)) LineType.duplicate else LineType.unique

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
      })
    })
  }

  def statsItem(title: String,toxicity:Int, count: Int, max: Int): String = {
    ("  <li>\n" +
      "    <span class=\"title\">%s</span>\n" +
      "    <span class=\"toxicity\">%d</span>\n" +
      "    <span class=\"value\">%d</span>\n" +
      "    <progress max=\"%d\" value=\"%d\"/>\n" +
      "  </li>").format(title, toxicity, count, max, count)
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
    //    if (duplicate == LineType.duplicate)
    //      output.write("    <td width=\"200px\" class=\"duplicate\"> Some metrics will go here</td>")
    //    else
    //      output.write("    <td width=\"200px\"></td>")

    output.write("    </tr>")
  }
}