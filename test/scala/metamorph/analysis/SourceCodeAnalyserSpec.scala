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

  private def analyse(code: String): AnalysedSourceCode = {
    val analyser = new SourceCodeAnalyser

    analyser.analyse(new SourceProvider {
      def each(function: (SourceCode) => Any) {
        function(new SourceCodeString(code))
      }
    })
  }
}
