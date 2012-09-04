package CodeR.CSharp.Parser

import org.scalatest.FlatSpec
import CodeR.CSharp.csParser
import org.antlr.runtime.{CommonTokenStream, ANTLRStringStream}
import org.antlr.runtime.tree.CommonTree
import org.scalatest.matchers.ShouldMatchers

class ParserTests extends FlatSpec with ShouldMatchers {

  def testParser(text: String): csParser = {
    val input = new ANTLRStringStream(text)

    val tokenStream = new CommonTokenStream(new PreProcessor(input))

    return new csParser(tokenStream)
  }

  def printNode(node: CommonTree, depth: Int) {
    for (d <- 0 to depth * 3) {
      print(' ')
    }

    if (node == null)
      println("<NULL>")
    else {
      println(node.getText)

      for (i <- 0 to node.getChildCount - 1) {
        printNode(node.getChild(i).asInstanceOf[CommonTree], depth + 1)
      }
    }
  }


  def printTree(scope: AnyRef) {
    if (scope != null)
      printNode(scope.asInstanceOf[CommonTree], 0)
    else
      println("No node available")
  }


  it should "parse basic primary expression list" in {
    val text =
      "//();" +
        "1;" +
        "true;" +
        "foo;" +
        "foo.bar;" +
        "a.b.c.d.e;" +
        "foo[];" +
        "foo[0];" +
        "foo[a];" +
        "foo[ab];" +
        "foo[ab].bar;" +
        "foo[ab].bar[a];" +
        "bar[][];" +
        "bar[a][];" +
        "bar[a][b];" +
        "foo();" +
        "foo(a);" +
        "foo(a,b);" +
        "foo[0].foo();" +
        "foo[a].foo(a);" +
        "foo[ab].foo(a,b);" +
        "foo[ab].bar.foo();" +
        "foo[ab].bar[a].foo();" +
        "//(foo)bar;			// unary does casting" +
        "this.foo;" +
        "this.foo();" +
        "this.foo[0];" +
        ""
    println(text)
    printTree(testParser(text).primary_expression_list.getTree)
  }


  it should "primary expression list 01" in {
    val text =
      "//();" +
        "foo;" +
        "foo.bar;" +
        "//foo->bar;" +
        "foo.bar->unsafe_member;" +
        "foo[ab]->bar;" +
        "a.b.c.d.e;" +
        "foo[];" +
        "foo[0];" +
        "foo[0](one,two,three);" +
        "foo[a];" +
        "foo[ab];" +
        "foo[ab].bar;" +
        "foo[ab].bar[a];" +
        "bar[][];" +
        "bar[a][];" +
        "bar[a][b];" +
        "foo();" +
        "foo(a);" +
        "foo(a,b);" +
        "foo[0].foo();" +
        "foo[a].foo(a);" +
        "foo[ab].foo(a,b);" +
        "foo[ab].bar.foo();" +
        "foo[ab].bar[a].foo();" +
        "//(foo);" +
        "this.foo;" +
        "this.foo();" +
        "this.foo()[4];" +
        "base.foo(one, two);" +
        "string.Intern(blah);" +
        "string.Intern<int>(blah);" +
        "StreamReader(context.Request.InputStream).ReadToEnd();" +
        "this.foo[0];" +
        "global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced);" +
        "typeof(foo);" +
        "" +
        "" +
        "" +
        "" +
        "new System.Uri(3,4);" +
        "new System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative);" +
        "new StreamReader(context.Request.InputStream).ReadToEnd();" +
        "//doc.LoadXml(new StreamReader(context.Request.InputStream).ReadToEnd());" +
        "((ModuleResolveEventHandler) ds[i])(this, new ResolveEventArgs(moduleName));" +
        "\"string\"[i%3];" +
        "test<asdf>;"

    printTree(testParser(text).primary_expression_list.getTree)
  }


  it should "primary expression part 00" in {
    val text = "(args)"

    printTree(testParser(text).primary_expression_part.getTree)
  }


  it should "primary expression start 00" in {
    val text = "foo"

    printTree(testParser(text).primary_expression_start.getTree)
  }


  it should "primary expression start 01" in {
    val text = "Foso"

    printTree(testParser(text).primary_expression_start.getTree)
  }


  it should "type 00" in {
    val text = "SomeType?"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 01" in {
    val text = "bool?"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 02" in {
    val text = "bool*"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 03" in {
    val text = "void**"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 05" in {
    val text = "List<string>"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 06" in {
    val text = "List[]"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 07" in {
    val text = "List<Foo<sstring>>"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 08" in {
    val text = "int[]"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 09" in {
    val text = "List<one,two>.Foo.Bar"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type 10" in {
    val text = "Foo[]"

    printTree(testParser(text).`type`.getTree)
  }


  it should "type or generic 00" in {
    val text = "Nullable<T>"

    printTree(testParser(text).type_or_generic.getTree)
  }


  it should "type or generic 01" in {
    val text =
      "Outer<Nullable<T>>" +
        ""
    testParser(text).type_or_generic
  }


  it should "type or generic 02" in {
    val text =
      "List<Foo<sstring>>" +
        ""
    testParser(text).type_or_generic
  }


  it should "unbound type name 10" in {
    val text =
      "Foo<,>" +
        ""
    testParser(text).unbound_type_name
  }


  it should "access operator 00" in {
    val text =
      "->" +
        ""
    testParser(text).access_operator
  }


  it should "additive expression 00" in {
    val text =
      "a - b" +
        ""
    testParser(text).additive_expression
  }


  it should "additive expression 01" in {
    val text =
      "mousePos - edges[i]._p1Transformed" +
        ""
    testParser(text).additive_expression
  }


  it should "additive expression 02" in {
    val text =
      "//edges[i].p1Transformed + numer / FOO" +
        "edges[i].p1Transformed + (number / foo)" +
        ""
    testParser(text).additive_expression
  }


  it should "anonymous method expression 00" in {
    val text =
      "delegate(Object obj, X509Certificate certificate, X509Chain chain, SslPolicyErrors errors)" +
        "{" +
        "return true;" +
        "}" +
        ""
    testParser(text).anonymous_method_expression
  }


  it should "anonymous object creation expression 00" in {
    val text =
      "//new" +
        "{ ggg = 5 }" +
        ""
    testParser(text).anonymous_object_creation_expression
  }


  it should "argument value 00" in {
    val text =
      "args" +
        "" +
        ""
    testParser(text).argument_value
  }


  it should "arguments 00" in {
    val text =
      "(args)" +
        "" +
        ""
    testParser(text).arguments
  }


  it should "arguments 01" in {
    val text =
      "(2,3)" +
        "" +
        ""
    testParser(text).arguments
  }


  it should "arguments 02" in {
    val text =
      "(ref (int) ref foo)" +
        "" +
        ""
    testParser(text).arguments
  }


  it should "array creation expression 00" in {
    val text =
      "new Point[3]" +
        "" +
        ""
    testParser(text).array_creation_expression
  }


  it should "array creation expression 01" in {
    val text =
      "new System.Point [4]" +
        "" +
        "" +
        ""
    testParser(text).array_creation_expression
  }


  it should "array creation expression 02" in {
    val text =
      "new int[3] {" +
        "1,2,3,4,5,6" +
        "}" +
        ""
    testParser(text).array_creation_expression
  }


  it should "array creation expression 03" in {
    val text =
      "new System.Point[4].GetEnumerator()" +
        ""
    testParser(text).array_creation_expression
  }


  it should "array initializer 00" in {
    val text =
      "{" +
        "1,2,3,4,5,6" +
        "}" +
        ""
    testParser(text).array_initializer
  }


  it should "assignment 00" in {
    val text =
      "StartupUri = 100" +
        ""
    testParser(text).assignment
  }


  it should "assignment 01" in {
    val text =
      "foo.StartupUri = 100" +
        ""
    testParser(text).assignment
  }


  it should "assignment 04" in {
    val text =
      "v1 = mousePos - edges[i]._p1Transformed" +
        ""
    testParser(text).assignment
  }


  it should "assignment 05" in {
    val text =
      "this.StartupUri = 100" +
        ""
    testParser(text).assignment
  }


  it should "assignment 06" in {
    val text =
      "searchPattern = Path(args)" +
        ""
    testParser(text).assignment
  }


  it should "assignment 07" in {
    val text =
      "a = b = c" +
        ""
    testParser(text).assignment
  }


  it should "assignment 08" in {
    val text =
      "searchPattern = Path.GetFileName = \"foo\"" +
        ""
    testParser(text).assignment
  }


  it should "assignment 09" in {
    val text =
      "this.StartupUri = new System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative)" +
        ""
    testParser(text).assignment
  }


  it should "assignment list 00" in {
    val text =
      "variable = Foo.Path(args);" +
        "variable2 = (CastMe)Foo.Path;" +
        "variable3 = (CastMe)Foo.Path(args);" +
        "//visCorners[0] = gt.Transform(new Point(contBounds.Left, contBounds.Top));" +
        "//a = b = c = \"foo\";" +
        "//searchPattern = (Zamo)Path.GetFileName(args);" +
        "//groups = model as Model3DGroup;" +
        "//this.argumentMap[argument.LongName] = argument;" +
        ""
    testParser(text).assignment_list
  }


  it should "attributes 00" in {
    val text =
      "[SecurityPermission(SecurityAction.LinkDemand,UnmanagedCode=true)]" +
        ""
    testParser(text).attributes
  }


  it should "block 00" in {
    val text =
      "{}" +
        ""
    testParser(text).block
  }


  it should "block 01" in {
    val text =
      ";" +
        ""
    testParser(text).block
  }


  it should "block 02" in {
    val text =
      "{;}" +
        ""
    testParser(text).block
  }


  it should "cast expression 00" in {
    val text =
      "(UIElement)Mouse" +
        ""
    testParser(text).cast_expression
  }


  it should "cast expression 01" in {
    val text =
      "(int)Mouse.Foo" +
        ""
    testParser(text).cast_expression
  }


  it should "cast expression 02" in {
    val text =
      "(int[])Mouse.Foo" +
        ""
    testParser(text).cast_expression
  }


  it should "cast expression 03" in {
    val text =
      "(int[])Mouse.Foo()" +
        ""
    testParser(text).cast_expression
  }


  it should "class base 00" in {
    val text =
      ": Comparer<Nullable<T>>" +
        ""
    testParser(text).class_base
  }


  it should "parse empty class declaration" in {
    val text =
      "class DisplayPaneCommands" +
        "{}"

    printTree(testParser(text).class_declaration.getTree)
  }


  it should "parse class declaration with single field" in {
    val text =
      "class DisplayPaneCommands" +
        "{	public int foo;    }"
    printTree(testParser(text).class_declaration.getTree)
  }


  it should "parse class declaration with single const field" in {
    val text =
      "class DisplayPaneCommands" +
        "{	public const int foo;    }"
    testParser(text).class_declaration
  }


  it should "class declaration 03" in {
    val text =
      "class DisplayPaneCommands" +
        "{" +
        "static public string[] Forward;" +
        "public string Forward;" +
        "public const string Forward;" +
        "public string Forward		   = \"Backwards\";" +
        "public const double Sideways   = 1234;" +
        "public const string Sideways   = 1.234;" +
        "public const string Sideways   = 1.234f;" +
        "public const string Sideways   = 0x1234;" +
        "//        public const string Back       = 0.ToString();" +
        "public const string Back       = null;" +
        "public string Foo			= SomeFunction();" +
        "public const string FindInPage = \"FindInPage\";" +
        "public const string Cut        = \"Cut\";" +
        "public const string Copy       = \"Copy\";" +
        "public const string Paste      = \"Paste\";" +
        "public const string Print      = \"Print\";" +
        "public const string PageDown   = \"PageDown\";" +
        "public const string SelectAll  = \"SelectAll\";" +
        "public const string RenameSelection = \"RenameSelection\";" +
        "public const string NextSearchResult = \"NextSearchResult\";" +
        "public const string PrevSearchResult = \"PrevSearchResult\";" +
        "}" +
        ""
    testParser(text).class_declaration
  }


