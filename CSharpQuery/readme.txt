You can run "parse *.cs" or "parse filename.cs" to check if the grammar will parse that file(s).  The file name has to be the first parameter.

parse filename.cs -n will dump out all the nodes it found in the AST.

parse filename.cs -a will only parse filename.cs if it has the Archive property set on the file.  It's just an easy way not to parse test files that you know already compile.  parse.exe clears the Archive bit when it successfully compiles a file.

The AntlrCSharp project builds the grammar using Java.  The project generates csLexer.cs and csParser.cs which are compiled in the CSharp project.  Visual Studio has a feature for external tools called Custom Build Rules.  These only exist in C++ projects.  So that is why the grammar is in a VC++ project and not in the CSharp project.  AntlrCSharp does nothing more than launch Java to build the lexer/parser.  (Right Click on the AntlrCSharp project and look for Custom Build Rules if you are curious.)  

See the AntlrCSharp project properties, configuration properties for setting Antlr options.  These options are built from the Custom Build Rule.

The CSharp project is nothing more than the compiled parser and lexer.  See the antlr.org site for more detail but the public methods on csParser.cs are nothing more than the rule names found in the grammar.  If you have the CSharp.dll you actually don't need to build cs.g from scratch, though of course you can.  

UnitTest, which builds parse.exe, is the test harness.  It will let you test individual rules.  If you pass a file name on the command line that matches a rule name, it will use that rule.  For example, "parse while_statement_00.cs" will call csParser.while_statement().  UnitTest uses reflection to find these methods.  This saves lots and lots of time since you don't have to change your unit test code all the time to test something new.  If it can't find a matching method, it uses compilation_unit().

