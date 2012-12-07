package metamorph

import model.MethodDeclaration
import org.scalatest.FunSpec
import collection.immutable.HashMap

class SignatureSpec extends FunSpec {

  describe("Signature") {
    it("Signature hash code reflects bound object") {
      new Signature("foo").hashCode() == new Signature("foo").hashCode()
    }

    it("can be used as a hash key") {

      val h = HashMap(new Signature("foo") -> "foo string")
      assert (h(new Signature("foo")) === "foo string")

    }
  }
}
