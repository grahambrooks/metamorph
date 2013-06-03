grammar Jsp;

jspPage:
    body
;

jspTagDef: body
;

body :allBody | scriptlessBody
// (vc: scriptingEnabled )?
//(vc: scriptlessBody )?
;

allBody:
    (
        ( '<%--' jspCommentBody )
    |   ( '<%@' directiveBody )
    |   ( '<jsp:directive.' xmlDirectiveBody )
    |   ( '<%!' declarationBody )
    |   ( '<jsp:declaration' xmlDeclarationBody)
    |   ( '<%=' expressionBody )
    |   ( '<jsp:expression' xmlExpressionBody)
    |   ( '<%' scriptletBody )
    |   ( '<jsp:scriptlet' xmlScriptletBody )
    |   ( '${' elExpressionBody )
    |   ( '#{' elExpressionBody )
    |   ( '<jsp:text' xmlTemplateText )
    |   ( '<jsp:' standardAction )
    |   ( '</' extraClosingTag )
    |   ( '<' customAction customActionBody )
    |   templateText
    )*
;

scriptlessBody:
    (
        ( '<%--' jspCommentBody )
    |   ( '<%@' directiveBody )
    |   ( '<jsp:directive.' xmlDirectiveBody )
    |   ( '<%!' <TRANSLATION_ERROR> )
    |   ( '<jsp:declaration' <TRANSLATION_ERROR> )
    |   ( '<%=' <TRANSLATION_ERROR> )
    |   ( '<jsp:expression' <TRANSLATION_ERROR> )
    |   ( '<%' <TRANSLATION_ERROR> )
    |   ( '<jsp:scriptlet' <TRANSLATION_ERROR> )
    |   ( '${' elExpressionBody )
    |   ( '#{' elExpressionBody )
    |   ( '<jsp:text' xmlTemplateText )
    |   ( '<jsp:' standardAction )
    |   ( '</' extraClosingTag )
    |   ( '<' customAction customActionBody )
    |   templateText
    )*
//[ vc: ELEnabled ]
;

templateTextBody:
    (
        ( '<%--' JSPCommentBody )
    |   ( '<%@' DirectiveBody )
    |   ( '<jsp:directive.' XMLDirectiveBody )
    |   ( '<%!' <TRANSLATION_ERROR> )
    |   ( '<jsp:declaration' <TRANSLATION_ERROR> )
    |   ( '<%=' <TRANSLATION_ERROR> )
    |   ( '<jsp:expression' <TRANSLATION_ERROR> )
    |   ( '<%' <TRANSLATION_ERROR> )
    |   ( '<jsp:scriptlet' <TRANSLATION_ERROR> )
    |   ( '${' <TRANSLATION_ERROR> )
    |   ( '#{' <TRANSLATION_ERROR> )
    |   ( '<jsp:text' <TRANSLATION_ERROR> )
    |   ( '<jsp:' <TRANSLATION_ERROR> )
    |   ( '<' CustomAction  <TRANSLATION_ERROR> )
    |   TemplateText
    )*
    ;
//[ vc: ELEnabled ]
jspCommentBody:
    ( Char* - ( Char* '--%>' ) ) '--%>'
    | <TRANSLATION_ERROR>
    ;

directiveBody: jspDirectiveBody | tagDefDirectiveBody
//[ vc: TagFileSpecificDirectives ]
;
xmlDirectiveBody : xmlJSPDirectiveBody | xmlTagDefDirectiveBody
//[ vc: TagFileSpecificXMLDirectives ]
;
jspDirectiveBody : S?
( ( 'page' S PageDirectiveAttrList )
| ( 'taglib' S TagLibDirectiveAttrList )
| ( 'include' S IncludeDirectiveAttrList )
)
S? '%>'
| <TRANSLATION_ERROR>
;

xmlJSPDirectiveBody:
    S?
    (
        ( 'page' S PageDirectiveAttrList S?
            (
                '/>' | ( '>' S? ETag )
            )
        )
    |   ( 'include' S IncludeDirectiveAttrList S?
            (
                '/>' | ( '>' S? ETag )
            )
        )
    )
//    | <TRANSLATION_ERROR>
;

tagDefDirectiveBody: S?
( ( 'tag' S tagDirectiveAttrList )
| ( 'taglib' S tagLibDirectiveAttrList )
| ( 'include' S includeDirectiveAttrList )
| ( 'attribute' S attributeDirectiveAttrList )
| ( 'variable' S variableDirectiveAttrList )
)
S? '%>'
| <TRANSLATION_ERROR>
;

xmlTagDefDirectiveBody:
    (
        ( 'tag' S TagDirectiveAttrList S?
            (
                '/>' | ( '>' S? ETag )
            )
        )
    |   ( 'include' S IncludeDirectiveAttrList S?
            (
                '/>' | ( '>' S? ETag )
            )
        )
    |   ( 'attribute' S AttributeDirectiveAttrList S?
            (
                '/>' | ( '>' S? ETag )
            )
        )
    |   ( 'variable' S VariableDirectiveAttrList S?
            (
                '/>' | ( '>' S? ETag )
            )
        )
    )
//| <TRANSLATION_ERROR>
;

pageDirectiveAttrList: ATTR[ language, extends, import, session,
buffer, autoFlush, isThreadSafe,
info, errorPage, isErrorPage,
contentType, pageEncoding,
isELIgnored ]
[ vc: PageDirectiveUniqueAttr ]
;

