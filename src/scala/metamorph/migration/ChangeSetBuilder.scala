package metamorph.migration

import metamorph.refactor.RenameClass

class ChangeSetBuilder(migration: Migration) {
  def buildChangeSet: ChangeSet = {
    migration.foldLeft(new ChangeSet()) {
      (s, m) => {
        m match {
          case m: RenameMigration => s.copy(s.changes ::: List(new RenameClass(m.predicate.toString, m.newName)))
          case _ => s
        }
      }
    }
  }
}
