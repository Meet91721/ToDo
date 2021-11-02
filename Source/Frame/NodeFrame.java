package Source.Frame;

import Source.linkedList.List;
import Source.linkedList.Node;

import java.awt.*;
import javax.swing.*;

import Source.Frame.Frame;

public class NodeFrame extends Node implements Frame {
    public NodeFrame(Node N) {
        super();
        this.Title = N.Title;
        this.Description = N.Description;
        this.Next = N.Next;
        this.Prev = N.Prev;
        this.Important = N.Important;
        this.Due = N.Due;
    }

    public void Print(JFrame jf) {
        jf.setVisible(false);

        JLabel title = new JLabel("<html><h1>" + this.Title + "</h1></html>");
        title.setBounds(250, 50, 100, 40);// x, y, w, h
        JLabel description = new JLabel("<html><h2>" + this.Description + "</h2></html>");
        title.setBounds(200, 120, 100, 40);
        JLabel due = new JLabel("<html><h3>" + this.Due + "</h3></html>");
        title.setBounds(200, 180, 100, 40);
        JLabel imp = new JLabel("<html><h3>" + this.Important + "</h1></html>");
        title.setBounds(200, 240, 100, 40);
        jf.add(title);
        jf.add(description);
        jf.add(due);
        jf.add(imp);

        jf.setVisible(true);
    }

}
