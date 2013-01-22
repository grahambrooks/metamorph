package metamorph.util

object BranchPath {
  def fromString(sourcePath: String): BranchPath = new BranchPath {
    val path = sourcePath

    override def toString: String = path

    def join(leaf: String) = new PartialPath(path + '/' + leaf)
  }

}

abstract class BranchPath {
  def join(leaf: String): PartialPath

  override def toString: String
}
