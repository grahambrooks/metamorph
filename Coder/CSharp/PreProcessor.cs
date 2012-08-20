using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using Antlr.Runtime;

namespace Coder.CSharp
{
    public class PreProcessor : csLexer
    {
        private readonly Queue<IToken> _tokens = new Queue<IToken>();
        private bool _warn = true;

        public PreProcessor()
        {
            Processing.Push(true);

            DefineCommandlineMacros();
        }

        private void DefineCommandlineMacros()
        {
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
                state.token = Processing.Peek() == false ? Tokens.Skip : state.token;
            }
            else if (_warn)
            {
                // Don't warn every token
                _warn = false;
                Debug.Assert(Processing.Count > 0, "Stack underflow preprocessing.  mTokens");
                Console.WriteLine("Found unexpected else.");
            }
        }

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
                IToken eof = new CommonToken(input, CharStreamConstants.EndOfFile, TokenChannels.Default, input.Index,
                                             input.Index);
                eof.Line = Line;
                eof.CharPositionInLine = CharPositionInLine;
                return eof;
            }
            return _tokens.Dequeue();
        }

        public override String GetErrorMessage(RecognitionException e, String[] tokenNames)
        {
            var stack = GetRuleInvocationStack(new StackTrace(e));
            var sb = new StringBuilder();
            sb.Append("\r\n");
            foreach (var o in stack)
                sb.AppendFormat("{0}\r\n", o);

            if (e is NoViableAltException)
            {
                var nvae = (NoViableAltException) e;
                sb.AppendFormat(" no viable alt; token = {0} (decision = {1} state {2}) decision=<<{3}>>\r\n",
                                e.Token.Text,
                                nvae.DecisionNumber,
                                nvae.StateNumber,
                                nvae.GrammarDecisionDescription);
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