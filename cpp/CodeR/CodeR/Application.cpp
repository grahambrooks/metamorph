#include <antlr3.hpp>
#include "Application.hpp"
#include "CSharpParser.hpp"

namespace CodeR {
    int Application::run(int argc, char const *argv) {
        ANTLR_UINT8 *filename;

        if (argc < 2 || argv[1] == NULL) {
            filename = (ANTLR_UINT8 *) "./input"; // Note in VS2005 debug, working directory must be configured
        } else {
            filename = (ANTLR_UINT8 *) argv[1];
        }

        CSharpLexer::InputStreamType inputStream(filename, ANTLR_ENC_8BIT);
        CSharpLexer lexer(&inputStream);
        CSharpParser::TokenStreamType token_stream(ANTLR_SIZE_HINT, lexer.get_tokSource());
        CSharpParser parser(&token_stream);

        parser.compilation_unit();

        return 0;
    }
}