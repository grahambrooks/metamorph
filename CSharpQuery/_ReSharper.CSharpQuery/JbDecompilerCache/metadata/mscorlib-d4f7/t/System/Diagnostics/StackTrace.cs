// Type: System.Diagnostics.StackTrace
// Assembly: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
// Assembly location: C:\Windows\Microsoft.NET\Framework\v4.0.30319\mscorlib.dll

using System;
using System.Runtime.InteropServices;
using System.Security;
using System.Security.Permissions;
using System.Threading;

namespace System.Diagnostics
{
    [ComVisible(true)]
    [Serializable]
    [SecurityPermission(SecurityAction.InheritanceDemand, UnmanagedCode = true)]
    public class StackTrace
    {
        public const int METHODS_TO_SKIP = 0;
        public StackTrace();
        public StackTrace(bool fNeedFileInfo);
        public StackTrace(int skipFrames);
        public StackTrace(int skipFrames, bool fNeedFileInfo);
        public StackTrace(Exception e);
        public StackTrace(Exception e, bool fNeedFileInfo);
        public StackTrace(Exception e, int skipFrames);
        public StackTrace(Exception e, int skipFrames, bool fNeedFileInfo);
        public StackTrace(StackFrame frame);
        public StackTrace(Thread targetThread, bool needFileInfo);
        public virtual StackFrame GetFrame(int index);

        [ComVisible(false)]
        public virtual StackFrame[] GetFrames();

        [SecuritySafeCritical]
        public override string ToString();

        public virtual int FrameCount { get; }
    }
}
