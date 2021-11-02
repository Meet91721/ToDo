package Source.Frame;

import Source.linkedList.List;
import Source.linkedList.Node;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.w3c.dom.css.Counter;

import Source.Frame.Frame;

public class ListFrame extends List implements Frame {
    NodeFrame current;

    public ListFrame(List L) {
        super();
        this.Head = L.Head;
    }

    public void Print(JFrame mainFrame) {
        mainFrame.setVisible(false);

        Node Temp = this.Head;
        int Counter = 0;

        while (Temp != null) {
            System.out.println("Hello" + Counter);
            JLabel Label = new JLabel(Temp.Title);
            Label.setBounds(10, 10 + 15 * Counter, 200, 25);// x, y, w, h

            Label.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    // Node t = Temp;
                    Label.setText("Mouse Clicked");
                    // current = new NodeFrame(t);
                    // current.Print(mainFrame);
                }

                public void mouseEntered(MouseEvent e) {
                    // Label.setText("Mouse Entered");
                }

                public void mouseExited(MouseEvent e) {
                    // Label.setText("Mouse Exited");
                }

                public void mousePressed(MouseEvent e) {
                    // Label.setText("Mouse Pressed");
                }

                public void mouseReleased(MouseEvent e) {
                    // Label.setText("Mouse Released");
                }
            });

            mainFrame.add(Label);

            Temp = Temp.Next;
            Counter++;
        }
        JLabel Label = new JLabel(this.Head.Title);
        Label.setBounds(10, 10 + 15 * Counter, 50, 25);// x, y, w, h
        Label.setVisible(false);
        mainFrame.add(Label);

        mainFrame.setVisible(true);
    }
}
