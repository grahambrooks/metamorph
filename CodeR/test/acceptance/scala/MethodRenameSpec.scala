import CodeR.{SourceFile, SourceCode, Refactor}
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar

class MethodRenameSpec extends FlatSpec with ShouldMatchers with MockitoSugar with Refactor {
  it should "rename a called method" in {
    val s = new SourceCode()
    s.addFile(new SourceFile("X", "class X { void M() { X variable; variable.M(); } }"))

    s.file("X").getContents should equal("class X { void M() { X variable; variable.M(); } }")

    //    val src = source file ("X") containing ("class X { void M() { X variable; variable.M(); } }")

    val refactoring = refactor {
      method.call("M").on(instancesOf(classes.derivedFrom("X"))).refactor {
        rename to ("Y")
      }
    }

    val modified = s.apply(refactoring)

    modified.file("X").getContents should equal("class X { void M() { X variable; variable.Y(); } }")
  }
}
