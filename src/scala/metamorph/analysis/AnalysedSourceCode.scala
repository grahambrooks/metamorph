package metamorph.analysis

import metamorph.model.{Warning, CodeModel, BlockDeclaration, MethodDeclaration}
import metamorph.util.BucketSet

class AnalysedSourceCode(val analysedModels: List[CodeModel],
                         val modelBuckets: BucketSet[CodeModel],
                         val methodBuckets: BucketSet[MethodDeclaration],
                         val blockBuckets: BucketSet[BlockDeclaration],
                         val warnings: List[Warning]) {
  def stats(declaration: MethodDeclaration): CodeStatistics = {
    new CodeStatistics
  }
}