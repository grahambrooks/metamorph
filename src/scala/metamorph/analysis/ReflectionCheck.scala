package metamorph.analysis

import metamorph.model.{Warning, CodeModel}

class ReflectionCheck {
  def apply(model: CodeModel): List[Warning] = {
    var warnings = List[Warning]()
    model.imports.foreach(importDecl => {
      if (importDecl.qualifiedName.startsWith("java.lang.reflect")) {
        warnings = warnings ::: List(new Warning(model, "Use of Java Reflection classes makes refactoring more difficult and may result in coding errors"))
      }
    })
    warnings
  }

}
