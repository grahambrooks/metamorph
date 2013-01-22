package metamorph.util

import java.io.File

object Paths {
  def join(path: BranchPath, leaf: String): PartialPath = new PartialPath(path.toString + '/' + leaf)

  def join(path: BranchPath, twig: String, leaf: String): PartialPath = new PartialPath(path.toString + '/' + twig + '/' + leaf)

  def make(file: File, twig: String, path: BranchPath) {
    new File(file.getPath + '/' + twig + '/' + path.toString).mkdirs

  }

}
