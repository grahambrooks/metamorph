package metamorph.reporting

import org.scalatest.FunSpec
import java.io.{File, StringWriter}

class HtmlReportSpec extends FunSpec {

  describe("Html reporting") {
    it("renders simple documents") {
      class HtmlTestReport extends Html {
        val output = new StringWriter()
        html {
          head {
            title("This is a report")
          }
          body {
            for (a <- 1 to 3)
              h1("You know you want to!")
          }
        }
      }


      val report = new HtmlTestReport
      assert(report.output.toString === "<html><head><title>This is a report</title>\n</head>\n<body><h1>You know you want to!</h1>\n<h1>You know you want to!</h1>\n<h1>You know you want to!</h1>\n</body>\n</html>\n")
    }

    it("handles relative paths") {
      val currentPath = "a/b/c.html"
      val targetPath = "x/y/z.js"

      val relativePath = {
        val x:String = currentPath.foldLeft("")((x,c) => { if (c == '/') x + "../" else x})
        x + targetPath
      }

      assert(relativePath === "../../x/y/z.js")
    }
  }

}
