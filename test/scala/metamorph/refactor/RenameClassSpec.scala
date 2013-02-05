package metamorph.refactor

import org.scalatest.FunSpec
import metamorph.SupportedLanguages
import metamorph.Java.SourceCodeString


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
  val someClass =
    "package ren;\n" +
      "\n" +
      "import ren.BaseClass;" +
      "\n" +
      "public class SomeClass {\n" +
      "  BaseClass baseClass;\n" +
      "\n" +
      "  public String toString() {\n" +
      "    BaseClass baseClassLocalVariable;\n" +
      "    return \"Base class\";\n" +
      "  }\n" +
      "}"

}


class RenameClassSpec extends FunSpec {
  describe("Class Rename") {
    it("renames classes that exist and where the new name does not conflict with an existing class name") {
      val sourceCode: SourceCodeString = new SourceCodeString(TestJavaSource.baseClass)
      SupportedLanguages.Java.refactoringParser(List(new RenameClass(currentName = "BaseClass", newName = "RenamedClass"))).refactor(sourceCode)

      val codeModel = SupportedLanguages.Java.parser.parse(sourceCode)

      assert(codeModel.typeDeclarations(0).shortName == "RenamedClass")
    }

    it("renames fully qualified references to renamed classes") {
      val sourceCode: SourceCodeString = new SourceCodeString(TestJavaSource.someClass)
      SupportedLanguages.Java.refactoringParser(List(new RenameClass(currentName = "ren.BaseClass", newName = "RenamedClass"))).refactor(sourceCode)

      val codeModel = SupportedLanguages.Java.parser.parse(sourceCode)

      assert(codeModel.imports.size == 1)
      assert(codeModel.imports(0).qualifiedName == "ren.RenamedClass")
    }

    it("renames un-qualified imports to renamed class if rename is not fully qualified") {
      val sourceCode: SourceCodeString = new SourceCodeString(TestJavaSource.someClass)
      SupportedLanguages.Java.refactoringParser(List(new RenameClass(currentName = "BaseClass", newName = "RenamedClass"))).refactor(sourceCode)

      val codeModel = SupportedLanguages.Java.parser.parse(sourceCode)

      assert(codeModel.imports.size == 1)
      assert(codeModel.imports(0).qualifiedName == "ren.RenamedClass")
    }

    it("renames the type of fields") {
      val sourceCode: SourceCodeString = new SourceCodeString(TestJavaSource.someClass)
      SupportedLanguages.Java.refactoringParser(List(new RenameClass(currentName = "BaseClass", newName = "RenamedClass"))).refactor(sourceCode)

      assert(sourceCode.text.contains("RenamedClass baseClass;"))
    }

    it("renames the type of variables") {
      val sourceCode: SourceCodeString = new SourceCodeString(TestJavaSource.someClass)
      SupportedLanguages.Java.refactoringParser(List(new RenameClass(currentName = "BaseClass", newName = "RenamedClass"))).refactor(sourceCode)

      assert(sourceCode.text.contains("RenamedClass baseClassLocalVariable;"))
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
