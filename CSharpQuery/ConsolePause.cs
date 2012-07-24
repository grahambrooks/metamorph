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
		int BeforeConsoleTop;
		int ExpectedLines = 0;
		bool Wait;
		public ConsolePause(bool wait)
		{
			Wait = wait;
			try
			{
				BeforeConsoleTop = Console.CursorTop;
			}
			catch (IOException)
			{
				// no console
			}
		}
		public void WriteLine(string s)
		{
			Console.WriteLine(s);
			ExpectedLines++;
		}
		public void warn(string s)
		{
			Console.ForegroundColor = ConsoleColor.Yellow;
			Console.WriteLine(s);
			Console.ForegroundColor = ConsoleColor.White;
			ExpectedLines++;
		}
		public void err(string s)
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
					if (Console.CursorTop > BeforeConsoleTop + ExpectedLines)
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
					err("Errors");
					if (Wait)
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
