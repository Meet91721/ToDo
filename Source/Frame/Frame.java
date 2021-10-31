package Source.Frame;

import ConsoleFunJNI.CFOpts;
import ConsoleFunJNI.ConsoleFun;

public interface Frame {
    public static class Color {
        public static int overdue = ConsoleFun.Color.Red;
        public static int IU = ConsoleFun.Color.Magenta;
        public static int U = ConsoleFun.Color.Cyan;
        public static int I = ConsoleFun.Color.Yellow;
        public static int simple = ConsoleFun.Color.Green;
    }

    public void Display1();
}