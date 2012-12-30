package metamorph.reporting

import org.scalatest.FunSpec

class HtmlReportSpec extends FunSpec {

  describe("Html reporting") {
    it("renders simple documents") {
      class HtmlTestReport extends Html {

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
      assert(report.render() === "<html><head><title>This is a report</title>\n</head>\n<body><h1>You know you want to!</h1>\n<h1>You know you want to!</h1>\n<h1>You know you want to!</h1>\n</body>\n</html>\n")
    }
  }

}
