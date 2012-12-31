package metamorph.Java

import org.antlr.v4.runtime.ANTLRInputStream
import io.Source
import java.io.{File, FileReader}

class SourceCodeFile(val rootPath:String, val file: File) extends SourceCode {
  def getInputStream = new ANTLRInputStream(new FileReader(file))

  def getSource = Source.fromFile(file)

  def getFilename = file.getAbsolutePath
  def getName = file.getName
  def branchPath = file.getParent.substring(rootPath.length+1)
}
