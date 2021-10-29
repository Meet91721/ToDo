package Source;

import ConsoleFunJNI.ConsoleFun;
import ConsoleFunJNI.CFOpts;

public class TestCF {
    public static void main(String[] args) {
        ConsoleFun.LoadLib("./ConsoleFun/ConsoleFunJNI");

        CFOpts Options = ConsoleFun.GetOpts();

        Options.BG = ConsoleFun.Color.Yellow;
        Options.Row = 0;
        Options.Col = 0;

        ConsoleFun.EmptyRect(Options);

        Options.Row = 2;
        Options.Col = 2;
        Options.Rows -= 4;
        Options.Cols -= 4;
        Options.FG = ConsoleFun.Color.Black;
        Options.BG = ConsoleFun.Color.Red;
        ConsoleFun.FilledRect(Options);

        ConsoleFun.GotoRC(10, 15);
        ConsoleFun.SetColor(ConsoleFun.Color.Cyan, ConsoleFun.Color.Black);
        System.out.print("Hello World!");

        return;
    }
}