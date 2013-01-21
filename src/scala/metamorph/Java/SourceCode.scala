package metamorph.Java

import org.antlr.v4.runtime.CharStream
import io.Source
import metamorph.{BranchPath, Signature, AbsolutePath}
import metamorph.model.CodeModel

trait SourceCode {
  def rename(name: String)

  def edit(function: (CodeEditor) => Unit)

  def branchPath: BranchPath

  def absolutePath: AbsolutePath

  def source: Source

  def name: String

  def antlrStream: CharStream

  def signature: Signature

  def sourceName: String
}
