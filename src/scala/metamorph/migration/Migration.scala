package metamorph.migration

trait Migration {
  def count: Int

  def kind: String
  def apply(index: Int): Migration

  def foldLeft[B](z : B)(f : (B, Migration) => B) : B = {
    var result = f(z, this)
    for (index <- 0 to count) {
      result = f(result, this(index))
    }
    result
  }
}
