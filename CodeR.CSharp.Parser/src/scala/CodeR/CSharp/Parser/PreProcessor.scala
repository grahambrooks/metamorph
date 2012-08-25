package CodeR.CSharp.Parser

import collection.mutable.Queue
import org.antlr.runtime._
import CodeR.CSharp.csLexer

class PreProcessor(stream: CharStream) extends csLexer {
  var _tokens = Queue[Token]()
  var _warn: Boolean = true
  Processing.push(true)
  super.setCharStream(stream)

  override def mTokens() {
    super.mTokens()
    // if we aren't processing, skip this token
    // if the Count is 0, we are in a bad state.
    if (Processing.size() > 0) {
      state.token = if (Processing.peek() == false) Token.SKIP_TOKEN else state.token
    }
    else if (_warn) {
      // Don't warn every token
      _warn = false
      //      Debug.Assert(Processing.Count > 0, "Stack underflow preprocessing.  mTokens");
      //      Console.WriteLine("Found unexpected else.");
    }
  }

  override def emit(token: Token) {
    state.token = token
    _tokens.enqueue(token)
  }

  override def nextToken(): Token = {
    super.nextToken()
    if (_tokens.size == 0) {
      val eof = new CommonToken(input, CharStream.EOF, Token.DEFAULT_CHANNEL, input.index, input.index);
      eof.setLine(getLine)
      eof.setCharPositionInLine(getCharPositionInLine)
      return eof
    }

    _tokens.dequeue
  }

  override def getErrorMessage(e: RecognitionException, tokenNames: Array[String]): String = {
    var sb = new StringBuffer();
    //    var stack = getRuleInvocationStack(new StackTrace(e));
    //    sb.append("\r\n");
    //
    //    foreach (var o in stack)
    //      sb.append(o + "\r\n");
    //
    //    if (e.isInstanceOf(NoViableAltException))
    //    {
    //      var nvae = (NoViableAltException) e;
    //      sb.AppendFormat(" no viable alt; token = {0} (decision = {1} state {2}) decision=<<{3}>>\r\n",
    //        e.Token.Text,
    //        nvae.DecisionNumber,
    //        nvae.StateNumber,
    //        nvae.GrammarDecisionDescription);
    //    }
    //    else
    //      sb.Append(base.GetErrorMessage(e, tokenNames));
    //
    return sb.toString
  }

  override def getTokenErrorDisplay(t: Token): String = t.toString()
}
