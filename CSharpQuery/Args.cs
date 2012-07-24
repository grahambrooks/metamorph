using System;

namespace CSharpQuery
{
    public static class Args
    {
        public static bool IsFlagSet(string flag)
        {
            return flag == Array.Find(Environment.GetCommandLineArgs(), s => s == flag);
        }
    }
}