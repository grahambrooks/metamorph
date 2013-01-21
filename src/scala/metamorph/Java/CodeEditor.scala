package metamorph.Java

trait CodeEditor {
  def replace(line: Int, startOffset: Int, length: Int, replacement: String)

  def renameFile(filename: String)
}
