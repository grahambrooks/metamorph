// Type: System.Exception
// Assembly: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
// Assembly location: C:\Windows\Microsoft.NET\Framework\v4.0.30319\mscorlib.dll

using System.Collections;
using System.Reflection;
using System.Runtime.InteropServices;
using System.Runtime.Serialization;
using System.Security;

namespace System
{
    [ComVisible(true)]
    [ClassInterface(ClassInterfaceType.None)]
    [ComDefaultInterface(typeof (_Exception))]
    [Serializable]
    public class Exception : ISerializable, _Exception
    {
        public Exception();
        public Exception(string message);
        public Exception(string message, Exception innerException);

        [SecuritySafeCritical]
        protected Exception(SerializationInfo info, StreamingContext context);

        public virtual Exception GetBaseException();

        [SecuritySafeCritical]
        public override string ToString();

        [SecurityCritical]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context);

        public new Type GetType();

        public virtual string Message { [SecuritySafeCritical]
        get; }

        public virtual IDictionary Data { [SecuritySafeCritical]
        get; }

        public Exception InnerException { get; }

        public MethodBase TargetSite { [SecuritySafeCritical]
        get; }

        public virtual string StackTrace { [SecuritySafeCritical]
        get; }

        public virtual string HelpLink { get; set; }

        public virtual string Source { [SecuritySafeCritical]
        get; set; }

        protected int HResult { get; set; }
        protected event EventHandler<SafeSerializationEventArgs> SerializeObjectState;
    }
}
