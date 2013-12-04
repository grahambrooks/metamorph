// $ANTLR ANTLRVersion> JavaLexer.java generatedTimestamp>

    package metamorph.java;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__88=1, T__87=2, T__86=3, T__85=4, T__84=5, T__83=6, T__82=7, T__81=8, 
		T__80=9, T__79=10, T__78=11, T__77=12, T__76=13, T__75=14, T__74=15, T__73=16, 
		T__72=17, T__71=18, T__70=19, T__69=20, T__68=21, T__67=22, T__66=23, 
		T__65=24, T__64=25, T__63=26, T__62=27, T__61=28, T__60=29, T__59=30, 
		T__58=31, T__57=32, T__56=33, T__55=34, T__54=35, T__53=36, T__52=37, 
		T__51=38, T__50=39, T__49=40, T__48=41, T__47=42, T__46=43, T__45=44, 
		T__44=45, T__43=46, T__42=47, T__41=48, T__40=49, T__39=50, T__38=51, 
		T__37=52, T__36=53, T__35=54, T__34=55, T__33=56, T__32=57, T__31=58, 
		T__30=59, T__29=60, T__28=61, T__27=62, T__26=63, T__25=64, T__24=65, 
		T__23=66, T__22=67, T__21=68, T__20=69, T__19=70, T__18=71, T__17=72, 
		T__16=73, T__15=74, T__14=75, T__13=76, T__12=77, T__11=78, T__10=79, 
		T__9=80, T__8=81, T__7=82, T__6=83, T__5=84, T__4=85, T__3=86, T__2=87, 
		T__1=88, T__0=89, HexLiteral=90, DecimalLiteral=91, OctalLiteral=92, FloatingPointLiteral=93, 
		CharacterLiteral=94, StringLiteral=95, ENUM=96, ASSERT=97, Identifier=98, 
		COMMENT=99, WS=100, LINE_COMMENT=101;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'interface'", "'&'", "'*'", "'['", "'<'", "'--'", "'false'", "'continue'", 
		"'!='", "'double'", "'abstract'", "'boolean'", "'}'", "'float'", "'char'", 
		"'strictfp'", "'case'", "'super'", "'do'", "'%'", "'*='", "')'", "'throw'", 
		"'@'", "'='", "'null'", "'throws'", "'|='", "'new'", "'class'", "'finally'", 
		"'|'", "'transient'", "'!'", "'long'", "'short'", "']'", "'-='", "'public'", 
		"'default'", "'synchronized'", "','", "'while'", "'-'", "'('", "':'", 
		"'if'", "'&='", "'int'", "'private'", "'?'", "'try'", "'void'", "'package'", 
		"'...'", "'{'", "'break'", "'native'", "'+='", "'extends'", "'^='", "'final'", 
		"'else'", "'catch'", "'true'", "'static'", "'++'", "'import'", "'byte'", 
		"'^'", "'.'", "'+'", "'protected'", "'for'", "'return'", "'volatile'", 
		"';'", "'&&'", "'this'", "'||'", "'>'", "'implements'", "'%='", "'switch'", 
		"'/='", "'/'", "'=='", "'~'", "'instanceof'", "HexLiteral", "DecimalLiteral", 
		"OctalLiteral", "FloatingPointLiteral", "CharacterLiteral", "StringLiteral", 
		"'enum'", "'assert'", "Identifier", "COMMENT", "WS", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__88", "T__87", "T__86", "T__85", "T__84", "T__83", "T__82", "T__81", 
		"T__80", "T__79", "T__78", "T__77", "T__76", "T__75", "T__74", "T__73", 
		"T__72", "T__71", "T__70", "T__69", "T__68", "T__67", "T__66", "T__65", 
		"T__64", "T__63", "T__62", "T__61", "T__60", "T__59", "T__58", "T__57", 
		"T__56", "T__55", "T__54", "T__53", "T__52", "T__51", "T__50", "T__49", 
		"T__48", "T__47", "T__46", "T__45", "T__44", "T__43", "T__42", "T__41", 
		"T__40", "T__39", "T__38", "T__37", "T__36", "T__35", "T__34", "T__33", 
		"T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", "T__25", 
		"T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", 
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"HexLiteral", "DecimalLiteral", "OctalLiteral", "HexDigit", "IntegerTypeSuffix", 
		"FloatingPointLiteral", "Exponent", "FloatTypeSuffix", "CharacterLiteral", 
		"StringLiteral", "EscapeSequence", "OctalEscape", "UnicodeEscape", "ENUM", 
		"ASSERT", "Identifier", "Letter", "JavaIDDigit", "COMMENT", "WS", "LINE_COMMENT"
	};


	  protected boolean enumIsKeyword = true;
	  protected boolean assertIsKeyword = true;


	public JavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Java.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }


	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch ( ruleIndex ) {
			case 0 : T__88_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__87_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__86_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__85_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__84_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__83_action((RuleContext)_localctx, actionIndex); break;
			case 6 : T__82_action((RuleContext)_localctx, actionIndex); break;
			case 7 : T__81_action((RuleContext)_localctx, actionIndex); break;
			case 8 : T__80_action((RuleContext)_localctx, actionIndex); break;
			case 9 : T__79_action((RuleContext)_localctx, actionIndex); break;
			case 10 : T__78_action((RuleContext)_localctx, actionIndex); break;
			case 11 : T__77_action((RuleContext)_localctx, actionIndex); break;
			case 12 : T__76_action((RuleContext)_localctx, actionIndex); break;
			case 13 : T__75_action((RuleContext)_localctx, actionIndex); break;
			case 14 : T__74_action((RuleContext)_localctx, actionIndex); break;
			case 15 : T__73_action((RuleContext)_localctx, actionIndex); break;
			case 16 : T__72_action((RuleContext)_localctx, actionIndex); break;
			case 17 : T__71_action((RuleContext)_localctx, actionIndex); break;
			case 18 : T__70_action((RuleContext)_localctx, actionIndex); break;
			case 19 : T__69_action((RuleContext)_localctx, actionIndex); break;
			case 20 : T__68_action((RuleContext)_localctx, actionIndex); break;
			case 21 : T__67_action((RuleContext)_localctx, actionIndex); break;
			case 22 : T__66_action((RuleContext)_localctx, actionIndex); break;
			case 23 : T__65_action((RuleContext)_localctx, actionIndex); break;
			case 24 : T__64_action((RuleContext)_localctx, actionIndex); break;
			case 25 : T__63_action((RuleContext)_localctx, actionIndex); break;
			case 26 : T__62_action((RuleContext)_localctx, actionIndex); break;
			case 27 : T__61_action((RuleContext)_localctx, actionIndex); break;
			case 28 : T__60_action((RuleContext)_localctx, actionIndex); break;
			case 29 : T__59_action((RuleContext)_localctx, actionIndex); break;
			case 30 : T__58_action((RuleContext)_localctx, actionIndex); break;
			case 31 : T__57_action((RuleContext)_localctx, actionIndex); break;
			case 32 : T__56_action((RuleContext)_localctx, actionIndex); break;
			case 33 : T__55_action((RuleContext)_localctx, actionIndex); break;
			case 34 : T__54_action((RuleContext)_localctx, actionIndex); break;
			case 35 : T__53_action((RuleContext)_localctx, actionIndex); break;
			case 36 : T__52_action((RuleContext)_localctx, actionIndex); break;
			case 37 : T__51_action((RuleContext)_localctx, actionIndex); break;
			case 38 : T__50_action((RuleContext)_localctx, actionIndex); break;
			case 39 : T__49_action((RuleContext)_localctx, actionIndex); break;
			case 40 : T__48_action((RuleContext)_localctx, actionIndex); break;
			case 41 : T__47_action((RuleContext)_localctx, actionIndex); break;
			case 42 : T__46_action((RuleContext)_localctx, actionIndex); break;
			case 43 : T__45_action((RuleContext)_localctx, actionIndex); break;
			case 44 : T__44_action((RuleContext)_localctx, actionIndex); break;
			case 45 : T__43_action((RuleContext)_localctx, actionIndex); break;
			case 46 : T__42_action((RuleContext)_localctx, actionIndex); break;
			case 47 : T__41_action((RuleContext)_localctx, actionIndex); break;
			case 48 : T__40_action((RuleContext)_localctx, actionIndex); break;
			case 49 : T__39_action((RuleContext)_localctx, actionIndex); break;
			case 50 : T__38_action((RuleContext)_localctx, actionIndex); break;
			case 51 : T__37_action((RuleContext)_localctx, actionIndex); break;
			case 52 : T__36_action((RuleContext)_localctx, actionIndex); break;
			case 53 : T__35_action((RuleContext)_localctx, actionIndex); break;
			case 54 : T__34_action((RuleContext)_localctx, actionIndex); break;
			case 55 : T__33_action((RuleContext)_localctx, actionIndex); break;
			case 56 : T__32_action((RuleContext)_localctx, actionIndex); break;
			case 57 : T__31_action((RuleContext)_localctx, actionIndex); break;
			case 58 : T__30_action((RuleContext)_localctx, actionIndex); break;
			case 59 : T__29_action((RuleContext)_localctx, actionIndex); break;
			case 60 : T__28_action((RuleContext)_localctx, actionIndex); break;
			case 61 : T__27_action((RuleContext)_localctx, actionIndex); break;
			case 62 : T__26_action((RuleContext)_localctx, actionIndex); break;
			case 63 : T__25_action((RuleContext)_localctx, actionIndex); break;
			case 64 : T__24_action((RuleContext)_localctx, actionIndex); break;
			case 65 : T__23_action((RuleContext)_localctx, actionIndex); break;
			case 66 : T__22_action((RuleContext)_localctx, actionIndex); break;
			case 67 : T__21_action((RuleContext)_localctx, actionIndex); break;
			case 68 : T__20_action((RuleContext)_localctx, actionIndex); break;
			case 69 : T__19_action((RuleContext)_localctx, actionIndex); break;
			case 70 : T__18_action((RuleContext)_localctx, actionIndex); break;
			case 71 : T__17_action((RuleContext)_localctx, actionIndex); break;
			case 72 : T__16_action((RuleContext)_localctx, actionIndex); break;
			case 73 : T__15_action((RuleContext)_localctx, actionIndex); break;
			case 74 : T__14_action((RuleContext)_localctx, actionIndex); break;
			case 75 : T__13_action((RuleContext)_localctx, actionIndex); break;
			case 76 : T__12_action((RuleContext)_localctx, actionIndex); break;
			case 77 : T__11_action((RuleContext)_localctx, actionIndex); break;
			case 78 : T__10_action((RuleContext)_localctx, actionIndex); break;
			case 79 : T__9_action((RuleContext)_localctx, actionIndex); break;
			case 80 : T__8_action((RuleContext)_localctx, actionIndex); break;
			case 81 : T__7_action((RuleContext)_localctx, actionIndex); break;
			case 82 : T__6_action((RuleContext)_localctx, actionIndex); break;
			case 83 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 84 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 85 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 86 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 87 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 88 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 89 : HexLiteral_action((RuleContext)_localctx, actionIndex); break;
			case 90 : DecimalLiteral_action((RuleContext)_localctx, actionIndex); break;
			case 91 : OctalLiteral_action((RuleContext)_localctx, actionIndex); break;
			case 92 : HexDigit_action((RuleContext)_localctx, actionIndex); break;
			case 93 : IntegerTypeSuffix_action((RuleContext)_localctx, actionIndex); break;
			case 94 : FloatingPointLiteral_action((RuleContext)_localctx, actionIndex); break;
			case 95 : Exponent_action((RuleContext)_localctx, actionIndex); break;
			case 96 : FloatTypeSuffix_action((RuleContext)_localctx, actionIndex); break;
			case 97 : CharacterLiteral_action((RuleContext)_localctx, actionIndex); break;
			case 98 : StringLiteral_action((RuleContext)_localctx, actionIndex); break;
			case 99 : EscapeSequence_action((RuleContext)_localctx, actionIndex); break;
			case 100 : OctalEscape_action((RuleContext)_localctx, actionIndex); break;
			case 101 : UnicodeEscape_action((RuleContext)_localctx, actionIndex); break;
			case 102 : ENUM_action((RuleContext)_localctx, actionIndex); break;
			case 103 : ASSERT_action((RuleContext)_localctx, actionIndex); break;
			case 104 : Identifier_action((RuleContext)_localctx, actionIndex); break;
			case 105 : Letter_action((RuleContext)_localctx, actionIndex); break;
			case 106 : JavaIDDigit_action((RuleContext)_localctx, actionIndex); break;
			case 107 : COMMENT_action((RuleContext)_localctx, actionIndex); break;
			case 108 : WS_action((RuleContext)_localctx, actionIndex); break;
			case 109 : LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	public void T__29_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__28_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__27_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__26_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void FloatTypeSuffix_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__25_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__24_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void OctalLiteral_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__23_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__22_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__21_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__20_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__9_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__8_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void Identifier_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__7_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__6_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__5_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__4_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__19_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__16_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__15_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__18_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__17_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__12_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__11_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__14_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__13_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__10_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 2 : skip();  break;
		}
	}
	public void T__80_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__81_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__82_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__83_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 4 : skip();  break;
		}
	}
	public void IntegerTypeSuffix_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__85_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__84_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void ASSERT_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 1 : if (!assertIsKeyword) _type = Identifier; break;
		}
	}
	public void T__87_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__86_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__88_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void WS_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 3 : skip();  break;
		}
	}
	public void T__71_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__72_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__70_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void FloatingPointLiteral_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void JavaIDDigit_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__76_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__75_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__74_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void Letter_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void EscapeSequence_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__73_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__79_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__78_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__77_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__68_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__69_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__66_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__67_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__64_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__65_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__62_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__63_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void CharacterLiteral_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void Exponent_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__61_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__60_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void HexDigit_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__55_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__56_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__57_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__58_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__51_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__52_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__53_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__54_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__59_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__50_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__42_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__43_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void HexLiteral_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__40_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__41_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__46_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__47_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__44_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__45_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__48_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__49_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void DecimalLiteral_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void StringLiteral_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__30_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__31_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__32_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__33_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void ENUM_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 0 : if (!enumIsKeyword) _type = Identifier; break;
		}
	}
	public void T__34_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__35_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__36_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__37_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__38_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__39_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void UnicodeEscape_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__1_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__0_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__3_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__2_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void OctalEscape_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}

	public static final String _serializedATN =
		"\2e\u0372\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6"+
		"\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\2\16\7"+
		"\16\2\17\7\17\2\20\7\20\2\21\7\21\2\22\7\22\2\23\7\23\2\24\7\24\2\25\7"+
		"\25\2\26\7\26\2\27\7\27\2\30\7\30\2\31\7\31\2\32\7\32\2\33\7\33\2\34\7"+
		"\34\2\35\7\35\2\36\7\36\2\37\7\37\2 \7 \2!\7!\2\"\7\"\2#\7#\2$\7$\2%\7"+
		"%\2&\7&\2\'\7\'\2(\7(\2)\7)\2*\7*\2+\7+\2,\7,\2-\7-\2.\7.\2/\7/\2\60\7"+
		"\60\2\61\7\61\2\62\7\62\2\63\7\63\2\64\7\64\2\65\7\65\2\66\7\66\2\67\7"+
		"\67\28\78\29\79\2:\7:\2;\7;\2<\7<\2=\7=\2>\7>\2?\7?\2@\7@\2A\7A\2B\7B"+
		"\2C\7C\2D\7D\2E\7E\2F\7F\2G\7G\2H\7H\2I\7I\2J\7J\2K\7K\2L\7L\2M\7M\2N"+
		"\7N\2O\7O\2P\7P\2Q\7Q\2R\7R\2S\7S\2T\7T\2U\7U\2V\7V\2W\7W\2X\7X\2Y\7Y"+
		"\2Z\7Z\2[\7[\2\\\7\\\2]\7]\2^\7^\2_\7_\2`\7`\2a\7a\2b\7b\2c\7c\2d\7d\2"+
		"e\7e\2f\7f\2g\7g\2h\7h\2i\7i\2j\7j\2k\7k\2l\7l\2m\7m\1\0\1\0\1\0\1\0\1"+
		"\0\1\0\1\0\1\0\1\0\1\0\1\1\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1\5\1\5\1\5\1\6"+
		"\1\6\1\6\1\6\1\6\1\6\1\7\1\7\1\7\1\7\1\7\1\7\1\7\1\7\1\7\1\b\1\b\1\b\1"+
		"\t\1\t\1\t\1\t\1\t\1\t\1\t\1\n\1\n\1\n\1\n\1\n\1\n\1\n\1\n\1\n\1\13\1"+
		"\13\1\13\1\13\1\13\1\13\1\13\1\13\1\f\1\f\1\r\1\r\1\r\1\r\1\r\1\r\1\16"+
		"\1\16\1\16\1\16\1\16\1\17\1\17\1\17\1\17\1\17\1\17\1\17\1\17\1\17\1\20"+
		"\1\20\1\20\1\20\1\20\1\21\1\21\1\21\1\21\1\21\1\21\1\22\1\22\1\22\1\23"+
		"\1\23\1\24\1\24\1\24\1\25\1\25\1\26\1\26\1\26\1\26\1\26\1\26\1\27\1\27"+
		"\1\30\1\30\1\31\1\31\1\31\1\31\1\31\1\32\1\32\1\32\1\32\1\32\1\32\1\32"+
		"\1\33\1\33\1\33\1\34\1\34\1\34\1\34\1\35\1\35\1\35\1\35\1\35\1\35\1\36"+
		"\1\36\1\36\1\36\1\36\1\36\1\36\1\36\1\37\1\37\1 \1 \1 \1 \1 \1 \1 \1 "+
		"\1 \1 \1!\1!\1\"\1\"\1\"\1\"\1\"\1#\1#\1#\1#\1#\1#\1$\1$\1%\1%\1%\1&\1"+
		"&\1&\1&\1&\1&\1&\1\'\1\'\1\'\1\'\1\'\1\'\1\'\1\'\1(\1(\1(\1(\1(\1(\1("+
		"\1(\1(\1(\1(\1(\1(\1)\1)\1*\1*\1*\1*\1*\1*\1+\1+\1,\1,\1-\1-\1.\1.\1."+
		"\1/\1/\1/\1\60\1\60\1\60\1\60\1\61\1\61\1\61\1\61\1\61\1\61\1\61\1\61"+
		"\1\62\1\62\1\63\1\63\1\63\1\63\1\64\1\64\1\64\1\64\1\64\1\65\1\65\1\65"+
		"\1\65\1\65\1\65\1\65\1\65\1\66\1\66\1\66\1\66\1\67\1\67\18\18\18\18\1"+
		"8\18\19\19\19\19\19\19\19\1:\1:\1:\1;\1;\1;\1;\1;\1;\1;\1;\1<\1<\1<\1"+
		"=\1=\1=\1=\1=\1=\1>\1>\1>\1>\1>\1?\1?\1?\1?\1?\1?\1@\1@\1@\1@\1@\1A\1"+
		"A\1A\1A\1A\1A\1A\1B\1B\1B\1C\1C\1C\1C\1C\1C\1C\1D\1D\1D\1D\1D\1E\1E\1"+
		"F\1F\1G\1G\1H\1H\1H\1H\1H\1H\1H\1H\1H\1H\1I\1I\1I\1I\1J\1J\1J\1J\1J\1"+
		"J\1J\1K\1K\1K\1K\1K\1K\1K\1K\1K\1L\1L\1M\1M\1M\1N\1N\1N\1N\1N\1O\1O\1"+
		"O\1P\1P\1Q\1Q\1Q\1Q\1Q\1Q\1Q\1Q\1Q\1Q\1Q\1R\1R\1R\1S\1S\1S\1S\1S\1S\1"+
		"S\1T\1T\1T\1U\1U\1V\1V\1V\1W\1W\1X\1X\1X\1X\1X\1X\1X\1X\1X\1X\1X\1Y\1"+
		"Y\1Y\4Y\u028d\bY\13Y\fY\u028e\1Y\3Y\u0292\bY\1Z\1Z\1Z\5Z\u0297\bZ\nZ\f"+
		"Z\u029a\tZ\3Z\u029c\bZ\1Z\3Z\u029f\bZ\1[\1[\4[\u02a3\b[\13[\f[\u02a4\1"+
		"[\3[\u02a8\b[\1\\\1\\\1]\1]\1^\4^\u02af\b^\13^\f^\u02b0\1^\1^\5^\u02b5"+
		"\b^\n^\f^\u02b8\t^\1^\3^\u02bb\b^\1^\3^\u02be\b^\1^\1^\4^\u02c2\b^\13"+
		"^\f^\u02c3\1^\3^\u02c7\b^\1^\3^\u02ca\b^\1^\4^\u02cd\b^\13^\f^\u02ce\1"+
		"^\1^\3^\u02d3\b^\1^\4^\u02d6\b^\13^\f^\u02d7\1^\1^\1^\1^\1^\3^\u02df\b"+
		"^\1^\5^\u02e2\b^\n^\f^\u02e5\t^\1^\1^\5^\u02e9\b^\n^\f^\u02ec\t^\3^\u02ee"+
		"\b^\1^\1^\3^\u02f2\b^\1^\4^\u02f5\b^\13^\f^\u02f6\1^\3^\u02fa\b^\3^\u02fc"+
		"\b^\1_\1_\3_\u0300\b_\1_\4_\u0303\b_\13_\f_\u0304\1`\1`\1a\1a\1a\3a\u030c"+
		"\ba\1a\1a\1b\1b\1b\5b\u0313\bb\nb\fb\u0316\tb\1b\1b\1c\1c\1c\1c\3c\u031e"+
		"\bc\1d\1d\1d\1d\1d\1d\1d\1d\1d\3d\u0329\bd\1e\1e\1e\1e\1e\1e\1e\1f\1f"+
		"\1f\1f\1f\1f\1f\1g\1g\1g\1g\1g\1g\1g\1g\1g\1h\1h\1h\5h\u0345\bh\nh\fh"+
		"\u0348\th\1i\1i\1j\1j\1k\1k\1k\1k\5k\u0352\bk\nk\fk\u0355\tk\1k\1k\1k"+
		"\1k\1k\1l\4l\u035d\bl\13l\fl\u035e\1l\1l\1m\1m\1m\1m\5m\u0367\bm\nm\f"+
		"m\u036a\tm\1m\3m\u036d\bm\1m\1m\1m\1mn\1\1\uffff\3\2\uffff\5\3\uffff\7"+
		"\4\uffff\t\5\uffff\13\6\uffff\r\7\uffff\17\b\uffff\21\t\uffff\23\n\uffff"+
		"\25\13\uffff\27\f\uffff\31\r\uffff\33\16\uffff\35\17\uffff\37\20\uffff"+
		"!\21\uffff#\22\uffff%\23\uffff\'\24\uffff)\25\uffff+\26\uffff-\27\uffff"+
		"/\30\uffff\61\31\uffff\63\32\uffff\65\33\uffff\67\34\uffff9\35\uffff;"+
		"\36\uffff=\37\uffff? \uffffA!\uffffC\"\uffffE#\uffffG$\uffffI%\uffffK"+
		"&\uffffM\'\uffffO(\uffffQ)\uffffS*\uffffU+\uffffW,\uffffY-\uffff[.\uffff"+
		"]/\uffff_\60\uffffa\61\uffffc\62\uffffe\63\uffffg\64\uffffi\65\uffffk"+
		"\66\uffffm\67\uffffo8\uffffq9\uffffs:\uffffu;\uffffw<\uffffy=\uffff{>"+
		"\uffff}?\uffff\177@\uffff\u0081A\uffff\u0083B\uffff\u0085C\uffff\u0087"+
		"D\uffff\u0089E\uffff\u008bF\uffff\u008dG\uffff\u008fH\uffff\u0091I\uffff"+
		"\u0093J\uffff\u0095K\uffff\u0097L\uffff\u0099M\uffff\u009bN\uffff\u009d"+
		"O\uffff\u009fP\uffff\u00a1Q\uffff\u00a3R\uffff\u00a5S\uffff\u00a7T\uffff"+
		"\u00a9U\uffff\u00abV\uffff\u00adW\uffff\u00afX\uffff\u00b1Y\uffff\u00b3"+
		"Z\uffff\u00b5[\uffff\u00b7\\\uffff\u00b9\0\uffff\u00bb\0\uffff\u00bd]"+
		"\uffff\u00bf\0\uffff\u00c1\0\uffff\u00c3^\uffff\u00c5_\uffff\u00c7\0\uffff"+
		"\u00c9\0\uffff\u00cb\0\uffff\u00cd`\0\u00cfa\1\u00d1b\uffff\u00d3\0\uffff"+
		"\u00d5\0\uffff\u00d7c\2\u00d9d\3\u00dbe\4\1\0\17\2XXxx\3\609AFaf\2LLl"+
		"l\2PPpp\2++--\2EEee\2++--\4DDFFddff\2\'\'\\\\\2\"\"\\\\\b\"\"\'\'\\\\"+
		"bbffnnrrtt\f$$AZ__az\u00c0\u00d6\u00d8\u00f6\u00f8\u1fff\u3040\u318f\u3300"+
		"\u337f\u3400\u3d2d\u4e00\u9fff\uf900\ufaff\17\609\u0660\u0669\u06f0\u06f9"+
		"\u0966\u096f\u09e6\u09ef\u0a66\u0a6f\u0ae6\u0aef\u0b66\u0b6f\u0be7\u0bef"+
		"\u0c66\u0c6f\u0ce6\u0cef\u0d66\u0d6f\u0e50\u0e59\u0ed0\u0ed9\u1040\u1049"+
		"\3\t\n\f\r  \2\n\n\r\r\u0393\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0\0\0\0\7\1"+
		"\0\0\0\0\t\1\0\0\0\0\13\1\0\0\0\0\r\1\0\0\0\0\17\1\0\0\0\0\21\1\0\0\0"+
		"\0\23\1\0\0\0\0\25\1\0\0\0\0\27\1\0\0\0\0\31\1\0\0\0\0\33\1\0\0\0\0\35"+
		"\1\0\0\0\0\37\1\0\0\0\0!\1\0\0\0\0#\1\0\0\0\0%\1\0\0\0\0\'\1\0\0\0\0)"+
		"\1\0\0\0\0+\1\0\0\0\0-\1\0\0\0\0/\1\0\0\0\0\61\1\0\0\0\0\63\1\0\0\0\0"+
		"\65\1\0\0\0\0\67\1\0\0\0\09\1\0\0\0\0;\1\0\0\0\0=\1\0\0\0\0?\1\0\0\0\0"+
		"A\1\0\0\0\0C\1\0\0\0\0E\1\0\0\0\0G\1\0\0\0\0I\1\0\0\0\0K\1\0\0\0\0M\1"+
		"\0\0\0\0O\1\0\0\0\0Q\1\0\0\0\0S\1\0\0\0\0U\1\0\0\0\0W\1\0\0\0\0Y\1\0\0"+
		"\0\0[\1\0\0\0\0]\1\0\0\0\0_\1\0\0\0\0a\1\0\0\0\0c\1\0\0\0\0e\1\0\0\0\0"+
		"g\1\0\0\0\0i\1\0\0\0\0k\1\0\0\0\0m\1\0\0\0\0o\1\0\0\0\0q\1\0\0\0\0s\1"+
		"\0\0\0\0u\1\0\0\0\0w\1\0\0\0\0y\1\0\0\0\0{\1\0\0\0\0}\1\0\0\0\0\177\1"+
		"\0\0\0\0\u0081\1\0\0\0\0\u0083\1\0\0\0\0\u0085\1\0\0\0\0\u0087\1\0\0\0"+
		"\0\u0089\1\0\0\0\0\u008b\1\0\0\0\0\u008d\1\0\0\0\0\u008f\1\0\0\0\0\u0091"+
		"\1\0\0\0\0\u0093\1\0\0\0\0\u0095\1\0\0\0\0\u0097\1\0\0\0\0\u0099\1\0\0"+
		"\0\0\u009b\1\0\0\0\0\u009d\1\0\0\0\0\u009f\1\0\0\0\0\u00a1\1\0\0\0\0\u00a3"+
		"\1\0\0\0\0\u00a5\1\0\0\0\0\u00a7\1\0\0\0\0\u00a9\1\0\0\0\0\u00ab\1\0\0"+
		"\0\0\u00ad\1\0\0\0\0\u00af\1\0\0\0\0\u00b1\1\0\0\0\0\u00b3\1\0\0\0\0\u00b5"+
		"\1\0\0\0\0\u00b7\1\0\0\0\0\u00bd\1\0\0\0\0\u00c3\1\0\0\0\0\u00c5\1\0\0"+
		"\0\0\u00cd\1\0\0\0\0\u00cf\1\0\0\0\0\u00d1\1\0\0\0\0\u00d7\1\0\0\0\0\u00d9"+
		"\1\0\0\0\0\u00db\1\0\0\0\1\u00dd\1\0\0\0\3\u00e7\1\0\0\0\5\u00e9\1\0\0"+
		"\0\7\u00eb\1\0\0\0\t\u00ed\1\0\0\0\13\u00ef\1\0\0\0\r\u00f2\1\0\0\0\17"+
		"\u00f8\1\0\0\0\21\u0101\1\0\0\0\23\u0104\1\0\0\0\25\u010b\1\0\0\0\27\u0114"+
		"\1\0\0\0\31\u011c\1\0\0\0\33\u011e\1\0\0\0\35\u0124\1\0\0\0\37\u0129\1"+
		"\0\0\0!\u0132\1\0\0\0#\u0137\1\0\0\0%\u013d\1\0\0\0\'\u0140\1\0\0\0)\u0142"+
		"\1\0\0\0+\u0145\1\0\0\0-\u0147\1\0\0\0/\u014d\1\0\0\0\61\u014f\1\0\0\0"+
		"\63\u0151\1\0\0\0\65\u0156\1\0\0\0\67\u015d\1\0\0\09\u0160\1\0\0\0;\u0164"+
		"\1\0\0\0=\u016a\1\0\0\0?\u0172\1\0\0\0A\u0174\1\0\0\0C\u017e\1\0\0\0E"+
		"\u0180\1\0\0\0G\u0185\1\0\0\0I\u018b\1\0\0\0K\u018d\1\0\0\0M\u0190\1\0"+
		"\0\0O\u0197\1\0\0\0Q\u019f\1\0\0\0S\u01ac\1\0\0\0U\u01ae\1\0\0\0W\u01b4"+
		"\1\0\0\0Y\u01b6\1\0\0\0[\u01b8\1\0\0\0]\u01ba\1\0\0\0_\u01bd\1\0\0\0a"+
		"\u01c0\1\0\0\0c\u01c4\1\0\0\0e\u01cc\1\0\0\0g\u01ce\1\0\0\0i\u01d2\1\0"+
		"\0\0k\u01d7\1\0\0\0m\u01df\1\0\0\0o\u01e3\1\0\0\0q\u01e5\1\0\0\0s\u01eb"+
		"\1\0\0\0u\u01f2\1\0\0\0w\u01f5\1\0\0\0y\u01fd\1\0\0\0{\u0200\1\0\0\0}"+
		"\u0206\1\0\0\0\177\u020b\1\0\0\0\u0081\u0211\1\0\0\0\u0083\u0216\1\0\0"+
		"\0\u0085\u021d\1\0\0\0\u0087\u0220\1\0\0\0\u0089\u0227\1\0\0\0\u008b\u022c"+
		"\1\0\0\0\u008d\u022e\1\0\0\0\u008f\u0230\1\0\0\0\u0091\u0232\1\0\0\0\u0093"+
		"\u023c\1\0\0\0\u0095\u0240\1\0\0\0\u0097\u0247\1\0\0\0\u0099\u0250\1\0"+
		"\0\0\u009b\u0252\1\0\0\0\u009d\u0255\1\0\0\0\u009f\u025a\1\0\0\0\u00a1"+
		"\u025d\1\0\0\0\u00a3\u025f\1\0\0\0\u00a5\u026a\1\0\0\0\u00a7\u026d\1\0"+
		"\0\0\u00a9\u0274\1\0\0\0\u00ab\u0277\1\0\0\0\u00ad\u0279\1\0\0\0\u00af"+
		"\u027c\1\0\0\0\u00b1\u027e\1\0\0\0\u00b3\u0289\1\0\0\0\u00b5\u029b\1\0"+
		"\0\0\u00b7\u02a0\1\0\0\0\u00b9\u02a9\1\0\0\0\u00bb\u02ab\1\0\0\0\u00bd"+
		"\u02fb\1\0\0\0\u00bf\u02fd\1\0\0\0\u00c1\u0306\1\0\0\0\u00c3\u0308\1\0"+
		"\0\0\u00c5\u030f\1\0\0\0\u00c7\u031d\1\0\0\0\u00c9\u0328\1\0\0\0\u00cb"+
		"\u032a\1\0\0\0\u00cd\u0331\1\0\0\0\u00cf\u0338\1\0\0\0\u00d1\u0341\1\0"+
		"\0\0\u00d3\u0349\1\0\0\0\u00d5\u034b\1\0\0\0\u00d7\u034d\1\0\0\0\u00d9"+
		"\u035c\1\0\0\0\u00db\u0362\1\0\0\0\u00dd\u00de\5i\0\0\u00de\u00df\5n\0"+
		"\0\u00df\u00e0\5t\0\0\u00e0\u00e1\5e\0\0\u00e1\u00e2\5r\0\0\u00e2\u00e3"+
		"\5f\0\0\u00e3\u00e4\5a\0\0\u00e4\u00e5\5c\0\0\u00e5\u00e6\5e\0\0\u00e6"+
		"\2\1\0\0\0\u00e7\u00e8\5&\0\0\u00e8\4\1\0\0\0\u00e9\u00ea\5*\0\0\u00ea"+
		"\6\1\0\0\0\u00eb\u00ec\5[\0\0\u00ec\b\1\0\0\0\u00ed\u00ee\5<\0\0\u00ee"+
		"\n\1\0\0\0\u00ef\u00f0\5-\0\0\u00f0\u00f1\5-\0\0\u00f1\f\1\0\0\0\u00f2"+
		"\u00f3\5f\0\0\u00f3\u00f4\5a\0\0\u00f4\u00f5\5l\0\0\u00f5\u00f6\5s\0\0"+
		"\u00f6\u00f7\5e\0\0\u00f7\16\1\0\0\0\u00f8\u00f9\5c\0\0\u00f9\u00fa\5"+
		"o\0\0\u00fa\u00fb\5n\0\0\u00fb\u00fc\5t\0\0\u00fc\u00fd\5i\0\0\u00fd\u00fe"+
		"\5n\0\0\u00fe\u00ff\5u\0\0\u00ff\u0100\5e\0\0\u0100\20\1\0\0\0\u0101\u0102"+
		"\5!\0\0\u0102\u0103\5=\0\0\u0103\22\1\0\0\0\u0104\u0105\5d\0\0\u0105\u0106"+
		"\5o\0\0\u0106\u0107\5u\0\0\u0107\u0108\5b\0\0\u0108\u0109\5l\0\0\u0109"+
		"\u010a\5e\0\0\u010a\24\1\0\0\0\u010b\u010c\5a\0\0\u010c\u010d\5b\0\0\u010d"+
		"\u010e\5s\0\0\u010e\u010f\5t\0\0\u010f\u0110\5r\0\0\u0110\u0111\5a\0\0"+
		"\u0111\u0112\5c\0\0\u0112\u0113\5t\0\0\u0113\26\1\0\0\0\u0114\u0115\5"+
		"b\0\0\u0115\u0116\5o\0\0\u0116\u0117\5o\0\0\u0117\u0118\5l\0\0\u0118\u0119"+
		"\5e\0\0\u0119\u011a\5a\0\0\u011a\u011b\5n\0\0\u011b\30\1\0\0\0\u011c\u011d"+
		"\5}\0\0\u011d\32\1\0\0\0\u011e\u011f\5f\0\0\u011f\u0120\5l\0\0\u0120\u0121"+
		"\5o\0\0\u0121\u0122\5a\0\0\u0122\u0123\5t\0\0\u0123\34\1\0\0\0\u0124\u0125"+
		"\5c\0\0\u0125\u0126\5h\0\0\u0126\u0127\5a\0\0\u0127\u0128\5r\0\0\u0128"+
		"\36\1\0\0\0\u0129\u012a\5s\0\0\u012a\u012b\5t\0\0\u012b\u012c\5r\0\0\u012c"+
		"\u012d\5i\0\0\u012d\u012e\5c\0\0\u012e\u012f\5t\0\0\u012f\u0130\5f\0\0"+
		"\u0130\u0131\5p\0\0\u0131 \1\0\0\0\u0132\u0133\5c\0\0\u0133\u0134\5a\0"+
		"\0\u0134\u0135\5s\0\0\u0135\u0136\5e\0\0\u0136\"\1\0\0\0\u0137\u0138\5"+
		"s\0\0\u0138\u0139\5u\0\0\u0139\u013a\5p\0\0\u013a\u013b\5e\0\0\u013b\u013c"+
		"\5r\0\0\u013c$\1\0\0\0\u013d\u013e\5d\0\0\u013e\u013f\5o\0\0\u013f&\1"+
		"\0\0\0\u0140\u0141\5%\0\0\u0141(\1\0\0\0\u0142\u0143\5*\0\0\u0143\u0144"+
		"\5=\0\0\u0144*\1\0\0\0\u0145\u0146\5)\0\0\u0146,\1\0\0\0\u0147\u0148\5"+
		"t\0\0\u0148\u0149\5h\0\0\u0149\u014a\5r\0\0\u014a\u014b\5o\0\0\u014b\u014c"+
		"\5w\0\0\u014c.\1\0\0\0\u014d\u014e\5@\0\0\u014e\60\1\0\0\0\u014f\u0150"+
		"\5=\0\0\u0150\62\1\0\0\0\u0151\u0152\5n\0\0\u0152\u0153\5u\0\0\u0153\u0154"+
		"\5l\0\0\u0154\u0155\5l\0\0\u0155\64\1\0\0\0\u0156\u0157\5t\0\0\u0157\u0158"+
		"\5h\0\0\u0158\u0159\5r\0\0\u0159\u015a\5o\0\0\u015a\u015b\5w\0\0\u015b"+
		"\u015c\5s\0\0\u015c\66\1\0\0\0\u015d\u015e\5|\0\0\u015e\u015f\5=\0\0\u015f"+
		"8\1\0\0\0\u0160\u0161\5n\0\0\u0161\u0162\5e\0\0\u0162\u0163\5w\0\0\u0163"+
		":\1\0\0\0\u0164\u0165\5c\0\0\u0165\u0166\5l\0\0\u0166\u0167\5a\0\0\u0167"+
		"\u0168\5s\0\0\u0168\u0169\5s\0\0\u0169<\1\0\0\0\u016a\u016b\5f\0\0\u016b"+
		"\u016c\5i\0\0\u016c\u016d\5n\0\0\u016d\u016e\5a\0\0\u016e\u016f\5l\0\0"+
		"\u016f\u0170\5l\0\0\u0170\u0171\5y\0\0\u0171>\1\0\0\0\u0172\u0173\5|\0"+
		"\0\u0173@\1\0\0\0\u0174\u0175\5t\0\0\u0175\u0176\5r\0\0\u0176\u0177\5"+
		"a\0\0\u0177\u0178\5n\0\0\u0178\u0179\5s\0\0\u0179\u017a\5i\0\0\u017a\u017b"+
		"\5e\0\0\u017b\u017c\5n\0\0\u017c\u017d\5t\0\0\u017dB\1\0\0\0\u017e\u017f"+
		"\5!\0\0\u017fD\1\0\0\0\u0180\u0181\5l\0\0\u0181\u0182\5o\0\0\u0182\u0183"+
		"\5n\0\0\u0183\u0184\5g\0\0\u0184F\1\0\0\0\u0185\u0186\5s\0\0\u0186\u0187"+
		"\5h\0\0\u0187\u0188\5o\0\0\u0188\u0189\5r\0\0\u0189\u018a\5t\0\0\u018a"+
		"H\1\0\0\0\u018b\u018c\5]\0\0\u018cJ\1\0\0\0\u018d\u018e\5-\0\0\u018e\u018f"+
		"\5=\0\0\u018fL\1\0\0\0\u0190\u0191\5p\0\0\u0191\u0192\5u\0\0\u0192\u0193"+
		"\5b\0\0\u0193\u0194\5l\0\0\u0194\u0195\5i\0\0\u0195\u0196\5c\0\0\u0196"+
		"N\1\0\0\0\u0197\u0198\5d\0\0\u0198\u0199\5e\0\0\u0199\u019a\5f\0\0\u019a"+
		"\u019b\5a\0\0\u019b\u019c\5u\0\0\u019c\u019d\5l\0\0\u019d\u019e\5t\0\0"+
		"\u019eP\1\0\0\0\u019f\u01a0\5s\0\0\u01a0\u01a1\5y\0\0\u01a1\u01a2\5n\0"+
		"\0\u01a2\u01a3\5c\0\0\u01a3\u01a4\5h\0\0\u01a4\u01a5\5r\0\0\u01a5\u01a6"+
		"\5o\0\0\u01a6\u01a7\5n\0\0\u01a7\u01a8\5i\0\0\u01a8\u01a9\5z\0\0\u01a9"+
		"\u01aa\5e\0\0\u01aa\u01ab\5d\0\0\u01abR\1\0\0\0\u01ac\u01ad\5,\0\0\u01ad"+
		"T\1\0\0\0\u01ae\u01af\5w\0\0\u01af\u01b0\5h\0\0\u01b0\u01b1\5i\0\0\u01b1"+
		"\u01b2\5l\0\0\u01b2\u01b3\5e\0\0\u01b3V\1\0\0\0\u01b4\u01b5\5-\0\0\u01b5"+
		"X\1\0\0\0\u01b6\u01b7\5(\0\0\u01b7Z\1\0\0\0\u01b8\u01b9\5:\0\0\u01b9\\"+
		"\1\0\0\0\u01ba\u01bb\5i\0\0\u01bb\u01bc\5f\0\0\u01bc^\1\0\0\0\u01bd\u01be"+
		"\5&\0\0\u01be\u01bf\5=\0\0\u01bf`\1\0\0\0\u01c0\u01c1\5i\0\0\u01c1\u01c2"+
		"\5n\0\0\u01c2\u01c3\5t\0\0\u01c3b\1\0\0\0\u01c4\u01c5\5p\0\0\u01c5\u01c6"+
		"\5r\0\0\u01c6\u01c7\5i\0\0\u01c7\u01c8\5v\0\0\u01c8\u01c9\5a\0\0\u01c9"+
		"\u01ca\5t\0\0\u01ca\u01cb\5e\0\0\u01cbd\1\0\0\0\u01cc\u01cd\5?\0\0\u01cd"+
		"f\1\0\0\0\u01ce\u01cf\5t\0\0\u01cf\u01d0\5r\0\0\u01d0\u01d1\5y\0\0\u01d1"+
		"h\1\0\0\0\u01d2\u01d3\5v\0\0\u01d3\u01d4\5o\0\0\u01d4\u01d5\5i\0\0\u01d5"+
		"\u01d6\5d\0\0\u01d6j\1\0\0\0\u01d7\u01d8\5p\0\0\u01d8\u01d9\5a\0\0\u01d9"+
		"\u01da\5c\0\0\u01da\u01db\5k\0\0\u01db\u01dc\5a\0\0\u01dc\u01dd\5g\0\0"+
		"\u01dd\u01de\5e\0\0\u01del\1\0\0\0\u01df\u01e0\5.\0\0\u01e0\u01e1\5.\0"+
		"\0\u01e1\u01e2\5.\0\0\u01e2n\1\0\0\0\u01e3\u01e4\5{\0\0\u01e4p\1\0\0\0"+
		"\u01e5\u01e6\5b\0\0\u01e6\u01e7\5r\0\0\u01e7\u01e8\5e\0\0\u01e8\u01e9"+
		"\5a\0\0\u01e9\u01ea\5k\0\0\u01ear\1\0\0\0\u01eb\u01ec\5n\0\0\u01ec\u01ed"+
		"\5a\0\0\u01ed\u01ee\5t\0\0\u01ee\u01ef\5i\0\0\u01ef\u01f0\5v\0\0\u01f0"+
		"\u01f1\5e\0\0\u01f1t\1\0\0\0\u01f2\u01f3\5+\0\0\u01f3\u01f4\5=\0\0\u01f4"+
		"v\1\0\0\0\u01f5\u01f6\5e\0\0\u01f6\u01f7\5x\0\0\u01f7\u01f8\5t\0\0\u01f8"+
		"\u01f9\5e\0\0\u01f9\u01fa\5n\0\0\u01fa\u01fb\5d\0\0\u01fb\u01fc\5s\0\0"+
		"\u01fcx\1\0\0\0\u01fd\u01fe\5^\0\0\u01fe\u01ff\5=\0\0\u01ffz\1\0\0\0\u0200"+
		"\u0201\5f\0\0\u0201\u0202\5i\0\0\u0202\u0203\5n\0\0\u0203\u0204\5a\0\0"+
		"\u0204\u0205\5l\0\0\u0205|\1\0\0\0\u0206\u0207\5e\0\0\u0207\u0208\5l\0"+
		"\0\u0208\u0209\5s\0\0\u0209\u020a\5e\0\0\u020a~\1\0\0\0\u020b\u020c\5"+
		"c\0\0\u020c\u020d\5a\0\0\u020d\u020e\5t\0\0\u020e\u020f\5c\0\0\u020f\u0210"+
		"\5h\0\0\u0210\u0080\1\0\0\0\u0211\u0212\5t\0\0\u0212\u0213\5r\0\0\u0213"+
		"\u0214\5u\0\0\u0214\u0215\5e\0\0\u0215\u0082\1\0\0\0\u0216\u0217\5s\0"+
		"\0\u0217\u0218\5t\0\0\u0218\u0219\5a\0\0\u0219\u021a\5t\0\0\u021a\u021b"+
		"\5i\0\0\u021b\u021c\5c\0\0\u021c\u0084\1\0\0\0\u021d\u021e\5+\0\0\u021e"+
		"\u021f\5+\0\0\u021f\u0086\1\0\0\0\u0220\u0221\5i\0\0\u0221\u0222\5m\0"+
		"\0\u0222\u0223\5p\0\0\u0223\u0224\5o\0\0\u0224\u0225\5r\0\0\u0225\u0226"+
		"\5t\0\0\u0226\u0088\1\0\0\0\u0227\u0228\5b\0\0\u0228\u0229\5y\0\0\u0229"+
		"\u022a\5t\0\0\u022a\u022b\5e\0\0\u022b\u008a\1\0\0\0\u022c\u022d\5^\0"+
		"\0\u022d\u008c\1\0\0\0\u022e\u022f\5.\0\0\u022f\u008e\1\0\0\0\u0230\u0231"+
		"\5+\0\0\u0231\u0090\1\0\0\0\u0232\u0233\5p\0\0\u0233\u0234\5r\0\0\u0234"+
		"\u0235\5o\0\0\u0235\u0236\5t\0\0\u0236\u0237\5e\0\0\u0237\u0238\5c\0\0"+
		"\u0238\u0239\5t\0\0\u0239\u023a\5e\0\0\u023a\u023b\5d\0\0\u023b\u0092"+
		"\1\0\0\0\u023c\u023d\5f\0\0\u023d\u023e\5o\0\0\u023e\u023f\5r\0\0\u023f"+
		"\u0094\1\0\0\0\u0240\u0241\5r\0\0\u0241\u0242\5e\0\0\u0242\u0243\5t\0"+
		"\0\u0243\u0244\5u\0\0\u0244\u0245\5r\0\0\u0245\u0246\5n\0\0\u0246\u0096"+
		"\1\0\0\0\u0247\u0248\5v\0\0\u0248\u0249\5o\0\0\u0249\u024a\5l\0\0\u024a"+
		"\u024b\5a\0\0\u024b\u024c\5t\0\0\u024c\u024d\5i\0\0\u024d\u024e\5l\0\0"+
		"\u024e\u024f\5e\0\0\u024f\u0098\1\0\0\0\u0250\u0251\5;\0\0\u0251\u009a"+
		"\1\0\0\0\u0252\u0253\5&\0\0\u0253\u0254\5&\0\0\u0254\u009c\1\0\0\0\u0255"+
		"\u0256\5t\0\0\u0256\u0257\5h\0\0\u0257\u0258\5i\0\0\u0258\u0259\5s\0\0"+
		"\u0259\u009e\1\0\0\0\u025a\u025b\5|\0\0\u025b\u025c\5|\0\0\u025c\u00a0"+
		"\1\0\0\0\u025d\u025e\5>\0\0\u025e\u00a2\1\0\0\0\u025f\u0260\5i\0\0\u0260"+
		"\u0261\5m\0\0\u0261\u0262\5p\0\0\u0262\u0263\5l\0\0\u0263\u0264\5e\0\0"+
		"\u0264\u0265\5m\0\0\u0265\u0266\5e\0\0\u0266\u0267\5n\0\0\u0267\u0268"+
		"\5t\0\0\u0268\u0269\5s\0\0\u0269\u00a4\1\0\0\0\u026a\u026b\5%\0\0\u026b"+
		"\u026c\5=\0\0\u026c\u00a6\1\0\0\0\u026d\u026e\5s\0\0\u026e\u026f\5w\0"+
		"\0\u026f\u0270\5i\0\0\u0270\u0271\5t\0\0\u0271\u0272\5c\0\0\u0272\u0273"+
		"\5h\0\0\u0273\u00a8\1\0\0\0\u0274\u0275\5/\0\0\u0275\u0276\5=\0\0\u0276"+
		"\u00aa\1\0\0\0\u0277\u0278\5/\0\0\u0278\u00ac\1\0\0\0\u0279\u027a\5=\0"+
		"\0\u027a\u027b\5=\0\0\u027b\u00ae\1\0\0\0\u027c\u027d\5~\0\0\u027d\u00b0"+
		"\1\0\0\0\u027e\u027f\5i\0\0\u027f\u0280\5n\0\0\u0280\u0281\5s\0\0\u0281"+
		"\u0282\5t\0\0\u0282\u0283\5a\0\0\u0283\u0284\5n\0\0\u0284\u0285\5c\0\0"+
		"\u0285\u0286\5e\0\0\u0286\u0287\5o\0\0\u0287\u0288\5f\0\0\u0288\u00b2"+
		"\1\0\0\0\u0289\u028a\5\60\0\0\u028a\u028c\7\0\0\0\u028b\u028d\3\u00b9"+
		"\\\0\u028c\u028b\1\0\0\0\u028d\u028e\1\0\0\0\u028e\u028c\1\0\0\0\u028e"+
		"\u028f\1\0\0\0\u028f\u0291\1\0\0\0\u0290\u0292\3\u00bb]\0\u0291\u0290"+
		"\1\0\0\0\u0291\u0292\1\0\0\0\u0292\u00b4\1\0\0\0\u0293\u029c\5\60\0\0"+
		"\u0294\u0298\2\619\0\u0295\u0297\2\609\0\u0296\u0295\1\0\0\0\u0297\u029a"+
		"\1\0\0\0\u0298\u0296\1\0\0\0\u0298\u0299\1\0\0\0\u0299\u029c\1\0\0\0\u029a"+
		"\u0298\1\0\0\0\u029b\u0293\1\0\0\0\u029b\u0294\1\0\0\0\u029c\u029e\1\0"+
		"\0\0\u029d\u029f\3\u00bb]\0\u029e\u029d\1\0\0\0\u029e\u029f\1\0\0\0\u029f"+
		"\u00b6\1\0\0\0\u02a0\u02a2\5\60\0\0\u02a1\u02a3\2\60\67\0\u02a2\u02a1"+
		"\1\0\0\0\u02a3\u02a4\1\0\0\0\u02a4\u02a2\1\0\0\0\u02a4\u02a5\1\0\0\0\u02a5"+
		"\u02a7\1\0\0\0\u02a6\u02a8\3\u00bb]\0\u02a7\u02a6\1\0\0\0\u02a7\u02a8"+
		"\1\0\0\0\u02a8\u00b8\1\0\0\0\u02a9\u02aa\7\1\0\0\u02aa\u00ba\1\0\0\0\u02ab"+
		"\u02ac\7\2\0\0\u02ac\u00bc\1\0\0\0\u02ad\u02af\2\609\0\u02ae\u02ad\1\0"+
		"\0\0\u02af\u02b0\1\0\0\0\u02b0\u02ae\1\0\0\0\u02b0\u02b1\1\0\0\0\u02b1"+
		"\u02b2\1\0\0\0\u02b2\u02b6\5.\0\0\u02b3\u02b5\2\609\0\u02b4\u02b3\1\0"+
		"\0\0\u02b5\u02b8\1\0\0\0\u02b6\u02b4\1\0\0\0\u02b6\u02b7\1\0\0\0\u02b7"+
		"\u02ba\1\0\0\0\u02b8\u02b6\1\0\0\0\u02b9\u02bb\3\u00bf_\0\u02ba\u02b9"+
		"\1\0\0\0\u02ba\u02bb\1\0\0\0\u02bb\u02bd\1\0\0\0\u02bc\u02be\3\u00c1`"+
		"\0\u02bd\u02bc\1\0\0\0\u02bd\u02be\1\0\0\0\u02be\u02fc\1\0\0\0\u02bf\u02c1"+
		"\5.\0\0\u02c0\u02c2\2\609\0\u02c1\u02c0\1\0\0\0\u02c2\u02c3\1\0\0\0\u02c3"+
		"\u02c1\1\0\0\0\u02c3\u02c4\1\0\0\0\u02c4\u02c6\1\0\0\0\u02c5\u02c7\3\u00bf"+
		"_\0\u02c6\u02c5\1\0\0\0\u02c6\u02c7\1\0\0\0\u02c7\u02c9\1\0\0\0\u02c8"+
		"\u02ca\3\u00c1`\0\u02c9\u02c8\1\0\0\0\u02c9\u02ca\1\0\0\0\u02ca\u02fc"+
		"\1\0\0\0\u02cb\u02cd\2\609\0\u02cc\u02cb\1\0\0\0\u02cd\u02ce\1\0\0\0\u02ce"+
		"\u02cc\1\0\0\0\u02ce\u02cf\1\0\0\0\u02cf\u02d0\1\0\0\0\u02d0\u02d2\3\u00bf"+
		"_\0\u02d1\u02d3\3\u00c1`\0\u02d2\u02d1\1\0\0\0\u02d2\u02d3\1\0\0\0\u02d3"+
		"\u02fc\1\0\0\0\u02d4\u02d6\2\609\0\u02d5\u02d4\1\0\0\0\u02d6\u02d7\1\0"+
		"\0\0\u02d7\u02d5\1\0\0\0\u02d7\u02d8\1\0\0\0\u02d8\u02d9\1\0\0\0\u02d9"+
		"\u02fc\3\u00c1`\0\u02da\u02db\5\60\0\0\u02db\u02df\5x\0\0\u02dc\u02dd"+
		"\5\60\0\0\u02dd\u02df\5X\0\0\u02de\u02da\1\0\0\0\u02de\u02dc\1\0\0\0\u02df"+
		"\u02e3\1\0\0\0\u02e0\u02e2\3\u00b9\\\0\u02e1\u02e0\1\0\0\0\u02e2\u02e5"+
		"\1\0\0\0\u02e3\u02e1\1\0\0\0\u02e3\u02e4\1\0\0\0\u02e4\u02ed\1\0\0\0\u02e5"+
		"\u02e3\1\0\0\0\u02e6\u02ea\5.\0\0\u02e7\u02e9\3\u00b9\\\0\u02e8\u02e7"+
		"\1\0\0\0\u02e9\u02ec\1\0\0\0\u02ea\u02e8\1\0\0\0\u02ea\u02eb\1\0\0\0\u02eb"+
		"\u02ee\1\0\0\0\u02ec\u02ea\1\0\0\0\u02ed\u02e6\1\0\0\0\u02ed\u02ee\1\0"+
		"\0\0\u02ee\u02ef\1\0\0\0\u02ef\u02f1\7\3\0\0\u02f0\u02f2\7\4\0\0\u02f1"+
		"\u02f0\1\0\0\0\u02f1\u02f2\1\0\0\0\u02f2\u02f4\1\0\0\0\u02f3\u02f5\2\60"+
		"9\0\u02f4\u02f3\1\0\0\0\u02f5\u02f6\1\0\0\0\u02f6\u02f4\1\0\0\0\u02f6"+
		"\u02f7\1\0\0\0\u02f7\u02f9\1\0\0\0\u02f8\u02fa\3\u00c1`\0\u02f9\u02f8"+
		"\1\0\0\0\u02f9\u02fa\1\0\0\0\u02fa\u02fc\1\0\0\0\u02fb\u02ae\1\0\0\0\u02fb"+
		"\u02bf\1\0\0\0\u02fb\u02cc\1\0\0\0\u02fb\u02d5\1\0\0\0\u02fb\u02de\1\0"+
		"\0\0\u02fc\u00be\1\0\0\0\u02fd\u02ff\7\5\0\0\u02fe\u0300\7\6\0\0\u02ff"+
		"\u02fe\1\0\0\0\u02ff\u0300\1\0\0\0\u0300\u0302\1\0\0\0\u0301\u0303\2\60"+
		"9\0\u0302\u0301\1\0\0\0\u0303\u0304\1\0\0\0\u0304\u0302\1\0\0\0\u0304"+
		"\u0305\1\0\0\0\u0305\u00c0\1\0\0\0\u0306\u0307\7\7\0\0\u0307\u00c2\1\0"+
		"\0\0\u0308\u030b\5\'\0\0\u0309\u030c\3\u00c7c\0\u030a\u030c\b\b\0\0\u030b"+
		"\u0309\1\0\0\0\u030b\u030a\1\0\0\0\u030c\u030d\1\0\0\0\u030d\u030e\5\'"+
		"\0\0\u030e\u00c4\1\0\0\0\u030f\u0314\5\"\0\0\u0310\u0313\3\u00c7c\0\u0311"+
		"\u0313\b\t\0\0\u0312\u0310\1\0\0\0\u0312\u0311\1\0\0\0\u0313\u0316\1\0"+
		"\0\0\u0314\u0312\1\0\0\0\u0314\u0315\1\0\0\0\u0315\u0317\1\0\0\0\u0316"+
		"\u0314\1\0\0\0\u0317\u0318\5\"\0\0\u0318\u00c6\1\0\0\0\u0319\u031a\5\\"+
		"\0\0\u031a\u031e\7\n\0\0\u031b\u031e\3\u00cbe\0\u031c\u031e\3\u00c9d\0"+
		"\u031d\u0319\1\0\0\0\u031d\u031b\1\0\0\0\u031d\u031c\1\0\0\0\u031e\u00c8"+
		"\1\0\0\0\u031f\u0320\5\\\0\0\u0320\u0321\2\60\63\0\u0321\u0322\2\60\67"+
		"\0\u0322\u0329\2\60\67\0\u0323\u0324\5\\\0\0\u0324\u0325\2\60\67\0\u0325"+
		"\u0329\2\60\67\0\u0326\u0327\5\\\0\0\u0327\u0329\2\60\67\0\u0328\u031f"+
		"\1\0\0\0\u0328\u0323\1\0\0\0\u0328\u0326\1\0\0\0\u0329\u00ca\1\0\0\0\u032a"+
		"\u032b\5\\\0\0\u032b\u032c\5u\0\0\u032c\u032d\3\u00b9\\\0\u032d\u032e"+
		"\3\u00b9\\\0\u032e\u032f\3\u00b9\\\0\u032f\u0330\3\u00b9\\\0\u0330\u00cc"+
		"\1\0\0\0\u0331\u0332\5e\0\0\u0332\u0333\5n\0\0\u0333\u0334\5u\0\0\u0334"+
		"\u0335\5m\0\0\u0335\u0336\1\0\0\0\u0336\u0337\6f\0\0\u0337\u00ce\1\0\0"+
		"\0\u0338\u0339\5a\0\0\u0339\u033a\5s\0\0\u033a\u033b\5s\0\0\u033b\u033c"+
		"\5e\0\0\u033c\u033d\5r\0\0\u033d\u033e\5t\0\0\u033e\u033f\1\0\0\0\u033f"+
		"\u0340\6g\1\0\u0340\u00d0\1\0\0\0\u0341\u0346\3\u00d3i\0\u0342\u0345\3"+
		"\u00d3i\0\u0343\u0345\3\u00d5j\0\u0344\u0342\1\0\0\0\u0344\u0343\1\0\0"+
		"\0\u0345\u0348\1\0\0\0\u0346\u0344\1\0\0\0\u0346\u0347\1\0\0\0\u0347\u00d2"+
		"\1\0\0\0\u0348\u0346\1\0\0\0\u0349\u034a\7\13\0\0\u034a\u00d4\1\0\0\0"+
		"\u034b\u034c\7\f\0\0\u034c\u00d6\1\0\0\0\u034d\u034e\5/\0\0\u034e\u034f"+
		"\5*\0\0\u034f\u0353\1\0\0\0\u0350\u0352\t\0\0\0\u0351\u0350\1\0\0\0\u0352"+
		"\u0355\1\0\0\0\u0353\u0354\1\0\0\0\u0353\u0351\1\0\0\0\u0354\u0356\1\0"+
		"\0\0\u0355\u0353\1\0\0\0\u0356\u0357\5*\0\0\u0357\u0358\5/\0\0\u0358\u0359"+
		"\1\0\0\0\u0359\u035a\6k\2\0\u035a\u00d8\1\0\0\0\u035b\u035d\7\r\0\0\u035c"+
		"\u035b\1\0\0\0\u035d\u035e\1\0\0\0\u035e\u035c\1\0\0\0\u035e\u035f\1\0"+
		"\0\0\u035f\u0360\1\0\0\0\u0360\u0361\6l\3\0\u0361\u00da\1\0\0\0\u0362"+
		"\u0363\5/\0\0\u0363\u0364\5/\0\0\u0364\u0368\1\0\0\0\u0365\u0367\b\16"+
		"\0\0\u0366\u0365\1\0\0\0\u0367\u036a\1\0\0\0\u0368\u0366\1\0\0\0\u0368"+
		"\u0369\1\0\0\0\u0369\u036c\1\0\0\0\u036a\u0368\1\0\0\0\u036b\u036d\5\r"+
		"\0\0\u036c\u036b\1\0\0\0\u036c\u036d\1\0\0\0\u036d\u036e\1\0\0\0\u036e"+
		"\u036f\5\n\0\0\u036f\u0370\1\0\0\0\u0370\u0371\6m\4\0\u0371\u00dc\1\0"+
		"\0\0\'\0\1\u028e\1\u0291\1\u0298\1\u029b\1\u029e\1\u02a4\1\u02a7\1\u02b0"+
		"\1\u02b6\1\u02ba\1\u02bd\1\u02c3\1\u02c6\1\u02c9\1\u02ce\1\u02d2\1\u02d7"+
		"\1\u02de\1\u02e3\1\u02ea\1\u02ed\1\u02f1\1\u02f6\1\u02f9\1\u02fb\1\u02ff"+
		"\1\u0304\1\u030b\1\u0312\1\u0314\1\u031d\1\u0328\1\u0344\1\u0346\1\u0353"+
		"\0\u035e\1\u0368\1\u036c\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}