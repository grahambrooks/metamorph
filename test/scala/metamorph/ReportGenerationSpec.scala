package metamorph

import org.scalatest.FunSpec
import org.clapper.scalasti.StringTemplateGroup

class ReportGenerationSpec extends FunSpec{
  describe("Report Generation") {
    it("Can apply available templates") {
      val group = new StringTemplateGroup("metamorph")
      val template = group.template("metamorph/templates/text/duplicate")

      template.setAttribute("title", "Duplication Report")

      assert(template.toString() === "Title: Duplication Report")
    }
  }
}
