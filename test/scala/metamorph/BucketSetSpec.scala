package metamorph

import org.scalatest.FunSpec

class BucketSetSpec extends FunSpec {
  describe("BucketSet") {
    it("is initially empty") {
      val bucket = new BucketSet[Object]

      var count = 0
      bucket.eachDuplicate(duplicate => count += 1)
      assert(count == 0)
    }

    it("uses apply to allow member access") {
      val bucket = new BucketSet[Object]

      val foo: String = "foo"
      val s = Signature.fromString(foo)
      bucket.add(s, foo)

      assert(bucket(s) === bucket.buckets(s))
    }

    it("is testable for duplicates") {
      val bucket = new BucketSet[Object]

      val s = Signature.fromString("foo")
      bucket.add(s, this)
      bucket.add(s, this)

      assert(bucket.hasDuplicatesFor(s) == true)
    }

    it("provides a list of buckets with duplicates as a list") {
      val bucket = new BucketSet[Object]

      val s = Signature.fromString("foo")
      bucket.add(s, this)
      bucket.add(s, this)

      assert(bucket.duplicates().size == 1)
    }

    it("Counts duplicates and not the total count of items that are duplicated") {
      val bucket = new BucketSet[Object]

      val s = Signature.fromString("foo")
      bucket.add(s, this)
      bucket.add(s, this)

      assert(bucket.getDuplicateCount == 1)
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
