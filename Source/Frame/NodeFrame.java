package Source.Frame;

import ConsoleFunJNI.ConsoleFun;
import ConsoleFunJNI.CFOpts;

import Source.linkedList.List;
import Source.linkedList.Node;

public class NodeFrame extends Node implements Frame {
    public NodeFrame(Node N) {
        super();
        this.Prev = N.Prev;
        this.Next = N.Next;

        this.Title = N.Title;
        this.Description = N.Description;

        this.Due = N.Due;
        this.Important = N.Important;
    }

    public void Display1() {
        CFOpts Options = ConsoleFun.GetOpts();

        Options.Row = 0;
        Options.Cols /= 3;
        Options.Col = Options.Cols;
        Options.Cols *= 2;
        Options.FG = ConsoleFun.Color.White;
        Options.BG = ConsoleFun.Color.Green;
        // Options containes the (Row, Col) for top left corner of frame
        // Rows and Cols it covers (Height and Width)
        // And FG and BG (Green) colors

        // First, Draw an filled rectangle for frame;
        ConsoleFun.FilledRect(Options);
    }
}