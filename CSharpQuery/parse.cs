using System;
using System.IO;
using Antlr.Runtime;
using Antlr.Runtime.Tree;

namespace CSharpQuery
{
    public class Parse
    {
        /// <summary>
        ///   ParseDirectory Depth first recursive parse of a directory.
        /// </summary>
        /// <param name="count"> Parsed successfully. </param>
        /// <param name="files"> Total files. </param>
        /// <param name="path"> </param>
        /// <param name="searchPattern"> File search pattern (*.cs) </param>
        public void ParseDirectory(string path, string searchPattern, ref int count, ref int files)
        {
            // use current directory if no path given
            if (path == string.Empty)
                path = ".";

            // recurse
            foreach (var subdir in Directory.GetDirectories(path))
                ParseDirectory(subdir, searchPattern, ref count, ref files);

            // parse the files
            foreach (var f in Directory.GetFiles(path, searchPattern))
            {
                // Do we pause/wait if errors are found?
                var wait = searchPattern.IndexOfAny(new[] {'*', '?'}) != -1;
                if (Args.IsFlagSet("-q")) // Quick set?
                    wait = false;
                files++;

#if AST
                ParseFileAST(f, wait, ref count);
#else
                ParseFile(f, wait, ref count);
#endif
            } // foreach File
        }

        /// <summary>
        ///   ParseFile
        /// </summary>
        /// <param name="fileName"> I expect some_rule_01.ext for a file name. If the rule name matches a real rule I will call that method. Otherwise, we call parse.compilation_unit(), the start of the grammar. </param>
        /// <param name="wait"> Wait on errors or keep going. </param>
        /// <param name="count"> Count of files successfully parsed. </param>
        /// <returns> parser.[rule]_return </returns>
        public void ParseFile(string fileName, bool wait, ref int count)
        {
            var ruleName = RuleNameFromFilePath(fileName);

            // if the -a and the Archive attribute is set on the file, then skip it
            if (ArchiveFlagIsClear(fileName, ref count))
                return;

            Console.WriteLine("---------------");
            Console.Error.WriteLine(fileName);

            var tokens = CreateLexer<PreProcessor>(fileName);
            var p = new csParser(tokens);

            using (var con = new ConsolePause(wait))
            {
                // Try and call a rule like CSParser.namespace_body() 
                // Use reflection to find the rule to use.
                var mi = p.GetType().GetMethod(ruleName);

                // did we find a method the same as file name?
                if (mi != null)
                {
                    con.Warn(string.Format("parser using rule -- {0}:", ruleName));
                    mi.Invoke(p, new object[0]);
                }
                else
                {
                    // by default use the start rule for csharp, I called this compilation_unit in the grammar.
                    con.Warn("parser using rule -- compilation_unit:");
                    p.compilation_unit();
                }


                // If we parsed the file (no error messages), clear the Archive flag
                if (!con.HasMessages)
                {
                    // Clear archive attribute
                    File.SetAttributes(fileName, File.GetAttributes(fileName) & ~FileAttributes.Archive);
                    ++count;
                }
            }
        }

#if AST
        /// <summary>
        ///   ParseFile
        /// </summary>
        /// <param name="fileName"> I expect some_rule_01.ext for a file name. If the rule name matches a real rule I will call that method. Otherwise, we call parse.compilation_unit(), the start of the grammar. </param>
        /// <param name="wait"> Wait on errors or keep going. </param>
        /// <param name="count"> Count of files successfully parsed. </param>
        /// <returns> parser.[rule]_return </returns>
        public CommonTreeNodeStream ParseFileAST(string fileName, bool wait, ref int count)
        {
            var ruleName = RuleNameFromFilePath(fileName);

            // if the -a and the Archive attribute is set on the file, then skip it
            if (ArchiveFlagIsClear(fileName, ref count))
                return null;

            Console.WriteLine("---------------");
            Console.Error.WriteLine(fileName);

            var tokens = CreateLexer<PreProcessor>(fileName);
            var p = new csParser(tokens);
            object parserResult = null;
            CommonTree tree = null;

            using (var con = new ConsolePause(wait))
            {
                // Try and call a rule like CSParser.namespace_body()
                // Use reflection to find the rule to use.
                var mi = p.GetType().GetMethod(ruleName);

                // did we find a method the same as file name?
                if (mi != null)
                {
                    con.Warn(string.Format("parser using rule -- {0}:", ruleName));
                    parserResult = mi.Invoke(p, new object[0]);
                }
                else
                {
                    // by default use the start rule for csharp, I called this compilation_unit in the grammar.
                    con.Warn("parser using rule -- compilation_unit:");
                    p.compilation_unit();
//                    parser_rt = p.compilation_unit();
                }

                #region Error Checking

                // Sometimes ANTLR returns a CommonErrorNode if we can't parse the file
                if (parserResult != null && parserResult is CommonErrorNode)
                {
                    Console.WriteLine(((CommonErrorNode) parserResult).trappedException.Message);
                    return null;
                }

                var ruleReturnScope = parserResult as RuleReturnScope;
                if (ruleReturnScope != null) tree = (CommonTree) ruleReturnScope.Tree;
                // Check if we didn't get an AST
                // This often happens if your grammar and tree grammar don't match
                if (tree == null)
                {
                    if (tokens.Count > 0)
                    {
                        con.Err("No Tree returned from parsing! (Your rule did not parse correctly)");
                    }
                    else
                    {
                        // the file was empty, this is not an error.
                        // Clear archive attribute
                        File.SetAttributes(fileName, File.GetAttributes(fileName) & ~FileAttributes.Archive);
                        ++count;
                    }
                    return null;
                }

                // If we parsed the file (no error messages), clear the Archive flag
                if (!con.HasMessages)
                {
                    // Clear archive attribute
                    File.SetAttributes(fileName, File.GetAttributes(fileName) & ~FileAttributes.Archive);
                    ++count;
                }

                #endregion
            }

            // Get the AST stream
            var nodes = new CommonTreeNodeStream(tree) {TokenStream = tokens};
            // Add the tokens for DumpNodes, otherwise there are no token names to print out.

            // Dump the tree nodes if -n is passed on the command line.
            DumpNodes(nodes);

            return nodes;
        }
#endif

