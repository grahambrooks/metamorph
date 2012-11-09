import metamorph.Refactor

class SampleRefactor extends Refactor {
  refactor {
    method.call("method1").on(instancesOf(classes.derivedFrom("X"))).refactor {
      rename("method1").to("methdod2")
    }
  }
}
