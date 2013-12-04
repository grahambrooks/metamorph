package metamorph.migration


class RenameMigration(val predicate: Predicate, val newName: String) extends Migration {
  def count = 0

  def kind = "Rename"

  def apply(index: Int) = null
}
