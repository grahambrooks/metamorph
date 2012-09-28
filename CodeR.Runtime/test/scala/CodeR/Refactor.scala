package CodeR

class Refactor {

  protected final class Rename {
    def to(name: String) {}
  }

  def rename(name: String): Rename = {
    new Rename
  }

  protected final class RefactorOperation() {
  }

  protected class Predicate {
    def refactor(refactorFunction: => scala.Unit) {
      refactorFunction
    }
  }

  protected final class ClassPredicate(name: String) extends Predicate {
    def this() = this(null)

    def derivedFrom(className: String): ClassPredicate = new ClassPredicate(className)
  }

  protected final class InstancePredicate(classPredicate: ClassPredicate) extends Predicate {

  }

  protected final class MethodPredicate(methodName: String, predicate: Predicate) extends Predicate {
    def this() = this(null, null)

    def call(name: String): MethodPredicate = {
      new MethodPredicate(name, null)
    }

    def on(predicate: Predicate): Predicate = new MethodPredicate(methodName, predicate)
  }

  protected val refactor: RefactorOperation = {
    new RefactorOperation
  }

  protected val method: MethodPredicate = new MethodPredicate

  def classes: ClassPredicate = new ClassPredicate

  def instancesOf(predicate: ClassPredicate): Predicate = new InstancePredicate(predicate)
}
