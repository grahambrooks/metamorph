package metamorph.Java

import org.antlr.v4.runtime.ANTLRInputStream
import io.Source
import java.io.{File, FileReader}
import metamorph.ContentSource
import metamorph.util.{Signature, BranchPath, AbsolutePath}


class SourceCodeFile(val contentSource: ContentSource, val file: File) extends SourceCode {
  def antlrStream = new ANTLRInputStream(new FileReader(file))

  def source = Source.fromFile(file)

  def absolutePath = AbsolutePath.fromString(file.getAbsolutePath)

  def name = file.getName

  def branchPath = {
    BranchPath.fromString(contentSource.rootPath.removeFrom(file.getParent))
  }

  def signature = Signature.fromString(file.getAbsolutePath)

  def sourceName = contentSource.name

  def edit(function: (CodeEditor) => Unit) {}

  def rename(name: String) {
    file.renameTo(new File(file.getParent + name))
  }
}
