using System;
using System.IO;
using Antlr.Runtime;
using Antlr.Runtime.Tree;

namespace Coder.CSharp
{
    public class CSharpParser
    {
        public void ParseDirectory(string path, string searchPattern, IQueryResults results)
        {
            if (path == string.Empty)
                path = ".";

            ProcessDirectory(path, searchPattern, results);

            ProcessFiles(path, searchPattern, results);
        }

        private void ProcessFiles(string path, string searchPattern, IQueryResults results)
        {
            foreach (var f in Directory.GetFiles(path, searchPattern))
            {
                var wait = searchPattern.IndexOfAny(new[] {'*', '?'}) != -1;
                if (Args.IsFlagSet("-q")) // Quick set?
                    wait = false;

                ParseFile(f, wait, results);
            }
        }

        private void ProcessDirectory(string path, string searchPattern, IQueryResults results)
        {
            foreach (var subdir in Directory.GetDirectories(path))
            {
                ParseDirectory(subdir, searchPattern, results);
            }
        }

        public void ParseFile(string fileName, bool wait, IQueryResults results)
        {
            results.ProcessingFile(fileName);

            var tokens = CreateLexer<PreProcessor>(fileName);
            var p = new csParser(tokens) {TreeAdaptor = new CommonTreeAdaptor()};
            CommonTree tree = null;

            var parserResult = p.compilation_unit();

            if (parserResult != null) tree = (CommonTree) parserResult.Tree;

            if (tree == null)
            {
                if (tokens.Count > 0)
                {
                    results.ErrorProcessingFile(fileName);
                }
            }
            else
            {
                var nodes = new CommonTreeNodeStream(tree) {TokenStream = tokens};
                FindEmptyCatchBlocks(fileName, nodes, results);
            }
        }

        private void FindEmptyCatchBlocks(string fileName, CommonTreeNodeStream nodes, IQueryResults results)
        {
            try
            {
                var current = nodes.NextElement() as CommonTree;
                while (!nodes.IsEndOfFile(current))
                {
                    if (TokenMatches(current, "catch"))
                    {
                        var catchToken = current.Token;
                        results.CatchFound(catchToken);

                        current = nodes.NextElement() as CommonTree;

                        if (TokenMatches(current, "{"))
                        {
                            var openingBrace = current.Token;
                            current = nodes.NextElement() as CommonTree;
                            if (TokenMatches(current, "}"))
                            {
                                results.EmptyCatchFound(catchToken, openingBrace, current.Token);
                            }
                        }
                    }
                    current = nodes.NextElement() as CommonTree;
                }
            }
            catch (Exception)
            {
                results.ErrorProcessingFile(fileName);
            }
        }

        private static bool TokenMatches(CommonTree ct, string text)
        {
            return ct != null && ct.Token != null && ct.Token.Text == text;
        }

        public CommonTokenStream CreateLexer<TL>(string fileName)
            where TL : Lexer, new()
        {
            var inputFileName = fileName;

            if (!Path.IsPathRooted(inputFileName))
                inputFileName = Path.Combine(Environment.CurrentDirectory, inputFileName);

            ICharStream input = new ANTLRFileStream(inputFileName);
            var lex = new TL {CharStream = input};

            return new CommonTokenStream(lex);
        }
    }
}