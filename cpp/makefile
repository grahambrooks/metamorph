
GENERATED	=	generated/CSharpLexer.cpp	\
			generated/CSharpLexer.hpp	\
			generated/CSharpParser.cpp	\
			generated/CSharpParser.hpp


all	:	CodeR


CodeR	: *.cpp $(GENERATED)
	clang++ -g -O1 -faddress-sanitizer -I . -I include/antlr3 -std=c++11 -Xclang "-stdlib=libc++" -Xlinker -lc++ -o CodeR generated/*.cpp main.cpp	
	# g++ -I . -I include/antlr3 -o CodeR generated/*.cpp main.cpp	


$(GENERATED)	:	CSharp.g
	java -jar antlr-3.4-with-cpp.jar -o generated CSharp.g


clean:
	rm -f CodeR
	rm -f generated/*
