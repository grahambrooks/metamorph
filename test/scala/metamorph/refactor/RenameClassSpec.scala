package metamorph.refactor

import org.scalatest.FunSpec
import io.Source
import metamorph.SupportedLanguages


//trait ClassDeclaration {}
//
//trait CompilationUnit {}
//
//trait Project {
//  def findClass(name: String) = null
//}


//class TestProject(units: List[SourceCode]) extends Project {
//  def refactor(changes: List[CodeChange]): Project = {
//    var updatedCode = List[SourceCode]()
//    units.foreach(sourceCode =>
//      updatedCode = updatedCode ::: List(sourceCode.refactor(changes))
//    )
//    new TestProject(updatedCode)
//  }
//}

object TestJavaSource {
  val baseClass =
    "package ren;\n" +
      "\n" +
      "public class BaseClass {\n" +
      "  public String toString() {\n" +
      "    return \"Base class\";\n" +
      "  }\n" +
      "}"

}


class RenameClassSpec extends FunSpec {

  //  val baseClass = new SourceCode {
  //    val text = ("package ren;\n" +
  //      "\n" +
  //      "public class BaseClass {\n" +
  //      "  public String toString() {\n" +
  //      "    return \"Base class\";\n" +
  //      "  }\n" +
  //      "}")
  //
  //    def refactor(changes: List[CodeChange]): CodeModel = {
  //      SupportedLanguages.Java.parser.refactor(Source.fromString(text), changes)
  //    }
  //  }
  describe("Class Rename") {
    ignore("Not yet implemented") {
      it("is applied during parsing") {
        val refactoredModel = SupportedLanguages.Java.parser.refactor(Source.fromString(TestJavaSource.baseClass), List(new RenameClass(currentName = "BaseClass", newName = "RenamedClass")))

        assert(refactoredModel.typeDeclaration.shortName == "RenamedClass")
      }
    }

    //    it("renames classes that exist and where the new name does not conflict with an existing class name") {
    //      val testProject = new TestProject(List(baseClass))
    //
    //      val change = new RenameClass(currentName = "BaseClass", newName = "RenamedClass")
    //
    //      val refactoredProject = testProject.refactor(List(change))
    //
    //      assert(refactoredProject.findClass("RenamedClass") != null)
    //      assert(refactoredProject.findClass("BaseClass") == null)
    //    }
  }
}
