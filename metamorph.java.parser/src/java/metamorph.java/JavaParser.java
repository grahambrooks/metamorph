// $ANTLR ANTLRVersion> JavaParser.java generatedTimestamp>

    package metamorph.java;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaParser extends Parser {
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
	public static final String[] tokenNames = {
        "<INVALID>", "'interface'", "'&'", "'*'", "'['", "'<'", "'--'", 
        "'false'", "'continue'", "'!='", "'double'", "'abstract'", "'boolean'", 
        "'}'", "'float'", "'char'", "'strictfp'", "'case'", "'super'", "'do'", 
        "'%'", "'*='", "')'", "'throw'", "'@'", "'='", "'null'", "'throws'", 
        "'|='", "'new'", "'class'", "'finally'", "'|'", "'transient'", "'!'", 
        "'long'", "'short'", "']'", "'-='", "'public'", "'default'", "'synchronized'", 
        "','", "'while'", "'-'", "'('", "':'", "'if'", "'&='", "'int'", 
        "'private'", "'?'", "'try'", "'void'", "'package'", "'...'", "'{'", 
        "'break'", "'native'", "'+='", "'extends'", "'^='", "'final'", "'else'", 
        "'catch'", "'true'", "'static'", "'++'", "'import'", "'byte'", "'^'", 
        "'.'", "'+'", "'protected'", "'for'", "'return'", "'volatile'", 
        "';'", "'&&'", "'this'", "'||'", "'>'", "'implements'", "'%='", 
        "'switch'", "'/='", "'/'", "'=='", "'~'", "'instanceof'", "HexLiteral", 
        "DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", "CharacterLiteral", 
        "StringLiteral", "'enum'", "'assert'", "Identifier", "COMMENT", 
        "WS", "LINE_COMMENT"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_typeDeclaration = 3, RULE_classDeclaration = 4, RULE_enumDeclaration = 5, 
		RULE_interfaceDeclaration = 6, RULE_classOrInterfaceModifier = 7, RULE_modifiers = 8, 
		RULE_typeParameters = 9, RULE_typeParameter = 10, RULE_typeBound = 11, 
		RULE_enumBody = 12, RULE_enumConstants = 13, RULE_enumConstant = 14, RULE_enumBodyDeclarations = 15, 
		RULE_normalInterfaceDeclaration = 16, RULE_typeList = 17, RULE_classBody = 18, 
		RULE_interfaceBody = 19, RULE_classBodyDeclaration = 20, RULE_member = 21, 
		RULE_methodDeclaration = 22, RULE_methodDeclarationRest = 23, RULE_genericMethodDeclaration = 24, 
		RULE_fieldDeclaration = 25, RULE_constructorDeclaration = 26, RULE_interfaceBodyDeclaration = 27, 
		RULE_interfaceMemberDecl = 28, RULE_interfaceMethodOrFieldDecl = 29, RULE_interfaceMethodOrFieldRest = 30, 
		RULE_voidMethodDeclaratorRest = 31, RULE_interfaceMethodDeclaratorRest = 32, 
		RULE_interfaceGenericMethodDecl = 33, RULE_voidInterfaceMethodDeclaratorRest = 34, 
		RULE_constantDeclarator = 35, RULE_variableDeclarators = 36, RULE_variableDeclarator = 37, 
		RULE_constantDeclaratorsRest = 38, RULE_constantDeclaratorRest = 39, RULE_variableDeclaratorId = 40, 
		RULE_variableInitializer = 41, RULE_arrayInitializer = 42, RULE_modifier = 43, 
		RULE_packageOrTypeName = 44, RULE_enumConstantName = 45, RULE_typeName = 46, 
		RULE_type = 47, RULE_classOrInterfaceType = 48, RULE_primitiveType = 49, 
		RULE_variableModifier = 50, RULE_typeArguments = 51, RULE_typeArgument = 52, 
		RULE_qualifiedNameList = 53, RULE_formalParameters = 54, RULE_formalParameterDecls = 55, 
		RULE_formalParameterDeclsRest = 56, RULE_methodBody = 57, RULE_constructorBody = 58, 
		RULE_explicitConstructorInvocation = 59, RULE_qualifiedName = 60, RULE_literal = 61, 
		RULE_integerLiteral = 62, RULE_booleanLiteral = 63, RULE_annotations = 64, 
		RULE_annotation = 65, RULE_annotationName = 66, RULE_elementValuePairs = 67, 
		RULE_elementValuePair = 68, RULE_elementValue = 69, RULE_elementValueArrayInitializer = 70, 
		RULE_annotationTypeDeclaration = 71, RULE_annotationTypeBody = 72, RULE_annotationTypeElementDeclaration = 73, 
		RULE_annotationTypeElementRest = 74, RULE_annotationMethodOrConstantRest = 75, 
		RULE_annotationMethodRest = 76, RULE_annotationConstantRest = 77, RULE_defaultValue = 78, 
		RULE_block = 79, RULE_blockStatement = 80, RULE_localVariableDeclarationStatement = 81, 
		RULE_localVariableDeclaration = 82, RULE_variableModifiers = 83, RULE_statement = 84, 
		RULE_catches = 85, RULE_catchClause = 86, RULE_formalParameter = 87, RULE_switchBlock = 88, 
		RULE_switchBlockStatementGroup = 89, RULE_switchLabel = 90, RULE_forControl = 91, 
		RULE_forInit = 92, RULE_enhancedForControl = 93, RULE_forUpdate = 94, 
		RULE_parExpression = 95, RULE_expressionList = 96, RULE_statementExpression = 97, 
		RULE_constantExpression = 98, RULE_expression = 99, RULE_primary = 100, 
		RULE_creator = 101, RULE_createdName = 102, RULE_innerCreator = 103, RULE_explicitGenericInvocation = 104, 
		RULE_arrayCreatorRest = 105, RULE_classCreatorRest = 106, RULE_nonWildcardTypeArguments = 107, 
		RULE_arguments = 108;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "typeDeclaration", 
		"classDeclaration", "enumDeclaration", "interfaceDeclaration", "classOrInterfaceModifier", 
		"modifiers", "typeParameters", "typeParameter", "typeBound", "enumBody", 
		"enumConstants", "enumConstant", "enumBodyDeclarations", "normalInterfaceDeclaration", 
		"typeList", "classBody", "interfaceBody", "classBodyDeclaration", "member", 
		"methodDeclaration", "methodDeclarationRest", "genericMethodDeclaration", 
		"fieldDeclaration", "constructorDeclaration", "interfaceBodyDeclaration", 
		"interfaceMemberDecl", "interfaceMethodOrFieldDecl", "interfaceMethodOrFieldRest", 
		"voidMethodDeclaratorRest", "interfaceMethodDeclaratorRest", "interfaceGenericMethodDecl", 
		"voidInterfaceMethodDeclaratorRest", "constantDeclarator", "variableDeclarators", 
		"variableDeclarator", "constantDeclaratorsRest", "constantDeclaratorRest", 
		"variableDeclaratorId", "variableInitializer", "arrayInitializer", "modifier", 
		"packageOrTypeName", "enumConstantName", "typeName", "type", "classOrInterfaceType", 
		"primitiveType", "variableModifier", "typeArguments", "typeArgument", 
		"qualifiedNameList", "formalParameters", "formalParameterDecls", "formalParameterDeclsRest", 
		"methodBody", "constructorBody", "explicitConstructorInvocation", "qualifiedName", 
		"literal", "integerLiteral", "booleanLiteral", "annotations", "annotation", 
		"annotationName", "elementValuePairs", "elementValuePair", "elementValue", 
		"elementValueArrayInitializer", "annotationTypeDeclaration", "annotationTypeBody", 
		"annotationTypeElementDeclaration", "annotationTypeElementRest", "annotationMethodOrConstantRest", 
		"annotationMethodRest", "annotationConstantRest", "defaultValue", "block", 
		"blockStatement", "localVariableDeclarationStatement", "localVariableDeclaration", 
		"variableModifiers", "statement", "catches", "catchClause", "formalParameter", 
		"switchBlock", "switchBlockStatementGroup", "switchLabel", "forControl", 
		"forInit", "enhancedForControl", "forUpdate", "parExpression", "expressionList", 
		"statementExpression", "constantExpression", "expression", "primary", 
		"creator", "createdName", "innerCreator", "explicitGenericInvocation", 
		"arrayCreatorRest", "classCreatorRest", "nonWildcardTypeArguments", "arguments"
	};

	@Override
	public String getGrammarFileName() { return "Java.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator<Token>(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext<Token> {
		public PackageDeclarationContext packageDeclaration() {
		    return getRuleContext(PackageDeclarationContext.class,0);
		}
		public ImportDeclarationContext importDeclaration(int i) {
		    return getRuleContext(ImportDeclarationContext.class,i);
		}
		public TerminalNode<Token> EOF() { return getToken(JavaParser.EOF, 0); }
		public List<? extends TypeDeclarationContext> typeDeclaration() {
		    return getRuleContexts(TypeDeclarationContext.class);
		}
		public List<? extends ImportDeclarationContext> importDeclaration() {
		    return getRuleContexts(ImportDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
		    return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitCompilationUnit(this);
			else return null;
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, 0);
		enterRule(_localctx, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==54 ) {
				{
				setState(218); packageDeclaration();
				}
			}

			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==68 ) {
				{
				{
				setState(221); importDeclaration();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==11 || _la==16 || _la==24 || _la==30 || _la==39 || _la==50 || _la==62 || _la==66 || _la==73 || _la==77 || _la==ENUM ) {
				{
				{
				setState(227); typeDeclaration();
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext<Token> {
		public QualifiedNameContext qualifiedName() {
		    return getRuleContext(QualifiedNameContext.class,0);
		}
		public PackageDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitPackageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitPackageDeclaration(this);
			else return null;
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, 2);
		enterRule(_localctx, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); match(54);
			setState(236); qualifiedName();
			setState(237); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext<Token> {
		public QualifiedNameContext qualifiedName() {
		    return getRuleContext(QualifiedNameContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitImportDeclaration(this);
			else return null;
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, 4);
		enterRule(_localctx, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(68);
			setState(241);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==66 ) {
				{
				setState(240); match(66);
				}
			}

			setState(243); qualifiedName();
			setState(246);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==71 ) {
				{
				setState(244); match(71);
				setState(245); match(3);
				}
			}

			setState(248); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext<Token> {
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
		    return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
		    return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
		    return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
		    return getRuleContext(EnumDeclarationContext.class,0);
		}
		public List<? extends ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
		    return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public TypeDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeDeclaration(this);
			else return null;
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, 6);
		enterRule(_localctx, RULE_typeDeclaration);
		try {
			int _alt;
			setState(262);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 1:
				case 11:
				case 16:
				case 24:
				case 30:
				case 39:
				case 50:
				case 62:
				case 66:
				case 73:
				case ENUM:
					enterOuterAlt(_localctx, 1);
					{
					setState(253);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(250); classOrInterfaceModifier();
							}
							} 
						}
						setState(255);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
					}
					setState(259);
					//_errHandler.sync(this);
					switch ( _input.LA(1) ) {
						case 30:
							{
							setState(256); classDeclaration();
							}
							break;
						case 1:
						case 24:
							{
							setState(257); interfaceDeclaration();
							}
							break;
						case ENUM:
							{
							setState(258); enumDeclaration();
							}
							break;
						default :
							throw new NoViableAltException(this);
					}
					}
					break;
				case 77:
					enterOuterAlt(_localctx, 2);
					{
					setState(261); match(77);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext<Token> {
		public TypeParametersContext typeParameters() {
		    return getRuleContext(TypeParametersContext.class,0);
		}
		public ClassBodyContext classBody() {
		    return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeListContext typeList() {
		    return getRuleContext(TypeListContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ClassDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitClassDeclaration(this);
			else return null;
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, 8);
		enterRule(_localctx, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(30);
			setState(265); match(Identifier);
			setState(267);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==5 ) {
				{
				setState(266); typeParameters();
				}
			}

			setState(271);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==60 ) {
				{
				setState(269); match(60);
				setState(270); type();
				}
			}

			setState(275);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==82 ) {
				{
				setState(273); match(82);
				setState(274); typeList();
				}
			}

			setState(277); classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclarationContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> ENUM() { return getToken(JavaParser.ENUM, 0); }
		public EnumBodyContext enumBody() {
		    return getRuleContext(EnumBodyContext.class,0);
		}
		public TypeListContext typeList() {
		    return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public EnumDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitEnumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitEnumDeclaration(this);
			else return null;
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, 10);
		enterRule(_localctx, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); match(ENUM);
			setState(280); match(Identifier);
			setState(283);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==82 ) {
				{
				setState(281); match(82);
				setState(282); typeList();
				}
			}

			setState(285); enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationContext extends ParserRuleContext<Token> {
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
		    return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
		    return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceDeclaration(this);
			else return null;
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, 12);
		enterRule(_localctx, RULE_interfaceDeclaration);
		try {
			setState(289);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(287); normalInterfaceDeclaration();
					}
					break;
				case 24:
					enterOuterAlt(_localctx, 2);
					{
					setState(288); annotationTypeDeclaration();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceModifierContext extends ParserRuleContext<Token> {
		public AnnotationContext annotation() {
		    return getRuleContext(AnnotationContext.class,0);
		}
		public ClassOrInterfaceModifierContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassOrInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassOrInterfaceModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitClassOrInterfaceModifier(this);
			else return null;
		}
	}

	public final ClassOrInterfaceModifierContext classOrInterfaceModifier() throws RecognitionException {
		ClassOrInterfaceModifierContext _localctx = new ClassOrInterfaceModifierContext(_ctx, 14);
		enterRule(_localctx, RULE_classOrInterfaceModifier);
		try {
			setState(299);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 24:
					enterOuterAlt(_localctx, 1);
					{
					setState(291); annotation();
					}
					break;
				case 39:
					enterOuterAlt(_localctx, 2);
					{
					setState(292); match(39);
					}
					break;
				case 73:
					enterOuterAlt(_localctx, 3);
					{
					setState(293); match(73);
					}
					break;
				case 50:
					enterOuterAlt(_localctx, 4);
					{
					setState(294); match(50);
					}
					break;
				case 11:
					enterOuterAlt(_localctx, 5);
					{
					setState(295); match(11);
					}
					break;
				case 66:
					enterOuterAlt(_localctx, 6);
					{
					setState(296); match(66);
					}
					break;
				case 62:
					enterOuterAlt(_localctx, 7);
					{
					setState(297); match(62);
					}
					break;
				case 16:
					enterOuterAlt(_localctx, 8);
					{
					setState(298); match(16);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifiersContext extends ParserRuleContext<Token> {
		public List<? extends ModifierContext> modifier() {
		    return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
		    return getRuleContext(ModifierContext.class,i);
		}
		public ModifiersContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitModifiers(this);
			else return null;
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, 16);
		enterRule(_localctx, RULE_modifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(301); modifier();
					}
					} 
				}
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext<Token> {
		public List<? extends TypeParameterContext> typeParameter() {
		    return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
		    return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeParametersContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeParameters(this);
			else return null;
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, 18);
		enterRule(_localctx, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(5);
			setState(308); typeParameter();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(309); match(42);
				setState(310); typeParameter();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316); match(81);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext<Token> {
		public TypeBoundContext typeBound() {
		    return getRuleContext(TypeBoundContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeParameterContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeParameter(this);
			else return null;
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, 20);
		enterRule(_localctx, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); match(Identifier);
			setState(321);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==60 ) {
				{
				setState(319); match(60);
				setState(320); typeBound();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBoundContext extends ParserRuleContext<Token> {
		public TypeContext type(int i) {
		    return getRuleContext(TypeContext.class,i);
		}
		public List<? extends TypeContext> type() {
		    return getRuleContexts(TypeContext.class);
		}
		public TypeBoundContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeBound(this);
			else return null;
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, 22);
		enterRule(_localctx, RULE_typeBound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); type();
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==2 ) {
				{
				{
				setState(324); match(2);
				setState(325); type();
				}
				}
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyContext extends ParserRuleContext<Token> {
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
		    return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumConstantsContext enumConstants() {
		    return getRuleContext(EnumConstantsContext.class,0);
		}
		public EnumBodyContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitEnumBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitEnumBody(this);
			else return null;
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, 24);
		enterRule(_localctx, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331); match(56);
			setState(333);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==24 || _la==Identifier ) {
				{
				setState(332); enumConstants();
				}
			}

			setState(336);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==42 ) {
				{
				setState(335); match(42);
				}
			}

			setState(339);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==77 ) {
				{
				setState(338); enumBodyDeclarations();
				}
			}

			setState(341); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantsContext extends ParserRuleContext<Token> {
		public List<? extends EnumConstantContext> enumConstant() {
		    return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
		    return getRuleContext(EnumConstantContext.class,i);
		}
		public EnumConstantsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_enumConstants; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterEnumConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitEnumConstants(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitEnumConstants(this);
			else return null;
		}
	}

	public final EnumConstantsContext enumConstants() throws RecognitionException {
		EnumConstantsContext _localctx = new EnumConstantsContext(_ctx, 26);
		enterRule(_localctx, RULE_enumConstants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(343); enumConstant();
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(344); match(42);
					setState(345); enumConstant();
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantContext extends ParserRuleContext<Token> {
		public ArgumentsContext arguments() {
		    return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
		    return getRuleContext(ClassBodyContext.class,0);
		}
		public AnnotationsContext annotations() {
		    return getRuleContext(AnnotationsContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public EnumConstantContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitEnumConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitEnumConstant(this);
			else return null;
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, 28);
		enterRule(_localctx, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==24 ) {
				{
				setState(351); annotations();
				}
			}

			setState(354); match(Identifier);
			setState(356);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==45 ) {
				{
				setState(355); arguments();
				}
			}

			setState(359);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==56 ) {
				{
				setState(358); classBody();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyDeclarationsContext extends ParserRuleContext<Token> {
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
		    return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public List<? extends ClassBodyDeclarationContext> classBodyDeclaration() {
		    return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitEnumBodyDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitEnumBodyDeclarations(this);
			else return null;
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, 30);
		enterRule(_localctx, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361); match(77);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==5 || _la==10 || _la==11 || _la==12 || _la==14 || _la==15 || _la==16 || _la==24 || _la==30 || _la==33 || _la==35 || _la==36 || _la==39 || _la==41 || _la==49 || _la==50 || _la==53 || _la==56 || _la==58 || _la==62 || _la==66 || _la==69 || _la==73 || _la==76 || _la==77 || _la==Identifier ) {
				{
				{
				setState(362); classBodyDeclaration();
				}
				}
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalInterfaceDeclarationContext extends ParserRuleContext<Token> {
		public TypeParametersContext typeParameters() {
		    return getRuleContext(TypeParametersContext.class,0);
		}
		public InterfaceBodyContext interfaceBody() {
		    return getRuleContext(InterfaceBodyContext.class,0);
		}
		public TypeListContext typeList() {
		    return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public NormalInterfaceDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_normalInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterNormalInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitNormalInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitNormalInterfaceDeclaration(this);
			else return null;
		}
	}

	public final NormalInterfaceDeclarationContext normalInterfaceDeclaration() throws RecognitionException {
		NormalInterfaceDeclarationContext _localctx = new NormalInterfaceDeclarationContext(_ctx, 32);
		enterRule(_localctx, RULE_normalInterfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); match(1);
			setState(369); match(Identifier);
			setState(371);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==5 ) {
				{
				setState(370); typeParameters();
				}
			}

			setState(375);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==60 ) {
				{
				setState(373); match(60);
				setState(374); typeList();
				}
			}

			setState(377); interfaceBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeListContext extends ParserRuleContext<Token> {
		public TypeContext type(int i) {
		    return getRuleContext(TypeContext.class,i);
		}
		public List<? extends TypeContext> type() {
		    return getRuleContexts(TypeContext.class);
		}
		public TypeListContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeList(this);
			else return null;
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, 34);
		enterRule(_localctx, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); type();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(380); match(42);
				setState(381); type();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext<Token> {
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
		    return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public List<? extends ClassBodyDeclarationContext> classBodyDeclaration() {
		    return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitClassBody(this);
			else return null;
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, 36);
		enterRule(_localctx, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387); match(56);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==5 || _la==10 || _la==11 || _la==12 || _la==14 || _la==15 || _la==16 || _la==24 || _la==30 || _la==33 || _la==35 || _la==36 || _la==39 || _la==41 || _la==49 || _la==50 || _la==53 || _la==56 || _la==58 || _la==62 || _la==66 || _la==69 || _la==73 || _la==76 || _la==77 || _la==Identifier ) {
				{
				{
				setState(388); classBodyDeclaration();
				}
				}
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(394); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyContext extends ParserRuleContext<Token> {
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
		    return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public List<? extends InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
		    return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceBody(this);
			else return null;
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, 38);
		enterRule(_localctx, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396); match(56);
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==5 || _la==10 || _la==11 || _la==12 || _la==14 || _la==15 || _la==16 || _la==24 || _la==30 || _la==33 || _la==35 || _la==36 || _la==39 || _la==41 || _la==49 || _la==50 || _la==53 || _la==58 || _la==62 || _la==66 || _la==69 || _la==73 || _la==76 || _la==77 || _la==Identifier ) {
				{
				{
				setState(397); interfaceBodyDeclaration();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(403); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext<Token> {
		public MemberContext member() {
		    return getRuleContext(MemberContext.class,0);
		}
		public BlockContext block() {
		    return getRuleContext(BlockContext.class,0);
		}
		public ModifiersContext modifiers() {
		    return getRuleContext(ModifiersContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitClassBodyDeclaration(this);
			else return null;
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, 40);
		enterRule(_localctx, RULE_classBodyDeclaration);
		int _la;
		try {
			setState(413);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(405); match(77);
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(407);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==66 ) {
						{
						setState(406); match(66);
						}
					}

					setState(409); block();
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 3);
					{
					setState(410); modifiers();
					setState(411); member();
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberContext extends ParserRuleContext<Token> {
		public InterfaceDeclarationContext interfaceDeclaration() {
		    return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
		    return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext genericMethodDeclaration() {
		    return getRuleContext(GenericMethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
		    return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
		    return getRuleContext(ClassDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
		    return getRuleContext(MethodDeclarationContext.class,0);
		}
		public MemberContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitMember(this);
			else return null;
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, 42);
		enterRule(_localctx, RULE_member);
		try {
			setState(421);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(415); genericMethodDeclaration();
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(416); methodDeclaration();
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 3);
					{
					setState(417); fieldDeclaration();
					}
					break;
				case 4:
					enterOuterAlt(_localctx, 4);
					{
					setState(418); constructorDeclaration();
					}
					break;
				case 5:
					enterOuterAlt(_localctx, 5);
					{
					setState(419); interfaceDeclaration();
					}
					break;
				case 6:
					enterOuterAlt(_localctx, 6);
					{
					setState(420); classDeclaration();
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext<Token> {
		public MethodDeclarationRestContext methodDeclarationRest() {
		    return getRuleContext(MethodDeclarationRestContext.class,0);
		}
		public FormalParametersContext formalParameters() {
		    return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitMethodDeclaration(this);
			else return null;
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, 44);
		enterRule(_localctx, RULE_methodDeclaration);
		int _la;
		try {
			setState(440);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(423); type();
					setState(424); match(Identifier);
					setState(425); formalParameters();
					setState(430);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ( _la==4 ) {
						{
						{
						setState(426); match(4);
						setState(427); match(37);
						}
						}
						setState(432);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(433); methodDeclarationRest();
					}
					break;
				case 53:
					enterOuterAlt(_localctx, 2);
					{
					setState(435); match(53);
					setState(436); match(Identifier);
					setState(437); formalParameters();
					setState(438); methodDeclarationRest();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationRestContext extends ParserRuleContext<Token> {
		public MethodBodyContext methodBody() {
		    return getRuleContext(MethodBodyContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
		    return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodDeclarationRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarationRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodDeclarationRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodDeclarationRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitMethodDeclarationRest(this);
			else return null;
		}
	}

	public final MethodDeclarationRestContext methodDeclarationRest() throws RecognitionException {
		MethodDeclarationRestContext _localctx = new MethodDeclarationRestContext(_ctx, 46);
		enterRule(_localctx, RULE_methodDeclarationRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==27 ) {
				{
				setState(442); match(27);
				setState(443); qualifiedNameList();
				}
			}

			setState(448);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 56:
					{
					setState(446); methodBody();
					}
					break;
				case 77:
					{
					setState(447); match(77);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericMethodDeclarationContext extends ParserRuleContext<Token> {
		public TypeParametersContext typeParameters() {
		    return getRuleContext(TypeParametersContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
		    return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_genericMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterGenericMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitGenericMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitGenericMethodDeclaration(this);
			else return null;
		}
	}

	public final GenericMethodDeclarationContext genericMethodDeclaration() throws RecognitionException {
		GenericMethodDeclarationContext _localctx = new GenericMethodDeclarationContext(_ctx, 48);
		enterRule(_localctx, RULE_genericMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450); typeParameters();
			setState(451); methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext<Token> {
		public VariableDeclaratorsContext variableDeclarators() {
		    return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitFieldDeclaration(this);
			else return null;
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, 50);
		enterRule(_localctx, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453); type();
			setState(454); variableDeclarators();
			setState(455); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext<Token> {
		public ConstructorBodyContext constructorBody() {
		    return getRuleContext(ConstructorBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
		    return getRuleContext(TypeParametersContext.class,0);
		}
		public FormalParametersContext formalParameters() {
		    return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public QualifiedNameListContext qualifiedNameList() {
		    return getRuleContext(QualifiedNameListContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitConstructorDeclaration(this);
			else return null;
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, 52);
		enterRule(_localctx, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==5 ) {
				{
				setState(457); typeParameters();
				}
			}

			setState(460); match(Identifier);
			setState(461); formalParameters();
			setState(464);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==27 ) {
				{
				setState(462); match(27);
				setState(463); qualifiedNameList();
				}
			}

			setState(466); constructorBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyDeclarationContext extends ParserRuleContext<Token> {
		public ModifiersContext modifiers() {
		    return getRuleContext(ModifiersContext.class,0);
		}
		public InterfaceMemberDeclContext interfaceMemberDecl() {
		    return getRuleContext(InterfaceMemberDeclContext.class,0);
		}
		public InterfaceBodyDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceBodyDeclaration(this);
			else return null;
		}
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration() throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, 54);
		enterRule(_localctx, RULE_interfaceBodyDeclaration);
		try {
			setState(472);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 1:
				case 5:
				case 10:
				case 11:
				case 12:
				case 14:
				case 15:
				case 16:
				case 24:
				case 30:
				case 33:
				case 35:
				case 36:
				case 39:
				case 41:
				case 49:
				case 50:
				case 53:
				case 58:
				case 62:
				case 66:
				case 69:
				case 73:
				case 76:
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(468); modifiers();
					setState(469); interfaceMemberDecl();
					}
					break;
				case 77:
					enterOuterAlt(_localctx, 2);
					{
					setState(471); match(77);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMemberDeclContext extends ParserRuleContext<Token> {
		public InterfaceDeclarationContext interfaceDeclaration() {
		    return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public InterfaceGenericMethodDeclContext interfaceGenericMethodDecl() {
		    return getRuleContext(InterfaceGenericMethodDeclContext.class,0);
		}
		public InterfaceMethodOrFieldDeclContext interfaceMethodOrFieldDecl() {
		    return getRuleContext(InterfaceMethodOrFieldDeclContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
		    return getRuleContext(ClassDeclarationContext.class,0);
		}
		public VoidInterfaceMethodDeclaratorRestContext voidInterfaceMethodDeclaratorRest() {
		    return getRuleContext(VoidInterfaceMethodDeclaratorRestContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public InterfaceMemberDeclContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDecl; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceMemberDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceMemberDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceMemberDecl(this);
			else return null;
		}
	}

	public final InterfaceMemberDeclContext interfaceMemberDecl() throws RecognitionException {
		InterfaceMemberDeclContext _localctx = new InterfaceMemberDeclContext(_ctx, 56);
		enterRule(_localctx, RULE_interfaceMemberDecl);
		try {
			setState(481);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(474); interfaceMethodOrFieldDecl();
					}
					break;
				case 5:
					enterOuterAlt(_localctx, 2);
					{
					setState(475); interfaceGenericMethodDecl();
					}
					break;
				case 53:
					enterOuterAlt(_localctx, 3);
					{
					setState(476); match(53);
					setState(477); match(Identifier);
					setState(478); voidInterfaceMethodDeclaratorRest();
					}
					break;
				case 1:
				case 24:
					enterOuterAlt(_localctx, 4);
					{
					setState(479); interfaceDeclaration();
					}
					break;
				case 30:
					enterOuterAlt(_localctx, 5);
					{
					setState(480); classDeclaration();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodOrFieldDeclContext extends ParserRuleContext<Token> {
		public InterfaceMethodOrFieldRestContext interfaceMethodOrFieldRest() {
		    return getRuleContext(InterfaceMethodOrFieldRestContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public InterfaceMethodOrFieldDeclContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodOrFieldDecl; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceMethodOrFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceMethodOrFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceMethodOrFieldDecl(this);
			else return null;
		}
	}

	public final InterfaceMethodOrFieldDeclContext interfaceMethodOrFieldDecl() throws RecognitionException {
		InterfaceMethodOrFieldDeclContext _localctx = new InterfaceMethodOrFieldDeclContext(_ctx, 58);
		enterRule(_localctx, RULE_interfaceMethodOrFieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483); type();
			setState(484); match(Identifier);
			setState(485); interfaceMethodOrFieldRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodOrFieldRestContext extends ParserRuleContext<Token> {
		public InterfaceMethodDeclaratorRestContext interfaceMethodDeclaratorRest() {
		    return getRuleContext(InterfaceMethodDeclaratorRestContext.class,0);
		}
		public ConstantDeclaratorsRestContext constantDeclaratorsRest() {
		    return getRuleContext(ConstantDeclaratorsRestContext.class,0);
		}
		public InterfaceMethodOrFieldRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodOrFieldRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceMethodOrFieldRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceMethodOrFieldRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceMethodOrFieldRest(this);
			else return null;
		}
	}

	public final InterfaceMethodOrFieldRestContext interfaceMethodOrFieldRest() throws RecognitionException {
		InterfaceMethodOrFieldRestContext _localctx = new InterfaceMethodOrFieldRestContext(_ctx, 60);
		enterRule(_localctx, RULE_interfaceMethodOrFieldRest);
		try {
			setState(491);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 4:
				case 25:
					enterOuterAlt(_localctx, 1);
					{
					setState(487); constantDeclaratorsRest();
					setState(488); match(77);
					}
					break;
				case 45:
					enterOuterAlt(_localctx, 2);
					{
					setState(490); interfaceMethodDeclaratorRest();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidMethodDeclaratorRestContext extends ParserRuleContext<Token> {
		public MethodBodyContext methodBody() {
		    return getRuleContext(MethodBodyContext.class,0);
		}
		public FormalParametersContext formalParameters() {
		    return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
		    return getRuleContext(QualifiedNameListContext.class,0);
		}
		public VoidMethodDeclaratorRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_voidMethodDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVoidMethodDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVoidMethodDeclaratorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVoidMethodDeclaratorRest(this);
			else return null;
		}
	}

	public final VoidMethodDeclaratorRestContext voidMethodDeclaratorRest() throws RecognitionException {
		VoidMethodDeclaratorRestContext _localctx = new VoidMethodDeclaratorRestContext(_ctx, 62);
		enterRule(_localctx, RULE_voidMethodDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493); formalParameters();
			setState(496);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==27 ) {
				{
				setState(494); match(27);
				setState(495); qualifiedNameList();
				}
			}

			setState(500);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 56:
					{
					setState(498); methodBody();
					}
					break;
				case 77:
					{
					setState(499); match(77);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodDeclaratorRestContext extends ParserRuleContext<Token> {
		public FormalParametersContext formalParameters() {
		    return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
		    return getRuleContext(QualifiedNameListContext.class,0);
		}
		public InterfaceMethodDeclaratorRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceMethodDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceMethodDeclaratorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceMethodDeclaratorRest(this);
			else return null;
		}
	}

	public final InterfaceMethodDeclaratorRestContext interfaceMethodDeclaratorRest() throws RecognitionException {
		InterfaceMethodDeclaratorRestContext _localctx = new InterfaceMethodDeclaratorRestContext(_ctx, 64);
		enterRule(_localctx, RULE_interfaceMethodDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502); formalParameters();
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==4 ) {
				{
				{
				setState(503); match(4);
				setState(504); match(37);
				}
				}
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(512);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==27 ) {
				{
				setState(510); match(27);
				setState(511); qualifiedNameList();
				}
			}

			setState(514); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceGenericMethodDeclContext extends ParserRuleContext<Token> {
		public InterfaceMethodDeclaratorRestContext interfaceMethodDeclaratorRest() {
		    return getRuleContext(InterfaceMethodDeclaratorRestContext.class,0);
		}
		public TypeParametersContext typeParameters() {
		    return getRuleContext(TypeParametersContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public InterfaceGenericMethodDeclContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_interfaceGenericMethodDecl; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInterfaceGenericMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInterfaceGenericMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInterfaceGenericMethodDecl(this);
			else return null;
		}
	}

	public final InterfaceGenericMethodDeclContext interfaceGenericMethodDecl() throws RecognitionException {
		InterfaceGenericMethodDeclContext _localctx = new InterfaceGenericMethodDeclContext(_ctx, 66);
		enterRule(_localctx, RULE_interfaceGenericMethodDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); typeParameters();
			setState(519);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
				case Identifier:
					{
					setState(517); type();
					}
					break;
				case 53:
					{
					setState(518); match(53);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
			setState(521); match(Identifier);
			setState(522); interfaceMethodDeclaratorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidInterfaceMethodDeclaratorRestContext extends ParserRuleContext<Token> {
		public FormalParametersContext formalParameters() {
		    return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
		    return getRuleContext(QualifiedNameListContext.class,0);
		}
		public VoidInterfaceMethodDeclaratorRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_voidInterfaceMethodDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVoidInterfaceMethodDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVoidInterfaceMethodDeclaratorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVoidInterfaceMethodDeclaratorRest(this);
			else return null;
		}
	}

	public final VoidInterfaceMethodDeclaratorRestContext voidInterfaceMethodDeclaratorRest() throws RecognitionException {
		VoidInterfaceMethodDeclaratorRestContext _localctx = new VoidInterfaceMethodDeclaratorRestContext(_ctx, 68);
		enterRule(_localctx, RULE_voidInterfaceMethodDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524); formalParameters();
			setState(527);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==27 ) {
				{
				setState(525); match(27);
				setState(526); qualifiedNameList();
				}
			}

			setState(529); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorContext extends ParserRuleContext<Token> {
		public ConstantDeclaratorRestContext constantDeclaratorRest() {
		    return getRuleContext(ConstantDeclaratorRestContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ConstantDeclaratorContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstantDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstantDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitConstantDeclarator(this);
			else return null;
		}
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, 70);
		enterRule(_localctx, RULE_constantDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531); match(Identifier);
			setState(532); constantDeclaratorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorsContext extends ParserRuleContext<Token> {
		public List<? extends VariableDeclaratorContext> variableDeclarator() {
		    return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
		    return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclaratorsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVariableDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVariableDeclarators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVariableDeclarators(this);
			else return null;
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, 72);
		enterRule(_localctx, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534); variableDeclarator();
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(535); match(42);
				setState(536); variableDeclarator();
				}
				}
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext<Token> {
		public VariableDeclaratorIdContext variableDeclaratorId() {
		    return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
		    return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVariableDeclarator(this);
			else return null;
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, 74);
		enterRule(_localctx, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542); variableDeclaratorId();
			setState(545);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==25 ) {
				{
				setState(543); match(25);
				setState(544); variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorsRestContext extends ParserRuleContext<Token> {
		public List<? extends ConstantDeclaratorContext> constantDeclarator() {
		    return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorRestContext constantDeclaratorRest() {
		    return getRuleContext(ConstantDeclaratorRestContext.class,0);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
		    return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public ConstantDeclaratorsRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaratorsRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstantDeclaratorsRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstantDeclaratorsRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitConstantDeclaratorsRest(this);
			else return null;
		}
	}

	public final ConstantDeclaratorsRestContext constantDeclaratorsRest() throws RecognitionException {
		ConstantDeclaratorsRestContext _localctx = new ConstantDeclaratorsRestContext(_ctx, 76);
		enterRule(_localctx, RULE_constantDeclaratorsRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547); constantDeclaratorRest();
			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(548); match(42);
				setState(549); constantDeclarator();
				}
				}
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorRestContext extends ParserRuleContext<Token> {
		public VariableInitializerContext variableInitializer() {
		    return getRuleContext(VariableInitializerContext.class,0);
		}
		public ConstantDeclaratorRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstantDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstantDeclaratorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitConstantDeclaratorRest(this);
			else return null;
		}
	}

	public final ConstantDeclaratorRestContext constantDeclaratorRest() throws RecognitionException {
		ConstantDeclaratorRestContext _localctx = new ConstantDeclaratorRestContext(_ctx, 78);
		enterRule(_localctx, RULE_constantDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==4 ) {
				{
				{
				setState(555); match(4);
				setState(556); match(37);
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(562); match(25);
			setState(563); variableInitializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorIdContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public VariableDeclaratorIdContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVariableDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVariableDeclaratorId(this);
			else return null;
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, 80);
		enterRule(_localctx, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565); match(Identifier);
			setState(570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==4 ) {
				{
				{
				setState(566); match(4);
				setState(567); match(37);
				}
				}
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext<Token> {
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
		    return getRuleContext(ArrayInitializerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVariableInitializer(this);
			else return null;
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, 82);
		enterRule(_localctx, RULE_variableInitializer);
		try {
			setState(575);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 56:
					enterOuterAlt(_localctx, 1);
					{
					setState(573); arrayInitializer();
					}
					break;
				case 6:
				case 7:
				case 10:
				case 12:
				case 14:
				case 15:
				case 18:
				case 26:
				case 29:
				case 34:
				case 35:
				case 36:
				case 44:
				case 45:
				case 49:
				case 53:
				case 65:
				case 67:
				case 69:
				case 72:
				case 79:
				case 88:
				case HexLiteral:
				case DecimalLiteral:
				case OctalLiteral:
				case FloatingPointLiteral:
				case CharacterLiteral:
				case StringLiteral:
				case Identifier:
					enterOuterAlt(_localctx, 2);
					{
					setState(574); expression(0);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext<Token> {
		public VariableInitializerContext variableInitializer(int i) {
		    return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<? extends VariableInitializerContext> variableInitializer() {
		    return getRuleContexts(VariableInitializerContext.class);
		}
		public ArrayInitializerContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitArrayInitializer(this);
			else return null;
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, 84);
		enterRule(_localctx, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(577); match(56);
			setState(589);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==56 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
				{
				setState(578); variableInitializer();
				setState(583);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(579); match(42);
						setState(580); variableInitializer();
						}
						} 
					}
					setState(585);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				setState(587);
				//_errHandler.sync(this);
				_la = _input.LA(1);
				if ( _la==42 ) {
					{
					setState(586); match(42);
					}
				}

				}
			}

			setState(591); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext<Token> {
		public AnnotationContext annotation() {
		    return getRuleContext(AnnotationContext.class,0);
		}
		public ModifierContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitModifier(this);
			else return null;
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, 86);
		enterRule(_localctx, RULE_modifier);
		try {
			setState(605);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 24:
					enterOuterAlt(_localctx, 1);
					{
					setState(593); annotation();
					}
					break;
				case 39:
					enterOuterAlt(_localctx, 2);
					{
					setState(594); match(39);
					}
					break;
				case 73:
					enterOuterAlt(_localctx, 3);
					{
					setState(595); match(73);
					}
					break;
				case 50:
					enterOuterAlt(_localctx, 4);
					{
					setState(596); match(50);
					}
					break;
				case 66:
					enterOuterAlt(_localctx, 5);
					{
					setState(597); match(66);
					}
					break;
				case 11:
					enterOuterAlt(_localctx, 6);
					{
					setState(598); match(11);
					}
					break;
				case 62:
					enterOuterAlt(_localctx, 7);
					{
					setState(599); match(62);
					}
					break;
				case 58:
					enterOuterAlt(_localctx, 8);
					{
					setState(600); match(58);
					}
					break;
				case 41:
					enterOuterAlt(_localctx, 9);
					{
					setState(601); match(41);
					}
					break;
				case 33:
					enterOuterAlt(_localctx, 10);
					{
					setState(602); match(33);
					}
					break;
				case 76:
					enterOuterAlt(_localctx, 11);
					{
					setState(603); match(76);
					}
					break;
				case 16:
					enterOuterAlt(_localctx, 12);
					{
					setState(604); match(16);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageOrTypeNameContext extends ParserRuleContext<Token> {
		public QualifiedNameContext qualifiedName() {
		    return getRuleContext(QualifiedNameContext.class,0);
		}
		public PackageOrTypeNameContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_packageOrTypeName; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterPackageOrTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitPackageOrTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitPackageOrTypeName(this);
			else return null;
		}
	}

	public final PackageOrTypeNameContext packageOrTypeName() throws RecognitionException {
		PackageOrTypeNameContext _localctx = new PackageOrTypeNameContext(_ctx, 88);
		enterRule(_localctx, RULE_packageOrTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607); qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantNameContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public EnumConstantNameContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantName; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterEnumConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitEnumConstantName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitEnumConstantName(this);
			else return null;
		}
	}

	public final EnumConstantNameContext enumConstantName() throws RecognitionException {
		EnumConstantNameContext _localctx = new EnumConstantNameContext(_ctx, 90);
		enterRule(_localctx, RULE_enumConstantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext<Token> {
		public QualifiedNameContext qualifiedName() {
		    return getRuleContext(QualifiedNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeName(this);
			else return null;
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, 92);
		enterRule(_localctx, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611); qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext<Token> {
		public PrimitiveTypeContext primitiveType() {
		    return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
		    return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitType(this);
			else return null;
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, 94);
		enterRule(_localctx, RULE_type);
		try {
			int _alt;
			setState(629);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(613); classOrInterfaceType();
					setState(618);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(614); match(4);
							setState(615); match(37);
							}
							} 
						}
						setState(620);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
					}
					}
					break;
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
					enterOuterAlt(_localctx, 2);
					{
					setState(621); primitiveType();
					setState(626);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(622); match(4);
							setState(623); match(37);
							}
							} 
						}
						setState(628);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					}
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext<Token> {
		public TypeArgumentsContext typeArguments(int i) {
		    return getRuleContext(TypeArgumentsContext.class,i);
		}
		public TerminalNode<Token> Identifier(int i) {
		    return getToken(JavaParser.Identifier, i);
		}
		public List<? extends TypeArgumentsContext> typeArguments() {
		    return getRuleContexts(TypeArgumentsContext.class);
		}
		public List<TerminalNode<Token>> Identifier() { return getTokens(JavaParser.Identifier); }
		public ClassOrInterfaceTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitClassOrInterfaceType(this);
			else return null;
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, 96);
		enterRule(_localctx, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(631); match(Identifier);
			setState(633);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(632); typeArguments();
					}
					break;
			}
			setState(642);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(635); match(71);
					setState(636); match(Identifier);
					setState(638);
					//_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
						case 1:
							{
							setState(637); typeArguments();
							}
							break;
					}
					}
					} 
				}
				setState(644);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext<Token> {
		public PrimitiveTypeContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitPrimitiveType(this);
			else return null;
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, 98);
		enterRule(_localctx, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			_input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==10 || _la==12 || _la==14 || _la==15 || _la==35 || _la==36 || _la==49 || _la==69) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext<Token> {
		public AnnotationContext annotation() {
		    return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVariableModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVariableModifier(this);
			else return null;
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, 100);
		enterRule(_localctx, RULE_variableModifier);
		try {
			setState(649);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 62:
					enterOuterAlt(_localctx, 1);
					{
					setState(647); match(62);
					}
					break;
				case 24:
					enterOuterAlt(_localctx, 2);
					{
					setState(648); annotation();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext<Token> {
		public TypeArgumentContext typeArgument(int i) {
		    return getRuleContext(TypeArgumentContext.class,i);
		}
		public List<? extends TypeArgumentContext> typeArgument() {
		    return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeArguments(this);
			else return null;
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, 102);
		enterRule(_localctx, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651); match(5);
			setState(652); typeArgument();
			setState(657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(653); match(42);
				setState(654); typeArgument();
				}
				}
				setState(659);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(660); match(81);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentContext extends ParserRuleContext<Token> {
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitTypeArgument(this);
			else return null;
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, 104);
		enterRule(_localctx, RULE_typeArgument);
		int _la;
		try {
			setState(668);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(662); type();
					}
					break;
				case 51:
					enterOuterAlt(_localctx, 2);
					{
					setState(663); match(51);
					setState(666);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==18 || _la==60 ) {
						{
						setState(664);
						_input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==18 || _la==60) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(665); type();
						}
					}

					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameListContext extends ParserRuleContext<Token> {
		public List<? extends QualifiedNameContext> qualifiedName() {
		    return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
		    return getRuleContext(QualifiedNameContext.class,i);
		}
		public QualifiedNameListContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterQualifiedNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitQualifiedNameList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitQualifiedNameList(this);
			else return null;
		}
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, 106);
		enterRule(_localctx, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670); qualifiedName();
			setState(675);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(671); match(42);
				setState(672); qualifiedName();
				}
				}
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext<Token> {
		public FormalParameterDeclsContext formalParameterDecls() {
		    return getRuleContext(FormalParameterDeclsContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitFormalParameters(this);
			else return null;
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, 108);
		enterRule(_localctx, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678); match(45);
			setState(680);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==10 || _la==12 || _la==14 || _la==15 || _la==24 || _la==35 || _la==36 || _la==49 || _la==62 || _la==69 || _la==Identifier ) {
				{
				setState(679); formalParameterDecls();
				}
			}

			setState(682); match(22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterDeclsContext extends ParserRuleContext<Token> {
		public FormalParameterDeclsRestContext formalParameterDeclsRest() {
		    return getRuleContext(FormalParameterDeclsRestContext.class,0);
		}
		public VariableModifiersContext variableModifiers() {
		    return getRuleContext(VariableModifiersContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public FormalParameterDeclsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterDecls; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterFormalParameterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitFormalParameterDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitFormalParameterDecls(this);
			else return null;
		}
	}

	public final FormalParameterDeclsContext formalParameterDecls() throws RecognitionException {
		FormalParameterDeclsContext _localctx = new FormalParameterDeclsContext(_ctx, 110);
		enterRule(_localctx, RULE_formalParameterDecls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684); variableModifiers();
			setState(685); type();
			setState(686); formalParameterDeclsRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterDeclsRestContext extends ParserRuleContext<Token> {
		public VariableDeclaratorIdContext variableDeclaratorId() {
		    return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public FormalParameterDeclsContext formalParameterDecls() {
		    return getRuleContext(FormalParameterDeclsContext.class,0);
		}
		public FormalParameterDeclsRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterDeclsRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterFormalParameterDeclsRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitFormalParameterDeclsRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitFormalParameterDeclsRest(this);
			else return null;
		}
	}

	public final FormalParameterDeclsRestContext formalParameterDeclsRest() throws RecognitionException {
		FormalParameterDeclsRestContext _localctx = new FormalParameterDeclsRestContext(_ctx, 112);
		enterRule(_localctx, RULE_formalParameterDeclsRest);
		int _la;
		try {
			setState(695);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(688); variableDeclaratorId();
					setState(691);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==42 ) {
						{
						setState(689); match(42);
						setState(690); formalParameterDecls();
						}
					}

					}
					break;
				case 55:
					enterOuterAlt(_localctx, 2);
					{
					setState(693); match(55);
					setState(694); variableDeclaratorId();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext<Token> {
		public BlockContext block() {
		    return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitMethodBody(this);
			else return null;
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, 114);
		enterRule(_localctx, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorBodyContext extends ParserRuleContext<Token> {
		public BlockStatementContext blockStatement(int i) {
		    return getRuleContext(BlockStatementContext.class,i);
		}
		public ExplicitConstructorInvocationContext explicitConstructorInvocation() {
		    return getRuleContext(ExplicitConstructorInvocationContext.class,0);
		}
		public List<? extends BlockStatementContext> blockStatement() {
		    return getRuleContexts(BlockStatementContext.class);
		}
		public ConstructorBodyContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstructorBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstructorBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitConstructorBody(this);
			else return null;
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, 116);
		enterRule(_localctx, RULE_constructorBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699); match(56);
			setState(701);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(700); explicitConstructorInvocation();
					}
					break;
			}
			setState(706);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==6 || _la==7 || _la==8 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==19 || _la==23 || _la==24 || _la==26 || _la==29 || _la==30 || _la==34 || _la==35 || _la==36 || _la==41 || _la==43 || _la==44 || _la==45 || _la==47 || _la==49 || _la==52 || _la==53 || _la==56 || _la==57 || _la==62 || _la==65 || _la==67 || _la==69 || _la==72 || _la==74 || _la==75 || _la==77 || _la==79 || _la==84 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==ASSERT || _la==Identifier ) {
				{
				{
				setState(703); blockStatement();
				}
				}
				setState(708);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(709); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitConstructorInvocationContext extends ParserRuleContext<Token> {
		public ArgumentsContext arguments() {
		    return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext primary() {
		    return getRuleContext(PrimaryContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
		    return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitConstructorInvocationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_explicitConstructorInvocation; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterExplicitConstructorInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitExplicitConstructorInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitExplicitConstructorInvocation(this);
			else return null;
		}
	}

	public final ExplicitConstructorInvocationContext explicitConstructorInvocation() throws RecognitionException {
		ExplicitConstructorInvocationContext _localctx = new ExplicitConstructorInvocationContext(_ctx, 118);
		enterRule(_localctx, RULE_explicitConstructorInvocation);
		int _la;
		try {
			setState(727);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(712);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==5 ) {
						{
						setState(711); nonWildcardTypeArguments();
						}
					}

					setState(714);
					_input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==18 || _la==79) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(715); arguments();
					setState(716); match(77);
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(718); primary();
					setState(719); match(71);
					setState(721);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==5 ) {
						{
						setState(720); nonWildcardTypeArguments();
						}
					}

					setState(723); match(18);
					setState(724); arguments();
					setState(725); match(77);
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> Identifier(int i) {
		    return getToken(JavaParser.Identifier, i);
		}
		public List<TerminalNode<Token>> Identifier() { return getTokens(JavaParser.Identifier); }
		public QualifiedNameContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitQualifiedName(this);
			else return null;
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, 120);
		enterRule(_localctx, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(729); match(Identifier);
			setState(734);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(730); match(71);
					setState(731); match(Identifier);
					}
					} 
				}
				setState(736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> StringLiteral() { return getToken(JavaParser.StringLiteral, 0); }
		public BooleanLiteralContext booleanLiteral() {
		    return getRuleContext(BooleanLiteralContext.class,0);
		}
		public TerminalNode<Token> CharacterLiteral() { return getToken(JavaParser.CharacterLiteral, 0); }
		public TerminalNode<Token> FloatingPointLiteral() { return getToken(JavaParser.FloatingPointLiteral, 0); }
		public IntegerLiteralContext integerLiteral() {
		    return getRuleContext(IntegerLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitLiteral(this);
			else return null;
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, 122);
		enterRule(_localctx, RULE_literal);
		try {
			setState(743);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case HexLiteral:
				case DecimalLiteral:
				case OctalLiteral:
					enterOuterAlt(_localctx, 1);
					{
					setState(737); integerLiteral();
					}
					break;
				case FloatingPointLiteral:
					enterOuterAlt(_localctx, 2);
					{
					setState(738); match(FloatingPointLiteral);
					}
					break;
				case CharacterLiteral:
					enterOuterAlt(_localctx, 3);
					{
					setState(739); match(CharacterLiteral);
					}
					break;
				case StringLiteral:
					enterOuterAlt(_localctx, 4);
					{
					setState(740); match(StringLiteral);
					}
					break;
				case 7:
				case 65:
					enterOuterAlt(_localctx, 5);
					{
					setState(741); booleanLiteral();
					}
					break;
				case 26:
					enterOuterAlt(_localctx, 6);
					{
					setState(742); match(26);
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerLiteralContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> HexLiteral() { return getToken(JavaParser.HexLiteral, 0); }
		public TerminalNode<Token> DecimalLiteral() { return getToken(JavaParser.DecimalLiteral, 0); }
		public TerminalNode<Token> OctalLiteral() { return getToken(JavaParser.OctalLiteral, 0); }
		public IntegerLiteralContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitIntegerLiteral(this);
			else return null;
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, 124);
		enterRule(_localctx, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			_input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext<Token> {
		public BooleanLiteralContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitBooleanLiteral(this);
			else return null;
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, 126);
		enterRule(_localctx, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			_input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==7 || _la==65) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationsContext extends ParserRuleContext<Token> {
		public List<? extends AnnotationContext> annotation() {
		    return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
		    return getRuleContext(AnnotationContext.class,i);
		}
		public AnnotationsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotations; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotations(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotations(this);
			else return null;
		}
	}

	public final AnnotationsContext annotations() throws RecognitionException {
		AnnotationsContext _localctx = new AnnotationsContext(_ctx, 128);
		enterRule(_localctx, RULE_annotations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(749); annotation();
				}
				}
				setState(752); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==24 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext<Token> {
		public AnnotationNameContext annotationName() {
		    return getRuleContext(AnnotationNameContext.class,0);
		}
		public ElementValueContext elementValue() {
		    return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairsContext elementValuePairs() {
		    return getRuleContext(ElementValuePairsContext.class,0);
		}
		public AnnotationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotation(this);
			else return null;
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, 130);
		enterRule(_localctx, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(754); match(24);
			setState(755); annotationName();
			setState(762);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==45 ) {
				{
				setState(756); match(45);
				setState(759);
				//_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
					case 1:
						{
						setState(757); elementValuePairs();
						}
						break;
					case 2:
						{
						setState(758); elementValue();
						}
						break;
				}
				setState(761); match(22);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationNameContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> Identifier(int i) {
		    return getToken(JavaParser.Identifier, i);
		}
		public List<TerminalNode<Token>> Identifier() { return getTokens(JavaParser.Identifier); }
		public AnnotationNameContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationName; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationName(this);
			else return null;
		}
	}

	public final AnnotationNameContext annotationName() throws RecognitionException {
		AnnotationNameContext _localctx = new AnnotationNameContext(_ctx, 132);
		enterRule(_localctx, RULE_annotationName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764); match(Identifier);
			setState(769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==71 ) {
				{
				{
				setState(765); match(71);
				setState(766); match(Identifier);
				}
				}
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairsContext extends ParserRuleContext<Token> {
		public ElementValuePairContext elementValuePair(int i) {
		    return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<? extends ElementValuePairContext> elementValuePair() {
		    return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairs; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterElementValuePairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitElementValuePairs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitElementValuePairs(this);
			else return null;
		}
	}

	public final ElementValuePairsContext elementValuePairs() throws RecognitionException {
		ElementValuePairsContext _localctx = new ElementValuePairsContext(_ctx, 134);
		enterRule(_localctx, RULE_elementValuePairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772); elementValuePair();
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(773); match(42);
				setState(774); elementValuePair();
				}
				}
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairContext extends ParserRuleContext<Token> {
		public ElementValueContext elementValue() {
		    return getRuleContext(ElementValueContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ElementValuePairContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitElementValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitElementValuePair(this);
			else return null;
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, 136);
		enterRule(_localctx, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780); match(Identifier);
			setState(781); match(25);
			setState(782); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueContext extends ParserRuleContext<Token> {
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
		    return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public AnnotationContext annotation() {
		    return getRuleContext(AnnotationContext.class,0);
		}
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public ElementValueContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitElementValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitElementValue(this);
			else return null;
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, 138);
		enterRule(_localctx, RULE_elementValue);
		try {
			setState(787);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 6:
				case 7:
				case 10:
				case 12:
				case 14:
				case 15:
				case 18:
				case 26:
				case 29:
				case 34:
				case 35:
				case 36:
				case 44:
				case 45:
				case 49:
				case 53:
				case 65:
				case 67:
				case 69:
				case 72:
				case 79:
				case 88:
				case HexLiteral:
				case DecimalLiteral:
				case OctalLiteral:
				case FloatingPointLiteral:
				case CharacterLiteral:
				case StringLiteral:
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(784); expression(0);
					}
					break;
				case 24:
					enterOuterAlt(_localctx, 2);
					{
					setState(785); annotation();
					}
					break;
				case 56:
					enterOuterAlt(_localctx, 3);
					{
					setState(786); elementValueArrayInitializer();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueArrayInitializerContext extends ParserRuleContext<Token> {
		public List<? extends ElementValueContext> elementValue() {
		    return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
		    return getRuleContext(ElementValueContext.class,i);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitElementValueArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitElementValueArrayInitializer(this);
			else return null;
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, 140);
		enterRule(_localctx, RULE_elementValueArrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(789); match(56);
			setState(798);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==24 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==56 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
				{
				setState(790); elementValue();
				setState(795);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(791); match(42);
						setState(792); elementValue();
						}
						} 
					}
					setState(797);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				}
				}
			}

			setState(801);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==42 ) {
				{
				setState(800); match(42);
				}
			}

			setState(803); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeDeclarationContext extends ParserRuleContext<Token> {
		public AnnotationTypeBodyContext annotationTypeBody() {
		    return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public AnnotationTypeDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationTypeDeclaration(this);
			else return null;
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, 142);
		enterRule(_localctx, RULE_annotationTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805); match(24);
			setState(806); match(1);
			setState(807); match(Identifier);
			setState(808); annotationTypeBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeBodyContext extends ParserRuleContext<Token> {
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration(int i) {
		    return getRuleContext(AnnotationTypeElementDeclarationContext.class,i);
		}
		public List<? extends AnnotationTypeElementDeclarationContext> annotationTypeElementDeclaration() {
		    return getRuleContexts(AnnotationTypeElementDeclarationContext.class);
		}
		public AnnotationTypeBodyContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationTypeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationTypeBody(this);
			else return null;
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, 144);
		enterRule(_localctx, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810); match(56);
			setState(814);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==10 || _la==11 || _la==12 || _la==14 || _la==15 || _la==16 || _la==24 || _la==30 || _la==33 || _la==35 || _la==36 || _la==39 || _la==41 || _la==49 || _la==50 || _la==58 || _la==62 || _la==66 || _la==69 || _la==73 || _la==76 || _la==ENUM || _la==Identifier ) {
				{
				{
				setState(811); annotationTypeElementDeclaration();
				}
				}
				setState(816);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(817); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext<Token> {
		public ModifiersContext modifiers() {
		    return getRuleContext(ModifiersContext.class,0);
		}
		public AnnotationTypeElementRestContext annotationTypeElementRest() {
		    return getRuleContext(AnnotationTypeElementRestContext.class,0);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationTypeElementDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationTypeElementDeclaration(this);
			else return null;
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, 146);
		enterRule(_localctx, RULE_annotationTypeElementDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819); modifiers();
			setState(820); annotationTypeElementRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementRestContext extends ParserRuleContext<Token> {
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
		    return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
		    return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
		    return getRuleContext(EnumDeclarationContext.class,0);
		}
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
		    return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() {
		    return getRuleContext(AnnotationMethodOrConstantRestContext.class,0);
		}
		public AnnotationTypeElementRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationTypeElementRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationTypeElementRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationTypeElementRest(this);
			else return null;
		}
	}

	public final AnnotationTypeElementRestContext annotationTypeElementRest() throws RecognitionException {
		AnnotationTypeElementRestContext _localctx = new AnnotationTypeElementRestContext(_ctx, 148);
		enterRule(_localctx, RULE_annotationTypeElementRest);
		int _la;
		try {
			setState(842);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(822); type();
					setState(823); annotationMethodOrConstantRest();
					setState(824); match(77);
					}
					break;
				case 30:
					enterOuterAlt(_localctx, 2);
					{
					setState(826); classDeclaration();
					setState(828);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==77 ) {
						{
						setState(827); match(77);
						}
					}

					}
					break;
				case 1:
					enterOuterAlt(_localctx, 3);
					{
					setState(830); normalInterfaceDeclaration();
					setState(832);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==77 ) {
						{
						setState(831); match(77);
						}
					}

					}
					break;
				case ENUM:
					enterOuterAlt(_localctx, 4);
					{
					setState(834); enumDeclaration();
					setState(836);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==77 ) {
						{
						setState(835); match(77);
						}
					}

					}
					break;
				case 24:
					enterOuterAlt(_localctx, 5);
					{
					setState(838); annotationTypeDeclaration();
					setState(840);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==77 ) {
						{
						setState(839); match(77);
						}
					}

					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationMethodOrConstantRestContext extends ParserRuleContext<Token> {
		public AnnotationMethodRestContext annotationMethodRest() {
		    return getRuleContext(AnnotationMethodRestContext.class,0);
		}
		public AnnotationConstantRestContext annotationConstantRest() {
		    return getRuleContext(AnnotationConstantRestContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodOrConstantRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationMethodOrConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationMethodOrConstantRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationMethodOrConstantRest(this);
			else return null;
		}
	}

	public final AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() throws RecognitionException {
		AnnotationMethodOrConstantRestContext _localctx = new AnnotationMethodOrConstantRestContext(_ctx, 150);
		enterRule(_localctx, RULE_annotationMethodOrConstantRest);
		try {
			setState(846);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(844); annotationMethodRest();
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(845); annotationConstantRest();
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationMethodRestContext extends ParserRuleContext<Token> {
		public DefaultValueContext defaultValue() {
		    return getRuleContext(DefaultValueContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public AnnotationMethodRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationMethodRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationMethodRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationMethodRest(this);
			else return null;
		}
	}

	public final AnnotationMethodRestContext annotationMethodRest() throws RecognitionException {
		AnnotationMethodRestContext _localctx = new AnnotationMethodRestContext(_ctx, 152);
		enterRule(_localctx, RULE_annotationMethodRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848); match(Identifier);
			setState(849); match(45);
			setState(850); match(22);
			setState(852);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==40 ) {
				{
				setState(851); defaultValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationConstantRestContext extends ParserRuleContext<Token> {
		public VariableDeclaratorsContext variableDeclarators() {
		    return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAnnotationConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAnnotationConstantRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitAnnotationConstantRest(this);
			else return null;
		}
	}

	public final AnnotationConstantRestContext annotationConstantRest() throws RecognitionException {
		AnnotationConstantRestContext _localctx = new AnnotationConstantRestContext(_ctx, 154);
		enterRule(_localctx, RULE_annotationConstantRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854); variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultValueContext extends ParserRuleContext<Token> {
		public ElementValueContext elementValue() {
		    return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitDefaultValue(this);
			else return null;
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, 156);
		enterRule(_localctx, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856); match(40);
			setState(857); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext<Token> {
		public BlockStatementContext blockStatement(int i) {
		    return getRuleContext(BlockStatementContext.class,i);
		}
		public List<? extends BlockStatementContext> blockStatement() {
		    return getRuleContexts(BlockStatementContext.class);
		}
		public BlockContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitBlock(this);
			else return null;
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, 158);
		enterRule(_localctx, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859); match(56);
			setState(863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==6 || _la==7 || _la==8 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==19 || _la==23 || _la==24 || _la==26 || _la==29 || _la==30 || _la==34 || _la==35 || _la==36 || _la==41 || _la==43 || _la==44 || _la==45 || _la==47 || _la==49 || _la==52 || _la==53 || _la==56 || _la==57 || _la==62 || _la==65 || _la==67 || _la==69 || _la==72 || _la==74 || _la==75 || _la==77 || _la==79 || _la==84 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==ASSERT || _la==Identifier ) {
				{
				{
				setState(860); blockStatement();
				}
				}
				setState(865);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(866); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext<Token> {
		public StatementContext statement() {
		    return getRuleContext(StatementContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
		    return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
		    return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
		    return getRuleContext(ClassDeclarationContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitBlockStatement(this);
			else return null;
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, 160);
		enterRule(_localctx, RULE_blockStatement);
		try {
			setState(872);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(868); localVariableDeclarationStatement();
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(869); classDeclaration();
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 3);
					{
					setState(870); interfaceDeclaration();
					}
					break;
				case 4:
					enterOuterAlt(_localctx, 4);
					{
					setState(871); statement();
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext<Token> {
		public LocalVariableDeclarationContext localVariableDeclaration() {
		    return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return null;
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, 162);
		enterRule(_localctx, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874); localVariableDeclaration();
			setState(875); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext<Token> {
		public VariableModifiersContext variableModifiers() {
		    return getRuleContext(VariableModifiersContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
		    return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitLocalVariableDeclaration(this);
			else return null;
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, 164);
		enterRule(_localctx, RULE_localVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877); variableModifiers();
			setState(878); type();
			setState(879); variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifiersContext extends ParserRuleContext<Token> {
		public VariableModifierContext variableModifier(int i) {
		    return getRuleContext(VariableModifierContext.class,i);
		}
		public List<? extends VariableModifierContext> variableModifier() {
		    return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifiersContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_variableModifiers; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterVariableModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitVariableModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitVariableModifiers(this);
			else return null;
		}
	}

	public final VariableModifiersContext variableModifiers() throws RecognitionException {
		VariableModifiersContext _localctx = new VariableModifiersContext(_ctx, 166);
		enterRule(_localctx, RULE_variableModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==24 || _la==62 ) {
				{
				{
				setState(881); variableModifier();
				}
				}
				setState(886);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext<Token> {
		public List<? extends StatementContext> statement() {
		    return getRuleContexts(StatementContext.class);
		}
		public List<? extends ExpressionContext> expression() {
		    return getRuleContexts(ExpressionContext.class);
		}
		public BlockContext block(int i) {
		    return getRuleContext(BlockContext.class,i);
		}
		public ParExpressionContext parExpression() {
		    return getRuleContext(ParExpressionContext.class,0);
		}
		public List<? extends CatchesContext> catches() {
		    return getRuleContexts(CatchesContext.class);
		}
		public StatementContext statement(int i) {
		    return getRuleContext(StatementContext.class,i);
		}
		public ExpressionContext expression(int i) {
		    return getRuleContext(ExpressionContext.class,i);
		}
		public StatementExpressionContext statementExpression() {
		    return getRuleContext(StatementExpressionContext.class,0);
		}
		public List<? extends BlockContext> block() {
		    return getRuleContexts(BlockContext.class);
		}
		public ForControlContext forControl() {
		    return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode<Token> ASSERT() { return getToken(JavaParser.ASSERT, 0); }
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public SwitchBlockContext switchBlock() {
		    return getRuleContext(SwitchBlockContext.class,0);
		}
		public CatchesContext catches(int i) {
		    return getRuleContext(CatchesContext.class,i);
		}
		public StatementContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitStatement(this);
			else return null;
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, 168);
		enterRule(_localctx, RULE_statement);
		int _la;
		try {
			setState(964);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(887); block();
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(888); match(ASSERT);
					setState(889); expression(0);
					setState(892);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==46 ) {
						{
						setState(890); match(46);
						setState(891); expression(0);
						}
					}

					setState(894); match(77);
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 3);
					{
					setState(896); match(47);
					setState(897); parExpression();
					setState(898); statement();
					setState(901);
					//_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
						case 1:
							{
							setState(899); match(63);
							setState(900); statement();
							}
							break;
					}
					}
					break;
				case 4:
					enterOuterAlt(_localctx, 4);
					{
					setState(903); match(74);
					setState(904); match(45);
					setState(905); forControl();
					setState(906); match(22);
					setState(907); statement();
					}
					break;
				case 5:
					enterOuterAlt(_localctx, 5);
					{
					setState(909); match(43);
					setState(910); parExpression();
					setState(911); statement();
					}
					break;
				case 6:
					enterOuterAlt(_localctx, 6);
					{
					setState(913); match(19);
					setState(914); statement();
					setState(915); match(43);
					setState(916); parExpression();
					setState(917); match(77);
					}
					break;
				case 7:
					enterOuterAlt(_localctx, 7);
					{
					setState(919); match(52);
					setState(920); block();
					setState(928);
					//_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
						case 1:
							{
							setState(921); catches();
							setState(922); match(31);
							setState(923); block();
							}
							break;
						case 2:
							{
							setState(925); catches();
							}
							break;
						case 3:
							{
							setState(926); match(31);
							setState(927); block();
							}
							break;
					}
					}
					break;
				case 8:
					enterOuterAlt(_localctx, 8);
					{
					setState(930); match(84);
					setState(931); parExpression();
					setState(932); switchBlock();
					}
					break;
				case 9:
					enterOuterAlt(_localctx, 9);
					{
					setState(934); match(41);
					setState(935); parExpression();
					setState(936); block();
					}
					break;
				case 10:
					enterOuterAlt(_localctx, 10);
					{
					setState(938); match(75);
					setState(940);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
						{
						setState(939); expression(0);
						}
					}

					setState(942); match(77);
					}
					break;
				case 11:
					enterOuterAlt(_localctx, 11);
					{
					setState(943); match(23);
					setState(944); expression(0);
					setState(945); match(77);
					}
					break;
				case 12:
					enterOuterAlt(_localctx, 12);
					{
					setState(947); match(57);
					setState(949);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==Identifier ) {
						{
						setState(948); match(Identifier);
						}
					}

					setState(951); match(77);
					}
					break;
				case 13:
					enterOuterAlt(_localctx, 13);
					{
					setState(952); match(8);
					setState(954);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==Identifier ) {
						{
						setState(953); match(Identifier);
						}
					}

					setState(956); match(77);
					}
					break;
				case 14:
					enterOuterAlt(_localctx, 14);
					{
					setState(957); match(77);
					}
					break;
				case 15:
					enterOuterAlt(_localctx, 15);
					{
					setState(958); statementExpression();
					setState(959); match(77);
					}
					break;
				case 16:
					enterOuterAlt(_localctx, 16);
					{
					setState(961); match(Identifier);
					setState(962); match(46);
					setState(963); statement();
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchesContext extends ParserRuleContext<Token> {
		public List<? extends CatchClauseContext> catchClause() {
		    return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
		    return getRuleContext(CatchClauseContext.class,i);
		}
		public CatchesContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_catches; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterCatches(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitCatches(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitCatches(this);
			else return null;
		}
	}

	public final CatchesContext catches() throws RecognitionException {
		CatchesContext _localctx = new CatchesContext(_ctx, 170);
		enterRule(_localctx, RULE_catches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966); catchClause();
			setState(970);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==64 ) {
				{
				{
				setState(967); catchClause();
				}
				}
				setState(972);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchClauseContext extends ParserRuleContext<Token> {
		public FormalParameterContext formalParameter() {
		    return getRuleContext(FormalParameterContext.class,0);
		}
		public BlockContext block() {
		    return getRuleContext(BlockContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitCatchClause(this);
			else return null;
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, 172);
		enterRule(_localctx, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973); match(64);
			setState(974); match(45);
			setState(975); formalParameter();
			setState(976); match(22);
			setState(977); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext<Token> {
		public VariableDeclaratorIdContext variableDeclaratorId() {
		    return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableModifiersContext variableModifiers() {
		    return getRuleContext(VariableModifiersContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitFormalParameter(this);
			else return null;
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, 174);
		enterRule(_localctx, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(979); variableModifiers();
			setState(980); type();
			setState(981); variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockContext extends ParserRuleContext<Token> {
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
		    return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<? extends SwitchLabelContext> switchLabel() {
		    return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
		    return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<? extends SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
		    return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitSwitchBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitSwitchBlock(this);
			else return null;
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, 176);
		enterRule(_localctx, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(983); match(56);
			setState(987);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(984); switchBlockStatementGroup();
					}
					} 
				}
				setState(989);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			}
			setState(993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==17 || _la==40 ) {
				{
				{
				setState(990); switchLabel();
				}
				}
				setState(995);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(996); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext<Token> {
		public BlockStatementContext blockStatement(int i) {
		    return getRuleContext(BlockStatementContext.class,i);
		}
		public List<? extends SwitchLabelContext> switchLabel() {
		    return getRuleContexts(SwitchLabelContext.class);
		}
		public List<? extends BlockStatementContext> blockStatement() {
		    return getRuleContexts(BlockStatementContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
		    return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitSwitchBlockStatementGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitSwitchBlockStatementGroup(this);
			else return null;
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, 178);
		enterRule(_localctx, RULE_switchBlockStatementGroup);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(999); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			do {
				switch ( _alt ) {
					case 1:
						{
						{
						setState(998); switchLabel();
						}
						}
						break;
					default :
						throw new NoViableAltException(this);
				}
				setState(1001); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(1006);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==1 || _la==6 || _la==7 || _la==8 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==19 || _la==23 || _la==24 || _la==26 || _la==29 || _la==30 || _la==34 || _la==35 || _la==36 || _la==41 || _la==43 || _la==44 || _la==45 || _la==47 || _la==49 || _la==52 || _la==53 || _la==56 || _la==57 || _la==62 || _la==65 || _la==67 || _la==69 || _la==72 || _la==74 || _la==75 || _la==77 || _la==79 || _la==84 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==ASSERT || _la==Identifier ) {
				{
				{
				setState(1003); blockStatement();
				}
				}
				setState(1008);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext<Token> {
		public ConstantExpressionContext constantExpression() {
		    return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumConstantNameContext enumConstantName() {
		    return getRuleContext(EnumConstantNameContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitSwitchLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitSwitchLabel(this);
			else return null;
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, 180);
		enterRule(_localctx, RULE_switchLabel);
		try {
			setState(1019);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(1009); match(17);
					setState(1010); constantExpression();
					setState(1011); match(46);
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(1013); match(17);
					setState(1014); enumConstantName();
					setState(1015); match(46);
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 3);
					{
					setState(1017); match(40);
					setState(1018); match(46);
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForControlContext extends ParserRuleContext<Token> {
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public EnhancedForControlContext enhancedForControl() {
		    return getRuleContext(EnhancedForControlContext.class,0);
		}
		public ForInitContext forInit() {
		    return getRuleContext(ForInitContext.class,0);
		}
		public ForUpdateContext forUpdate() {
		    return getRuleContext(ForUpdateContext.class,0);
		}
		public ForControlContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitForControl(this);
			else return null;
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, 182);
		enterRule(_localctx, RULE_forControl);
		int _la;
		try {
			setState(1033);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(1021); enhancedForControl();
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(1023);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==24 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==62 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
						{
						setState(1022); forInit();
						}
					}

					setState(1025); match(77);
					setState(1027);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
						{
						setState(1026); expression(0);
						}
					}

					setState(1029); match(77);
					setState(1031);
					//_errHandler.sync(this);
					_la = _input.LA(1);
					if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
						{
						setState(1030); forUpdate();
						}
					}

					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext<Token> {
		public ExpressionListContext expressionList() {
		    return getRuleContext(ExpressionListContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
		    return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ForInitContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitForInit(this);
			else return null;
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, 184);
		enterRule(_localctx, RULE_forInit);
		try {
			setState(1037);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(1035); localVariableDeclaration();
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(1036); expressionList();
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForControlContext extends ParserRuleContext<Token> {
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public VariableModifiersContext variableModifiers() {
		    return getRuleContext(VariableModifiersContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public EnhancedForControlContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitEnhancedForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitEnhancedForControl(this);
			else return null;
		}
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, 186);
		enterRule(_localctx, RULE_enhancedForControl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1039); variableModifiers();
			setState(1040); type();
			setState(1041); match(Identifier);
			setState(1042); match(46);
			setState(1043); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForUpdateContext extends ParserRuleContext<Token> {
		public ExpressionListContext expressionList() {
		    return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitForUpdate(this);
			else return null;
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, 188);
		enterRule(_localctx, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1045); expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParExpressionContext extends ParserRuleContext<Token> {
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitParExpression(this);
			else return null;
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, 190);
		enterRule(_localctx, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1047); match(45);
			setState(1048); expression(0);
			setState(1049); match(22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext<Token> {
		public List<? extends ExpressionContext> expression() {
		    return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
		    return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitExpressionList(this);
			else return null;
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, 192);
		enterRule(_localctx, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1051); expression(0);
			setState(1056);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==42 ) {
				{
				{
				setState(1052); match(42);
				setState(1053); expression(0);
				}
				}
				setState(1058);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext<Token> {
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitStatementExpression(this);
			else return null;
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, 194);
		enterRule(_localctx, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext<Token> {
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitConstantExpression(this);
			else return null;
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, 196);
		enterRule(_localctx, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1061); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext<Token> {
		public int _p;
		public List<? extends ExpressionContext> expression() {
		    return getRuleContexts(ExpressionContext.class);
		}
		public ArgumentsContext arguments() {
		    return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionContext expression(int i) {
		    return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext expressionList() {
		    return getRuleContext(ExpressionListContext.class,0);
		}
		public PrimaryContext primary() {
		    return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public ExplicitGenericInvocationContext explicitGenericInvocation() {
		    return getRuleContext(ExplicitGenericInvocationContext.class,0);
		}
		public CreatorContext creator() {
		    return getRuleContext(CreatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext<Token> parent, int state) { super(parent, state); }
		public ExpressionContext(ParserRuleContext<Token> parent, int state, int _p) {
			super(parent, state);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitExpression(this);
			else return null;
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext<Token> _parentctx = _ctx;
		ExpressionContext _localctx = new ExpressionContext(_ctx, 198, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 198;
		pushNewRecursionContext(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1076);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
				case 1:
					{
					setState(1064); match(45);
					setState(1065); type();
					setState(1066); match(22);
					setState(1067); expression(18);
					}
					break;
				case 2:
					{
					setState(1069);
					_input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==6 || _la==44 || _la==67 || _la==72) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1070); expression(15);
					}
					break;
				case 3:
					{
					setState(1071);
					_input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==34 || _la==88) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1072); expression(14);
					}
					break;
				case 4:
					{
					setState(1073); primary();
					}
					break;
				case 5:
					{
					setState(1074); match(29);
					setState(1075); creator();
					}
					break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					_prevctx.stop = _input.LT(-1);
					{
					setState(1202);
					//_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
						case 1:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1078);
							if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
							setState(1079);
							_input.LT(1);
							_la = _input.LA(1);
							if ( !(_la==3 || _la==20 || _la==86) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(1080); expression(14);
							}
							break;
						case 2:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1081);
							if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
							setState(1082);
							_input.LT(1);
							_la = _input.LA(1);
							if ( !(_la==44 || _la==72) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(1083); expression(13);
							}
							break;
						case 3:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1084);
							if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
							setState(1092);
							//_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
								case 1:
									{
									setState(1085); match(5);
									setState(1086); match(5);
									}
									break;
								case 2:
									{
									setState(1087); match(81);
									setState(1088); match(81);
									setState(1089); match(81);
									}
									break;
								case 3:
									{
									setState(1090); match(81);
									setState(1091); match(81);
									}
									break;
							}
							setState(1094); expression(12);
							}
							break;
						case 4:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1095);
							if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
							setState(1102);
							//_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
								case 1:
									{
									setState(1096); match(5);
									setState(1097); match(25);
									}
									break;
								case 2:
									{
									setState(1098); match(81);
									setState(1099); match(25);
									}
									break;
								case 3:
									{
									setState(1100); match(81);
									}
									break;
								case 4:
									{
									setState(1101); match(5);
									}
									break;
							}
							setState(1104); expression(11);
							}
							break;
						case 5:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1105);
							if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
							setState(1106);
							_input.LT(1);
							_la = _input.LA(1);
							if ( !(_la==9 || _la==87) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(1107); expression(9);
							}
							break;
						case 6:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1108);
							if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
							setState(1109); match(2);
							setState(1110); expression(8);
							}
							break;
						case 7:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1111);
							if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
							setState(1112); match(70);
							setState(1113); expression(6);
							}
							break;
						case 8:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1114);
							if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
							setState(1115); match(32);
							setState(1116); expression(6);
							}
							break;
						case 9:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1117);
							if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
							setState(1118); match(78);
							setState(1119); expression(5);
							}
							break;
						case 10:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1120);
							if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
							setState(1121); match(80);
							setState(1122); expression(4);
							}
							break;
						case 11:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1123);
							if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
							setState(1143);
							//_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
								case 1:
									{
									setState(1124); match(61);
									}
									break;
								case 2:
									{
									setState(1125); match(59);
									}
									break;
								case 3:
									{
									setState(1126); match(38);
									}
									break;
								case 4:
									{
									setState(1127); match(21);
									}
									break;
								case 5:
									{
									setState(1128); match(85);
									}
									break;
								case 6:
									{
									setState(1129); match(48);
									}
									break;
								case 7:
									{
									setState(1130); match(28);
									}
									break;
								case 8:
									{
									setState(1131); match(25);
									}
									break;
								case 9:
									{
									setState(1132); match(81);
									setState(1133); match(81);
									setState(1134); match(25);
									}
									break;
								case 10:
									{
									setState(1135); match(81);
									setState(1136); match(81);
									setState(1137); match(81);
									setState(1138); match(25);
									}
									break;
								case 11:
									{
									setState(1139); match(5);
									setState(1140); match(5);
									setState(1141); match(25);
									}
									break;
								case 12:
									{
									setState(1142); match(83);
									}
									break;
							}
							setState(1145); expression(1);
							}
							break;
						case 12:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1146);
							if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
							setState(1147); match(51);
							setState(1148); expression(0);
							setState(1149); match(46);
							setState(1150); expression(3);
							}
							break;
						case 13:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1152);
							if (!(26 >= _localctx._p)) throw new FailedPredicateException(this, "26 >= $_p");
							setState(1153); match(71);
							setState(1154); match(Identifier);
							}
							break;
						case 14:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1155);
							if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
							setState(1156); match(71);
							setState(1157); match(79);
							}
							break;
						case 15:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1158);
							if (!(24 >= _localctx._p)) throw new FailedPredicateException(this, "24 >= $_p");
							setState(1159); match(71);
							setState(1160); match(18);
							setState(1161); match(45);
							setState(1163);
							//_errHandler.sync(this);
							_la = _input.LA(1);
							if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
								{
								setState(1162); expressionList();
								}
							}

							setState(1165); match(22);
							}
							break;
						case 16:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1166);
							if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
							setState(1167); match(71);
							setState(1168); match(29);
							setState(1169); match(Identifier);
							setState(1170); match(45);
							setState(1172);
							//_errHandler.sync(this);
							_la = _input.LA(1);
							if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
								{
								setState(1171); expressionList();
								}
							}

							setState(1174); match(22);
							}
							break;
						case 17:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1175);
							if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
							setState(1176); match(71);
							setState(1177); match(18);
							setState(1178); match(71);
							setState(1179); match(Identifier);
							setState(1181);
							//_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
								case 1:
									{
									setState(1180); arguments();
									}
									break;
							}
							}
							break;
						case 18:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1183);
							if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
							setState(1184); match(71);
							setState(1185); explicitGenericInvocation();
							}
							break;
						case 19:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1186);
							if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
							setState(1187); match(4);
							setState(1188); expression(0);
							setState(1189); match(37);
							}
							break;
						case 20:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1191);
							if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
							setState(1192);
							_input.LT(1);
							_la = _input.LA(1);
							if ( !(_la==6 || _la==67) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							}
							break;
						case 21:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1193);
							if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
							setState(1194); match(45);
							setState(1196);
							//_errHandler.sync(this);
							_la = _input.LA(1);
							if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
								{
								setState(1195); expressionList();
								}
							}

							setState(1198); match(22);
							}
							break;
						case 22:
							{
							_localctx = new ExpressionContext(_parentctx, _startState, _p);
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_expression);
							_localctx.start = _prevctx.start;
							setState(1199);
							if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
							setState(1200); match(89);
							setState(1201); type();
							}
							break;
					}
					} 
				}
				setState(1206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext<Token> {
		public ExpressionContext expression() {
		    return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
		    return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public LiteralContext literal() {
		    return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitPrimary(this);
			else return null;
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, 200);
		enterRule(_localctx, RULE_primary);
		try {
			setState(1222);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
					setState(1207); match(45);
					setState(1208); expression(0);
					setState(1209); match(22);
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
					setState(1211); match(79);
					}
					break;
				case 3:
					enterOuterAlt(_localctx, 3);
					{
					setState(1212); match(18);
					}
					break;
				case 4:
					enterOuterAlt(_localctx, 4);
					{
					setState(1213); literal();
					}
					break;
				case 5:
					enterOuterAlt(_localctx, 5);
					{
					setState(1214); match(Identifier);
					}
					break;
				case 6:
					enterOuterAlt(_localctx, 6);
					{
					setState(1215); type();
					setState(1216); match(71);
					setState(1217); match(30);
					}
					break;
				case 7:
					enterOuterAlt(_localctx, 7);
					{
					setState(1219); match(53);
					setState(1220); match(71);
					setState(1221); match(30);
					}
					break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext<Token> {
		public CreatedNameContext createdName() {
		    return getRuleContext(CreatedNameContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
		    return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
		    return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
		    return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitCreator(this);
			else return null;
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, 202);
		enterRule(_localctx, RULE_creator);
		try {
			setState(1233);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 5:
					enterOuterAlt(_localctx, 1);
					{
					setState(1224); nonWildcardTypeArguments();
					setState(1225); createdName();
					setState(1226); classCreatorRest();
					}
					break;
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
				case Identifier:
					enterOuterAlt(_localctx, 2);
					{
					setState(1228); createdName();
					setState(1231);
					//_errHandler.sync(this);
					switch ( _input.LA(1) ) {
						case 4:
							{
							setState(1229); arrayCreatorRest();
							}
							break;
						case 45:
							{
							setState(1230); classCreatorRest();
							}
							break;
						default :
							throw new NoViableAltException(this);
					}
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatedNameContext extends ParserRuleContext<Token> {
		public PrimitiveTypeContext primitiveType() {
		    return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
		    return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitCreatedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitCreatedName(this);
			else return null;
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, 204);
		enterRule(_localctx, RULE_createdName);
		try {
			setState(1237);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case Identifier:
					enterOuterAlt(_localctx, 1);
					{
					setState(1235); classOrInterfaceType();
					}
					break;
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
					enterOuterAlt(_localctx, 2);
					{
					setState(1236); primitiveType();
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnerCreatorContext extends ParserRuleContext<Token> {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
		    return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ClassCreatorRestContext classCreatorRest() {
		    return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public InnerCreatorContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_innerCreator; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInnerCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInnerCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitInnerCreator(this);
			else return null;
		}
	}

	public final InnerCreatorContext innerCreator() throws RecognitionException {
		InnerCreatorContext _localctx = new InnerCreatorContext(_ctx, 206);
		enterRule(_localctx, RULE_innerCreator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1240);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==5 ) {
				{
				setState(1239); nonWildcardTypeArguments();
				}
			}

			setState(1242); match(Identifier);
			setState(1243); classCreatorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitGenericInvocationContext extends ParserRuleContext<Token> {
		public ArgumentsContext arguments() {
		    return getRuleContext(ArgumentsContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
		    return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public TerminalNode<Token> Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ExplicitGenericInvocationContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterExplicitGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitExplicitGenericInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitExplicitGenericInvocation(this);
			else return null;
		}
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, 208);
		enterRule(_localctx, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1245); nonWildcardTypeArguments();
			setState(1246); match(Identifier);
			setState(1247); arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreatorRestContext extends ParserRuleContext<Token> {
		public List<? extends ExpressionContext> expression() {
		    return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
		    return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayInitializerContext arrayInitializer() {
		    return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreatorRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitArrayCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitArrayCreatorRest(this);
			else return null;
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, 210);
		enterRule(_localctx, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1249); match(4);
			setState(1277);
			//_errHandler.sync(this);
			switch ( _input.LA(1) ) {
				case 37:
					{
					setState(1250); match(37);
					setState(1255);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ( _la==4 ) {
						{
						{
						setState(1251); match(4);
						setState(1252); match(37);
						}
						}
						setState(1257);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1258); arrayInitializer();
					}
					break;
				case 6:
				case 7:
				case 10:
				case 12:
				case 14:
				case 15:
				case 18:
				case 26:
				case 29:
				case 34:
				case 35:
				case 36:
				case 44:
				case 45:
				case 49:
				case 53:
				case 65:
				case 67:
				case 69:
				case 72:
				case 79:
				case 88:
				case HexLiteral:
				case DecimalLiteral:
				case OctalLiteral:
				case FloatingPointLiteral:
				case CharacterLiteral:
				case StringLiteral:
				case Identifier:
					{
					setState(1259); expression(0);
					setState(1260); match(37);
					setState(1267);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1261); match(4);
							setState(1262); expression(0);
							setState(1263); match(37);
							}
							} 
						}
						setState(1269);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
					}
					setState(1274);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1270); match(4);
							setState(1271); match(37);
							}
							} 
						}
						setState(1276);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
					}
					}
					break;
				default :
					throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassCreatorRestContext extends ParserRuleContext<Token> {
		public ArgumentsContext arguments() {
		    return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
		    return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitClassCreatorRest(this);
			else return null;
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, 212);
		enterRule(_localctx, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1279); arguments();
			setState(1281);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
				case 1:
					{
					setState(1280); classBody();
					}
					break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonWildcardTypeArgumentsContext extends ParserRuleContext<Token> {
		public TypeListContext typeList() {
		    return getRuleContext(TypeListContext.class,0);
		}
		public NonWildcardTypeArgumentsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterNonWildcardTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitNonWildcardTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitNonWildcardTypeArguments(this);
			else return null;
		}
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, 214);
		enterRule(_localctx, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1283); match(5);
			setState(1284); typeList();
			setState(1285); match(81);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext<Token> {
		public ExpressionListContext expressionList() {
		    return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<T>)visitor).visitArguments(this);
			else return null;
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, 216);
		enterRule(_localctx, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1287); match(45);
			setState(1289);
			//_errHandler.sync(this);
			_la = _input.LA(1);
			if ( _la==6 || _la==7 || _la==10 || _la==12 || _la==14 || _la==15 || _la==18 || _la==26 || _la==29 || _la==34 || _la==35 || _la==36 || _la==44 || _la==45 || _la==49 || _la==53 || _la==65 || _la==67 || _la==69 || _la==72 || _la==79 || _la==88 || _la==HexLiteral || _la==DecimalLiteral || _la==OctalLiteral || _la==FloatingPointLiteral || _la==CharacterLiteral || _la==StringLiteral || _la==Identifier ) {
				{
				setState(1288); expressionList();
				}
			}

			setState(1291); match(22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch ( ruleIndex ) {
				case 99 : return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	public boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch ( predIndex ) {
			case 0 : return 13 >= _localctx._p;
			case 1 : return 12 >= _localctx._p;
			case 2 : return 11 >= _localctx._p;
			case 3 : return 10 >= _localctx._p;
			case 4 : return 8 >= _localctx._p;
			case 5 : return 7 >= _localctx._p;
			case 6 : return 6 >= _localctx._p;
			case 7 : return 5 >= _localctx._p;
			case 8 : return 4 >= _localctx._p;
			case 9 : return 3 >= _localctx._p;
			case 10 : return 1 >= _localctx._p;
			case 11 : return 2 >= _localctx._p;
			case 12 : return 26 >= _localctx._p;
			case 13 : return 25 >= _localctx._p;
			case 14 : return 24 >= _localctx._p;
			case 15 : return 23 >= _localctx._p;
			case 17 : return 21 >= _localctx._p;
			case 16 : return 22 >= _localctx._p;
			case 19 : return 17 >= _localctx._p;
			case 18 : return 19 >= _localctx._p;
			case 21 : return 9 >= _localctx._p;
			case 20 : return 16 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3e\u050e\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6\2\7"+
		"\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\2\16\7\16\2\17"+
		"\7\17\2\20\7\20\2\21\7\21\2\22\7\22\2\23\7\23\2\24\7\24\2\25\7\25\2\26"+
		"\7\26\2\27\7\27\2\30\7\30\2\31\7\31\2\32\7\32\2\33\7\33\2\34\7\34\2\35"+
		"\7\35\2\36\7\36\2\37\7\37\2 \7 \2!\7!\2\"\7\"\2#\7#\2$\7$\2%\7%\2&\7&"+
		"\2\'\7\'\2(\7(\2)\7)\2*\7*\2+\7+\2,\7,\2-\7-\2.\7.\2/\7/\2\60\7\60\2\61"+
		"\7\61\2\62\7\62\2\63\7\63\2\64\7\64\2\65\7\65\2\66\7\66\2\67\7\67\28\7"+
		"8\29\79\2:\7:\2;\7;\2<\7<\2=\7=\2>\7>\2?\7?\2@\7@\2A\7A\2B\7B\2C\7C\2"+
		"D\7D\2E\7E\2F\7F\2G\7G\2H\7H\2I\7I\2J\7J\2K\7K\2L\7L\2M\7M\2N\7N\2O\7"+
		"O\2P\7P\2Q\7Q\2R\7R\2S\7S\2T\7T\2U\7U\2V\7V\2W\7W\2X\7X\2Y\7Y\2Z\7Z\2"+
		"[\7[\2\\\7\\\2]\7]\2^\7^\2_\7_\2`\7`\2a\7a\2b\7b\2c\7c\2d\7d\2e\7e\2f"+
		"\7f\2g\7g\2h\7h\2i\7i\2j\7j\2k\7k\2l\7l\1\0\3\0\u00dc\b\0\1\0\5\0\u00df"+
		"\b\0\n\0\f\0\u00e2\t\0\1\0\5\0\u00e5\b\0\n\0\f\0\u00e8\t\0\1\0\1\0\1\1"+
		"\1\1\1\1\1\1\1\2\1\2\3\2\u00f2\b\2\1\2\1\2\1\2\3\2\u00f7\b\2\1\2\1\2\1"+
		"\3\5\3\u00fc\b\3\n\3\f\3\u00ff\t\3\1\3\1\3\1\3\3\3\u0104\b\3\1\3\3\3\u0107"+
		"\b\3\1\4\1\4\1\4\3\4\u010c\b\4\1\4\1\4\3\4\u0110\b\4\1\4\1\4\3\4\u0114"+
		"\b\4\1\4\1\4\1\5\1\5\1\5\1\5\3\5\u011c\b\5\1\5\1\5\1\6\1\6\3\6\u0122\b"+
		"\6\1\7\1\7\1\7\1\7\1\7\1\7\1\7\1\7\3\7\u012c\b\7\1\b\5\b\u012f\b\b\n\b"+
		"\f\b\u0132\t\b\1\t\1\t\1\t\1\t\5\t\u0138\b\t\n\t\f\t\u013b\t\t\1\t\1\t"+
		"\1\n\1\n\1\n\3\n\u0142\b\n\1\13\1\13\1\13\5\13\u0147\b\13\n\13\f\13\u014a"+
		"\t\13\1\f\1\f\3\f\u014e\b\f\1\f\3\f\u0151\b\f\1\f\3\f\u0154\b\f\1\f\1"+
		"\f\1\r\1\r\1\r\5\r\u015b\b\r\n\r\f\r\u015e\t\r\1\16\3\16\u0161\b\16\1"+
		"\16\1\16\3\16\u0165\b\16\1\16\3\16\u0168\b\16\1\17\1\17\5\17\u016c\b\17"+
		"\n\17\f\17\u016f\t\17\1\20\1\20\1\20\3\20\u0174\b\20\1\20\1\20\3\20\u0178"+
		"\b\20\1\20\1\20\1\21\1\21\1\21\5\21\u017f\b\21\n\21\f\21\u0182\t\21\1"+
		"\22\1\22\5\22\u0186\b\22\n\22\f\22\u0189\t\22\1\22\1\22\1\23\1\23\5\23"+
		"\u018f\b\23\n\23\f\23\u0192\t\23\1\23\1\23\1\24\1\24\3\24\u0198\b\24\1"+
		"\24\1\24\1\24\1\24\3\24\u019e\b\24\1\25\1\25\1\25\1\25\1\25\1\25\3\25"+
		"\u01a6\b\25\1\26\1\26\1\26\1\26\1\26\5\26\u01ad\b\26\n\26\f\26\u01b0\t"+
		"\26\1\26\1\26\1\26\1\26\1\26\1\26\1\26\3\26\u01b9\b\26\1\27\1\27\3\27"+
		"\u01bd\b\27\1\27\1\27\3\27\u01c1\b\27\1\30\1\30\1\30\1\31\1\31\1\31\1"+
		"\31\1\32\3\32\u01cb\b\32\1\32\1\32\1\32\1\32\3\32\u01d1\b\32\1\32\1\32"+
		"\1\33\1\33\1\33\1\33\3\33\u01d9\b\33\1\34\1\34\1\34\1\34\1\34\1\34\1\34"+
		"\3\34\u01e2\b\34\1\35\1\35\1\35\1\35\1\36\1\36\1\36\1\36\3\36\u01ec\b"+
		"\36\1\37\1\37\1\37\3\37\u01f1\b\37\1\37\1\37\3\37\u01f5\b\37\1 \1 \1 "+
		"\5 \u01fa\b \n \f \u01fd\t \1 \1 \3 \u0201\b \1 \1 \1!\1!\1!\3!\u0208"+
		"\b!\1!\1!\1!\1\"\1\"\1\"\3\"\u0210\b\"\1\"\1\"\1#\1#\1#\1$\1$\1$\5$\u021a"+
		"\b$\n$\f$\u021d\t$\1%\1%\1%\3%\u0222\b%\1&\1&\1&\5&\u0227\b&\n&\f&\u022a"+
		"\t&\1\'\1\'\5\'\u022e\b\'\n\'\f\'\u0231\t\'\1\'\1\'\1\'\1(\1(\1(\5(\u0239"+
		"\b(\n(\f(\u023c\t(\1)\1)\3)\u0240\b)\1*\1*\1*\1*\5*\u0246\b*\n*\f*\u0249"+
		"\t*\1*\3*\u024c\b*\3*\u024e\b*\1*\1*\1+\1+\1+\1+\1+\1+\1+\1+\1+\1+\1+"+
		"\1+\3+\u025e\b+\1,\1,\1-\1-\1.\1.\1/\1/\1/\5/\u0269\b/\n/\f/\u026c\t/"+
		"\1/\1/\1/\5/\u0271\b/\n/\f/\u0274\t/\3/\u0276\b/\1\60\1\60\3\60\u027a"+
		"\b\60\1\60\1\60\1\60\3\60\u027f\b\60\5\60\u0281\b\60\n\60\f\60\u0284\t"+
		"\60\1\61\1\61\1\62\1\62\3\62\u028a\b\62\1\63\1\63\1\63\1\63\5\63\u0290"+
		"\b\63\n\63\f\63\u0293\t\63\1\63\1\63\1\64\1\64\1\64\1\64\3\64\u029b\b"+
		"\64\3\64\u029d\b\64\1\65\1\65\1\65\5\65\u02a2\b\65\n\65\f\65\u02a5\t\65"+
		"\1\66\1\66\3\66\u02a9\b\66\1\66\1\66\1\67\1\67\1\67\1\67\18\18\18\38\u02b4"+
		"\b8\18\18\38\u02b8\b8\19\19\1:\1:\3:\u02be\b:\1:\5:\u02c1\b:\n:\f:\u02c4"+
		"\t:\1:\1:\1;\3;\u02c9\b;\1;\1;\1;\1;\1;\1;\1;\3;\u02d2\b;\1;\1;\1;\1;"+
		"\3;\u02d8\b;\1<\1<\1<\5<\u02dd\b<\n<\f<\u02e0\t<\1=\1=\1=\1=\1=\1=\3="+
		"\u02e8\b=\1>\1>\1?\1?\1@\4@\u02ef\b@\13@\f@\u02f0\1A\1A\1A\1A\1A\3A\u02f8"+
		"\bA\1A\3A\u02fb\bA\1B\1B\1B\5B\u0300\bB\nB\fB\u0303\tB\1C\1C\1C\5C\u0308"+
		"\bC\nC\fC\u030b\tC\1D\1D\1D\1D\1E\1E\1E\3E\u0314\bE\1F\1F\1F\1F\5F\u031a"+
		"\bF\nF\fF\u031d\tF\3F\u031f\bF\1F\3F\u0322\bF\1F\1F\1G\1G\1G\1G\1G\1H"+
		"\1H\5H\u032d\bH\nH\fH\u0330\tH\1H\1H\1I\1I\1I\1J\1J\1J\1J\1J\1J\3J\u033d"+
		"\bJ\1J\1J\3J\u0341\bJ\1J\1J\3J\u0345\bJ\1J\1J\3J\u0349\bJ\3J\u034b\bJ"+
		"\1K\1K\3K\u034f\bK\1L\1L\1L\1L\3L\u0355\bL\1M\1M\1N\1N\1N\1O\1O\5O\u035e"+
		"\bO\nO\fO\u0361\tO\1O\1O\1P\1P\1P\1P\3P\u0369\bP\1Q\1Q\1Q\1R\1R\1R\1R"+
		"\1S\5S\u0373\bS\nS\fS\u0376\tS\1T\1T\1T\1T\1T\3T\u037d\bT\1T\1T\1T\1T"+
		"\1T\1T\1T\3T\u0386\bT\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T"+
		"\1T\1T\1T\1T\1T\1T\1T\1T\1T\3T\u03a1\bT\1T\1T\1T\1T\1T\1T\1T\1T\1T\1T"+
		"\3T\u03ad\bT\1T\1T\1T\1T\1T\1T\1T\3T\u03b6\bT\1T\1T\1T\3T\u03bb\bT\1T"+
		"\1T\1T\1T\1T\1T\1T\1T\3T\u03c5\bT\1U\1U\5U\u03c9\bU\nU\fU\u03cc\tU\1V"+
		"\1V\1V\1V\1V\1V\1W\1W\1W\1W\1X\1X\5X\u03da\bX\nX\fX\u03dd\tX\1X\5X\u03e0"+
		"\bX\nX\fX\u03e3\tX\1X\1X\1Y\4Y\u03e8\bY\13Y\fY\u03e9\1Y\5Y\u03ed\bY\n"+
		"Y\fY\u03f0\tY\1Z\1Z\1Z\1Z\1Z\1Z\1Z\1Z\1Z\1Z\3Z\u03fc\bZ\1[\1[\3[\u0400"+
		"\b[\1[\1[\3[\u0404\b[\1[\1[\3[\u0408\b[\3[\u040a\b[\1\\\1\\\3\\\u040e"+
		"\b\\\1]\1]\1]\1]\1]\1]\1^\1^\1_\1_\1_\1_\1`\1`\1`\5`\u041f\b`\n`\f`\u0422"+
		"\t`\1a\1a\1b\1b\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\3c\u0435\bc\1c"+
		"\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\3c\u0445\bc\1c\1c\1c\1c\1c\1c"+
		"\1c\1c\3c\u044f\bc\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c"+
		"\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\3c"+
		"\u0478\bc\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\3c\u048c"+
		"\bc\1c\1c\1c\1c\1c\1c\1c\3c\u0495\bc\1c\1c\1c\1c\1c\1c\1c\3c\u049e\bc"+
		"\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\1c\3c\u04ad\bc\1c\1c\1c\1c\5c\u04b3"+
		"\bc\nc\fc\u04b6\tc\1d\1d\1d\1d\1d\1d\1d\1d\1d\1d\1d\1d\1d\1d\1d\3d\u04c7"+
		"\bd\1e\1e\1e\1e\1e\1e\1e\3e\u04d0\be\3e\u04d2\be\1f\1f\3f\u04d6\bf\1g"+
		"\3g\u04d9\bg\1g\1g\1g\1h\1h\1h\1h\1i\1i\1i\1i\5i\u04e6\bi\ni\fi\u04e9"+
		"\ti\1i\1i\1i\1i\1i\1i\1i\5i\u04f2\bi\ni\fi\u04f5\ti\1i\1i\5i\u04f9\bi"+
		"\ni\fi\u04fc\ti\3i\u04fe\bi\1j\1j\3j\u0502\bj\1k\1k\1k\1k\1l\1l\3l\u050a"+
		"\bl\1l\1l\1lm\0\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8"+
		"\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0"+
		"\u00d2\u00d4\u00d6\u00d8\0\13\6\n\n\f\f\16\17#$\61\61EE\2\22\22<<\2\22"+
		"\22OO\1Z\\\2\7\7AA\4\6\6,,CCHH\2\"\"XX\3\3\3\24\24VV\2,,HH\2\t\tWW\2\6"+
		"\6CC\u0589\0\u00db\1\0\0\0\2\u00eb\1\0\0\0\4\u00ef\1\0\0\0\6\u0106\1\0"+
		"\0\0\b\u0108\1\0\0\0\n\u0117\1\0\0\0\f\u0121\1\0\0\0\16\u012b\1\0\0\0"+
		"\20\u0130\1\0\0\0\22\u0133\1\0\0\0\24\u013e\1\0\0\0\26\u0143\1\0\0\0\30"+
		"\u014b\1\0\0\0\32\u0157\1\0\0\0\34\u0160\1\0\0\0\36\u0169\1\0\0\0 \u0170"+
		"\1\0\0\0\"\u017b\1\0\0\0$\u0183\1\0\0\0&\u018c\1\0\0\0(\u019d\1\0\0\0"+
		"*\u01a5\1\0\0\0,\u01b8\1\0\0\0.\u01bc\1\0\0\0\60\u01c2\1\0\0\0\62\u01c5"+
		"\1\0\0\0\64\u01ca\1\0\0\0\66\u01d8\1\0\0\08\u01e1\1\0\0\0:\u01e3\1\0\0"+
		"\0<\u01eb\1\0\0\0>\u01ed\1\0\0\0@\u01f6\1\0\0\0B\u0204\1\0\0\0D\u020c"+
		"\1\0\0\0F\u0213\1\0\0\0H\u0216\1\0\0\0J\u021e\1\0\0\0L\u0223\1\0\0\0N"+
		"\u022f\1\0\0\0P\u0235\1\0\0\0R\u023f\1\0\0\0T\u0241\1\0\0\0V\u025d\1\0"+
		"\0\0X\u025f\1\0\0\0Z\u0261\1\0\0\0\\\u0263\1\0\0\0^\u0275\1\0\0\0`\u0277"+
		"\1\0\0\0b\u0285\1\0\0\0d\u0289\1\0\0\0f\u028b\1\0\0\0h\u029c\1\0\0\0j"+
		"\u029e\1\0\0\0l\u02a6\1\0\0\0n\u02ac\1\0\0\0p\u02b7\1\0\0\0r\u02b9\1\0"+
		"\0\0t\u02bb\1\0\0\0v\u02d7\1\0\0\0x\u02d9\1\0\0\0z\u02e7\1\0\0\0|\u02e9"+
		"\1\0\0\0~\u02eb\1\0\0\0\u0080\u02ee\1\0\0\0\u0082\u02f2\1\0\0\0\u0084"+
		"\u02fc\1\0\0\0\u0086\u0304\1\0\0\0\u0088\u030c\1\0\0\0\u008a\u0313\1\0"+
		"\0\0\u008c\u0315\1\0\0\0\u008e\u0325\1\0\0\0\u0090\u032a\1\0\0\0\u0092"+
		"\u0333\1\0\0\0\u0094\u034a\1\0\0\0\u0096\u034e\1\0\0\0\u0098\u0350\1\0"+
		"\0\0\u009a\u0356\1\0\0\0\u009c\u0358\1\0\0\0\u009e\u035b\1\0\0\0\u00a0"+
		"\u0368\1\0\0\0\u00a2\u036a\1\0\0\0\u00a4\u036d\1\0\0\0\u00a6\u0374\1\0"+
		"\0\0\u00a8\u03c4\1\0\0\0\u00aa\u03c6\1\0\0\0\u00ac\u03cd\1\0\0\0\u00ae"+
		"\u03d3\1\0\0\0\u00b0\u03d7\1\0\0\0\u00b2\u03e7\1\0\0\0\u00b4\u03fb\1\0"+
		"\0\0\u00b6\u0409\1\0\0\0\u00b8\u040d\1\0\0\0\u00ba\u040f\1\0\0\0\u00bc"+
		"\u0415\1\0\0\0\u00be\u0417\1\0\0\0\u00c0\u041b\1\0\0\0\u00c2\u0423\1\0"+
		"\0\0\u00c4\u0425\1\0\0\0\u00c6\u0434\1\0\0\0\u00c8\u04c6\1\0\0\0\u00ca"+
		"\u04d1\1\0\0\0\u00cc\u04d5\1\0\0\0\u00ce\u04d8\1\0\0\0\u00d0\u04dd\1\0"+
		"\0\0\u00d2\u04e1\1\0\0\0\u00d4\u04ff\1\0\0\0\u00d6\u0503\1\0\0\0\u00d8"+
		"\u0507\1\0\0\0\u00da\u00dc\3\2\1\0\u00db\u00da\1\0\0\0\u00db\u00dc\1\0"+
		"\0\0\u00dc\u00e0\1\0\0\0\u00dd\u00df\3\4\2\0\u00de\u00dd\1\0\0\0\u00df"+
		"\u00e2\1\0\0\0\u00e0\u00de\1\0\0\0\u00e0\u00e1\1\0\0\0\u00e1\u00e6\1\0"+
		"\0\0\u00e2\u00e0\1\0\0\0\u00e3\u00e5\3\6\3\0\u00e4\u00e3\1\0\0\0\u00e5"+
		"\u00e8\1\0\0\0\u00e6\u00e4\1\0\0\0\u00e6\u00e7\1\0\0\0\u00e7\u00e9\1\0"+
		"\0\0\u00e8\u00e6\1\0\0\0\u00e9\u00ea\5\uffff\0\0\u00ea\1\1\0\0\0\u00eb"+
		"\u00ec\5\66\0\0\u00ec\u00ed\3x<\0\u00ed\u00ee\5M\0\0\u00ee\3\1\0\0\0\u00ef"+
		"\u00f1\5D\0\0\u00f0\u00f2\5B\0\0\u00f1\u00f0\1\0\0\0\u00f1\u00f2\1\0\0"+
		"\0\u00f2\u00f3\1\0\0\0\u00f3\u00f6\3x<\0\u00f4\u00f5\5G\0\0\u00f5\u00f7"+
		"\5\3\0\0\u00f6\u00f4\1\0\0\0\u00f6\u00f7\1\0\0\0\u00f7\u00f8\1\0\0\0\u00f8"+
		"\u00f9\5M\0\0\u00f9\5\1\0\0\0\u00fa\u00fc\3\16\7\0\u00fb\u00fa\1\0\0\0"+
		"\u00fc\u00ff\1\0\0\0\u00fd\u00fb\1\0\0\0\u00fd\u00fe\1\0\0\0\u00fe\u0103"+
		"\1\0\0\0\u00ff\u00fd\1\0\0\0\u0100\u0104\3\b\4\0\u0101\u0104\3\f\6\0\u0102"+
		"\u0104\3\n\5\0\u0103\u0100\1\0\0\0\u0103\u0101\1\0\0\0\u0103\u0102\1\0"+
		"\0\0\u0104\u0107\1\0\0\0\u0105\u0107\5M\0\0\u0106\u00fd\1\0\0\0\u0106"+
		"\u0105\1\0\0\0\u0107\7\1\0\0\0\u0108\u0109\5\36\0\0\u0109\u010b\5b\0\0"+
		"\u010a\u010c\3\22\t\0\u010b\u010a\1\0\0\0\u010b\u010c\1\0\0\0\u010c\u010f"+
		"\1\0\0\0\u010d\u010e\5<\0\0\u010e\u0110\3^/\0\u010f\u010d\1\0\0\0\u010f"+
		"\u0110\1\0\0\0\u0110\u0113\1\0\0\0\u0111\u0112\5R\0\0\u0112\u0114\3\""+
		"\21\0\u0113\u0111\1\0\0\0\u0113\u0114\1\0\0\0\u0114\u0115\1\0\0\0\u0115"+
		"\u0116\3$\22\0\u0116\t\1\0\0\0\u0117\u0118\5`\0\0\u0118\u011b\5b\0\0\u0119"+
		"\u011a\5R\0\0\u011a\u011c\3\"\21\0\u011b\u0119\1\0\0\0\u011b\u011c\1\0"+
		"\0\0\u011c\u011d\1\0\0\0\u011d\u011e\3\30\f\0\u011e\13\1\0\0\0\u011f\u0122"+
		"\3 \20\0\u0120\u0122\3\u008eG\0\u0121\u011f\1\0\0\0\u0121\u0120\1\0\0"+
		"\0\u0122\r\1\0\0\0\u0123\u012c\3\u0082A\0\u0124\u012c\5\'\0\0\u0125\u012c"+
		"\5I\0\0\u0126\u012c\5\62\0\0\u0127\u012c\5\13\0\0\u0128\u012c\5B\0\0\u0129"+
		"\u012c\5>\0\0\u012a\u012c\5\20\0\0\u012b\u0123\1\0\0\0\u012b\u0124\1\0"+
		"\0\0\u012b\u0125\1\0\0\0\u012b\u0126\1\0\0\0\u012b\u0127\1\0\0\0\u012b"+
		"\u0128\1\0\0\0\u012b\u0129\1\0\0\0\u012b\u012a\1\0\0\0\u012c\17\1\0\0"+
		"\0\u012d\u012f\3V+\0\u012e\u012d\1\0\0\0\u012f\u0132\1\0\0\0\u0130\u012e"+
		"\1\0\0\0\u0130\u0131\1\0\0\0\u0131\21\1\0\0\0\u0132\u0130\1\0\0\0\u0133"+
		"\u0134\5\5\0\0\u0134\u0139\3\24\n\0\u0135\u0136\5*\0\0\u0136\u0138\3\24"+
		"\n\0\u0137\u0135\1\0\0\0\u0138\u013b\1\0\0\0\u0139\u0137\1\0\0\0\u0139"+
		"\u013a\1\0\0\0\u013a\u013c\1\0\0\0\u013b\u0139\1\0\0\0\u013c\u013d\5Q"+
		"\0\0\u013d\23\1\0\0\0\u013e\u0141\5b\0\0\u013f\u0140\5<\0\0\u0140\u0142"+
		"\3\26\13\0\u0141\u013f\1\0\0\0\u0141\u0142\1\0\0\0\u0142\25\1\0\0\0\u0143"+
		"\u0148\3^/\0\u0144\u0145\5\2\0\0\u0145\u0147\3^/\0\u0146\u0144\1\0\0\0"+
		"\u0147\u014a\1\0\0\0\u0148\u0146\1\0\0\0\u0148\u0149\1\0\0\0\u0149\27"+
		"\1\0\0\0\u014a\u0148\1\0\0\0\u014b\u014d\58\0\0\u014c\u014e\3\32\r\0\u014d"+
		"\u014c\1\0\0\0\u014d\u014e\1\0\0\0\u014e\u0150\1\0\0\0\u014f\u0151\5*"+
		"\0\0\u0150\u014f\1\0\0\0\u0150\u0151\1\0\0\0\u0151\u0153\1\0\0\0\u0152"+
		"\u0154\3\36\17\0\u0153\u0152\1\0\0\0\u0153\u0154\1\0\0\0\u0154\u0155\1"+
		"\0\0\0\u0155\u0156\5\r\0\0\u0156\31\1\0\0\0\u0157\u015c\3\34\16\0\u0158"+
		"\u0159\5*\0\0\u0159\u015b\3\34\16\0\u015a\u0158\1\0\0\0\u015b\u015e\1"+
		"\0\0\0\u015c\u015a\1\0\0\0\u015c\u015d\1\0\0\0\u015d\33\1\0\0\0\u015e"+
		"\u015c\1\0\0\0\u015f\u0161\3\u0080@\0\u0160\u015f\1\0\0\0\u0160\u0161"+
		"\1\0\0\0\u0161\u0162\1\0\0\0\u0162\u0164\5b\0\0\u0163\u0165\3\u00d8l\0"+
		"\u0164\u0163\1\0\0\0\u0164\u0165\1\0\0\0\u0165\u0167\1\0\0\0\u0166\u0168"+
		"\3$\22\0\u0167\u0166\1\0\0\0\u0167\u0168\1\0\0\0\u0168\35\1\0\0\0\u0169"+
		"\u016d\5M\0\0\u016a\u016c\3(\24\0\u016b\u016a\1\0\0\0\u016c\u016f\1\0"+
		"\0\0\u016d\u016b\1\0\0\0\u016d\u016e\1\0\0\0\u016e\37\1\0\0\0\u016f\u016d"+
		"\1\0\0\0\u0170\u0171\5\1\0\0\u0171\u0173\5b\0\0\u0172\u0174\3\22\t\0\u0173"+
		"\u0172\1\0\0\0\u0173\u0174\1\0\0\0\u0174\u0177\1\0\0\0\u0175\u0176\5<"+
		"\0\0\u0176\u0178\3\"\21\0\u0177\u0175\1\0\0\0\u0177\u0178\1\0\0\0\u0178"+
		"\u0179\1\0\0\0\u0179\u017a\3&\23\0\u017a!\1\0\0\0\u017b\u0180\3^/\0\u017c"+
		"\u017d\5*\0\0\u017d\u017f\3^/\0\u017e\u017c\1\0\0\0\u017f\u0182\1\0\0"+
		"\0\u0180\u017e\1\0\0\0\u0180\u0181\1\0\0\0\u0181#\1\0\0\0\u0182\u0180"+
		"\1\0\0\0\u0183\u0187\58\0\0\u0184\u0186\3(\24\0\u0185\u0184\1\0\0\0\u0186"+
		"\u0189\1\0\0\0\u0187\u0185\1\0\0\0\u0187\u0188\1\0\0\0\u0188\u018a\1\0"+
		"\0\0\u0189\u0187\1\0\0\0\u018a\u018b\5\r\0\0\u018b%\1\0\0\0\u018c\u0190"+
		"\58\0\0\u018d\u018f\3\66\33\0\u018e\u018d\1\0\0\0\u018f\u0192\1\0\0\0"+
		"\u0190\u018e\1\0\0\0\u0190\u0191\1\0\0\0\u0191\u0193\1\0\0\0\u0192\u0190"+
		"\1\0\0\0\u0193\u0194\5\r\0\0\u0194\'\1\0\0\0\u0195\u019e\5M\0\0\u0196"+
		"\u0198\5B\0\0\u0197\u0196\1\0\0\0\u0197\u0198\1\0\0\0\u0198\u0199\1\0"+
		"\0\0\u0199\u019e\3\u009eO\0\u019a\u019b\3\20\b\0\u019b\u019c\3*\25\0\u019c"+
		"\u019e\1\0\0\0\u019d\u0195\1\0\0\0\u019d\u0197\1\0\0\0\u019d\u019a\1\0"+
		"\0\0\u019e)\1\0\0\0\u019f\u01a6\3\60\30\0\u01a0\u01a6\3,\26\0\u01a1\u01a6"+
		"\3\62\31\0\u01a2\u01a6\3\64\32\0\u01a3\u01a6\3\f\6\0\u01a4\u01a6\3\b\4"+
		"\0\u01a5\u019f\1\0\0\0\u01a5\u01a0\1\0\0\0\u01a5\u01a1\1\0\0\0\u01a5\u01a2"+
		"\1\0\0\0\u01a5\u01a3\1\0\0\0\u01a5\u01a4\1\0\0\0\u01a6+\1\0\0\0\u01a7"+
		"\u01a8\3^/\0\u01a8\u01a9\5b\0\0\u01a9\u01ae\3l\66\0\u01aa\u01ab\5\4\0"+
		"\0\u01ab\u01ad\5%\0\0\u01ac\u01aa\1\0\0\0\u01ad\u01b0\1\0\0\0\u01ae\u01ac"+
		"\1\0\0\0\u01ae\u01af\1\0\0\0\u01af\u01b1\1\0\0\0\u01b0\u01ae\1\0\0\0\u01b1"+
		"\u01b2\3.\27\0\u01b2\u01b9\1\0\0\0\u01b3\u01b4\5\65\0\0\u01b4\u01b5\5"+
		"b\0\0\u01b5\u01b6\3l\66\0\u01b6\u01b7\3.\27\0\u01b7\u01b9\1\0\0\0\u01b8"+
		"\u01a7\1\0\0\0\u01b8\u01b3\1\0\0\0\u01b9-\1\0\0\0\u01ba\u01bb\5\33\0\0"+
		"\u01bb\u01bd\3j\65\0\u01bc\u01ba\1\0\0\0\u01bc\u01bd\1\0\0\0\u01bd\u01c0"+
		"\1\0\0\0\u01be\u01c1\3r9\0\u01bf\u01c1\5M\0\0\u01c0\u01be\1\0\0\0\u01c0"+
		"\u01bf\1\0\0\0\u01c1/\1\0\0\0\u01c2\u01c3\3\22\t\0\u01c3\u01c4\3,\26\0"+
		"\u01c4\61\1\0\0\0\u01c5\u01c6\3^/\0\u01c6\u01c7\3H$\0\u01c7\u01c8\5M\0"+
		"\0\u01c8\63\1\0\0\0\u01c9\u01cb\3\22\t\0\u01ca\u01c9\1\0\0\0\u01ca\u01cb"+
		"\1\0\0\0\u01cb\u01cc\1\0\0\0\u01cc\u01cd\5b\0\0\u01cd\u01d0\3l\66\0\u01ce"+
		"\u01cf\5\33\0\0\u01cf\u01d1\3j\65\0\u01d0\u01ce\1\0\0\0\u01d0\u01d1\1"+
		"\0\0\0\u01d1\u01d2\1\0\0\0\u01d2\u01d3\3t:\0\u01d3\65\1\0\0\0\u01d4\u01d5"+
		"\3\20\b\0\u01d5\u01d6\38\34\0\u01d6\u01d9\1\0\0\0\u01d7\u01d9\5M\0\0\u01d8"+
		"\u01d4\1\0\0\0\u01d8\u01d7\1\0\0\0\u01d9\67\1\0\0\0\u01da\u01e2\3:\35"+
		"\0\u01db\u01e2\3B!\0\u01dc\u01dd\5\65\0\0\u01dd\u01de\5b\0\0\u01de\u01e2"+
		"\3D\"\0\u01df\u01e2\3\f\6\0\u01e0\u01e2\3\b\4\0\u01e1\u01da\1\0\0\0\u01e1"+
		"\u01db\1\0\0\0\u01e1\u01dc\1\0\0\0\u01e1\u01df\1\0\0\0\u01e1\u01e0\1\0"+
		"\0\0\u01e29\1\0\0\0\u01e3\u01e4\3^/\0\u01e4\u01e5\5b\0\0\u01e5\u01e6\3"+
		"<\36\0\u01e6;\1\0\0\0\u01e7\u01e8\3L&\0\u01e8\u01e9\5M\0\0\u01e9\u01ec"+
		"\1\0\0\0\u01ea\u01ec\3@ \0\u01eb\u01e7\1\0\0\0\u01eb\u01ea\1\0\0\0\u01ec"+
		"=\1\0\0\0\u01ed\u01f0\3l\66\0\u01ee\u01ef\5\33\0\0\u01ef\u01f1\3j\65\0"+
		"\u01f0\u01ee\1\0\0\0\u01f0\u01f1\1\0\0\0\u01f1\u01f4\1\0\0\0\u01f2\u01f5"+
		"\3r9\0\u01f3\u01f5\5M\0\0\u01f4\u01f2\1\0\0\0\u01f4\u01f3\1\0\0\0\u01f5"+
		"?\1\0\0\0\u01f6\u01fb\3l\66\0\u01f7\u01f8\5\4\0\0\u01f8\u01fa\5%\0\0\u01f9"+
		"\u01f7\1\0\0\0\u01fa\u01fd\1\0\0\0\u01fb\u01f9\1\0\0\0\u01fb\u01fc\1\0"+
		"\0\0\u01fc\u0200\1\0\0\0\u01fd\u01fb\1\0\0\0\u01fe\u01ff\5\33\0\0\u01ff"+
		"\u0201\3j\65\0\u0200\u01fe\1\0\0\0\u0200\u0201\1\0\0\0\u0201\u0202\1\0"+
		"\0\0\u0202\u0203\5M\0\0\u0203A\1\0\0\0\u0204\u0207\3\22\t\0\u0205\u0208"+
		"\3^/\0\u0206\u0208\5\65\0\0\u0207\u0205\1\0\0\0\u0207\u0206\1\0\0\0\u0208"+
		"\u0209\1\0\0\0\u0209\u020a\5b\0\0\u020a\u020b\3@ \0\u020bC\1\0\0\0\u020c"+
		"\u020f\3l\66\0\u020d\u020e\5\33\0\0\u020e\u0210\3j\65\0\u020f\u020d\1"+
		"\0\0\0\u020f\u0210\1\0\0\0\u0210\u0211\1\0\0\0\u0211\u0212\5M\0\0\u0212"+
		"E\1\0\0\0\u0213\u0214\5b\0\0\u0214\u0215\3N\'\0\u0215G\1\0\0\0\u0216\u021b"+
		"\3J%\0\u0217\u0218\5*\0\0\u0218\u021a\3J%\0\u0219\u0217\1\0\0\0\u021a"+
		"\u021d\1\0\0\0\u021b\u0219\1\0\0\0\u021b\u021c\1\0\0\0\u021cI\1\0\0\0"+
		"\u021d\u021b\1\0\0\0\u021e\u0221\3P(\0\u021f\u0220\5\31\0\0\u0220\u0222"+
		"\3R)\0\u0221\u021f\1\0\0\0\u0221\u0222\1\0\0\0\u0222K\1\0\0\0\u0223\u0228"+
		"\3N\'\0\u0224\u0225\5*\0\0\u0225\u0227\3F#\0\u0226\u0224\1\0\0\0\u0227"+
		"\u022a\1\0\0\0\u0228\u0226\1\0\0\0\u0228\u0229\1\0\0\0\u0229M\1\0\0\0"+
		"\u022a\u0228\1\0\0\0\u022b\u022c\5\4\0\0\u022c\u022e\5%\0\0\u022d\u022b"+
		"\1\0\0\0\u022e\u0231\1\0\0\0\u022f\u022d\1\0\0\0\u022f\u0230\1\0\0\0\u0230"+
		"\u0232\1\0\0\0\u0231\u022f\1\0\0\0\u0232\u0233\5\31\0\0\u0233\u0234\3"+
		"R)\0\u0234O\1\0\0\0\u0235\u023a\5b\0\0\u0236\u0237\5\4\0\0\u0237\u0239"+
		"\5%\0\0\u0238\u0236\1\0\0\0\u0239\u023c\1\0\0\0\u023a\u0238\1\0\0\0\u023a"+
		"\u023b\1\0\0\0\u023bQ\1\0\0\0\u023c\u023a\1\0\0\0\u023d\u0240\3T*\0\u023e"+
		"\u0240\3\u00c6c\0\u023f\u023d\1\0\0\0\u023f\u023e\1\0\0\0\u0240S\1\0\0"+
		"\0\u0241\u024d\58\0\0\u0242\u0247\3R)\0\u0243\u0244\5*\0\0\u0244\u0246"+
		"\3R)\0\u0245\u0243\1\0\0\0\u0246\u0249\1\0\0\0\u0247\u0245\1\0\0\0\u0247"+
		"\u0248\1\0\0\0\u0248\u024b\1\0\0\0\u0249\u0247\1\0\0\0\u024a\u024c\5*"+
		"\0\0\u024b\u024a\1\0\0\0\u024b\u024c\1\0\0\0\u024c\u024e\1\0\0\0\u024d"+
		"\u0242\1\0\0\0\u024d\u024e\1\0\0\0\u024e\u024f\1\0\0\0\u024f\u0250\5\r"+
		"\0\0\u0250U\1\0\0\0\u0251\u025e\3\u0082A\0\u0252\u025e\5\'\0\0\u0253\u025e"+
		"\5I\0\0\u0254\u025e\5\62\0\0\u0255\u025e\5B\0\0\u0256\u025e\5\13\0\0\u0257"+
		"\u025e\5>\0\0\u0258\u025e\5:\0\0\u0259\u025e\5)\0\0\u025a\u025e\5!\0\0"+
		"\u025b\u025e\5L\0\0\u025c\u025e\5\20\0\0\u025d\u0251\1\0\0\0\u025d\u0252"+
		"\1\0\0\0\u025d\u0253\1\0\0\0\u025d\u0254\1\0\0\0\u025d\u0255\1\0\0\0\u025d"+
		"\u0256\1\0\0\0\u025d\u0257\1\0\0\0\u025d\u0258\1\0\0\0\u025d\u0259\1\0"+
		"\0\0\u025d\u025a\1\0\0\0\u025d\u025b\1\0\0\0\u025d\u025c\1\0\0\0\u025e"+
		"W\1\0\0\0\u025f\u0260\3x<\0\u0260Y\1\0\0\0\u0261\u0262\5b\0\0\u0262[\1"+
		"\0\0\0\u0263\u0264\3x<\0\u0264]\1\0\0\0\u0265\u026a\3`\60\0\u0266\u0267"+
		"\5\4\0\0\u0267\u0269\5%\0\0\u0268\u0266\1\0\0\0\u0269\u026c\1\0\0\0\u026a"+
		"\u0268\1\0\0\0\u026a\u026b\1\0\0\0\u026b\u0276\1\0\0\0\u026c\u026a\1\0"+
		"\0\0\u026d\u0272\3b\61\0\u026e\u026f\5\4\0\0\u026f\u0271\5%\0\0\u0270"+
		"\u026e\1\0\0\0\u0271\u0274\1\0\0\0\u0272\u0270\1\0\0\0\u0272\u0273\1\0"+
		"\0\0\u0273\u0276\1\0\0\0\u0274\u0272\1\0\0\0\u0275\u0265\1\0\0\0\u0275"+
		"\u026d\1\0\0\0\u0276_\1\0\0\0\u0277\u0279\5b\0\0\u0278\u027a\3f\63\0\u0279"+
		"\u0278\1\0\0\0\u0279\u027a\1\0\0\0\u027a\u0282\1\0\0\0\u027b\u027c\5G"+
		"\0\0\u027c\u027e\5b\0\0\u027d\u027f\3f\63\0\u027e\u027d\1\0\0\0\u027e"+
		"\u027f\1\0\0\0\u027f\u0281\1\0\0\0\u0280\u027b\1\0\0\0\u0281\u0284\1\0"+
		"\0\0\u0282\u0280\1\0\0\0\u0282\u0283\1\0\0\0\u0283a\1\0\0\0\u0284\u0282"+
		"\1\0\0\0\u0285\u0286\7\0\0\0\u0286c\1\0\0\0\u0287\u028a\5>\0\0\u0288\u028a"+
		"\3\u0082A\0\u0289\u0287\1\0\0\0\u0289\u0288\1\0\0\0\u028ae\1\0\0\0\u028b"+
		"\u028c\5\5\0\0\u028c\u0291\3h\64\0\u028d\u028e\5*\0\0\u028e\u0290\3h\64"+
		"\0\u028f\u028d\1\0\0\0\u0290\u0293\1\0\0\0\u0291\u028f\1\0\0\0\u0291\u0292"+
		"\1\0\0\0\u0292\u0294\1\0\0\0\u0293\u0291\1\0\0\0\u0294\u0295\5Q\0\0\u0295"+
		"g\1\0\0\0\u0296\u029d\3^/\0\u0297\u029a\5\63\0\0\u0298\u0299\7\1\0\0\u0299"+
		"\u029b\3^/\0\u029a\u0298\1\0\0\0\u029a\u029b\1\0\0\0\u029b\u029d\1\0\0"+
		"\0\u029c\u0296\1\0\0\0\u029c\u0297\1\0\0\0\u029di\1\0\0\0\u029e\u02a3"+
		"\3x<\0\u029f\u02a0\5*\0\0\u02a0\u02a2\3x<\0\u02a1\u029f\1\0\0\0\u02a2"+
		"\u02a5\1\0\0\0\u02a3\u02a1\1\0\0\0\u02a3\u02a4\1\0\0\0\u02a4k\1\0\0\0"+
		"\u02a5\u02a3\1\0\0\0\u02a6\u02a8\5-\0\0\u02a7\u02a9\3n\67\0\u02a8\u02a7"+
		"\1\0\0\0\u02a8\u02a9\1\0\0\0\u02a9\u02aa\1\0\0\0\u02aa\u02ab\5\26\0\0"+
		"\u02abm\1\0\0\0\u02ac\u02ad\3\u00a6S\0\u02ad\u02ae\3^/\0\u02ae\u02af\3"+
		"p8\0\u02afo\1\0\0\0\u02b0\u02b3\3P(\0\u02b1\u02b2\5*\0\0\u02b2\u02b4\3"+
		"n\67\0\u02b3\u02b1\1\0\0\0\u02b3\u02b4\1\0\0\0\u02b4\u02b8\1\0\0\0\u02b5"+
		"\u02b6\5\67\0\0\u02b6\u02b8\3P(\0\u02b7\u02b0\1\0\0\0\u02b7\u02b5\1\0"+
		"\0\0\u02b8q\1\0\0\0\u02b9\u02ba\3\u009eO\0\u02bas\1\0\0\0\u02bb\u02bd"+
		"\58\0\0\u02bc\u02be\3v;\0\u02bd\u02bc\1\0\0\0\u02bd\u02be\1\0\0\0\u02be"+
		"\u02c2\1\0\0\0\u02bf\u02c1\3\u00a0P\0\u02c0\u02bf\1\0\0\0\u02c1\u02c4"+
		"\1\0\0\0\u02c2\u02c0\1\0\0\0\u02c2\u02c3\1\0\0\0\u02c3\u02c5\1\0\0\0\u02c4"+
		"\u02c2\1\0\0\0\u02c5\u02c6\5\r\0\0\u02c6u\1\0\0\0\u02c7\u02c9\3\u00d6"+
		"k\0\u02c8\u02c7\1\0\0\0\u02c8\u02c9\1\0\0\0\u02c9\u02ca\1\0\0\0\u02ca"+
		"\u02cb\7\2\0\0\u02cb\u02cc\3\u00d8l\0\u02cc\u02cd\5M\0\0\u02cd\u02d8\1"+
		"\0\0\0\u02ce\u02cf\3\u00c8d\0\u02cf\u02d1\5G\0\0\u02d0\u02d2\3\u00d6k"+
		"\0\u02d1\u02d0\1\0\0\0\u02d1\u02d2\1\0\0\0\u02d2\u02d3\1\0\0\0\u02d3\u02d4"+
		"\5\22\0\0\u02d4\u02d5\3\u00d8l\0\u02d5\u02d6\5M\0\0\u02d6\u02d8\1\0\0"+
		"\0\u02d7\u02c8\1\0\0\0\u02d7\u02ce\1\0\0\0\u02d8w\1\0\0\0\u02d9\u02de"+
		"\5b\0\0\u02da\u02db\5G\0\0\u02db\u02dd\5b\0\0\u02dc\u02da\1\0\0\0\u02dd"+
		"\u02e0\1\0\0\0\u02de\u02dc\1\0\0\0\u02de\u02df\1\0\0\0\u02dfy\1\0\0\0"+
		"\u02e0\u02de\1\0\0\0\u02e1\u02e8\3|>\0\u02e2\u02e8\5]\0\0\u02e3\u02e8"+
		"\5^\0\0\u02e4\u02e8\5_\0\0\u02e5\u02e8\3~?\0\u02e6\u02e8\5\32\0\0\u02e7"+
		"\u02e1\1\0\0\0\u02e7\u02e2\1\0\0\0\u02e7\u02e3\1\0\0\0\u02e7\u02e4\1\0"+
		"\0\0\u02e7\u02e5\1\0\0\0\u02e7\u02e6\1\0\0\0\u02e8{\1\0\0\0\u02e9\u02ea"+
		"\7\3\0\0\u02ea}\1\0\0\0\u02eb\u02ec\7\4\0\0\u02ec\177\1\0\0\0\u02ed\u02ef"+
		"\3\u0082A\0\u02ee\u02ed\1\0\0\0\u02ef\u02f0\1\0\0\0\u02f0\u02ee\1\0\0"+
		"\0\u02f0\u02f1\1\0\0\0\u02f1\u0081\1\0\0\0\u02f2\u02f3\5\30\0\0\u02f3"+
		"\u02fa\3\u0084B\0\u02f4\u02f7\5-\0\0\u02f5\u02f8\3\u0086C\0\u02f6\u02f8"+
		"\3\u008aE\0\u02f7\u02f5\1\0\0\0\u02f7\u02f6\1\0\0\0\u02f7\u02f8\1\0\0"+
		"\0\u02f8\u02f9\1\0\0\0\u02f9\u02fb\5\26\0\0\u02fa\u02f4\1\0\0\0\u02fa"+
		"\u02fb\1\0\0\0\u02fb\u0083\1\0\0\0\u02fc\u0301\5b\0\0\u02fd\u02fe\5G\0"+
		"\0\u02fe\u0300\5b\0\0\u02ff\u02fd\1\0\0\0\u0300\u0303\1\0\0\0\u0301\u02ff"+
		"\1\0\0\0\u0301\u0302\1\0\0\0\u0302\u0085\1\0\0\0\u0303\u0301\1\0\0\0\u0304"+
		"\u0309\3\u0088D\0\u0305\u0306\5*\0\0\u0306\u0308\3\u0088D\0\u0307\u0305"+
		"\1\0\0\0\u0308\u030b\1\0\0\0\u0309\u0307\1\0\0\0\u0309\u030a\1\0\0\0\u030a"+
		"\u0087\1\0\0\0\u030b\u0309\1\0\0\0\u030c\u030d\5b\0\0\u030d\u030e\5\31"+
		"\0\0\u030e\u030f\3\u008aE\0\u030f\u0089\1\0\0\0\u0310\u0314\3\u00c6c\0"+
		"\u0311\u0314\3\u0082A\0\u0312\u0314\3\u008cF\0\u0313\u0310\1\0\0\0\u0313"+
		"\u0311\1\0\0\0\u0313\u0312\1\0\0\0\u0314\u008b\1\0\0\0\u0315\u031e\58"+
		"\0\0\u0316\u031b\3\u008aE\0\u0317\u0318\5*\0\0\u0318\u031a\3\u008aE\0"+
		"\u0319\u0317\1\0\0\0\u031a\u031d\1\0\0\0\u031b\u0319\1\0\0\0\u031b\u031c"+
		"\1\0\0\0\u031c\u031f\1\0\0\0\u031d\u031b\1\0\0\0\u031e\u0316\1\0\0\0\u031e"+
		"\u031f\1\0\0\0\u031f\u0321\1\0\0\0\u0320\u0322\5*\0\0\u0321\u0320\1\0"+
		"\0\0\u0321\u0322\1\0\0\0\u0322\u0323\1\0\0\0\u0323\u0324\5\r\0\0\u0324"+
		"\u008d\1\0\0\0\u0325\u0326\5\30\0\0\u0326\u0327\5\1\0\0\u0327\u0328\5"+
		"b\0\0\u0328\u0329\3\u0090H\0\u0329\u008f\1\0\0\0\u032a\u032e\58\0\0\u032b"+
		"\u032d\3\u0092I\0\u032c\u032b\1\0\0\0\u032d\u0330\1\0\0\0\u032e\u032c"+
		"\1\0\0\0\u032e\u032f\1\0\0\0\u032f\u0331\1\0\0\0\u0330\u032e\1\0\0\0\u0331"+
		"\u0332\5\r\0\0\u0332\u0091\1\0\0\0\u0333\u0334\3\20\b\0\u0334\u0335\3"+
		"\u0094J\0\u0335\u0093\1\0\0\0\u0336\u0337\3^/\0\u0337\u0338\3\u0096K\0"+
		"\u0338\u0339\5M\0\0\u0339\u034b\1\0\0\0\u033a\u033c\3\b\4\0\u033b\u033d"+
		"\5M\0\0\u033c\u033b\1\0\0\0\u033c\u033d\1\0\0\0\u033d\u034b\1\0\0\0\u033e"+
		"\u0340\3 \20\0\u033f\u0341\5M\0\0\u0340\u033f\1\0\0\0\u0340\u0341\1\0"+
		"\0\0\u0341\u034b\1\0\0\0\u0342\u0344\3\n\5\0\u0343\u0345\5M\0\0\u0344"+
		"\u0343\1\0\0\0\u0344\u0345\1\0\0\0\u0345\u034b\1\0\0\0\u0346\u0348\3\u008e"+
		"G\0\u0347\u0349\5M\0\0\u0348\u0347\1\0\0\0\u0348\u0349\1\0\0\0\u0349\u034b"+
		"\1\0\0\0\u034a\u0336\1\0\0\0\u034a\u033a\1\0\0\0\u034a\u033e\1\0\0\0\u034a"+
		"\u0342\1\0\0\0\u034a\u0346\1\0\0\0\u034b\u0095\1\0\0\0\u034c\u034f\3\u0098"+
		"L\0\u034d\u034f\3\u009aM\0\u034e\u034c\1\0\0\0\u034e\u034d\1\0\0\0\u034f"+
		"\u0097\1\0\0\0\u0350\u0351\5b\0\0\u0351\u0352\5-\0\0\u0352\u0354\5\26"+
		"\0\0\u0353\u0355\3\u009cN\0\u0354\u0353\1\0\0\0\u0354\u0355\1\0\0\0\u0355"+
		"\u0099\1\0\0\0\u0356\u0357\3H$\0\u0357\u009b\1\0\0\0\u0358\u0359\5(\0"+
		"\0\u0359\u035a\3\u008aE\0\u035a\u009d\1\0\0\0\u035b\u035f\58\0\0\u035c"+
		"\u035e\3\u00a0P\0\u035d\u035c\1\0\0\0\u035e\u0361\1\0\0\0\u035f\u035d"+
		"\1\0\0\0\u035f\u0360\1\0\0\0\u0360\u0362\1\0\0\0\u0361\u035f\1\0\0\0\u0362"+
		"\u0363\5\r\0\0\u0363\u009f\1\0\0\0\u0364\u0369\3\u00a2Q\0\u0365\u0369"+
		"\3\b\4\0\u0366\u0369\3\f\6\0\u0367\u0369\3\u00a8T\0\u0368\u0364\1\0\0"+
		"\0\u0368\u0365\1\0\0\0\u0368\u0366\1\0\0\0\u0368\u0367\1\0\0\0\u0369\u00a1"+
		"\1\0\0\0\u036a\u036b\3\u00a4R\0\u036b\u036c\5M\0\0\u036c\u00a3\1\0\0\0"+
		"\u036d\u036e\3\u00a6S\0\u036e\u036f\3^/\0\u036f\u0370\3H$\0\u0370\u00a5"+
		"\1\0\0\0\u0371\u0373\3d\62\0\u0372\u0371\1\0\0\0\u0373\u0376\1\0\0\0\u0374"+
		"\u0372\1\0\0\0\u0374\u0375\1\0\0\0\u0375\u00a7\1\0\0\0\u0376\u0374\1\0"+
		"\0\0\u0377\u03c5\3\u009eO\0\u0378\u0379\5a\0\0\u0379\u037c\3\u00c6c\0"+
		"\u037a\u037b\5.\0\0\u037b\u037d\3\u00c6c\0\u037c\u037a\1\0\0\0\u037c\u037d"+
		"\1\0\0\0\u037d\u037e\1\0\0\0\u037e\u037f\5M\0\0\u037f\u03c5\1\0\0\0\u0380"+
		"\u0381\5/\0\0\u0381\u0382\3\u00be_\0\u0382\u0385\3\u00a8T\0\u0383\u0384"+
		"\5?\0\0\u0384\u0386\3\u00a8T\0\u0385\u0383\1\0\0\0\u0385\u0386\1\0\0\0"+
		"\u0386\u03c5\1\0\0\0\u0387\u0388\5J\0\0\u0388\u0389\5-\0\0\u0389\u038a"+
		"\3\u00b6[\0\u038a\u038b\5\26\0\0\u038b\u038c\3\u00a8T\0\u038c\u03c5\1"+
		"\0\0\0\u038d\u038e\5+\0\0\u038e\u038f\3\u00be_\0\u038f\u0390\3\u00a8T"+
		"\0\u0390\u03c5\1\0\0\0\u0391\u0392\5\23\0\0\u0392\u0393\3\u00a8T\0\u0393"+
		"\u0394\5+\0\0\u0394\u0395\3\u00be_\0\u0395\u0396\5M\0\0\u0396\u03c5\1"+
		"\0\0\0\u0397\u0398\5\64\0\0\u0398\u03a0\3\u009eO\0\u0399\u039a\3\u00aa"+
		"U\0\u039a\u039b\5\37\0\0\u039b\u039c\3\u009eO\0\u039c\u03a1\1\0\0\0\u039d"+
		"\u03a1\3\u00aaU\0\u039e\u039f\5\37\0\0\u039f\u03a1\3\u009eO\0\u03a0\u0399"+
		"\1\0\0\0\u03a0\u039d\1\0\0\0\u03a0\u039e\1\0\0\0\u03a1\u03c5\1\0\0\0\u03a2"+
		"\u03a3\5T\0\0\u03a3\u03a4\3\u00be_\0\u03a4\u03a5\3\u00b0X\0\u03a5\u03c5"+
		"\1\0\0\0\u03a6\u03a7\5)\0\0\u03a7\u03a8\3\u00be_\0\u03a8\u03a9\3\u009e"+
		"O\0\u03a9\u03c5\1\0\0\0\u03aa\u03ac\5K\0\0\u03ab\u03ad\3\u00c6c\0\u03ac"+
		"\u03ab\1\0\0\0\u03ac\u03ad\1\0\0\0\u03ad\u03ae\1\0\0\0\u03ae\u03c5\5M"+
		"\0\0\u03af\u03b0\5\27\0\0\u03b0\u03b1\3\u00c6c\0\u03b1\u03b2\5M\0\0\u03b2"+
		"\u03c5\1\0\0\0\u03b3\u03b5\59\0\0\u03b4\u03b6\5b\0\0\u03b5\u03b4\1\0\0"+
		"\0\u03b5\u03b6\1\0\0\0\u03b6\u03b7\1\0\0\0\u03b7\u03c5\5M\0\0\u03b8\u03ba"+
		"\5\b\0\0\u03b9\u03bb\5b\0\0\u03ba\u03b9\1\0\0\0\u03ba\u03bb\1\0\0\0\u03bb"+
		"\u03bc\1\0\0\0\u03bc\u03c5\5M\0\0\u03bd\u03c5\5M\0\0\u03be\u03bf\3\u00c2"+
		"a\0\u03bf\u03c0\5M\0\0\u03c0\u03c5\1\0\0\0\u03c1\u03c2\5b\0\0\u03c2\u03c3"+
		"\5.\0\0\u03c3\u03c5\3\u00a8T\0\u03c4\u0377\1\0\0\0\u03c4\u0378\1\0\0\0"+
		"\u03c4\u0380\1\0\0\0\u03c4\u0387\1\0\0\0\u03c4\u038d\1\0\0\0\u03c4\u0391"+
		"\1\0\0\0\u03c4\u0397\1\0\0\0\u03c4\u03a2\1\0\0\0\u03c4\u03a6\1\0\0\0\u03c4"+
		"\u03aa\1\0\0\0\u03c4\u03af\1\0\0\0\u03c4\u03b3\1\0\0\0\u03c4\u03b8\1\0"+
		"\0\0\u03c4\u03bd\1\0\0\0\u03c4\u03be\1\0\0\0\u03c4\u03c1\1\0\0\0\u03c5"+
		"\u00a9\1\0\0\0\u03c6\u03ca\3\u00acV\0\u03c7\u03c9\3\u00acV\0\u03c8\u03c7"+
		"\1\0\0\0\u03c9\u03cc\1\0\0\0\u03ca\u03c8\1\0\0\0\u03ca\u03cb\1\0\0\0\u03cb"+
		"\u00ab\1\0\0\0\u03cc\u03ca\1\0\0\0\u03cd\u03ce\5@\0\0\u03ce\u03cf\5-\0"+
		"\0\u03cf\u03d0\3\u00aeW\0\u03d0\u03d1\5\26\0\0\u03d1\u03d2\3\u009eO\0"+
		"\u03d2\u00ad\1\0\0\0\u03d3\u03d4\3\u00a6S\0\u03d4\u03d5\3^/\0\u03d5\u03d6"+
		"\3P(\0\u03d6\u00af\1\0\0\0\u03d7\u03db\58\0\0\u03d8\u03da\3\u00b2Y\0\u03d9"+
		"\u03d8\1\0\0\0\u03da\u03dd\1\0\0\0\u03db\u03d9\1\0\0\0\u03db\u03dc\1\0"+
		"\0\0\u03dc\u03e1\1\0\0\0\u03dd\u03db\1\0\0\0\u03de\u03e0\3\u00b4Z\0\u03df"+
		"\u03de\1\0\0\0\u03e0\u03e3\1\0\0\0\u03e1\u03df\1\0\0\0\u03e1\u03e2\1\0"+
		"\0\0\u03e2\u03e4\1\0\0\0\u03e3\u03e1\1\0\0\0\u03e4\u03e5\5\r\0\0\u03e5"+
		"\u00b1\1\0\0\0\u03e6\u03e8\3\u00b4Z\0\u03e7\u03e6\1\0\0\0\u03e8\u03e9"+
		"\1\0\0\0\u03e9\u03e7\1\0\0\0\u03e9\u03ea\1\0\0\0\u03ea\u03ee\1\0\0\0\u03eb"+
		"\u03ed\3\u00a0P\0\u03ec\u03eb\1\0\0\0\u03ed\u03f0\1\0\0\0\u03ee\u03ec"+
		"\1\0\0\0\u03ee\u03ef\1\0\0\0\u03ef\u00b3\1\0\0\0\u03f0\u03ee\1\0\0\0\u03f1"+
		"\u03f2\5\21\0\0\u03f2\u03f3\3\u00c4b\0\u03f3\u03f4\5.\0\0\u03f4\u03fc"+
		"\1\0\0\0\u03f5\u03f6\5\21\0\0\u03f6\u03f7\3Z-\0\u03f7\u03f8\5.\0\0\u03f8"+
		"\u03fc\1\0\0\0\u03f9\u03fa\5(\0\0\u03fa\u03fc\5.\0\0\u03fb\u03f1\1\0\0"+
		"\0\u03fb\u03f5\1\0\0\0\u03fb\u03f9\1\0\0\0\u03fc\u00b5\1\0\0\0\u03fd\u040a"+
		"\3\u00ba]\0\u03fe\u0400\3\u00b8\\\0\u03ff\u03fe\1\0\0\0\u03ff\u0400\1"+
		"\0\0\0\u0400\u0401\1\0\0\0\u0401\u0403\5M\0\0\u0402\u0404\3\u00c6c\0\u0403"+
		"\u0402\1\0\0\0\u0403\u0404\1\0\0\0\u0404\u0405\1\0\0\0\u0405\u0407\5M"+
		"\0\0\u0406\u0408\3\u00bc^\0\u0407\u0406\1\0\0\0\u0407\u0408\1\0\0\0\u0408"+
		"\u040a\1\0\0\0\u0409\u03fd\1\0\0\0\u0409\u03ff\1\0\0\0\u040a\u00b7\1\0"+
		"\0\0\u040b\u040e\3\u00a4R\0\u040c\u040e\3\u00c0`\0\u040d\u040b\1\0\0\0"+
		"\u040d\u040c\1\0\0\0\u040e\u00b9\1\0\0\0\u040f\u0410\3\u00a6S\0\u0410"+
		"\u0411\3^/\0\u0411\u0412\5b\0\0\u0412\u0413\5.\0\0\u0413\u0414\3\u00c6"+
		"c\0\u0414\u00bb\1\0\0\0\u0415\u0416\3\u00c0`\0\u0416\u00bd\1\0\0\0\u0417"+
		"\u0418\5-\0\0\u0418\u0419\3\u00c6c\0\u0419\u041a\5\26\0\0\u041a\u00bf"+
		"\1\0\0\0\u041b\u0420\3\u00c6c\0\u041c\u041d\5*\0\0\u041d\u041f\3\u00c6"+
		"c\0\u041e\u041c\1\0\0\0\u041f\u0422\1\0\0\0\u0420\u041e\1\0\0\0\u0420"+
		"\u0421\1\0\0\0\u0421\u00c1\1\0\0\0\u0422\u0420\1\0\0\0\u0423\u0424\3\u00c6"+
		"c\0\u0424\u00c3\1\0\0\0\u0425\u0426\3\u00c6c\0\u0426\u00c5\1\0\0\0\u0427"+
		"\u0428\6c\uffff\0\u0428\u0429\5-\0\0\u0429\u042a\3^/\0\u042a\u042b\5\26"+
		"\0\0\u042b\u042c\3\u00c6c\0\u042c\u0435\1\0\0\0\u042d\u042e\7\5\0\0\u042e"+
		"\u0435\3\u00c6c\0\u042f\u0430\7\6\0\0\u0430\u0435\3\u00c6c\0\u0431\u0435"+
		"\3\u00c8d\0\u0432\u0433\5\35\0\0\u0433\u0435\3\u00cae\0\u0434\u0427\1"+
		"\0\0\0\u0434\u042d\1\0\0\0\u0434\u042f\1\0\0\0\u0434\u0431\1\0\0\0\u0434"+
		"\u0432\1\0\0\0\u0435\u04b4\1\0\0\0\u0436\u0437\4c\0\1\u0437\u0438\7\7"+
		"\0\0\u0438\u04b3\3\u00c6c\0\u0439\u043a\4c\1\1\u043a\u043b\7\b\0\0\u043b"+
		"\u04b3\3\u00c6c\0\u043c\u0444\4c\2\1\u043d\u043e\5\5\0\0\u043e\u0445\5"+
		"\5\0\0\u043f\u0440\5Q\0\0\u0440\u0441\5Q\0\0\u0441\u0445\5Q\0\0\u0442"+
		"\u0443\5Q\0\0\u0443\u0445\5Q\0\0\u0444\u043d\1\0\0\0\u0444\u043f\1\0\0"+
		"\0\u0444\u0442\1\0\0\0\u0445\u0446\1\0\0\0\u0446\u04b3\3\u00c6c\0\u0447"+
		"\u044e\4c\3\1\u0448\u0449\5\5\0\0\u0449\u044f\5\31\0\0\u044a\u044b\5Q"+
		"\0\0\u044b\u044f\5\31\0\0\u044c\u044f\5Q\0\0\u044d\u044f\5\5\0\0\u044e"+
		"\u0448\1\0\0\0\u044e\u044a\1\0\0\0\u044e\u044c\1\0\0\0\u044e\u044d\1\0"+
		"\0\0\u044f\u0450\1\0\0\0\u0450\u04b3\3\u00c6c\0\u0451\u0452\4c\4\1\u0452"+
		"\u0453\7\t\0\0\u0453\u04b3\3\u00c6c\0\u0454\u0455\4c\5\1\u0455\u0456\5"+
		"\2\0\0\u0456\u04b3\3\u00c6c\0\u0457\u0458\4c\6\1\u0458\u0459\5F\0\0\u0459"+
		"\u04b3\3\u00c6c\0\u045a\u045b\4c\7\1\u045b\u045c\5 \0\0\u045c\u04b3\3"+
		"\u00c6c\0\u045d\u045e\4c\b\1\u045e\u045f\5N\0\0\u045f\u04b3\3\u00c6c\0"+
		"\u0460\u0461\4c\t\1\u0461\u0462\5P\0\0\u0462\u04b3\3\u00c6c\0\u0463\u0477"+
		"\4c\n\1\u0464\u0478\5=\0\0\u0465\u0478\5;\0\0\u0466\u0478\5&\0\0\u0467"+
		"\u0478\5\25\0\0\u0468\u0478\5U\0\0\u0469\u0478\5\60\0\0\u046a\u0478\5"+
		"\34\0\0\u046b\u0478\5\31\0\0\u046c\u046d\5Q\0\0\u046d\u046e\5Q\0\0\u046e"+
		"\u0478\5\31\0\0\u046f\u0470\5Q\0\0\u0470\u0471\5Q\0\0\u0471\u0472\5Q\0"+
		"\0\u0472\u0478\5\31\0\0\u0473\u0474\5\5\0\0\u0474\u0475\5\5\0\0\u0475"+
		"\u0478\5\31\0\0\u0476\u0478\5S\0\0\u0477\u0464\1\0\0\0\u0477\u0465\1\0"+
		"\0\0\u0477\u0466\1\0\0\0\u0477\u0467\1\0\0\0\u0477\u0468\1\0\0\0\u0477"+
		"\u0469\1\0\0\0\u0477\u046a\1\0\0\0\u0477\u046b\1\0\0\0\u0477\u046c\1\0"+
		"\0\0\u0477\u046f\1\0\0\0\u0477\u0473\1\0\0\0\u0477\u0476\1\0\0\0\u0478"+
		"\u0479\1\0\0\0\u0479\u04b3\3\u00c6c\0\u047a\u047b\4c\13\1\u047b\u047c"+
		"\5\63\0\0\u047c\u047d\3\u00c6c\0\u047d\u047e\5.\0\0\u047e\u047f\3\u00c6"+
		"c\0\u047f\u04b3\1\0\0\0\u0480\u0481\4c\f\1\u0481\u0482\5G\0\0\u0482\u04b3"+
		"\5b\0\0\u0483\u0484\4c\r\1\u0484\u0485\5G\0\0\u0485\u04b3\5O\0\0\u0486"+
		"\u0487\4c\16\1\u0487\u0488\5G\0\0\u0488\u0489\5\22\0\0\u0489\u048b\5-"+
		"\0\0\u048a\u048c\3\u00c0`\0\u048b\u048a\1\0\0\0\u048b\u048c\1\0\0\0\u048c"+
		"\u048d\1\0\0\0\u048d\u04b3\5\26\0\0\u048e\u048f\4c\17\1\u048f\u0490\5"+
		"G\0\0\u0490\u0491\5\35\0\0\u0491\u0492\5b\0\0\u0492\u0494\5-\0\0\u0493"+
		"\u0495\3\u00c0`\0\u0494\u0493\1\0\0\0\u0494\u0495\1\0\0\0\u0495\u0496"+
		"\1\0\0\0\u0496\u04b3\5\26\0\0\u0497\u0498\4c\20\1\u0498\u0499\5G\0\0\u0499"+
		"\u049a\5\22\0\0\u049a\u049b\5G\0\0\u049b\u049d\5b\0\0\u049c\u049e\3\u00d8"+
		"l\0\u049d\u049c\1\0\0\0\u049d\u049e\1\0\0\0\u049e\u04b3\1\0\0\0\u049f"+
		"\u04a0\4c\21\1\u04a0\u04a1\5G\0\0\u04a1\u04b3\3\u00d0h\0\u04a2\u04a3\4"+
		"c\22\1\u04a3\u04a4\5\4\0\0\u04a4\u04a5\3\u00c6c\0\u04a5\u04a6\5%\0\0\u04a6"+
		"\u04b3\1\0\0\0\u04a7\u04a8\4c\23\1\u04a8\u04b3\7\n\0\0\u04a9\u04aa\4c"+
		"\24\1\u04aa\u04ac\5-\0\0\u04ab\u04ad\3\u00c0`\0\u04ac\u04ab\1\0\0\0\u04ac"+
		"\u04ad\1\0\0\0\u04ad\u04ae\1\0\0\0\u04ae\u04b3\5\26\0\0\u04af\u04b0\4"+
		"c\25\1\u04b0\u04b1\5Y\0\0\u04b1\u04b3\3^/\0\u04b2\u0436\1\0\0\0\u04b2"+
		"\u0439\1\0\0\0\u04b2\u043c\1\0\0\0\u04b2\u0447\1\0\0\0\u04b2\u0451\1\0"+
		"\0\0\u04b2\u0454\1\0\0\0\u04b2\u0457\1\0\0\0\u04b2\u045a\1\0\0\0\u04b2"+
		"\u045d\1\0\0\0\u04b2\u0460\1\0\0\0\u04b2\u0463\1\0\0\0\u04b2\u047a\1\0"+
		"\0\0\u04b2\u0480\1\0\0\0\u04b2\u0483\1\0\0\0\u04b2\u0486\1\0\0\0\u04b2"+
		"\u048e\1\0\0\0\u04b2\u0497\1\0\0\0\u04b2\u049f\1\0\0\0\u04b2\u04a2\1\0"+
		"\0\0\u04b2\u04a7\1\0\0\0\u04b2\u04a9\1\0\0\0\u04b2\u04af\1\0\0\0\u04b3"+
		"\u04b6\1\0\0\0\u04b4\u04b2\1\0\0\0\u04b4\u04b5\1\0\0\0\u04b5\u00c7\1\0"+
		"\0\0\u04b6\u04b4\1\0\0\0\u04b7\u04b8\5-\0\0\u04b8\u04b9\3\u00c6c\0\u04b9"+
		"\u04ba\5\26\0\0\u04ba\u04c7\1\0\0\0\u04bb\u04c7\5O\0\0\u04bc\u04c7\5\22"+
		"\0\0\u04bd\u04c7\3z=\0\u04be\u04c7\5b\0\0\u04bf\u04c0\3^/\0\u04c0\u04c1"+
		"\5G\0\0\u04c1\u04c2\5\36\0\0\u04c2\u04c7\1\0\0\0\u04c3\u04c4\5\65\0\0"+
		"\u04c4\u04c5\5G\0\0\u04c5\u04c7\5\36\0\0\u04c6\u04b7\1\0\0\0\u04c6\u04bb"+
		"\1\0\0\0\u04c6\u04bc\1\0\0\0\u04c6\u04bd\1\0\0\0\u04c6\u04be\1\0\0\0\u04c6"+
		"\u04bf\1\0\0\0\u04c6\u04c3\1\0\0\0\u04c7\u00c9\1\0\0\0\u04c8\u04c9\3\u00d6"+
		"k\0\u04c9\u04ca\3\u00ccf\0\u04ca\u04cb\3\u00d4j\0\u04cb\u04d2\1\0\0\0"+
		"\u04cc\u04cf\3\u00ccf\0\u04cd\u04d0\3\u00d2i\0\u04ce\u04d0\3\u00d4j\0"+
		"\u04cf\u04cd\1\0\0\0\u04cf\u04ce\1\0\0\0\u04d0\u04d2\1\0\0\0\u04d1\u04c8"+
		"\1\0\0\0\u04d1\u04cc\1\0\0\0\u04d2\u00cb\1\0\0\0\u04d3\u04d6\3`\60\0\u04d4"+
		"\u04d6\3b\61\0\u04d5\u04d3\1\0\0\0\u04d5\u04d4\1\0\0\0\u04d6\u00cd\1\0"+
		"\0\0\u04d7\u04d9\3\u00d6k\0\u04d8\u04d7\1\0\0\0\u04d8\u04d9\1\0\0\0\u04d9"+
		"\u04da\1\0\0\0\u04da\u04db\5b\0\0\u04db\u04dc\3\u00d4j\0\u04dc\u00cf\1"+
		"\0\0\0\u04dd\u04de\3\u00d6k\0\u04de\u04df\5b\0\0\u04df\u04e0\3\u00d8l"+
		"\0\u04e0\u00d1\1\0\0\0\u04e1\u04fd\5\4\0\0\u04e2\u04e7\5%\0\0\u04e3\u04e4"+
		"\5\4\0\0\u04e4\u04e6\5%\0\0\u04e5\u04e3\1\0\0\0\u04e6\u04e9\1\0\0\0\u04e7"+
		"\u04e5\1\0\0\0\u04e7\u04e8\1\0\0\0\u04e8\u04ea\1\0\0\0\u04e9\u04e7\1\0"+
		"\0\0\u04ea\u04fe\3T*\0\u04eb\u04ec\3\u00c6c\0\u04ec\u04f3\5%\0\0\u04ed"+
		"\u04ee\5\4\0\0\u04ee\u04ef\3\u00c6c\0\u04ef\u04f0\5%\0\0\u04f0\u04f2\1"+
		"\0\0\0\u04f1\u04ed\1\0\0\0\u04f2\u04f5\1\0\0\0\u04f3\u04f1\1\0\0\0\u04f3"+
		"\u04f4\1\0\0\0\u04f4\u04fa\1\0\0\0\u04f5\u04f3\1\0\0\0\u04f6\u04f7\5\4"+
		"\0\0\u04f7\u04f9\5%\0\0\u04f8\u04f6\1\0\0\0\u04f9\u04fc\1\0\0\0\u04fa"+
		"\u04f8\1\0\0\0\u04fa\u04fb\1\0\0\0\u04fb\u04fe\1\0\0\0\u04fc\u04fa\1\0"+
		"\0\0\u04fd\u04e2\1\0\0\0\u04fd\u04eb\1\0\0\0\u04fe\u00d3\1\0\0\0\u04ff"+
		"\u0501\3\u00d8l\0\u0500\u0502\3$\22\0\u0501\u0500\1\0\0\0\u0501\u0502"+
		"\1\0\0\0\u0502\u00d5\1\0\0\0\u0503\u0504\5\5\0\0\u0504\u0505\3\"\21\0"+
		"\u0505\u0506\5Q\0\0\u0506\u00d7\1\0\0\0\u0507\u0509\5-\0\0\u0508\u050a"+
		"\3\u00c0`\0\u0509\u0508\1\0\0\0\u0509\u050a\1\0\0\0\u050a\u050b\1\0\0"+
		"\0\u050b\u050c\5\26\0\0\u050c\u00d9\1\0\0\0\u008c\u00db\1\u00e0\1\u00e6"+
		"\1\u00f1\1\u00f6\1\u00fd\1\u0103\1\u0106\1\u010b\1\u010f\1\u0113\1\u011b"+
		"\1\u0121\1\u012b\1\u0130\1\u0139\1\u0141\1\u0148\1\u014d\1\u0150\1\u0153"+
		"\1\u015c\1\u0160\1\u0164\1\u0167\1\u016d\1\u0173\1\u0177\1\u0180\1\u0187"+
		"\1\u0190\1\u0197\1\u019d\1\u01a5\1\u01ae\1\u01b8\1\u01bc\1\u01c0\1\u01ca"+
		"\1\u01d0\1\u01d8\1\u01e1\1\u01eb\1\u01f0\1\u01f4\1\u01fb\1\u0200\1\u0207"+
		"\1\u020f\1\u021b\1\u0221\1\u0228\1\u022f\1\u023a\1\u023f\1\u0247\1\u024b"+
		"\1\u024d\1\u025d\1\u026a\1\u0272\1\u0275\1\u0279\1\u027e\1\u0282\1\u0289"+
		"\1\u0291\1\u029a\1\u029c\1\u02a3\1\u02a8\1\u02b3\1\u02b7\1\u02bd\1\u02c2"+
		"\1\u02c8\1\u02d1\1\u02d7\1\u02de\1\u02e7\1\u02f0\1\u02f7\1\u02fa\1\u0301"+
		"\1\u0309\1\u0313\1\u031b\1\u031e\1\u0321\1\u032e\1\u033c\1\u0340\1\u0344"+
		"\1\u0348\1\u034a\1\u034e\1\u0354\1\u035f\1\u0368\1\u0374\1\u037c\1\u0385"+
		"\1\u03a0\1\u03ac\1\u03b5\1\u03ba\1\u03c4\1\u03ca\1\u03db\1\u03e1\1\u03e9"+
		"\1\u03ee\1\u03fb\1\u03ff\1\u0403\1\u0407\1\u0409\1\u040d\1\u0420\1\u0434"+
		"\1\u0444\1\u044e\1\u0477\1\u048b\1\u0494\1\u049d\1\u04ac\1\u04b2\1\u04b4"+
		"\1\u04c6\1\u04cf\1\u04d1\1\u04d5\1\u04d8\1\u04e7\1\u04f3\1\u04fa\1\u04fd"+
		"\1\u0501\1\u0509\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}