package metamorph

abstract class CodeChange {
  def apply(src: SourceFile): SourceFile
}
