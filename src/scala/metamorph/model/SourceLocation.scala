package metamorph.model

trait SourceLocation {
    def getLine : Int
    def getStartCharacterOffset : Int
    def getEndCharacterOffset : Int
}
