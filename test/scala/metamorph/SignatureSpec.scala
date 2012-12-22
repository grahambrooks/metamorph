package metamorph

import model.MethodDeclaration
import org.scalatest.FunSpec
import collection.immutable.HashMap

class SignatureSpec extends FunSpec {

  describe("Signature") {
    it("Signature hash code reflects bound object") {
      StringSignature("foo").hashCode() == StringSignature("foo").hashCode()
    }

    it("can be used as a hash key") {

      val h = HashMap(StringSignature("foo") -> "foo string")
      assert (h(StringSignature("foo")) === "foo string")

    }

    it("can compose other signatures") {
      val s = StringSignature("foo")
      val s2 = CompositeSignature("bar", s)

      assert(s2.hashCode == "bar".hashCode + "foo".hashCode)
    }
  }
}
