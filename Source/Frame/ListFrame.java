package Source.Frame;

import ConsoleFunJNI.ConsoleFun;
import ConsoleFunJNI.CFOpts;

import Source.linkedList.List;
import Source.linkedList.Node;

public class ListFrame extends List implements Frame {
    public NodeFrame CurrentFocus;

    public ListFrame(List L) {
        super();
        this.Head = L.Head;
        CurrentFocus = new NodeFrame(Head);
    }

    public void Display1() {
        CFOpts Options = ConsoleFun.GetOpts();

        Options.Row = 0;
        Options.Col = 0;
        Options.Cols /= 3;
        Options.FG = ConsoleFun.Color.White;
        Options.BG = ConsoleFun.Color.Blue;
        // Options contains the (Row, Col) for top left corner of frame
        // Rows and Cols it covers (Height and Width)
        // And FG and BG (Blue) colors

        // First, Draw an filled rectangle for frame;

        ConsoleFun.FilledRect(Options);

        Node curr = Head;

        int i = 0;
        int MAX = Options.Rows / 2; // Total rows / rows per elements to be printed
        while (i < MAX && curr != null) {
            ConsoleFun.GotoRC(2 * i, 0);
            System.out.println(curr.Title);
            curr = curr.Next;
            i += 1;
        }

    } // Display1

    public void Display2() {
        CurrentFocus.Display1();
    } // Display2

}