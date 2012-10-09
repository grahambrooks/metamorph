package CodeR

abstract class CodeChange {
  def apply(src: SourceFile): SourceFile
}
