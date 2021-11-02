package Source.Frame;

import Source.linkedList.List;
import Source.linkedList.Node;

import java.awt.*;
import javax.swing.*;

import Source.Frame.Frame;

public class ListFrame extends List implements Frame {
    public ListFrame(List L) {
        super();
        this.Head = L.Head;
    }

    public void Print(JFrame mainFrame) {
        mainFrame.setVisible(false);

        Node Temp = this.Head;
        int Counter = 0;
        while (Temp != null && Temp.Next != null) {
            JLabel Label = new JLabel(Temp.Title);
            Label.setBounds(25, 25 + 25 * Counter, 50, 25);

            mainFrame.add(Label);

            Temp = Temp.Next;
            Counter += 1;
        }

        mainFrame.setVisible(true);
    }
}
