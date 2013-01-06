package metamorph.analysis

import metamorph.BucketSet
import metamorph.model.{CodeModel, BlockDeclaration, MethodDeclaration}

class AnalysedSourceCode(val analysedModels: List[CodeModel],
                         val modelBuckets: BucketSet[CodeModel],
                         val methodBuckets: BucketSet[MethodDeclaration],
                         val blockBuckets: BucketSet[BlockDeclaration]) {
}