  it should "class declaration 04" in {
    val text =
      "class App : System.Windows.Application {" +
        "" +
        "//        [System.Diagnostics.DebuggerNonUserCodeAttribute()]" +
        "public void InitializeComponent() {" +
        "" +
        "//            #line 18 \"..\\..\\App.xaml\"" +
        "//            this.StartupUri = new System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative);" +
        "" +
        "//            #line default" +
        "//            #line hidden" +
        "}" +
        "}" +
        ""
    testParser(text).class_declaration
  }


  it should "class declaration 05" in {
    val text =
      "class App : System.Windows.Application {" +
        "" +
        "public EventHandler<ParserFoo> ActionSelected;" +
        "public event EventHandler<ParserActionEventArgs> ActionSelected;" +
        "//        [System.Diagnostics.DebuggerNonUserCodeAttribute()]" +
        "public void InitializeComponent() {" +
        "" +
        "//            #line 18 \"..\\..\\App.xaml\"" +
        "//            this.StartupUri = new System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative);" +
        "" +
        "//            #line default" +
        "//            #line hidden" +
        "}" +
        "}" +
        ""
    testParser(text).class_declaration
  }


  it should "class declaration 06" in {
    val text =
      "class App : System.Windows.Application" +
        "{" +
        "" +
        "public event EventHandler<ParserActionEventArgs> ActionSelected;" +
        "public bool? InitializeComponent()" +
        "{" +
        "}" +
        "}" +
        ""
    testParser(text).class_declaration
  }


  it should "class declaration 07" in {
    val text =
      "class App : System.Windows.Application" +
        "{" +
        "" +
        "public Foo.bar.baz<string>.FOO foo;" +
        "public Foo<string,string>.bar.baz<string>.FOO foo;" +
        "public event EventHandler<ParserActionEventArgs> ActionSelected;" +
        "public bool? InitializeComponent()" +
        "{" +
        "}" +
        "}" +
        ""
    testParser(text).class_declaration
  }


  it should "class declaration 08" in {
    val text =
      "class GenericArraySortHelper" +
        "where TKey : new()" +
        "{" +
        "" +
        "}" +
        ""
    testParser(text).class_declaration
  }


  it should "class declaration 09" in {
    val text =
      "class NullableComparer where T : Comparer<WTF<T>>" +
        "{" +
        "" +
        "}" +
        ""
    testParser(text).class_declaration
  }


  it should "class member declaration 08" in {
    val text =
      "" +
        "[SecurityPermission(SecurityAction.LinkDemand,UnmanagedCode=true)]" +
        "internal class GenericArraySortHelper<TKey, TValue>" +
        ": IArraySortHelper<TKey, TValue>" +
        "where TKey : IComparable<TKey>" +
        "{" +
        "" +
        "}" +
        "#if !FEATURE_PAL" +
        "#else // !FEATURE_PAL" +
        "" +
        "#if !PLATFORM_UNIX" +
        "//       //internal const String DLLPREFIX = \"\";" +
        "//       //internal const String DLLSUFFIX = \".dll\";" +
        "#else // !PLATFORM_UNIX" +
        "#if __APPLE__" +
        "//       //internal const String DLLPREFIX = \"lib\";" +
        "//       //internal const String DLLSUFFIX = \".dylib\";" +
        "// #elif _AIX" +
        "//       //internal const String DLLPREFIX = \"lib\";" +
        "//       //internal const String DLLSUFFIX = \".a\";" +
        "#elif __hppa__ || IA64" +
        "//       //internal const String DLLPREFIX = \"lib\";" +
        "//       //internal const String DLLSUFFIX = \".sl\";" +
        "// #else" +
        "//       //internal const String DLLPREFIX = \"lib\";" +
        "//       //internal const String DLLSUFFIX = \".so\";" +
        "#endif" +
        "#endif // !PLATFORM_UNIX" +
        "#endif" +
        ""
    testParser(text).class_member_declaration
  }


  ignore should "parse collection initializer" in {
    val text =
      "//new Point3D[] {" +
        "new Point3D(x1, y1, z1)," +
        "new Point3D(x1, y1, z2)," +
        "new Point3D(x1, y2, z1)," +
        "new Point3D(x1, y2, z2)," +
        "new Point3D(x2, y1, z1)," +
        "new Point3D(x2, y1, z2)," +
        "new Point3D(x2, y2, z1)," +
        "new Point3D(x2, y2, z2)," +
        "}"

    testParser(text).collection_initializer
  }


  it should "conditional expression 00" in {
    val text = "true ? -1 : 1"
    testParser(text).conditional_expression
  }


  it should "conditional expression 01" in {
    val text =
      "this is ProxyHwnd ? this : null" +
        ""
    testParser(text).conditional_expression
  }


  it should "declaration statement 00" in {
    val text = "string searchPattern = Path.GetFileName(args);"
    printTree(testParser(text).declaration_statement.getTree)
  }


  it should "parse declaration statement with constant initializer" in {
    val text = "int minimumHelpTextColumn = 5;"
    printTree(testParser(text).declaration_statement.getTree)
  }


  it should "delegate declaration 00" in {
    val text =
      "/// <summary>" +
        "/// A generic delegate for calling a function with one parameter of type <see cref=\"IResource\"/>." +
        "/// </summary>" +
        "delegate void ResourceDelegate( IResource res );" +
        "" +
        "/// <summary>" +
        "/// A generic delegate for calling a function with one parameter of type <see cref=\"IResourceList\"/>." +
        "/// </summary>" +
        "//    public delegate void ResourceListDelegate( IResourceList resList );" +
        ""
    testParser(text).delegate_declaration
  }


  it should "delegate declaration 01" in {
    val text =
      "/// <summary>" +
        "/// A generic delegate for calling a function with one parameter of type <see cref=\"IResourceList\"/>." +
        "/// </summary>" +
        "delegate void ResourceListDelegate( IResourceList resList );" +
        ""
    testParser(text).delegate_declaration
  }


  it should "delegate declaration 02" in {
    val text =
      "/// <summary>" +
        "/// A generic delegate for calling a function with one parameter of type <see cref=\"IResourceList\"/>." +
        "/// </summary>" +
        "delegate void ResourceListDelegate<out T>( IResourceList resList );" +
        ""
    testParser(text).delegate_declaration
  }


  it should "delegate declaration list 00" in {
    val text =
      "/// <summary>" +
        "/// A generic delegate for calling a function with one parameter of type <see cref=\"IResource\"/>." +
        "/// </summary>" +
        "public delegate void ResourceDelegate( IResource res );" +
        "" +
        "/// <summary>" +
        "/// A generic delegate for calling a function with one parameter of type <see cref=\"IResourceList\"/>." +
        "/// </summary>" +
        "public delegate void ResourceListDelegate( IResourceList resList );" +
        "private delegate void DispatcherCallback();" +
        ""
    testParser(text).delegate_declaration_list
  }


  it should "destructor declaration 00" in {
    val text =
      "~SafeHandle()" +
        "{" +
        "this.Dispose(false);" +
        "}" +
        ""
    testParser(text).destructor_declaration
  }


  it should "embedded statement 00" in {
    val text =
      "//Path.Foo();" +
        "this.argumentMap[argument.LongName] = argument;" +
        ""
    testParser(text).embedded_statement
  }


  it should "embedded statement 01" in {
    val text =
      "*(src + len) = 0;" +
        "" +
        "" +
        ""
    testParser(text).embedded_statement
  }


  it should "enum declaration 00" in {
    val text =
      "/// <summary>" +
        "/// Specifies a format of a plain or rich text string." +
        "/// </summary>" +
        "//public" +
        "enum TextFormat" +
        "{" +
        "/// <summary>" +
        "/// The string contains plain text." +
        "/// </summary>" +
        "PlainText," +
        "" +
        "/// <summary>" +
        "/// The string is a valid HTML fragment." +
        "/// </summary>" +
        "Html," +
        "" +
        "/// <summary>" +
        "/// The string contains rich text in the RTF format." +
        "// </summary>" +
        "Rtf ," +
        "}" +
        ""
    testParser(text).enum_declaration
  }


  it should "enum member declaration 00" in {
    val text =
      "/// <summary>" +
        "/// Specifies a format of a plain or rich text string." +
        "/// </summary>" +
        "/// <summary>" +
        "/// The string contains plain text." +
        "/// </summary>" +
        "PlainText" +
        ""
    testParser(text).enum_member_declaration
  }


  it should "enum member declaration 01" in {
    val text =
      "PlainText4 = 4" +
        ""
    testParser(text).enum_member_declaration
  }


  it should "enum member declaration 02" in {
    val text =
      "PlainText4 = Plain" +
        ""
    testParser(text).enum_member_declaration
  }


  it should "enum member declarations 00" in {
    val text =
      "// enum_body can have the trailing ','" +
        "PlainText1," +
        "PlainText2," +
        "PlainText3," +
        "PlainText4 = 4," +
        "PlainText5 = 7" +
        ""
    testParser(text).enum_member_declarations
  }


  it should "event declaration 00" in {
    val text =
      "event string[] ActionSelected;" +
        ""
    testParser(text).event_declaration
  }


  it should "expression 00" in {
    val text =
      "100" +
        ""
    testParser(text).expression
  }


  it should "expression 01" in {
    val text =
      "new System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative)" +
        ""
    testParser(text).expression
  }


  it should "expression 02" in {
    val text =
      "Path(args)" +
        ""
    testParser(text).expression
  }


  it should "expression 03" in {
    val text =
      "from from_ in students" +
        "where student.Scores[0] > 90" +
        "select student" +
        "" +
        ""
    testParser(text).expression
  }


  it should "expression list 00" in {
    val text =
      "3,4" +
        "" +
        ""
    testParser(text).expression_list
  }


  it should "expression list test 02" in {
    val text =
      "4;" +
        "Foo.Path(args);" +
        "gt.Transform(new Point(contBounds.Left, contBounds.Top));" +
        "mousePos - edges[i]._p1Transformed;" +
        "numer / denom;" +
        "(string)Path.GetFileName(args);" +
        "typeof(foo);" +
        "foo ?? bar;" +
        "foo <= bar;" +
        "foo is bar;" +
        "foo as bar;" +
        "true ? true : false;" +
        "(zf == doubl.PositiveInfinity) ? -1 : (zf / (zn - zf));" +
        "(zf == double.PositiveInfinity) ? -1 : (zf / (zn - zf));" +
        "new Point3D(x2, y2, z2);" +
        "((ICollection)_storage).CopyTo(array, index);" +
        "global::System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced);" +
        "this.argumentMap[argument.LongName] = argument;" +
        "strings[index++] = new ArgumentHelpStrings(\"@<file>\", \"Read response file for more options\");" +
        "LongName(attribute, field).Substring(0,1);" +
        "base.foo(one, two);" +
        "string.Intern(symbol);" +
        "//Type ? typeof(Type) : value.GetType();" +
        "typeof(object) as RuntimeType;" +
        "\"string\"[i % 3];" +
        "*(src + len) = 0;" +
        "new object[0];" +
        "new object[0].GetEnumerator();" +
        ""
    testParser(text).expression_list_test
  }


  it should "expression statement 00" in {
    val text =
      "StartupUri = 100;" +
        ""
    testParser(text).expression_statement
  }


  it should "expression statement 01" in {
    val text =
      "foo.StartupUri = 100;" +
        ""
    testParser(text).expression_statement
  }


  ignore should "expression statement" in {
    val text =
      "//Path.Foo();" +
        "this.argumentMap[argument.LongName] = argument;"
    testParser(text).expression_statement
  }


  it should "parse expression statement increment expression" in {
    val text = "++i;"

    printTree(testParser(text).expression_statement.getTree)
  }


  it should "expression statement 05" in {
    val text = "this.StartupUri = 100;"

    printTree(testParser(text).expression_statement.getTree)
  }


  it should "expression statement 08" in {
    val text = "strings[index++] = new ArgumentHelpStrings(\"@<file>\", \"Read response file for more options\");"

    printTree(testParser(text).expression_statement.getTree)
  }


  it should "expression statement 09" in {
    val text = "this.StartupUri = new System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative);"

    printTree(testParser(text).expression_statement.getTree)
  }


