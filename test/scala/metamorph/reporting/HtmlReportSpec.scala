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

      assert(report.render() === "<html><head><title>This is a report</title><head><body><h1>You know you want to!</h1><h1>You know you want to!</h1><h1>You know you want to!</h1></body></html>")
    }
  }

}
