package metamorph.migration

import model.QualifiedName
import org.scalatest.FunSpec
import metamorph.refactor.RenameClass

class ChangeSetBuilderSpec extends FunSpec {
  describe("Change Set") {
    it("converts rename migrations to rename refactoring") {
      val currentName = new QualifiedName("A")
      val migrations = new RenameMigration(new Predicate(currentName), "B")

      val builder = new ChangeSetBuilder(migrations)

      val changes = builder.buildChangeSet

      assert(changes.count == 1)
      assert(changes(0).asInstanceOf[RenameClass].currentName == "A")
      assert(changes(0).asInstanceOf[RenameClass].newName == "B")
    }
  }
}
