package metamorph

import org.scalatest.FunSpec

class BucketSpec extends FunSpec {
  describe("Bucket") {
    it("is initially empty") {
      val bucket = new Bucket[Object]

      var count = 0
      bucket.eachDuplicate(dups => count += 1)
      assert(count == 0)
    }

    it("identifies duplicate signatures") {
      val bucket = new Bucket[Object]

      val s = new Signature("foo")
      bucket.add(s, this)
      bucket.add(s, this)
      var count = 0
      var duplicates = 0

      bucket.eachDuplicate(items => {count += 1; duplicates += items.size})

      assert(count == 1)
      assert(duplicates == 2)
    }
  }
}
