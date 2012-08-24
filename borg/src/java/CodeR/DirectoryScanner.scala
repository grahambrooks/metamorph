package CodeR

import java.io.File

class DirectoryScanner (rootPath: String, filePattern : String) {

  private def scan(file: File, function: (File) => Any) {
          if (file.isDirectory) {
            file.listFiles().foreach(f => scan(f, function))
          } else if (file.isFile) {
            if (file.getName.matches(filePattern)) {
              function(file)
            }
          }

  }

  def eachFile(function: (File) => Any) {
    val rootFile = new File(rootPath);

    scan(rootFile, function)
  }
}