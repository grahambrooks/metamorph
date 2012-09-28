import CodeR.Refactor

class SampleRefactor extends Refactor {

  method.call("method1").on(instancesOf(classes.derivedFrom("X"))).refactor {
    rename("method1").to("methdod2")
  }
}
