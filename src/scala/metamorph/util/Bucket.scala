package metamorph.util

class Bucket[T](item: T) extends Iterable[T] {
  var bucket:List[T] = List(item)
  def add(item:T) {
    bucket :::= List(item)
  }

  def hasDuplicates = bucket.size > 1

  def iterator = bucket.iterator

  def apply(i: Int): T = bucket(i)
}
