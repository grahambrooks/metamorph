package metamorph

import org.scalatest.FunSpec

class BucketSpec extends FunSpec {
  describe("BucketSet") {
    it("is initially empty") {
      val bucket = new BucketSet[Object]

      var count = 0
      bucket.eachDuplicate(duplicate => count += 1)
      assert(count == 0)
    }

    it("identifies duplicate signatures") {
      val bucket = new BucketSet[Object]

      val s = Signature.fromString("foo")
      bucket.add(s, this)
      bucket.add(s, this)
      var count = 0
      var duplicates = 0

      bucket.eachDuplicate(items => {
        count += 1
        duplicates += items.size
      })

      assert(count == 1)
      assert(duplicates == 2)
    }
  }
}
