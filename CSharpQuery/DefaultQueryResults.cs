using System;
using System.Collections.Generic;
using Antlr.Runtime;

namespace CSharpQuery
{
    internal class CatchToken
    {
        private readonly int _line;

        public CatchToken(IToken t)
        {
            _line = t.Line;
        }

        public int Line
        {
            get { return _line; }
        }
    }

    internal class DefaultQueryResults : IQueryResults
    {
        private readonly Dictionary<string, List<CatchToken>> _scannedFiles = new Dictionary<string, List<CatchToken>>();
        private readonly List<CatchToken> _catchStatements = new List<CatchToken>();
        private readonly List<CatchToken> _emptyCatchStatements = new List<CatchToken>();
        private List<CatchToken> _currentFileList = new List<CatchToken>();
        private readonly List<String> _erroredFiles = new List<string>();

        public void ProcessingFile(string filename)
        {
            Console.Write('.');
            _currentFileList = new List<CatchToken>();
            _scannedFiles.Add(filename, _currentFileList);
        }

        public void ErrorProcessingFile(string filename)
        {
            _erroredFiles.Add(filename);
        }

        public void CatchFound(IToken token)
        {
            _catchStatements.Add(new CatchToken(token));
        }

        public void EmptyCatchFound(IToken catchToken)
        {
            _emptyCatchStatements.Add(new CatchToken(catchToken));
            _currentFileList.Add(new CatchToken(catchToken));
        }

        public void PrintSummaryToConsole()
        {
            PrintSummary(new ConsoleWriter());
        }

        public void PrintSummary(ConsoleWriter writer)
        {
            writer.WriteLine();
            writer.WriteLine("Query summary {0}", DateTime.Now);
            Separator(writer);
            writer.WriteLine("Files found                 {0}", _scannedFiles.Count + _erroredFiles.Count);
            writer.WriteLine("Successfully scanned        {0}", _scannedFiles.Count);
            writer.WriteLine("Catch blocks found          {0}", _catchStatements.Count);
            writer.WriteLine("Empty Catch blocks found    {0}", _emptyCatchStatements.Count);
            writer.WriteLine();


            foreach (var entry in _scannedFiles)
            {
                if (entry.Value.Count > 0)
                {
                    writer.WriteLine("{0} empty catch blocks found in {1}", entry.Value.Count, entry.Key);
                }
            }


            writer.WriteLine("");
            writer.WriteLine("Failed to scan:");
            Separator(writer);

            foreach (var erroredFile in _erroredFiles)
            {
                writer.Error("Error processing file {0}", erroredFile);
            }
        }

        private static void Separator(ConsoleWriter writer)
        {
            writer.WriteLine("----------------------------------------------------------------------");
        }
    }
}