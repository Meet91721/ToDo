package Source;

import ConsoleFunJNI.ConsoleFun;
import ConsoleFunJNI.CFOpts;

import Source.linkedList.List;
import Source.linkedList.Node;

public class TestCF {

    public static void main(String[] args) {
        // Load ConsoleFun library;
        ConsoleFun.LoadLib("./ConsoleFun/ConsoleFunJNI");

        char Str[];
        CFOpts Options = ConsoleFun.GetOpts();

        Options.BG = ConsoleFun.Color.Yellow;
        Options.Row = 0;
        Options.Col = 0;
        ConsoleFun.FilledRect(Options);

        Options.Row = 1;
        Options.Col = 1;
        Options.Rows -= 2;
        Options.Cols -= 2;
        Options.BG = ConsoleFun.Color.Red;
        ConsoleFun.EmptyRect(Options);

        Options.Row = 5;
        Options.Col = 5;
        Options.Rows = 5;
        Options.Cols = 40;
        Options.BG = ConsoleFun.Color.Black;
        ConsoleFun.GotoRC(4, 5);

        System.out.print("Enter text Here: ");
        Str = ConsoleFun.ReadBox(Options);

        ConsoleFun.GotoRC(14, 5);
        Options.Row = 15;
        Options.FG = ConsoleFun.Color.Black;
        Options.BG = ConsoleFun.Color.Cyan;

        System.out.print("You Entered: ");
        ConsoleFun.WriteBox(Str, Options);

        ConsoleFun.GetCh();
        return;
    } // main
}
