#include    <CSharpLexer.hpp>
#include    <CSharpParser.hpp>

using namespace CodeR;

int test_main(int argc, char *argv[])
{
  ANTLR_UINT8*  fName;
  
  if (argc < 2 || argv[1] == NULL) {
    fName =(ANTLR_UINT8*)"./input"; // Note in VS2005 debug, working directory must be configured
  } else {
    fName = (ANTLR_UINT8*)argv[1];
  }
  
  
  CSharpLexer::InputStreamType input(fName, ANTLR_ENC_8BIT);
  CSharpLexer lxr(&input);	    // CLexerNew is generated by ANTLR
  CSharpParser::TokenStreamType tstream(ANTLR_SIZE_HINT, lxr.get_tokSource() );
  CSharpParser psr(&tstream);  // CParserNew is generated by ANTLR3
  
  psr.compilation_unit();

  return 0;
}


int main()
{
  test_main(1, NULL);
  return 0;
}
