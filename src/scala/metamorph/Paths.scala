package metamorph

import java.io.File

object Paths {
  def join(path: BranchPath, leaf: String): PartialPath = new PartialPath(path.toString + '/' + leaf)

  def make(file: File, path: BranchPath) {
    new File(file.getPath + '/' + path.toString).mkdirs

  }

}