  ignore should "parse field declaration" in {
    val text =
      "//internal static readonly Typesa" +
        "ClassTypes" +
        "= {" +
        "typeof(void)," +
        "typeof(Char)," +
        "typeof(SByte)," +
        "typeof(Byte)," +
        "typeof(Int16)," +
        "typeof(UInt16)," +
        "typeof(Int32)," +
        "typeof(UInt32)," +
        "typeof(Int64)," +
        "typeof(UInt64)," +
        "typeof(Single)," +
        "typeof(Double)," +
        "typeof(String)," +
        "typeof(void)," +
        "typeof(DateTime)," +
        "typeof(TimeSpan)," +
        "typeof(Object)," +
        "typeof(Decimal)," +
        "null,  // Enums - what do we do here?" +
        "typeof(Missing)," +
        "typeof(DBNull)," +
        "};" +
        "/* */"

    printTree(testParser(text).field_declaration.getTree)
  }


  it should "field declarations 00" in {
    val text =
      "public string Foo;" +
        "public tring[] Foo;" +
        "public string[] Foo = 0;" +
        "public string Foo,Bar;" +
        "internal unsafe void* BaseAddress;" +
        "" +
        "// We need \"expression\" for these next tests." +
        "//public const string Foo = string.Empty;" +
        "//public const string Foo = 0.ToString();"

    printTree(testParser(text).field_declarations.getTree)
  }


  it should "fixed statement 00" in {
    val text =
      "fixed(byte* b = basePtr)" +
        "{" +
        "IntPtr currentPtr = new IntPtr( (vsoid *) b);" +
        "}"

    printTree(testParser(text).fixed_statement.getTree)
  }


  it should "for statement 00" in {
    val text = "for (int i = Stack.Count - 2; i >= 0; i++)" +
      ";"

    printTree(testParser(text).for_statement.getTree)
  }


  it should "for statement 01" in {
    val text =
      "for (int i = buckets[bucket]; i >= 0; last = i, i = entries[i].next)" +
        ";" +
        ""
    testParser(text).for_statement
  }


  it should "formal parameter list 00" in {
    val text = "WordPtr[] words"

    printTree(testParser(text).formal_parameter_list.getTree)
  }


  it should "formal parameter list 01" in {
    val text = "void** words"

    printTree(testParser(text).formal_parameter_list.getTree)
  }


  it should "from clause 00" in {
    val text = "from from_ in students"

    printTree(testParser(text).from_clause.getTree)
  }


  it should "global attributes 00" in {
    val text =
      "[assembly: AssemblyTitle(\"3DTools\")]" +
        "[assembly: AssemblyDescription(\"\")]" +
        "[assembly: AssemblyConfiguration(\"\")]" +
        "[assembly: AssemblyCompany(\"Microsoft\")]" +
        "[assembly: AssemblyProduct(\"3D Tools for the Windows Presentation Foundation\")]" +
        "[assembly: AssemblyCopyright(\"Copyright @ Microsoft 2006\")]" +
        "[assembly: AssemblyTrademark(\"\")]" +
        "[assembly: AssemblyCulture(\"\")]" +
        "[assembly: ComVisible(false)]"

    printTree(testParser(text).global_attributes.getTree)
  }


  it should "global namespace declaration" in {
    val text =
      "//global namespace test" +
        "using System;" +
        "" +
        "[assembly: AssemblyTrademark(\"\")]" +
        "[AssemblyCulture(\"\")]" +
        "" +
        "public class Foo" +
        "{" +
        "static string[] _foo;" +
        "static void Main(string[] args)" +
        "{" +
        "}" +
        "}" +
        "" +
        "namespace Foo" +
        "{" +
        "using Text;" +
        "[DebuggerDisplay(\"hello\")]" +
        "public class Bar" +
        "{" +
        "static string[] _foo;" +
        "static void Main(string[] args)" +
        "{" +
        "_foo = \"bar\";" +
        "}" +
        "}" +
        "}" +
        "" +
        "namespace Bar" +
        "{" +
        "}"

    printTree(testParser(text).namespace_declaration.getTree)
  }


  it should "identifier 00" in {
    val text = "Foso"

    printTree(testParser(text).identifier.getTree)
  }


  it should "interface declaration 00" in {
    val text = "//public" +
      "interface IPlugin" +
      "{" +
      "void Register();" +
      "void Startup();" +
      "void Shutdown();" +
      "}"

    printTree(testParser(text).interface_declaration.getTree)
  }


  it should "interface declaration 01" in {
    val text =
      "//public" +
        "interface IDisplayPane: ICommandProcessor" +
        "{" +
        "Control GetControl();" +
        "void DisplayResource( IResource resource );" +
        "//[ Obsolete( \"Use the IDisplayPane2.HighlightWords(IResource, WordPtr[]) overload instead.\", false ) ]" +
        "void HighlightWords( WordPtr[] words );" +
        "void EndDisplayResource( IResource resource );" +
        "void DisposePane();" +
        "string GetSelectedText( ref TextFormat format );" +
        "string GetSelectedPlainText();" +
        "}" +
        ""
    testParser(text).interface_declaration
  }


  it should "interface declaration 02" in {
    val text =
      "//public" +
        "interface IDisplayPane3 : IDisplayPane" +
        "{" +
        "void DisplayResource( IResource resource, WordPtr[] wordsToHighlight );" +
        "}" +
        ""
    testParser(text).interface_declaration
  }


  it should "interface declaration 03" in {
    val text =
      "//public" +
        "interface IOverlayIconProvider" +
        "{" +
        "/// <summary>" +
        "/// Returns the list of icons that should be overlaid on the specified resource." +
        "/// </summary>" +
        "/// <param name=\"res\">The resource for which the icons are requested.</param>" +
        "/// <returns>The array of icons, or null if no overlay icons are available.</returns>" +
        "//Icon[] GetOverlayIcons( IResource res );" +
        "Icon[] GetOverlayIcons( IResource res );" +
        "}"

    printTree(testParser(text).interface_declaration.getTree)
  }


  it should "interface declaration 04" in {
    val text =
      "//public" +
        "interface IDisplayPane: ICommandProcessor" +
        "{" +
        "/// <summary>" +
        "/// Returns the instance of the control which is embedded in the preview pane" +
        "/// when the resource is displayed." +
        "/// </summary>" +
        "/// <returns>The control used to display the resource.</returns>" +
        "Control GetControl();" +
        "" +
        "/// <summary>" +
        "/// Shows the data of the specified resource in the display pane." +
        "/// </summary>" +
        "/// <param name=\"resource\">The resource to display.</param>" +
        "void DisplayResource( IResource resource );" +
        "" +
        "/// <summary>" +
        "/// Highlights the specified search result words in the resource text." +
        "/// </summary>" +
        "/// <param name=\"words\">The array of references to words to be highlighted.</param>" +
        "/// <remarks>" +
        "/// <para>The array is sorted by section and then by offset within the section.</para>" +
        "/// <para>Use the <see cref=\"IDisplayPane2.DisplayResource(IResource, WordPtr[])\"/> overload to load the resource and request words highlighting with a single call. This provides for the optimized highlighting implementation which applies at the stage of loading the resource.</para>" +
        "/// </remarks>" +
        "//		[ Obsolete( \"Use the IDisplayPane2.HighlightWords(IResource, WordPtr[]) overload instead.\", false ) ]" +
        "void HighlightWords( WordPtr[] words );" +
        "" +
        "/// <summary>" +
        "/// Ends the display of the specific resource in the display pane." +
        "/// </summary>" +
        "/// <param name=\"resource\">The resource which was displayed in the pane.</param>" +
        "/// <remarks>After <c>EndDisplayResource</c> is called, if the user switches to a resource" +
        "/// of the same type, <see cref=\"DisplayResource\"/> is called to display the resource in the" +
        "/// same display pane instance. If the user switches to a resource of a different type," +
        "/// <see cref=\"DisposePane\"/> is called to dispose of the pane.</remarks>" +
        "void EndDisplayResource( IResource resource );" +
        "" +
        "/// <summary>" +
        "/// Disposes of the display pane." +
        "/// </summary>" +
        "/// <remarks>After the core has called <c>DisposePane</c>, it no longer uses the pane instance." +
        "/// If a resource of the same type needs to be displayed again, a new pane instance is created" +
        "/// by a call to <see cref=\"IResourceDisplayer.CreateDisplayPane\"/>.</remarks>" +
        "void DisposePane();" +
        "" +
        "/// <summary>" +
        "/// Returns the text currently selected in the display pane as an RTF, HTML or plain-text" +
        "/// string." +
        "/// </summary>" +
        "/// <param name=\"format\">The format in which the method returns the string.</param>" +
        "/// <returns>The selected text, or null if there is no selection.</returns>" +
        "string GetSelectedText( ref TextFormat format );" +
        "" +
        "/// <summary>" +
        "/// Returns the text currently selected in the display pane as a plain-text string." +
        "/// </summary>" +
        "/// <returns>The selected text in plain-text format, or null if there is no selection.</returns>" +
        "string GetSelectedPlainText();" +
        "}"

    printTree(testParser(text).interface_declaration.getTree)
  }


  it should "interface declaration 05" in {
    val text =
      "/// <summary>" +
        "/// Defines additional functions for display panes." +
        "/// </summary>" +
        "/// <since>2.0</since>" +
        "//public" +
        "interface IDisplayPane2: IDisplayPane" +
        "{" +
        "/// <summary>" +
        "/// Shows the data of the specified resource in the display pane and highlights" +
        "/// the specified words in its text." +
        "/// </summary>" +
        "/// <param name=\"resource\">The resource to display.</param>" +
        "/// <param name=\"wordsToHighlight\">The array of references to words to be highlighted. May be <c>null</c>, which means that no words should be highlighted and Display Pane's behavior should default to <see cref=\"IDisplayPane.DisplayResource(IResource)\"/>.</param>" +
        "/// <remarks>" +
        "/// <para>The array is sorted by section and then by offset within the section.</para>" +
        "/// <para>This overload incapsulates the behavior of <see cref=\"IDisplayPane.DisplayResource(IResource)\"/> and <see cref=\"IDisplayPane.HighlightWords\"/> in order to provide the optimized performance.</para>" +
        "/// </remarks>" +
        "void DisplayResource( IResource resource, WordPtr[] wordsToHighlight );" +
        "int AddRemoteCall(string rcName, string tokenword);" +
        "}"

    printTree(testParser(text).interface_declaration.getTree)
  }


  it should "interface declaration 06" in {
    val text =
      "/// <summary>" +
        "/// Defines additional functions for display panes." +
        "/// </summary>" +
        "/// <since>2.0</since>" +
        "//public" +
        "interface IDisplayPane2: IDisplayPane" +
        "{" +
        "string Foo {get;set;}" +
        "}"

    printTree(testParser(text).interface_declaration.getTree)
  }


  it should "interface declaration 07" in {
    val text =
      "//public" +
        "interface IResourceTypeTabCollection" +
        "{" +
        "/// <summary>" +
        "/// The count of registered resource type tabs." +
        "/// </summary>" +
        "int Count { get; }" +
        "" +
        "/// <summary>" +
        "/// Returns the resource type tab at the given index." +
        "/// </summary>" +
        "/// <remarks>The tab at index 0 is 'All Resources'; the first tab registered by a plugin" +
        "/// is at index 1.</remarks>" +
        "IResourceTypeTab this [int index] { get; }" +
        "" +
        "/// <summary>" +
        "/// Returns the resource type tab with the specified ID." +
        "/// </summary>" +
        "IResourceTypeTab this [string tabId] { get; }" +
        "}" +
        ""
    testParser(text).interface_declaration
  }


  it should "interface declaration 08" in {
    val text =
      "//public" +
        "interface IResourceTypeTabCollection<out T>" +
        "{" +
        "/// <summary>" +
        "/// The count of registered resource type tabs." +
        "/// </summary>" +
        "int Count { get; }" +
        "" +
        "/// <summary>" +
        "/// Returns the resource type tab at the given index." +
        "/// </summary>" +
        "/// <remarks>The tab at index 0 is 'All Resources'; the first tab registered by a plugin" +
        "/// is at index 1.</remarks>" +
        "IResourceTypeTab this [int index] { get; }" +
        "" +
        "/// <summary>" +
        "/// Returns the resource type tab with the specified ID." +
        "/// </summary>" +
        "IResourceTypeTab this [string tabId] { get; }" +
        "}" +
        ""
    testParser(text).interface_declaration
  }


