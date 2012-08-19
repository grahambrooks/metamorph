namespace CSharpQuery
{
    public interface ISourceLocation
    {
        int Line { get; }
        int StartCharacterOffset { get; }
        int EndCharacterOffset  { get; }
    }
}