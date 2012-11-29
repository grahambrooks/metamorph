package metamorph

trait SourceLocation {
    def getLine : Int
    def getStartCharacterOffset : Int
    def getEndCharacterOffset : Int
}