  it should "interface declaration 09" in {
    val text =
      "interface GenericArraySortHelper where TKey : new()" +
        "{" +
        "" +
        "}"

    printTree(testParser(text).interface_declaration.getTree)
  }


  it should "interface indexer declaration 00" in {
    val text =
      "// IResourceTypeTab" +
        "this [int index] { get; }" +
        ""
    testParser(text).interface_indexer_declaration
  }


  it should "interface member declaration 00" in {
    val text =
      "unsafe void GetSecuritySite( /* [out] */ void **ppSite);" +
        ""
    testParser(text).interface_member_declaration
  }


  it should "interface method declaration 02" in {
    val text =
      "HighlightWords( WordPtr[] words );" +
        ""
    testParser(text).interface_method_declaration
  }


  it should "interface method declaration 03" in {
    val text =
      "/// <summary>" +
        "/// Returns the list of icons that should be overlaid on the specified resource." +
        "/// </summary>" +
        "/// <param name=\"res\">The resource for which the icons are requested.</param>" +
        "/// <returns>The array of icons, or null if no overlay icons are available.</returns>" +
        "//Icon[] GetOverlayIcons( IResource res );" +
        "GetOverlayIcons( IResource res );" +
        "//        void HighlightWords( WordPtr[] words );" +
        ""
    testParser(text).interface_method_declaration
  }


  it should "interface method declaration 04" in {
    val text =
      "// unsafe void" +
        "GetSecuritySite( /* [out] */ void **ppSite);" +
        ""
    testParser(text).interface_method_declaration
  }


  it should "interface type list 00" in {
    val text =
      "Comparer<WTF<T>>" +
        ""
    testParser(text).interface_type_list
  }


  it should "parse a simple method invocation expression" in {
    val text = "Path.Foo()"

    printTree(testParser(text).invocation_expression.getTree)
  }


  it should "invocation expression 01" in {
    val text =
      "string.Intern(symbol)" +
        "" +
        ""
    testParser(text).invocation_expression
  }


  it should "invocation expression 02" in {
    val text =
      "string.Intern<notint>(symbol)" +
        "" +
        ""
    testParser(text).invocation_expression
  }


  it should "invocation expression 03" in {
    val text =
      "doc.LoadXml(new StreamReader(context.Request.InputStream).ReadToEnd())" +
        "" +
        ""
    testParser(text).invocation_expression
  }


  it should "invocation expression 04" in {
    val text =
      "doc.LoadXml((int)foo)" +
        "" +
        ""
    testParser(text).invocation_expression
  }


  it should "invocation expression 05" in {
    val text =
      "doc.LoadXml(ref (int)foo)" +
        "" +
        ""
    testParser(text).invocation_expression
  }


  it should "invocation expression 06" in {
    val text =
      "doc.LoadXml(ref (int) ref foo)" +
        "" +
        ""
    testParser(text).invocation_expression
  }


  it should "invocation expression list 00" in {
    val text =
      "One();" +
        "Two(two_args);" +
        "Twob[11](two_args);" +
        "Twob[11].Foo(two_args);" +
        "Twob[11].Foo(two_args)[3](args);" +
        "//Twob[11].Foo(two_args)[3](args);" +
        "Twob[11].Foo(two_args)[3].Foob();" +
        "Three.Path(args);" +
        "Three.Dir(args).ThreeB(argsb);" +
        "//(Three.Dir(args)).ThreeB(argsb);" +
        "//(CastTo)Four.Path(args);" +
        "Two();" +
        "three(foo => foo == bar);" +
        "four(() => foo == bar);" +
        "BCLDebug.Assert(array != null, \"Check the arguments in the caller!\");" +
        ""
    testParser(text).invocation_expression_list
  }


  it should "invocation expression list 01" in {
    val text =
      "One();" +
        "Two(two_args);" +
        "Twob[11].Foo(two_args);" +
        "Twob[11].Foo(two_args)[3].Foob();" +
        "Three.Path(args);" +
        "Three.Dir(args).ThreeB(argsb);" +
        "//(Three.Dir(args)).ThreeB(argsb);" +
        "//(CastTo)Four.Path(args);" +
        "Two();" +
        "three(foo => foo == bar);" +
        "four(() => foo == bar);" +
        "BCLDebug.Assert(array != null, \"Check the arguments in the caller!\");" +
        "Spam(Green: eggs);" +
        ""
    testParser(text).invocation_expression_list
  }


  it should "lambda expression 00" in {
    val text =
      "() => foo == bar" +
        ""
    testParser(text).lambda_expression
  }


  it should "lambda expression 01" in {
    val text =
      "foo => foo == bar" +
        ""
    testParser(text).lambda_expression
  }


  it should "literal 00" in {
    val text =
      "@\"something\"\"else\"" +
        ""
    testParser(text).literal
  }


  it should "literal 01" in {
    val text =
      "\";lkj\"" +
        "" +
        ""
    testParser(text).literal
  }


  it should "literal 02" in {
    val text =
      "1234" +
        "" +
        ""
    testParser(text).literal
  }


  it should "literal 03" in {
    val text =
      "0x1234" +
        "" +
        ""
    testParser(text).literal
  }


  it should "literal 04" in {
    val text =
      "'a'" +
        "" +
        ""
    testParser(text).literal
  }


  it should "literals 00" in {
    val text =
      "\"string\"" +
        "'c'" +
        "123" +
        "0x429" +
        "0f" +
        "0l" +
        "0.345" +
        "0.234e12" +
        "0.234e12f" +
        "" +
        "//(\"foobar\")" +
        "//(\"foobar\", 2)" +
        "" +
        ""
    testParser(text).literals
  }


  it should "local constant declaration 00" in {
    val text =
      "const int minimumHelpTextColumn = 5" +
        ""
    testParser(text).local_constant_declaration
  }


  it should "local variable declaration 00" in {
    val text =
      "string searchPattern = Path.GetFileName(args)" +
        ""
    testParser(text).local_variable_declaration
  }


  it should "local variable declaration 01" in {
    val text =
      "Token tkn = base.TryMatch(context, source)" +
        ""
    testParser(text).local_variable_declaration
  }


  it should "local variable declaration 02" in {
    val text =
      "Dictionary<Guid, CachedAnnotation>.ValueCollection.Enumerator enumerator = this._currentAnnotations.Values.GetEnumerator()" +
        ""
    testParser(text).local_variable_declaration
  }


  it should "local variable declaration list 00" in {
    val text =
      "string searchPattern = (not_string)Path.GetFileName(args);" +
        "string searchPattern = (string)Path.GetFileName(args);" +
        "string searchPattern = Path.GetFileName(args);" +
        "UIElement uie = (int)Mouse.Captured();" +
        "Point[] visCorners = new Point[4];" +
        "double visEdgeDiff = (visEdgeStart - visEdgeEnd).Length;" +
        "Token tkn = base.TryMatch(context, source);" +
        "" +
        "" +
        ""
    testParser(text).local_variable_declaration_list
  }


  it should "local variable declarator 00" in {
    val text =
      "uie = (UIElement)Mouse.Captured" +
        ""
    testParser(text).local_variable_declarator
  }


  it should "local variable initializer list 00" in {
    val text =
      "Path.GetFileName(args);" +
        "base.foo(one, two);" +
        "" +
        ""
    testParser(text).local_variable_initializer_list
  }


  //  it should "member access 00" in {
  //    val text =
  //      "foo.bar" +
  //        ""
  //    testParser(text).member_access
  //  }


  //  it should "member access 01" in {
  //    val text =
  //      "foo.bar()" +
  //        ""
  //    testParser(text).member_access
  //  }


  it should "member declarator 00" in {
    val text =
      "ggg = 5" +
        ""
    testParser(text).member_declarator
  }


  it should "member name 00" in {
    val text =
      "System.Collections.ICollection<Type>.Copy" +
        ""
    testParser(text).member_name
  }


  it should "method body 00" in {
    val text =
      "{" +
        "((ICollection)_storage).CopyTo(array, index);" +
        "}" +
        ""
    testParser(text).method_body
  }


  it should "method declaration 00" in {
    val text =
      "Foo()" +
        "{" +
        "}" +
        ""
    testParser(text).method_declaration
  }


  it should "method declaration 01" in {
    val text =
      "ICollection.CopyTo(Array array, int index)" +
        "{" +
        "((ICollection)_storage).CopyTo(array, index);" +
        "}" +
        ""
    testParser(text).method_declaration
  }


  it should "method declaration 02" in {
    val text =
      "ICollection<Type>.CopyTo(Array array, int index)" +
        "{" +
        "((ICollection)_storage).CopyTo(array, index);" +
        "}" +
        ""
    testParser(text).method_declaration
  }


  it should "method declaration 03" in {
    val text =
      "GetSecuritySite( /* [out] */ void **ppSite) {}" +
        ""
    testParser(text).method_declaration
  }


  it should "method declarations 00" in {
    val text =
      "string Foo();" +
        "public string Foo();" +
        "public static string Foo();" +
        "public override string Foo();" +
        "void ICollection.CopyTo(Array array, int index)" +
        "{" +
        "((ICollection)_storage).CopyTo(array, index);" +
        "}" +
        ""
    testParser(text).method_declarations
  }


  it should "method declarations 01" in {
    val text =
      "string Foo() { }" +
        "public string Foo() { ; }" +
        "public static string Foo();" +
        "public override string Foo();" +
        "public override string[] Foo();" +
        "internal unsafe void* BaseAddress();" +
        ""
    testParser(text).method_declarations
  }


  it should "method declarations 02" in {
    val text =
      "string Foo() { }" +
        "public string Foo() { ; }" +
        "public static string Foo();" +
        "public override string Foo();" +
        "public override frank[] Foo();" +
        "internal unsafe void* BaseAddress();" +
        "public override frank[] Foo(Spam spam='foo');" +
        "//public override object this[string keyword];" +
        ""
    testParser(text).method_declarations
  }


  it should "method header 00" in {
    val text =
      "Foo(int x)" +
        ""
    testParser(text).method_header
  }


  it should "method header 01" in {
    val text =
      "ICollection.CopyTo(Array array, int index)" +
        ""
    testParser(text).method_header
  }


  it should "multiplicative expression 00" in {
    val text =
      "numer / denom" +
        ""
    testParser(text).multiplicative_expression
  }


  it should "namespace declaration" in {
    val text =
      "//global namespace test" +
        "using System;" +
        "" +
        "[assembly: AssemblyTrademark(\"\")]" +
        "[AssemblyCulture(\"\")]" +
        "" +
        "public class Foo" +
        "{" +
        "static string[] _foo;" +
        "static void Main(string[] args)" +
        "{" +
        "}" +
        "}" +
        "" +
        "namespace Foo" +
        "{" +
        "using Text;" +
        "[DebuggerDisplay(\"hello\")]" +
        "public class Bar" +
        "{" +
        "static string[] _foo;" +
        "static void Main(string[] args)" +
        "{" +
        "_foo = \"bar\";" +
        "}" +
        "}" +
        "}" +
        "" +
        "namespace Bar" +
        "{" +
        "}" +
        ""
    testParser(text).namespace_declaration
  }


  it should "namespace declaration 00" in {
    val text =
      "namespace JetBrains.Omea.OpenAPI" +
        "{" +
        "}" +
        ""
    testParser(text).namespace_declaration
  }


  it should "namespace declaration 01" in {
    val text =
      "namespace JetBrains.Omea.OpenAPI" +
        "{" +
        "[SecurityPermission(SecurityAction.LinkDemand, UnmanagedCode = true)]" +
        "public class Foo" +
        "{" +
        "static int foo;" +
        "}" +
        "}" +
        ""
    testParser(text).namespace_declaration
  }


