package CodeR

trait SourceLocation {
    def getLine : Int
    def getStartCharacterOffset : Int
    def getEndCharacterOffset : Int
}
