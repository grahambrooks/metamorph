package metamorph

import collection.mutable

class SourceCode {
  var sources = new mutable.HashMap[String, SourceFile]

  def addFile(file: SourceFile) {
    sources(file.name) = file
  }


  def apply(changes: ChangeSet): SourceCode = {
    val modified = new SourceCode
    sources.foreach {
      case (name, code) => modified.sources(name) = changes.apply(code)
    }

    return modified
  }


  def file(name: String): SourceFile = {
    if (sources.get(name) != scala.None) {
      return sources(name).asInstanceOf[SourceFile]
    } else {
      val sf = new SourceFile(name)
      sources(name) = sf
      return sf
    }
  }
}
