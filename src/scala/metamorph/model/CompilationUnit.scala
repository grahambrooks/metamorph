package metamorph.model

class CompilationUnit(val packageDeclaration: PackageDeclaration,
                      val imports: List[ImportDeclaration],
                      val types: List[TypeDeclaration]) {
}
