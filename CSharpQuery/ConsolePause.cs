using System;
using System.IO;

namespace CSharpQuery
{
	/// <summary>
	/// If the console moves, Pause.
	/// [Esc] throws an ApplicationException so you can exit.
	/// </summary>
	public class ConsolePause : IDisposable
	{
	    readonly int _beforeConsoleTop;
		int _expectedLines;
	    readonly bool _wait;
		public ConsolePause(bool wait)
		{
			_wait = wait;
			try
			{
				_beforeConsoleTop = Console.CursorTop;
			}
			catch (IOException)
			{
				// no console
			}
		}
		public void WriteLine(string s)
		{
			Console.WriteLine(s);
			_expectedLines++;
		}
		public void Warn(string s)
		{
			Console.ForegroundColor = ConsoleColor.Yellow;
			Console.WriteLine(s);
			Console.ForegroundColor = ConsoleColor.White;
			_expectedLines++;
		}
		public void Err(string s)
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine(s);
			Console.ForegroundColor = ConsoleColor.White;
		}

		public bool HasMessages
		{
			get
			{
				try
				{
					if (Console.CursorTop > _beforeConsoleTop + _expectedLines)
						return true;
				}
				catch (IOException)
				{
				}
				return false;
			}
		}
		public void Dispose()
		{
			try
			{
				if (HasMessages)
				{
					Err("Errors");
					if (_wait)
						if (Console.ReadKey().Key == ConsoleKey.Escape)
							throw new ApplicationException("done");
				}

				if (Console.BufferHeight > 1000)
					if (Console.CursorTop > Console.BufferHeight - 1000)
					{
						// Make more space so Console.CursorTop moves, instead of staying at the max.
						Console.Clear();
						Console.CursorTop = 0;
					}
			}
			catch(IOException)
			{
				// no console
			}
		}
	}
}
