package metamorph


class RootPath(path: String) {
  def length(): Int = path.length

  def removeFrom(pathText: String): String = {
    if (path.last == '/')
      pathText.substring(path.length)
    else
      pathText.substring(path.length + 1)
  }
}