  it should "namespace declaration 02" in {
    val text =
      "namespace JetBrains.Omea.OpenAPI" +
        "{" +
        "public class Foo" +
        "{" +
        "static int[] foo;" +
        "}" +
        "}" +
        ""
    testParser(text).namespace_declaration
  }


  it should "namespace declaration 03" in {
    val text =
      "namespace JetBrains.Omea.OpenAPI" +
        "{" +
        "public class Foo" +
        "{" +
        "static int[] foo;" +
        "static void Main()" +
        "{" +
        "}" +
        "}" +
        "}" +
        ""
    testParser(text).namespace_declaration
  }


  it should "namespace declaration 04" in {
    val text =
      "namespace JetBrains.Omea.OpenAPI" +
        "{" +
        "public class Foo" +
        "{" +
        "static string[] _foo;" +
        "static void Main(string[] args)" +
        "{" +
        "}" +
        "}" +
        "public class Bar" +
        "{" +
        "}" +
        "}" +
        ""
    testParser(text).namespace_declaration
  }


  it should "namespace or type name 00" in {
    val text =
      "global::ICollection<Type>" +
        ""
    testParser(text).namespace_or_type_name
  }


  it should "namespace or type name 01" in {
    val text =
      "global::ICollection<Type>.Foo.Bar" +
        ""
    testParser(text).namespace_or_type_name
  }


  it should "namespace or type name 02" in {
    val text =
      "ICollection<Type>.Foo" +
        ""
    testParser(text).namespace_or_type_name
  }


  it should "non array type" in {
    val text =
      "Point" +
        "" +
        "" +
        ""
    testParser(text).non_array_type
  }


  it should "non assignment expression list 00" in {
    val text =
      "3;" +
        "foo;" +
        "wtf;" +
        "foo => foo == bar;" +
        ""
    testParser(text).non_assignment_expression_list
  }


  it should "object creation expression 00" in {
    val text =
      "//new" +
        "System.Uri()" +
        ""
    testParser(text).object_creation_expression
  }


  it should "object creation expression 01" in {
    val text =
      "//new" +
        "System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative)" +
        ""
    testParser(text).object_creation_expression
  }


  it should "object creation expression 02" in {
    val text =
      "//new" +
        "Point3D {" +
        "new Point3D(x1, y1, z1)," +
        "new Point3D(x1, y1, z2)," +
        "new Point3D(x1, y2, z1)," +
        "new Point3D(x1, y2, z2)," +
        "new Point3D(x2, y1, z1)," +
        "new Point3D(x2, y1, z2)," +
        "new Point3D(x2, y2, z1)," +
        "new Point3D(x2, y2, z2)," +
        "}" +
        ""
    testParser(text).object_creation_expression
  }


  it should "object creation expression 03" in {
    val text =
      "//new" +
        "Point3D[] {" +
        "new Point3D(x1, y1, z1)," +
        "new Point3D(x1, y1, z2)," +
        "new Point3D(x1, y2, z1)," +
        "new Point3D(x1, y2, z2)," +
        "new Point3D(x2, y1, z1)," +
        "new Point3D(x2, y1, z2)," +
        "new Point3D(x2, y2, z1)," +
        "new Point3D(x2, y2, z2)," +
        "}" +
        ""
    testParser(text).object_creation_expression
  }


  it should "operator declarator 00" in {
    val text =
      "operator + (string phrase, GrammarBuilder builder)" +
        ""
    testParser(text).operator_declarator
  }


  it should "paren expression 00" in {
    val text =
      "(numer / denom)" +
        "//()" +
        "//(\"foobar\")" +
        "//(\"foobar\", 2)"
    testParser(text).paren_expression
  }


