package metamorph

import org.scalatest.FunSpec
import collection.immutable.HashMap

class SignatureSpec extends FunSpec {

  describe("Signature") {
    it("Signature hash code reflects bound object") {
      Signature.fromString("foo").hashCode() == Signature.fromString("foo").hashCode()
    }

    it("can be used as a hash key") {

      val h = HashMap(Signature.fromString("foo") -> "foo string")
      assert(h(Signature.fromString("foo")) === "foo string")

    }

    it("can compose other signatures") {
      val s = Signature.fromString("foo")
      val s2 = Signature.composite("bar", s)

      assert(s2.hashCode == "bar".hashCode + "foo".hashCode)
    }
  }
}
