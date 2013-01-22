package metamorph.util

class PartialPath(path: String) {
  def relativePathTo(target: String): String =
    path.foldLeft("")((x, c) => {
    if (c == '/') x + "../" else x
  }) + target

  override def toString = path
}