  //  it should "PluginInterfaces" in {
  //    val text =
  //      "﻿using System;" +
  //        "using System.Collections;" +
  //        "using System.IO;" +
  //        "using System.Drawing;" +
  //        "using System.Windows.Forms;" +
  //        "using System.Xml;" +
  //        "" +
  //        "namespace JetBrains.Omea.OpenAPI" +
  //        "{" +
  //        "public enum TextFormat" +
  //        "{" +
  //        "PlainText," +
  //        "Html," +
  //        "Rtf" +
  //        "};" +
  //        "public interface IPlugin" +
  //        "{" +
  //        "void Register();" +
  //        "void Startup();" +
  //        "void Shutdown();" +
  //        "}" +
  //        "public interface IResourceDisplayer" +
  //        "{" +
  //        "IDisplayPane CreateDisplayPane( string resourceType );" +
  //        "}" +
  //        "public interface ICommandProcessor : IFoo, IBar" +
  //        "{" +
  //        "bool CanExecuteCommand( string command );" +
  //        "void ExecuteCommand( string command );" +
  //        "}" +
  //        "public interface IDisplayPane: ICommandProcessor" +
  //        "{" +
  //        "Control GetControl();" +
  //        "void DisplayResource( IResource resource );" +
  //        "//		[ Obsolete( \"Use the IDisplayPane2.HighlightWords(IResource, WordPtr[]) overload instead.\", false ) ]" +
  //        "void HighlightWords( WordPtr[] words );" +
  //        "void EndDisplayResource( IResource resource );" +
  //        "void DisposePane();" +
  //        "string GetSelectedText( ref TextFormat format );" +
  //        "string GetSelectedPlainText();" +
  //        "}" +
  //        "public interface IDisplayPane2 : IDisplayPane" +
  //        "{" +
  //        "void DisplayResource( IResource resource, WordPtr[] wordsToHighlight );" +
  //        "}" +
  //        "public interface IResourceTextProvider" +
  //        "{" +
  //        "bool ProcessResourceText( IResource res, IResourceTextConsumer consumer );" +
  //        "}" +
  //        "public interface IResourceTextIndexingPermitter" +
  //        "{" +
  //        "bool CanIndexResource( IResource res );" +
  //        "}" +
  //        "public interface IResourceIconProvider" +
  //        "{" +
  //        "Icon GetResourceIcon( IResource resource );" +
  //        "Icon GetDefaultIcon( string resType );" +
  //        "}" +
  //        "public interface IOverlayIconProvider" +
  //        "{" +
  //        "Icon[] GetOverlayIcons( IResource res );" +
  //        "}" +
  //        "public interface IStreamProvider" +
  //        "{" +
  //        "Stream GetResourceStream( IResource resource );" +
  //        "}" +
  //        "" +
  //        "public class DisplayPaneCommands" +
  //        "{" +
  //        "public const string Sideways   = \"foo\";" +
  //        "public const string Back       = \"Back\";" +
  //        "public const string Forward    = \"Forward\";" +
  //        "public const string FindInPage = \"FindInPage\";" +
  //        "public const string Cut        = \"Cut\";" +
  //        "public const string Copy       = \"Copy\";" +
  //        "public const string Paste      = \"Paste\";" +
  //        "public const string Print      = \"Print\";" +
  //        "public const string PageDown   = \"PageDown\";" +
  //        "public const string SelectAll  = \"SelectAll\";" +
  //        "public const string RenameSelection = \"RenameSelection\";" +
  //        "public const string NextSearchResult = \"NextSearchResult\";" +
  //        "public const string PrevSearchResult = \"PrevSearchResult\";" +
  //        "}" +
  //        "public interface IResourceUIHandler" +
  //        "{" +
  //        "void ResourceNodeSelected( IResource res );" +
  //        "bool CanRenameResource( IResource res );" +
  //        "bool ResourceRenamed( IResource res, string newName );" +
  //        "bool CanDropResources( IResource targetResource, IResourceList dragResources );" +
  //        "void ResourcesDropped( IResource targetResource, IResourceList droppedResources );" +
  //        "}" +
  //        "public interface IResourceDragDropHandler" +
  //        "{" +
  //        "void AddResourceDragData( IResourceList dragResources, IDataObject dataObject );" +
  //        "DragDropEffects DragOver( IResource targetResource, IDataObject data, DragDropEffects allowedEffect," +
  //        "int keyState );" +
  //        "void Drop( IResource targetResource, IDataObject data, DragDropEffects allowedEffect, int keyState );" +
  //        "}" +
  //        "public interface IResourceRenameHandler" +
  //        "{" +
  //        "bool CanRenameResource( IResource res, ref string editText );" +
  //        "bool ResourceRenamed( IResource res, string newName );" +
  //        "}" +
  //        "public enum ThreadExpandReason" +
  //        "{" +
  //        "Enumerate," +
  //        "Expand" +
  //        "}" +
  //        "public interface IResourceThreadingHandler" +
  //        "{" +
  //        "IResource GetThreadParent( IResource res );" +
  //        "IResourceList GetThreadChildren( IResource res );" +
  //        "bool IsThreadChanged( IResource res, IPropertyChangeSet changeSet );" +
  //        "bool CanExpandThread( IResource res, ThreadExpandReason reason );" +
  //        "bool HandleThreadExpand( IResource res, ThreadExpandReason reason );" +
  //        "}" +
  //        "public interface ICustomColumn" +
  //        "{" +
  //        "void Draw( IResource res, Graphics g, Rectangle rc );" +
  //        "void DrawHeader( Graphics g, Rectangle rc );" +
  //        "void MouseClicked( IResource res, Point pt );" +
  //        "bool ShowContextMenu( IActionContext context, Control ownerControl, Point pt );" +
  //        "string GetTooltip( IResource res );" +
  //        "}" +
  //        "public enum SerializationMode" +
  //        "{" +
  //        "Default," +
  //        "NoSerialize," +
  //        "AskSerialize," +
  //        "Serialize" +
  //        "}" +
  //        "public interface IResourceSerializer" +
  //        "{" +
  //        "void AfterSerialize( IResource parentResource, IResource res, XmlNode node );" +
  //        "IResource AfterDeserialize( IResource parentResource, IResource res, XmlNode node );" +
  //        "SerializationMode GetSerializationMode( IResource res, string propertyType );" +
  //        "}" +
  //        "public interface IResourceDeleter" +
  //        "{" +
  //        "DialogResult ConfirmDeleteResources( IResourceList resources, bool permanent, bool showCancel );" +
  //        "bool CanDeleteResource( IResource res, bool permanent );" +
  //        "bool CanIgnoreRecyclebin();" +
  //        "void DeleteResource( IResource res );" +
  //        "void DeleteResourcePermanent( IResource res );" +
  //        "void UndeleteResource( IResource res );" +
  //        "}" +
  //        "public interface INewspaperProvider" +
  //        "{" +
  //        "void GetHeaderStyles( string resourceType, TextWriter writer );" +
  //        "void GetItemHtml( IResource item, TextWriter writer );" +
  //        "}" +
  //        "" +
  //        "public delegate void ResourceDelegate( IResource res );" +
  //        "public delegate void ResourceListDelegate( IResourceList resList );" +
  //        "public enum StatusPane" +
  //        "{" +
  //        "UI," +
  //        "Network," +
  //        "ResourceBrowser" +
  //        "};" +
  //        "public interface IUnreadCountProvider" +
  //        "{" +
  //        "IResourceList GetResourcesForView( IResource viewResource );" +
  //        "}" +
  //        "public interface IUnreadManager" +
  //        "{" +
  //        "void RegisterUnreadCountProvider( string resType, IUnreadCountProvider provider );" +
  //        "int GetUnreadCount( IResource res );" +
  //        "void InvalidateUnreadCounter( IResource res );" +
  //        "}" +
  //        "public interface IProgressWindow" +
  //        "{" +
  //        "void UpdateProgress( int percentage, string message, string timeMessage );" +
  //        "}" +
  //        "public interface IStatusWriter" +
  //        "{" +
  //        "void ShowStatus( string message );" +
  //        "void ShowStatus( string message, bool repaint );" +
  //        "void ClearStatus();" +
  //        "string LastMessage{ get; }" +
  //        "void ShowStatus(string message, int nSecondsToKeep);" +
  //        "}" +
  //        "public interface IResourceNodeFilter" +
  //        "{" +
  //        "bool AcceptNode( IResource res, int level );" +
  //        "}" +
  //        "public interface IResourceTreePane" +
  //        "{" +
  //        "void RegisterToolbarAction( IAction action, Icon icon, string text, string tooltip," +
  //        "IActionStateFilter[] filters );" +
  //        "void RegisterToolbarAction( IAction action, Image icon, string text, string tooltip," +
  //        "IActionStateFilter[] filters );" +
  //        "void AddNodeFilter( IResourceNodeFilter nodeFilter );" +
  //        "void UpdateNodeFilter( bool keepSelection );" +
  //        "void SelectResource( IResource res );" +
  //        "void EditResourceLabel( IResource res );" +
  //        "void ExpandParents( IResource res );" +
  //        "//        [Obsolete]" +
  //        "void EnableDropOnEmpty( IResourceUIHandler emptyDropHandler );" +
  //        "void EnableDropOnEmpty( IResourceDragDropHandler emptyDropHandler );" +
  //        "bool SelectAddedItems { get; set; }" +
  //        "int ParentProperty { get; set; }" +
  //        "string[] WorkspaceFilterTypes { get; set; }" +
  //        "IResource SelectedNode { get; }" +
  //        "ResourceToolTipCallback ToolTipCallback { get; set; }" +
  //        "}" +
  //        "public delegate string ResourceToolTipCallback( IResource res );" +
  //        "public interface ISidebar" +
  //        "{" +
  //        "void RegisterPane( AbstractViewPane viewPane, string paneId, string caption, Image icon );" +
  //        "void SetPaneCaption( string paneId, string caption );" +
  //        "bool IsPaneExpanded( string paneId );" +
  //        "void SetPaneExpanded( string paneId, bool expanded );" +
  //        "int PanesCount { get; }" +
  //        "AbstractViewPane GetPane( string name );" +
  //        "}" +
  //        "public interface ISidebarSwitcher" +
  //        "{" +
  //        "void RegisterViewPane( string paneId, string tabId, string caption, Image icon, AbstractViewPane viewPane );" +
  //        "IResourceTreePane RegisterTreeViewPane( string paneId, string tabId, string caption, Image icon," +
  //        "IResource rootResource );" +
  //        "void RegisterResourceStructurePane( string paneId, string tabId, string caption, Image icon," +
  //        "AbstractViewPane viewPane );" +
  //        "IResourceTreePane RegisterResourceStructureTreePane( string paneId, string tabId, string caption," +
  //        "Image icon, IResource rootResource );" +
  //        "IResourceTreePane RegisterResourceStructureTreePane( string paneId, string tabId, string caption," +
  //        "Image icon, string rootResType );" +
  //        "void RegisterViewPaneShortcut( string paneId, Keys shortcut );" +
  //        "IResourceTreePane DefaultViewPane { get; }" +
  //        "void ActivateViewPane( string paneId );" +
  //        "AbstractViewPane ActivateViewPane( string tabId, string paneId );" +
  //        "string ActivePaneId { get; }" +
  //        "AbstractViewPane GetPane( string paneId );" +
  //        "AbstractViewPane GetPane( string tabId, string paneId );" +
  //        "string GetResourceStructurePaneId( string tabId );" +
  //        "}" +
  //        "public interface IResourceTypeTab" +
  //        "{" +
  //        "string Id { get; }" +
  //        "string Name { get; }" +
  //        "string[] GetResourceTypes();" +
  //        "int LinkPropId { get; }" +
  //        "IResourceList GetFilterList( bool live );" +
  //        "}" +
  //        "public interface IResourceTypeTabCollection" +
  //        "{" +
  //        "int Count { get; }" +
  //        "IResourceTypeTab this [int index] { get; }" +
  //        "IResourceTypeTab this [string tabId] { get; }" +
  //        "}" +
  //        "public interface ITabManager" +
  //        "{" +
  //        "IResourceTypeTabCollection Tabs { get; }" +
  //        "void RegisterResourceTypeTab( string tabId, string tabName, string resType, int order );" +
  //        "void RegisterResourceTypeTab( string tabId, string tabName, string[] resTypes, int order );" +
  //        "void RegisterResourceTypeTab( string tabId, string tabName, string[] resTypes, int linkPropId," +
  //        "int order );" +
  //        "void SetDefaultSelectedResource( string tabId, IResource res );" +
  //        "void SelectResourceTypeTab( string resType );" +
  //        "void SelectLinkPropTab( int linkPropId );" +
  //        "string FindResourceTypeTab( string resType );" +
  //        "string FindLinkPropTab( int linkPropId );" +
  //        "string CurrentTabId { get; set; }" +
  //        "IResourceTypeTab CurrentTab { get; }" +
  //        "bool ActivateTab( string tabId );" +
  //        "string GetResourceTab( IResource res );" +
  //        "event EventHandler TabChanged;" +
  //        "}" +
  //        "public class StandardViewPanes" +
  //        "{" +
  //        "public const string ViewsCategories = \"ViewsCategories\";" +
  //        "public const string Correspondents = \"Correspondents\";" +
  //        "}" +
  //        "public interface IContextProvider" +
  //        "{" +
  //        "IActionContext GetContext( ActionContextKind kind );" +
  //        "}" +
  //        "[Flags]" +
  //        "public enum MultiLineColumnFlags" +
  //        "{" +
  //        "AnchorLeft = 1," +
  //        "AnchorRight = 2," +
  //        "HideIfNoProp = 4" +
  //        "}" +
  //        "public interface IResourceGroupProvider" +
  //        "{" +
  //        "string GetGroupName( IResource res );" +
  //        "}" +
  //        "public interface IDisplayColumnManager" +
  //        "{" +
  //        "void RegisterDisplayColumn( string resourceType, int index, ColumnDescriptor column );" +
  //        "void RegisterAvailableColumn( string resourceType, ColumnDescriptor column );" +
  //        "void RemoveAvailableColumn( string resourceType, string propName );" +
  //        "void RegisterCustomColumn( int propId, ICustomColumn customColumn );" +
  //        "void RegisterMultiLineColumn( string resourceType, int propId, int startRow, int endRow," +
  //        "int startX, int width, MultiLineColumnFlags flags, Color textColor, HorizontalAlignment textAlign );" +
  //        "void RegisterMultiLineColumn( string resourceType, int[] propIds, int startRow, int endRow," +
  //        "int startX, int width, MultiLineColumnFlags flags, Color textColor, HorizontalAlignment textAlign );" +
  //        "void SetAlignTopLevelItems( string resourceType, bool align );" +
  //        "void RegisterPropertyToTextCallback( int propId, PropertyToTextCallback propToText );" +
  //        "void RegisterPropertyToTextCallback( int propId, PropertyToTextCallback2 propToText );" +
  //        "ColumnDescriptor[] GetDefaultColumns( IResourceList resList );" +
  //        "ColumnDescriptor[] AddAnyTypeColumns( ColumnDescriptor[] columnDescriptors );" +
  //        "}" +
  //        "public interface ISettingStore" +
  //        "{" +
  //        "void WriteString( string section, string key, string value );" +
  //        "void WriteInt( string section, string key, int value );" +
  //        "void WriteBool( string section, string key, bool value );" +
  //        "void WriteDate( string section, string key, DateTime value );" +
  //        "string ReadString( string section, string key );" +
  //        "string ReadString( string section, string key, string defaultValue );" +
  //        "int ReadInt( string section, string key, int defaultValue );" +
  //        "bool ReadBool( string section, string key, bool defaultValue );" +
  //        "DateTime ReadDate( string section, string key, DateTime defaultValue );" +
  //        "}" +
  //        "public interface IPluginLoader" +
  //        "{" +
  //        "void RegisterResourceUIHandler( string resType, IResourceUIHandler handler );" +
  //        "IResourceUIHandler GetResourceUIHandler( string resType );" +
  //        "IResourceUIHandler GetResourceUIHandler( IResource res );" +
  //        "void RegisterResourceDragDropHandler( string resType, IResourceDragDropHandler handler );" +
  //        "IResourceDragDropHandler GetResourceDragDropHandler( IResource res );" +
  //        "IResourceDragDropHandler GetResourceDragDropHandler( string resType );" +
  //        "void RegisterResourceRenameHandler( string resType, IResourceRenameHandler handler );" +
  //        "IResourceRenameHandler GetResourceRenameHandler( IResource res );" +
  //        "void RegisterResourceThreadingHandler( string resType, IResourceThreadingHandler handler );" +
  //        "void RegisterResourceThreadingHandler( int propId, IResourceThreadingHandler handler );" +
  //        "void RegisterDefaultThreadingHandler( string resType, int replyProp );" +
  //        "IResourceThreadingHandler GetResourceThreadingHandler( string resType );" +
  //        "IResourceThreadingHandler CompositeThreadingHandler { get; }" +
  //        "void RegisterResourceTextProvider( string resType, IResourceTextProvider provider );" +
  //        "bool HasTypedTextProvider( string resType );" +
  //        "void InvokeResourceTextProviders( IResource res, IResourceTextConsumer consumer );" +
  //        "void RegisterResourceDisplayer( string resType, IResourceDisplayer displayer );" +
  //        "IResourceDisplayer GetResourceDisplayer( string resType );" +
  //        "void RegisterNewspaperProvider( string resType, INewspaperProvider provider );" +
  //        "INewspaperProvider GetNewspaperProvider( string resType );" +
  //        "void RegisterStreamProvider( string resType, IStreamProvider provider );" +
  //        "IStreamProvider GetStreamProvider( string resType );" +
  //        "void RegisterPluginService( object pluginService );" +
  //        "object GetPluginService( Type serviceType );" +
  //        "void RegisterResourceSerializer( string resType, IResourceSerializer serializer );" +
  //        "IResourceSerializer GetResourceSerializer( string resType );" +
  //        "void RegisterViewsConstructor( IViewsConstructor constructor );" +
  //        "ArrayList GetViewsConstructors();" +
  //        "void RegisterResourceDeleter( string resType, IResourceDeleter deleter );" +
  //        "IResourceDeleter GetResourceDeleter( string resType );" +
  //        "}" +
  //        "public interface IResourceIconManager" +
  //        "{" +
  //        "void RegisterResourceIconProvider( string resType, IResourceIconProvider provider );" +
  //        "void RegisterResourceIconProvider( string[] resTypes, IResourceIconProvider provider );" +
  //        "void RegisterOverlayIconProvider( string resType, IOverlayIconProvider provider );" +
  //        "IResourceIconProvider GetResourceIconProvider( string resType );" +
  //        "int GetIconIndex( IResource res );" +
  //        "int GetDefaultIconIndex( string resType );" +
  //        "int[] GetOverlayIconIndices( IResource res );" +
  //        "void RegisterPropTypeIcon( int propId, Icon icon );" +
  //        "int GetPropTypeIconIndex( int propId );" +
  //        "void RegisterResourceLargeIcon( string resType, Icon icon );" +
  //        "Icon GetResourceLargeIcon( string resType );" +
  //        "ImageList  ImageList      { get; }" +
  //        "ColorDepth IconColorDepth { get; }" +
  //        "" +
  //        "Hashtable  CollectAssemblyIcons();" +
  //        "}" +
  //        "public enum WorkspaceResourceType" +
  //        "{" +
  //        "Container," +
  //        "Filter," +
  //        "Folder," +
  //        "None" +
  //        "}" +
  //        "public interface IWorkspaceManager" +
  //        "{" +
  //        "void RegisterWorkspaceType( string resType, int[] linkPropIDs, WorkspaceResourceType workspaceResourceType );" +
  //        "void RegisterWorkspaceContainerType( string resType, int[] linkPropIds, int recurseLinkPropId );" +
  //        "void RegisterWorkspaceFolderType( string resType, string contentType, int[] linkPropIDs );" +
  //        "void RegisterWorkspaceSelectorFilter( string resType, IResourceNodeFilter filter );" +
  //        "void RegisterWorkspaceSelectorFilter( string resType, IResourceNodeFilter availTreeFilter," +
  //        "IResourceNodeFilter workspaceTreeFilter );" +
  //        "IResource CreateWorkspace( string name );" +
  //        "void DeleteWorkspace( IResource workspace );" +
  //        "void AddResourceToWorkspace( IResource workspace, IResource res );" +
  //        "void AddResourceToWorkspaceRecursive( IResource workspace, IResource res );" +
  //        "void AddResourcesToWorkspace( IResource workspace, IResourceList resList );" +
  //        "void AddToActiveWorkspace( IResource res );" +
  //        "void AddToActiveWorkspaceRecursive( IResource res );" +
  //        "void RemoveResourceFromWorkspace( IResource workspace, IResource res );" +
  //        "void RemoveResourcesFromWorkspace( IResource workspace, IResourceList resList );" +
  //        "IResourceList GetFilterList( IResource workspace );" +
  //        "IResourceList GetWorkspaceResources( IResource workspace, string resType );" +
  //        "IResourceList GetWorkspaceResourcesLive( IResource workspace, string resType );" +
  //        "WorkspaceResourceType GetWorkspaceResourceType( string resType );" +
  //        "int GetRecurseLinkPropId( string resType );" +
  //        "bool IsInWorkspaceRecursive( IResource workspace, IResource res );" +
  //        "IResourceList GetResourceWorkspaces( IResource resource );" +
  //        "IResourceList GetAllWorkspaces();" +
  //        "void SetWorkspaceTabName( string resourceType, string tabName );" +
  //        "void CleanWorkspaceLinks( IResource res );" +
  //        "IResource ActiveWorkspace { get; set; }" +
  //        "event EventHandler WorkspaceChanged;" +
  //        "}" +
  //        "public interface ICategoryManager" +
  //        "{" +
  //        "IResourceList GetResourceCategories( IResource resource );" +
  //        "void AddResourceCategory( IResource res, IResource category );" +
  //        "void SetResourceCategory( IResource res, IResource category );" +
  //        "void RemoveResourceCategory( IResource res, IResource category );" +
  //        "IResource FindCategory( IResource parentCategory, string name );" +
  //        "IResource FindOrCreateCategory( IResource parentCategory, string name );" +
  //        "IResource GetRootForTypedCategory( string resType );" +
  //        "IResource FindRootForTypedCategory( string resType );" +
  //        "IResource RootCategory" +
  //        "{" +
  //        "get;" +
  //        "}" +
  //        "bool CheckRenameCategory( IWin32Window parentWindow, IResource category, string newName );" +
  //        "}" +
  //        "public interface IResourceListListener" +
  //        "{" +
  //        "void ResourceAdded( IResource res );" +
  //        "void ResourceDeleting( IResource res );" +
  //        "void ResourceChanged( IResource res, IPropertyChangeSet cs );" +
  //        "}" +
  //        "public interface IResourceTreeManager" +
  //        "{" +
  //        "IResource ResourceTreeRoot { get; }" +
  //        "IResource GetRootForType( string resType );" +
  //        "void LinkToResourceRoot( IResource res, int index );" +
  //        "void SetResourceNodeSort( IResource node, string sortProps );" +
  //        "string GetResourceNodeSort( IResource node );" +
  //        "void SetViewsExclusive( string resType );" +
  //        "bool AreViewsExclusive( string resType );" +
  //        "void RegisterTreeListener( IResource parent, int parentProp, IResourceListListener listener );" +
  //        "void UnregisterTreeListener( IResource parent, int parentProp, IResourceListListener listener );" +
  //        "}" +
  //        "public interface INotificationManager" +
  //        "{" +
  //        "void RegisterNotifyMeResourceType( string resType, string ruleResType );" +
  //        "void RegisterNotifyMeCondition( string resType, IResource conditionTemplate, int linkPropId );" +
  //        "IResource[] GetNotifyMeConditions( string resType );" +
  //        "int GetConditionLinkType( string resType, IResource conditionTemplate );" +
  //        "string GetRuleResourceType( string resType );" +
  //        "}" +
  //        "public interface IRemoteControlManager" +
  //        "{" +
  //        "int AddRemoteCall(string rcName, string foo);" +
  //        "}" +
  //        "public delegate void EditedResourceSavedDelegate( IResource res, object tag );" +
  //        "public delegate void ValidateStringDelegate( string value, ref string validateErrorMessage );" +
  //        "}" +
  //        ""
  //    testParser(text).PluginInterfaces.cs
  //  }

