package metamorph.core

import org.scalatest.FunSpec
import io.Source
import java.io.File
import metamorph.Java.{SourceCodeFile, SourceCodeReader}
import metamorph.util.RootPath
import metamorph.ContentSource

class PathSpec extends FunSpec {
  val testFilename: String = "params.json"
  val filePattern = ".*\\.java"

  private def scan(file: File): Set[File] = {
    var files = Set[File]()

    if (file.isDirectory) {
      file.listFiles().foreach(f => files = files ++ scan(f))
    } else if (file.isFile) {
      if (file.getName.matches(filePattern)) {
        files = files + (file)
      }
    }
    files
  }


  describe("Path") {
    it("is initially empty") {
      val isVowel = Set('a', 'e', 'i', 'o', 'u')
      val vowelsInWord = (word: String) => word.filter(isVowel).toSet

      assert(isVowel('a') == true)

      assert(vowelsInWord("hello") == Set('o', 'e'))

      val files = Set(testFilename, testFilename)

      val expected = Source.fromFile(testFilename).size

      val sizes = files.map((filename: String) => {
        Source.fromFile(filename).size
      })

      assert(sizes == Set(expected, expected))

      val models = scan(new File(".")).map(file =>  new SourceCodeReader(new SourceCodeFile(new ContentSource("test", new RootPath(".")), file)).read)

      models.foreach(model => println(model.name, model.typeSignature))

      val fileSizes = scan(new File(".")).map((file: File) => Set(file.getName, file.length()))

      println(fileSizes)
    }
  }
}