        /// <summary>
        ///   CreateLexer
        /// </summary>
        public CommonTokenStream CreateLexer<TL>(string fileName)
            where TL : Lexer, new()
        {
            var inputFileName = fileName;

            if (!Path.IsPathRooted(inputFileName))
                inputFileName = Path.Combine(Environment.CurrentDirectory, inputFileName);

            Console.WriteLine(inputFileName);
            ICharStream input = new ANTLRFileStream(inputFileName);
            var lex = new TL {CharStream = input};

            return new CommonTokenStream(lex);
        }

        /// <summary>
        ///   RuleNameFromFilePath Return a rule as a string using the file name. eg. namespace_body_00.cs -> namespace_body
        /// </summary>
        protected virtual string RuleNameFromFilePath(string fileName)
        {
            var baseName = Path.GetFileNameWithoutExtension(fileName);
            var fileNameNoExtension = string.Empty;

            // try and find the ANTLR rule to use
            // eg. some_rule from the file name some_rule_NN.cs

            if (!String.IsNullOrEmpty(baseName) && baseName.Length > 3)
                fileNameNoExtension = baseName.Substring(0, baseName.Length - 3);

            return fileNameNoExtension;
        }

        /// <summary>
        ///   ArchiveFlagIsClear If the command line has -a and the Archive attribute is clear, return true. We clear the archive attribute when we successfully parse a file.
        /// </summary>
        protected bool ArchiveFlagIsClear(string fileName, ref int count)
        {
            if (Args.IsFlagSet("-a"))
            {
                var attribs = File.GetAttributes(fileName);

                // if Archive is clear, then we parsed this already
                if ((attribs & FileAttributes.Archive) != FileAttributes.Archive)
                {
                    ++count;
                    return true;
                }
            }
            return false;
        }

        /// <summary>
        ///   DumpNodes The CommonTreeNodeStream has a tree in "flat form". The UP and DOWN tokens represent the branches of the tree. Dump these out in tree form to the console.
        /// </summary>
        private static void DumpNodes(CommonTreeNodeStream nodes)
        {
            // Dump out nodes if -n on command line
            if (Args.IsFlagSet("-n"))
            {
                Console.ForegroundColor = ConsoleColor.Magenta;
                Console.WriteLine("Nodes");
                var spaces = 0;
                const string spacesText = "                                                                                       ";
                object prev = string.Empty;
                var o = nodes.NextElement();
                while (!nodes.IsEndOfFile(o))
                {
                    //object o = nodes.Get(n);
                    //object o = nodes[n];
                    if (o.ToString() == "DOWN")
                    {
                        spaces += 2;
                        if (prev.ToString() != "UP" && prev.ToString() != "DOWN")
                            Console.Write("\r\n{0} {1}", spacesText.Substring(0, spaces), prev);
                    }
                    else if (o.ToString() == "UP")
                    {
                        spaces -= 2;
                        if (prev.ToString() != "UP" && prev.ToString() != "DOWN")
                            Console.Write(" {0}\r\n{1}", prev, spacesText.Substring(0, spaces));
                    }
                    else if (prev.ToString() != "UP" && prev.ToString() != "DOWN")
                        Console.Write(" {0}", prev);

                    prev = o;
                    o = nodes.NextElement();
                }
                if (prev.ToString() != "UP" && prev.ToString() != "DOWN")
                    Console.WriteLine(" {0}", prev);
                Console.ResetColor();
            }
        }
    }
}