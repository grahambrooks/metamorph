package metamorph.analysis

import metamorph.BucketSet
import metamorph.model.{Warning, CodeModel, BlockDeclaration, MethodDeclaration}

class AnalysedSourceCode(val analysedModels: List[CodeModel],
                         val modelBuckets: BucketSet[CodeModel],
                         val methodBuckets: BucketSet[MethodDeclaration],
                         val blockBuckets: BucketSet[BlockDeclaration],
                         val warnings: List[Warning]) {
}