package metamorph.analysis

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import metamorph.Java.{SourceCodeString, SourceCode}

class SourceCodeAnalyserSpec extends FunSpec with ShouldMatchers {
  describe("Warnings") {
    it("should warn about references to java.lang.reflect in the imports list") {
      val results = analyse("import java.lang.reflect.*;")

      assert(results.analysedModels.length == 1)
      assert(results.warnings.length == 1)
      assert(results.warnings(0).message == "Use of Java Reflection classes makes refactoring more difficult and may result in coding errors")
    }

    it("warns about reflection when importing single class") {
      val results = analyse("import java.lang.reflect.Constructor;")

      assert(results.analysedModels.length == 1)
      assert(results.warnings.length == 1)
    }
  }

  describe("statistics") {
    it("calculates the cyclomatic complexity of a method") {
      val results = analyse("class X {" +
        "public void method() {" +
        "   if (a > 1) {" +
        "}" +
        "}}")

      assert(results.analysedModels(0).methods(0).stats.complexity == 2)
    }

    it("calculates the total cyclomatic complexity of a class") {
      val results = analyse("class X {" +
        "  public void method1() {" +
        "     if (a > 1) {" +
        "     }" +
        "  }" +
        "  public void method2() {" +
        "     if (a > 1) {" +
        "     }" +
        "  }" +
        "}")

      assert(results.analysedModels(0).stats.complexity == 4)
    }

    ignore("statistics that still need to be collected") {
      it("calculates total lines of code") {}
      it("calculates toxicity based on long methods and classes") {}
      it("calculates total number of methods") {}
      it("calculates toxicity for excessive number of methods per class") {}
      it("calculates depth in inheritance tree") {}
      it("calculates efferent coupling for a class") {}
      it("calculates toxicity for excessive efferent coupling") {}
      it("calculates afferent coupling for a class") {}
      it("calculates toxicity for excessive afferent coupling") {}
    }
  }

  private def analyse(code: String): AnalysedSourceCode = {
    val analyser = new SourceCodeAnalyser

    analyser.analyse(new SourceProvider {
      def each(function: (SourceCode) => Any) {
        function(new SourceCodeString(code))
      }
    })
  }
}