  //
  //  it should "pp test" in {
  //    val text =
  //      "//#if SHAZAM==BATMAN==ROBIN" +
  //        "#if FOO" +
  //        "#if !FOO" +
  //        "--++ HELLO SHOULD NOT FAIL" +
  //        "#endif" +
  //        "#elif BAAM" +
  //        "++-- will NOT Fail" +
  //        "#else" +
  //        "" +
  //        "#if !GAS" +
  //        "public interface Bar{ void member(); }" +
  //        "#else" +
  //        "--++ HELLO SHOULD NOT FAIL" +
  //        "#endif" +
  //        "" +
  //        "public class Foo{}" +
  //        "#endif" +
  //        "public interface Bar{ void member(); }" +
  //        ""
  //    testParser(text).pp_test
  //  }


  //  it should "pp test2" in {
  //    val text =
  //      "// Copyright (c) Microsoft Corporation. All rights reserved." +
  //        "" +
  //        "#if !ISOLATION_IN_MSCORLIB" +
  //        "#define FEATURE_COMINTEROP" +
  //        "#endif" +
  //        "using System;" +
  //        "using System.IO;" +
  //        "using System.Runtime.InteropServices;" +
  //        "using System.Collections;" +
  //        "using System.Globalization;" +
  //        "using System.Threading;" +
  //        "" +
  //        "internal static class Win32Native {" +
  //        "#if !FEATURE_PAL" +
  //        "#else // !FEATURE_PAL" +
  //        "" +
  //        "#if !PLATFORM_UNIX" +
  //        "//       //internal const String DLLPREFIX = \"\";" +
  //        "//       //internal const String DLLSUFFIX = \".dll\";" +
  //        "#else // !PLATFORM_UNIX" +
  //        "#if __APPLE__" +
  //        "//       //internal const String DLLPREFIX = \"lib\";" +
  //        "//       //internal const String DLLSUFFIX = \".dylib\";" +
  //        "// #elif _AIX" +
  //        "//       //internal const String DLLPREFIX = \"lib\";" +
  //        "//       //internal const String DLLSUFFIX = \".a\";" +
  //        "#elif __hppa__ || IA64" +
  //        "//       //internal const String DLLPREFIX = \"lib\";" +
  //        "//       //internal const String DLLSUFFIX = \".sl\";" +
  //        "// #else" +
  //        "//       //internal const String DLLPREFIX = \"lib\";" +
  //        "//       //internal const String DLLSUFFIX = \".so\";" +
  //        "#endif" +
  //        "#endif // !PLATFORM_UNIX" +
  //        "#endif" +
  //        "}" +
  //        "" +
  //        ""
  //    testParser(text).pp_test2
  //  }


  it should "primary expression 00" in {
    val text =
      "Foo" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression 01" in {
    val text =
      "Path(args)" +
        "" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression 03" in {
    val text =
      "Foo.Path(args)" +
        "" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression 04" in {
    val text =
      "Foo[]" +
        "" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression 05" in {
    val text =
      "Foo[a]" +
        "" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression 06" in {
    val text =
      "Foo[a].Bar" +
        "" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression 07" in {
    val text =
      "Foo[a].Bar[p]" +
        "" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression 08" in {
    val text =
      "string.Intern(blah)" +
        "" +
        "" +
        ""
    testParser(text).primary_expression
  }


  it should "primary expression list 09" in {
    val text =
      "//();" +
        "1;" +
        "true;" +
        "foo;" +
        "foo.bar;" +
        "a.b.c.d.e;" +
        "foo[];" +
        "foo[0];" +
        "foo[a];" +
        "foo[ab];" +
        "foo[ab].bar;" +
        "foo[ab].bar[a];" +
        "bar[][];" +
        "bar[a][];" +
        "bar[a][b];" +
        "foo();" +
        "foo(a);" +
        "foo(a,b);" +
        "foo[0].foo();" +
        "foo[a].foo(a);" +
        "foo[ab].foo(a,b);" +
        "foo[ab].bar.foo();" +
        "foo[ab].bar[a].foo();" +
        "//(foo)bar;			// unary does casting" +
        "this.foo;" +
        "this.foo();" +
        "this.foo[0];" +
        "" +
        ""
    testParser(text).primary_expression_list
  }


  it should "primary expression list 08" in {
    val text =
      "//();" +
        "foo;" +
        "foo.bar;" +
        "//foo->bar;" +
        "foo.bar->unsafe_member;" +
        "foo[ab]->bar;" +
        "a.b.c.d.e;" +
        "foo[];" +
        "foo[0];" +
        "foo[0](one,two,three);" +
        "foo[a];" +
        "foo[ab];" +
        "foo[ab].bar;" +
        "foo[ab].bar[a];" +
        "bar[][];" +
        "bar[a][];" +
        "bar[a][b];" +
        "foo();" +
        "foo(a);" +
        "foo(a,b);" +
        "foo[0].foo();" +
        "foo[a].foo(a);" +
        "foo[ab].foo(a,b);" +
        "foo[ab].bar.foo();" +
        "foo[ab].bar[a].foo();" +
        "//(foo);" +
        "this.foo;" +
        "this.foo();" +
        "this.foo()[4];" +
        "base.foo(one, two);" +
        "string.Intern(blah);" +
        "string.Intern<int>(blah);" +
        "this.foo[0];" +
        "global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced);" +
        "typeof(foo);" +
        "new System.Uri();" +
        "new Point3D[] {" +
        "new Point3D(x1, y1, z1)," +
        "new Point3D(x1, y1, z2)," +
        "new Point3D(x1, y2, z1)," +
        "new Point3D(x1, y2, z2)," +
        "new Point3D(x2, y1, z1)," +
        "new Point3D(x2, y1, z2)," +
        "new Point3D(x2, y2, z1)," +
        "new Point3D(x2, y2, z2)," +
        "};" +
        "new System.Uri(\"DemoWindow.xaml\", System.UriKind.Relative);" +
        "new StreamReader(context.Request.InputStream).ReadToEnd();" +
        "//doc.LoadXml(new StreamReader(context.Request.InputStream).ReadToEnd());" +
        "((ModuleResolveEventHandler) ds[i])(this, new ResolveEventArgs(moduleName));" +
        "\"string\"[i%3];" +
        "test<asdf>;" +
        ""
    testParser(text).primary_expression_list
  }


  it should "primary or array creation expression 00" in {
    val text =
      "new Point3D[] {" +
        "new Point3D(x1, y1, z1)," +
        "new Point3D(x1, y1, z2)," +
        "new Point3D(x1, y2, z1)," +
        "new Point3D(x1, y2, z2)," +
        "new Point3D(x2, y1, z1)," +
        "new Point3D(x2, y1, z2)," +
        "new Point3D(x2, y2, z1)," +
        "new Point3D(x2, y2, z2)," +
        "}" +
        ""
    testParser(text).primary_or_array_creation_expression
  }


  it should "property declaration list 00" in {
    val text =
      "not_string Foo { set; get; }" +
        "public string Foo { public set; get; }" +
        "string[] Foo { get; set; }" +
        "public not_string Foo { set; get; }" +
        ""
    testParser(text).property_declaration_list
  }


  it should "qid part 00" in {
    val text =
      "->bar" +
        ""
    testParser(text).qid_part
  }


  it should "query body 00" in {
    val text =
      "where student.Scores[0] > 90" +
        "select foo" +
        "" +
        ""
    testParser(text).query_body
  }


  it should "query body clause 00" in {
    val text =
      "where student.Scores[0] > 90" +
        "" +
        ""
    testParser(text).query_body_clause
  }


  it should "query expression 00" in {
    val text =
      "from student in students" +
        "where student.Scores[0] > 90" +
        "select student" +
        "" +
        ""
    testParser(text).query_expression
  }


  it should "query expression 01" in {
    val text =
      "from from_ in students" +
        "where student.Scores[0] > 90" +
        "select student" +
        "" +
        ""
    testParser(text).query_expression
  }


  it should "ref variable reference 00" in {
    val text =
      "ref (int) ref foo" +
        "" +
        ""
    testParser(text).ref_variable_reference
  }


  it should "return statement 00" in {
    val text =
      "return true;" +
        ""
    testParser(text).return_statement
  }


  it should "return statement 01" in {
    val text =
      "return -1;" +
        ""
    testParser(text).return_statement
  }


