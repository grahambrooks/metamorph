using Antlr.Runtime;

namespace CSharpQuery
{
    public interface IQueryResults
    {
        void ProcessingFile(string filename);
        void ErrorProcessingFile(string filename);
        void CatchFound(IToken token);
        void EmptyCatchFound(IToken catchToken);
    }
}