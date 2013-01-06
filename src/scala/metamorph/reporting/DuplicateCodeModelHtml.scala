package metamorph.reporting

import java.io.Writer
import metamorph.Paths
import metamorph.model.CodeModel

class DuplicateCodeModelHtml(val analysedCodeModel: CodeModel, val duplicates: List[CodeModel], val output: Writer) extends Html {
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

      val models =List(analysedCodeModel) ::: duplicates

      output.write("<table>\n")

      output.write("<tr>")
      models.foreach(acm => {
        output.write("<th class='duplicate'>%s : %s</th>".format(acm.sourceCode.sourceName, acm.sourceCode.name))
      })
      output.write("</tr>")

      output.write("<tr>")
      models.foreach(acm => {
        output.write("<td class='duplicate'>")
        output.write("<pre class=\"prettyprint\"><code class=\"prettyprint language-java\">")

        val x = acm.sourceCode.source
        x.getLines().foreach(line => {
          output.write("\n" + line)
        })
        output.write("</code></pre></td>")
      })
      output.write("</tr>")
    })
  }
}
