using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using Antlr.Runtime;

namespace CSharpQuery
{
    /// <summary>
    ///   PreProcessor The lexer preprocesses the CSharp code.
    /// </summary>
    public class PreProcessor : csLexer
    {
        // if there's an #if / #else mismatch, don't complain every token :)
        private bool _warn = true;

        public PreProcessor()
        {
            // By default we are preprocessing input
            Processing.Push(true);

            // Grab what's defined from the command line
            var args = Environment.GetCommandLineArgs();
            for (var n = 0; n < args.Length; ++n)
            {
                if (args[n] == "-D")
                    if ((n + 1) < args.Length)
                        MacroDefines.Add(args[n + 1], string.Empty);
            }
        }

        public override void mTokens()
        {
            base.mTokens();
            // if we aren't processing, skip this token
            // if the Count is 0, we are in a bad state.
            if (Processing.Count > 0)
            {
                state.token = Processing.Peek() == false ? Token.SKIP_TOKEN : state.token;
            }
            else if (_warn)
            {
                // Don't warn every token
                _warn = false;
                Debug.Assert(Processing.Count > 0, "Stack underflow preprocessing.  mTokens");
                Console.WriteLine("Found unexpected else.");
            }
        }

        // Code for Emiting new tokens
        // I Emit() multiple tokens in the case of 0123.ToString()
        // TODO:  There's a better way to do this just in the grammar (who knew)!  This works fine at the moment.
        private readonly Queue<IToken> _tokens = new Queue<IToken>();

        public override void Emit(IToken token)
        {
            state.token = token;
            _tokens.Enqueue(token);
        }

        public override IToken NextToken()
        {
            base.NextToken();
            if (_tokens.Count == 0)
            {
                return Token.EOF_TOKEN;
            }
            return _tokens.Dequeue();
        }

        /// <summary>
        ///   These two functions prints a stack of rules for a failure. It sounds really useful but it's mostly noise and didn't help me locate errors any quicker (mostly slower). Feel free to comment out. From "The ANTLR Reference" pg. 247 (translated to C#)
        /// </summary>
        public override String GetErrorMessage(RecognitionException e, String[] tokenNames)
        {
            //IList stack = GetRuleInvocationStack(e, this.GetType().Name);
            var stack = GetRuleInvocationStack(e, GetType().Name);
            var sb = new StringBuilder();
            sb.Append("\r\n");
            foreach (var o in stack)
                sb.AppendFormat("{0}\r\n", o);

            if (e is NoViableAltException)
            {
                var nvae = (NoViableAltException) e;
                sb.AppendFormat(" no viable alt; token = {0} (decision = {1} state {2}) decision=<<{3}>>\r\n",
                                e.Token.Text,
                                nvae.decisionNumber,
                                nvae.stateNumber,
                                nvae.grammarDecisionDescription);
            }
            else
                sb.Append(base.GetErrorMessage(e, tokenNames));

            return sb.ToString();
        }

        public override String GetTokenErrorDisplay(IToken t)
        {
            return t.ToString();
        }
    }
}