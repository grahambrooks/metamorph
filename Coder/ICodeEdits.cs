namespace Coder
{
    internal interface ICodeEdits
    {
        void Apply(SourceLine line, SourceFileWriter output);
    }
}