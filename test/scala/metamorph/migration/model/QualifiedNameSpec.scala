package metamorph.migration.model

import org.scalatest.FunSpec

class QualifiedNameSpec extends FunSpec{
  describe("Qualified Name") {
    it("is composed of a name and qualification") {
      val qualifiedName = new QualifiedName(List("A", "b"), "C")

      assert(qualifiedName.name === "C")
    }

    it("represents a . separated name") {
      val qualifiedName = new QualifiedName(List("A", "B", "C"), "D")

      assert(qualifiedName.toString === "A.B.C.D")
    }

    it("need not be qualified") {
      val qualifiedName = new QualifiedName(List(), "A")

      assert(qualifiedName.toString == "A")
    }

    it("is comparable") {
      val qn1 = new QualifiedName("A")
      val qn2 = new QualifiedName("A")

      assert(qn1 == qn2)
    }
  }

}
