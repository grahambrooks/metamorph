using System;
using System.IO;
using System.Reflection;
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
        /// <param name="search_pattern"> File search pattern (*.cs) </param>
        public void ParseDirectory(string path, string search_pattern, ref int count, ref int files)
        {
            // use current directory if no path given
            if (path == string.Empty)
                path = ".";

            // recurse
            foreach (var subdir in Directory.GetDirectories(path))
                ParseDirectory(subdir, search_pattern, ref count, ref files);

            // parse the files
            foreach (var f in Directory.GetFiles(path, search_pattern))
            {
                // Do we pause/wait if errors are found?
                var wait = true;
                if (search_pattern.IndexOfAny(new[] {'*', '?'}) == -1)
                    wait = false;
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
        /// <param name="file_name"> I expect some_rule_01.ext for a file name. If the rule name matches a real rule I will call that method. Otherwise, we call parse.compilation_unit(), the start of the grammar. </param>
        /// <param name="wait"> Wait on errors or keep going. </param>
        /// <param name="count"> Count of files successfully parsed. </param>
        /// <returns> parser.[rule]_return </returns>
        public void ParseFile(string file_name, bool wait, ref int count)
        {
            var rule_name = RuleNameFromFilePath(file_name);

            // if the -a and the Archive attribute is set on the file, then skip it
            if (ArchiveFlagIsClear(file_name, ref count))
                return;

            Console.WriteLine("---------------");
            Console.Error.WriteLine(file_name);

            var tokens = CreateLexer<PreProcessor>(file_name);
            var p = new csParser(tokens);

            using (var con = new ConsolePause(wait))
            {
                // Try and call a rule like CSParser.namespace_body() 
                // Use reflection to find the rule to use.
                var mi = p.GetType().GetMethod(rule_name);

                // did we find a method the same as file name?
                if (mi != null)
                {
                    con.warn(string.Format("parser using rule -- {0}:", rule_name));
                    mi.Invoke(p, new object[0]);
                }
                else
                {
                    // by default use the start rule for csharp, I called this compilation_unit in the grammar.
                    con.warn("parser using rule -- compilation_unit:");
                    p.compilation_unit();
                }


                // If we parsed the file (no error messages), clear the Archive flag
                if (!con.HasMessages)
                {
                    // Clear archive attribute
                    File.SetAttributes(file_name, File.GetAttributes(file_name) & ~FileAttributes.Archive);
                    ++count;
                }
            }
        }

#if AST
    /// <summary> ParseFile
    /// </summary>
    /// <param name="file_name">I expect some_rule_01.ext for a file name.  If the rule name matches a real
    /// rule I will call that method.  Otherwise, we call parse.compilation_unit(), the start of the grammar.
    /// </param>
    /// <param name="wait"> Wait on errors or keep going.</param>
    /// <param name="count"> Count of files successfully parsed.</param>
    /// <returns>parser.[rule]_return</returns>
        public CommonTreeNodeStream ParseFileAST(string file_name, bool wait, ref int count)
		{
            string rule_name = RuleNameFromFilePath(file_name);

            // if the -a and the Archive attribute is set on the file, then skip it
            if (ArchiveFlagIsClear(file_name, ref count))
                return null;

			Console.WriteLine("---------------");
			Console.Error.WriteLine(file_name);

            CommonTokenStream tokens = CreateLexer<PreProcessor>(file_name);
			csParser p = new csParser(tokens);
			object parser_rt = null;
			CommonTree tree = null;

			using (ConsolePause con = new ConsolePause(wait))
			{
                // Try and call a rule like CSParser.namespace_body()
				// Use reflection to find the rule to use.
				MethodInfo mi = p.GetType().GetMethod(rule_name);

                // did we find a method the same as file name?
                if (mi != null)
				{
					con.warn(string.Format("parser using rule -- {0}:", rule_name));
					parser_rt = mi.Invoke(p, new object[0]);
				}
				else
				{
                    // by default use the start rule for csharp, I called this compilation_unit in the grammar.
					con.warn("parser using rule -- compilation_unit:");
                    p.compilation_unit();
//                    parser_rt = p.compilation_unit();
                }

                #region Error Checking
                // Sometimes ANTLR returns a CommonErrorNode if we can't parse the file
				if (parser_rt != null && parser_rt is CommonErrorNode)
				{
					Console.WriteLine(((CommonErrorNode)parser_rt).trappedException.Message);
					return null;
				}

				tree = (CommonTree)((RuleReturnScope)parser_rt).Tree;
                // Check if we didn't get an AST
                // This often happens if your grammar and tree grammar don't match
                if (tree == null)
				{
                    if (tokens.Count > 0)
					{
						con.err("No Tree returned from parsing! (Your rule did not parse correctly)");
					}
					else
					{
                        // the file was empty, this is not an error.
						// Clear archive attribute
						File.SetAttributes(file_name, File.GetAttributes(file_name) & ~FileAttributes.Archive);
						++count;
					}
					return null;
				}
				
                // If we parsed the file (no error messages), clear the Archive flag
				if (!con.HasMessages)
				{
					// Clear archive attribute
					File.SetAttributes(file_name, File.GetAttributes(file_name) & ~FileAttributes.Archive);
					++count;
                }
                #endregion
            }

            // Get the AST stream
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			// Add the tokens for DumpNodes, otherwise there are no token names to print out.
            nodes.TokenStream = tokens;

            // Dump the tree nodes if -n is passed on the command line.
			DumpNodes(nodes);
	
			return nodes;
		}
#endif

        /// <summary>
        ///   CreateLexer
        /// </summary>
        public CommonTokenStream CreateLexer<L>(string file_name)
            where L : Lexer, new()
        {
            var inputFileName = file_name;
            CommonTokenStream tokens = null;

            if (!Path.IsPathRooted(inputFileName))
                inputFileName = Path.Combine(Environment.CurrentDirectory, inputFileName);

            Console.WriteLine(inputFileName);
            ICharStream input = new ANTLRFileStream(inputFileName);
            var lex = new L();
            lex.CharStream = input;

            tokens = new CommonTokenStream(lex);
            return tokens;
        }

        /// <summary>
        ///   RuleNameFromFilePath Return a rule as a string using the file name. eg. namespace_body_00.cs -> namespace_body
        /// </summary>
        protected virtual string RuleNameFromFilePath(string file_name)
        {
            var fnne = Path.GetFileNameWithoutExtension(file_name);
            var file_name_no_extension = string.Empty;

            // try and find the ANTLR rule to use
            // eg. some_rule from the file name some_rule_NN.cs
            if (fnne != string.Empty && fnne.Length > 3)
                file_name_no_extension = fnne.Substring(0, fnne.Length - 3);

            return file_name_no_extension;
        }

        /// <summary>
        ///   ArchiveFlagIsClear If the command line has -a and the Archive attribute is clear, return true. We clear the archive attribute when we successfully parse a file.
        /// </summary>
        protected bool ArchiveFlagIsClear(string file_name, ref int count)
        {
            if (Args.IsFlagSet("-a"))
            {
                var attribs = File.GetAttributes(file_name);

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
                var str_spaces = "                                                                                       ";
                object o_prev = string.Empty;
                var o = nodes.NextElement();
                while (!nodes.IsEndOfFile(o))
                {
                    //object o = nodes.Get(n);
                    //object o = nodes[n];
                    if (o.ToString() == "DOWN")
                    {
                        spaces += 2;
                        if (o_prev.ToString() != "UP" && o_prev.ToString() != "DOWN")
                            Console.Write("\r\n{0} {1}", str_spaces.Substring(0, spaces), o_prev);
                    }
                    else if (o.ToString() == "UP")
                    {
                        spaces -= 2;
                        if (o_prev.ToString() != "UP" && o_prev.ToString() != "DOWN")
                            Console.Write(" {0}\r\n{1}", o_prev, str_spaces.Substring(0, spaces));
                    }
                    else if (o_prev.ToString() != "UP" && o_prev.ToString() != "DOWN")
                        Console.Write(" {0}", o_prev);

                    o_prev = o;
                    o = nodes.NextElement();
                }
                if (o_prev.ToString() != "UP" && o_prev.ToString() != "DOWN")
                    Console.WriteLine(" {0}", o_prev);
                Console.ResetColor();
            }
        }
    }
}