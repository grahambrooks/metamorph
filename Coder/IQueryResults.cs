using Antlr.Runtime;

namespace Coder
{
    public interface IQueryResults
    {
        void ProcessingFile(string filename);
        void ErrorProcessingFile(string filename);
        void CatchFound(IToken token);
        void EmptyCatchFound(IToken catchToken, IToken openingBrace, IToken closingBrace);
    }
}