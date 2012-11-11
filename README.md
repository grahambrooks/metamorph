# metamorph - Code Rewriter

A language aware automation tool for analysing and updating program
source code.

# Background

Maven, Ivy and other dependency management tools have emerged to allow
project teams to manage the influx of changes from their
dependencies. Change is a fact of life and framework/library
developers want to launch their new code on the world quickly and
safely. Projects take some time to accommodate changes from the
dependencies. In the worst cases change becomes impossible for various
reasons and re-writes are considered.

metamorph intends to help this situation by allowing library and framework
developers define changes necessary to upgrade to a newer version of
the library or framework. These changes specify which parts of the
application using the library or framework need to be changed and
how.

The problem is broken down as follows:

## Specifying which parts of an application need to change

## Detailing the change

## Finding the parts that need to change

## Making the changes


# Design

metamorph has been developed to run on the JVM and is written using a
combination of Java and Scala. ANTLR is used for language parsing
heavy lifting.

Each supported language is packaged as a JAR file. uses these language
parsers to build Abstract Syntax Tree representations of the the
source.

A domain specific language is used by library and framework developers
to define where changes in source code need to be made to accommodate
an updated version of their code. This DSL is in the form of a
semantic predicate that builds up knowledge of a particular instance
that can then be used to re-write the source code.

e.g. Method rename

In this scenario a library method has been renamed from method1 to
method2 on class X.

All calls of method1 need to be renamed to method2. This could be on
direct instances of class X or instances of derived classes.

`Rename(MethodCall("method1").On(Instances(DerivedFrom("X")), To("method2"))`

All overrides of method1 in derived classes need to be renamed to
method2.

`Rename(Method("method1").On(Classes(DerivedFrom("X")), To("method2"))`

## Code organization

### Parsers

The parsers take source code and generate text containing the Abstract
Syntax Tree (AST) representation of the source files.

* metamorph.csharp.parser
* metamorph.java.parser

### The metamorph runtime

Supports the generation of refactoring commands

### metamorph

The metamorph command line shell