  it should "return statement 02" in {
    val text =
      "return (void**) base.handle;" +
        ""
    testParser(text).return_statement
  }


  it should "return type 00" in {
    val text =
      "string[]" +
        ""
    testParser(text).return_type
  }


  it should "statement 00" in {
    val text =
      "//Path.Foo();" +
        "this.argumentMap[argument.LongName] = argument;" +
        ""
    testParser(text).statement
  }


  it should "statement 01" in {
    val text =
      "_string.Intern(symbol);" +
        ""
    testParser(text).statement
  }


  it should "statement 02" in {
    val text =
      "++g;" +
        ""
    testParser(text).statement
  }


  it should "statement 03" in {
    val text =
      "while (true) ++i;" +
        "" +
        ""
    testParser(text).statement
  }


  it should "statement 04" in {
    val text =
      "i--;" +
        "" +
        ""
    testParser(text).statement
  }


  it should "statement expression 00" in {
    val text =
      "//Path.Foo();" +
        "this.argumentMap[argument.LongName] = argument" +
        ""
    testParser(text).statement_expression
  }


  it should "statement expression 01" in {
    val text =
      "++i" +
        ""
    testParser(text).statement_expression
  }


  it should "statement expression 02" in {
    val text =
      "i--" +
        ""
    testParser(text).statement_expression
  }


  //  it should "Test2" in {
  //    val text =
  //      "using System;" +
  //        "using System.Collections;" +
  //        "using System.IO;" +
  //        "using System.Drawing;" +
  //        "using System.Windows.Forms;" +
  //        "using // TEST" +
  //        "System.Xml;" +
  //        "" +
  //        "namespace JetBrains.Omea.OpenAPI" +
  //        "{" +
  //        "/// <summary>" +
  //        "/// Specifies a format of a plain or rich text string." +
  //        "/// </summary>" +
  //        "public enum TextFormat" +
  //        "{" +
  //        "/// <summary>" +
  //        "/// The string contains plain text." +
  //        "/// </summary>" +
  //        "PlainText," +
  //        "" +
  //        "/// <summary>" +
  //        "/// The string is a valid HTML fragment." +
  //        "/// </summary>" +
  //        "Html," +
  //        "" +
  //        "/// <summary>" +
  //        "/// The string contains rich text in the RTF format." +
  //        "// </summary>" +
  //        "Rtf" +
  //        "};" +
  //        "}" +
  //        ""
  //    testParser(text).Test2.cs
  //  }


  //  it should "Test3" in {
  //    val text =
  //      "using System;" +
  //        "using System.Collections;" +
  //        "using System.IO;" +
  //        "using System.Drawing;" +
  //        "using System.Windows.Forms;" +
  //        "using System.Xml;" +
  //        "" +
  //        "namespace JetBrains.Omea.OpenAPI" +
  //        "{" +
  //        "public enum TextFormat" +
  //        "{" +
  //        "PlainText," +
  //        "Html," +
  //        "Rtf" +
  //        "};" +
  //        "public interface IPlugin" +
  //        "{" +
  //        "void Register();" +
  //        "void Startup();" +
  //        "void Shutdown();" +
  //        "}" +
  //        "public interface IResourceDisplayer" +
  //        "{" +
  //        "IDisplayPane CreateDisplayPane( string resourceType );" +
  //        "}" +
  //        "public interface ICommandProcessor : IFoo, IBar" +
  //        "{" +
  //        "bool CanExecuteCommand( string command );" +
  //        "void ExecuteCommand( string command );" +
  //        "}" +
  //        "public interface IDisplayPane: ICommandProcessor" +
  //        "{" +
  //        "Control GetControl();" +
  //        "void DisplayResource( IResource resource );" +
  //        "//[ Obsolete( \"Use the IDisplayPane2.HighlightWords(IResource, WordPtr[]) overload instead.\", false ) ]" +
  //        "void HighlightWords( WordPtr[] words );" +
  //        "void EndDisplayResource( IResource resource );" +
  //        "void DisposePane();" +
  //        "string GetSelectedText( ref TextFormat format );" +
  //        "string GetSelectedPlainText();" +
  //        "}" +
  //        "public interface IDisplayPane3 : IDisplayPane" +
  //        "{" +
  //        "void DisplayResource( IResource resource, WordPtr[] wordsToHighlight );" +
  //        "}" +
  //        "//    public interface IResourceTextProvider" +
  //        "//    {" +
  //        "//        bool ProcessResourceText( IResource res, IResourceTextConsumer consumer );" +
  //        "//    }" +
  //        "}" +
  //        ""
  //    testParser(text).Test3.cs
  //  }


  //  it should "Test4" in {
  //    val text =
  //      "//#pragma checksum \"..\..\Window1.xaml\" \"{406ea660-64cf-4c82-b6f0-42d48172a799}\" \"4D5C2DB46D4AEBF3CE9D342012AD1775\"" +
  //        "//@null = new WriteStream(entry, isThrow, contentLength, this.async);" +
  //        "//                    case '\"':" +
  //        "//                    case '“':" +
  //        "//                    case '”':" +
  //        "//                    object[] args = new object[] { 100.ToString(CultureInfo.InstalledUICulture), discardedSinceLastFlush.ToString(CultureInfo.InstalledUICulture), lastFlush.ToString(\"r\", CultureInfo.InstalledUICulture) };" +
  //        "//" +
  //        "//" +
  //        "using System;" +
  //        "using System.Collections;" +
  //        "using System.IO;" +
  //        "using System.Drawing;" +
  //        "using System.Windows.Forms;" +
  //        "using System.Xml;" +
  //        "" +
  //        "namespace JetBrains.Omea.OpenAPI" +
  //        "{" +
  //        "" +
  //        "public class DisplayPaneCommands" +
  //        "{" +
  //        "public string Forward;" +
  //        "public const string Forward;" +
  //        "public string Forward		   = \"Backwards\";" +
  //        "public const double Sideways   = 1234;" +
  //        "public const string Sideways   = 1.234;" +
  //        "public const string Sideways   = 1.234f;" +
  //        "public const string Sideways   = 0x1234;" +
  //        "// need expressions for this" +
  //        "//        public const string Back       = 0.ToString();" +
  //        "public const string Back       = null;" +
  //        "public const string FindInPage = \"FindInPage\";" +
  //        "public const string Cut        = \"Cut\";" +
  //        "public const string Copy       = \"Copy\";" +
  //        "public const string Paste      = \"Paste\";" +
  //        "public const string Print      = \"Print\";" +
  //        "public const string PageDown   = \"PageDown\";" +
  //        "public const string SelectAll  = \"SelectAll\";" +
  //        "public const string RenameSelection = \"RenameSelection\";" +
  //        "public const string NextSearchResult = \"NextSearchResult\";" +
  //        "public const string PrevSearchResult = \"PrevSearchResult\";" +
  //        "}" +
  //        "}" +
  //        ""
  //    testParser(text).Test4.cs
  //  }


  it should "try statement 00" in {
    val text =
      "try" +
        "{" +
        "Path.Foo();" +
        "}" +
        "finally" +
        "{}" +
        ""
    printTree(testParser(text).try_statement.getTree)
  }


  it should "try statement 01" in {
    val text =
      "try" +
        "{" +
        "int local = Path.Foo();" +
        "Model3DGroup @group = model as Model3DGroup;" +
        "}" +
        "finally" +
        "{}" +
        ""
    testParser(text).try_statement
  }


  it should "try statement 02" in {
    val text =
      "try" +
        "{" +
        "int local = Path.Foo();" +
        "Model3DGroup @group = model as Model3DGroup;" +
        "while(true)" +
        "{" +
        "}" +
        "}" +
        "catch (System.IndexOutOfRangeException)" +
        "{" +
        "}" +
        ""
    testParser(text).try_statement
  }


  it should "try statement 03" in {
    val text =
      "try" +
        "{" +
        "int local = Path.Foo();" +
        "Model3DGroup @group = model as Model3DGroup;" +
        "while(true)" +
        "{" +
        "}" +
        "}" +
        "catch (System.IndexOutOfRangeException)" +
        "{" +
        "}" +
        "catch(Exception)" +
        "{" +
        "}" +
        "catch" +
        "{" +
        "}" +
        "finally" +
        "{" +
        "}" +
        ""
    testParser(text).try_statement
  }

  it should "parse basic try-catch block" in {
    testParser("try" +
      "{" +
      "}" +
      "catch" +
      "{" +
      "}").try_statement()
  }


  it should "type 001" in {
    val text =
      "SomeType?" +
        ""
    testParser(text).`type`
  }


  it should "type 011" in {
    val text =
      "bool?" +
        ""
    testParser(text).`type`
  }


  it should "type 021" in {
    val text =
      "bool*" +
        ""
    testParser(text).`type`
  }


  it should "type 031" in {
    val text =
      "void**" +
        ""
    testParser(text).`type`
  }


  it should "type 051" in {
    val text =
      "List<string>" +
        ""
    testParser(text).`type`
  }


  it should "type 061" in {
    val text =
      "List[]" +
        ""
    testParser(text).`type`
  }


  it should "type 071" in {
    val text =
      "List<Foo<sstring>>" +
        ""
    testParser(text).`type`
  }


  it should "type 081" in {
    val text =
      "List[]" +
        ""
    testParser(text).`type`
  }


  it should "type 091" in {
    val text =
      "List<one,two>.Foo.Bar" +
        ""
    testParser(text).`type`
  }


  it should "type parameter constraints clause 00" in {
    val text =
      "where T : IComparable<WTF<T>>" +
        ""
    testParser(text).type_parameter_constraints_clause
  }


  it should "typeof expression 00" in {
    val text =
      "typeof(foo)" +
        ""
    testParser(text).typeof_expression
  }


  it should "typeof expression 01" in {
    val text =
      "typeof(int)" +
        ""
    testParser(text).typeof_expression
  }


  it should "typeof expression 02" in {
    val text =
      "typeof(System.Nullable<>)" +
        ""
    testParser(text).typeof_expression
  }


  it should "typeof expression 03" in {
    val text =
      "typeof(foo[])" +
        ""
    testParser(text).typeof_expression
  }


  it should "typeof expression 04" in {
    val text =
      "typeof(foo<>)" +
        ""
    testParser(text).typeof_expression
  }


  it should "unary expression 00" in {
    val text =
      "(insd)bar" +
        ""
    testParser(text).unary_expression
  }


  it should "unary expression list 00" in {
    val text =
      "1;" +
        "-1;" +
        "--pre;" +
        "++pre;" +
        "post--;" +
        "post++;" +
        "Path(args);" +
        "visCorners[3];" +
        "//();" +
        "foo;" +
        "foo.bar;" +
        "a.b.c.d.e;" +
        "foo[];" +
        "foo[0];" +
        "foo[a];" +
        "foo[ab];" +
        "foo[ab].bar;" +
        "foo[ab].bar[a];" +
        "bar[][];" +
        "bar[a][];" +
        "bar[a][b];" +
        "foo();" +
        "foo(a);" +
        "foo(a,b);" +
        "foo[0].foo();" +
        "foo[a].foo(a);" +
        "foo[ab].foo(a,b);" +
        "foo[ab].bar.foo();" +
        "foo[ab].bar[a].foo();" +
        "(insd)bar;      	// cast" +
        "(this.foo).bar;	// paren_expression" +
        "(CastMe)Foo.Path(args);" +
        "this.foo();" +
        "this.foo[0];" +
        "this.argumentMap[argument.LongName];" +
        "*something;" +
        "*(something);	// paren_expression" +
        "*(src + len);	// paren expression" +
        ""
    testParser(text).unary_expression_list
  }


  it should "variant generic parameter list 00" in {
    val text =
      "<out S, in P, A, M>" +
        ""
    testParser(text).variant_generic_parameter_list
  }


  it should "while statement 00" in {
    val text =
      "while (true)" +
        "foo();" +
        "" +
        ""
    testParser(text).while_statement
  }


  it should "while statement 01" in {
    val text =
      "while (true)" +
        "foo.bar;" +
        "" +
        ""
    testParser(text).while_statement
  }


}

