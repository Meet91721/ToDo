package Source.Frame;

import Source.Main;
import Source.linkedList.List;
import Source.linkedList.Node;

import java.awt.event.*;
import javax.swing.*;

import Source.Frame.ListFrame;
import java.text.SimpleDateFormat;

public class ListFrame extends List implements Frame {
    public ListFrame(List L) {
        super();
        this.Head = L.Head;
    }

    public void Print() {
        Main.mainFrame.setVisible(false);

        Main.mainFrame = new JFrame();
        Main.mainFrame.setSize(1000, 800);

        Node Temp = this.Head;
        int Counter = 0;

        while (Temp != null) {
            final Node t = Temp;
            // System.out.println("Hello" + Counter);
            JLabel Label = new JLabel("<html><h1>" + Temp.Title + "</h1></html>");
            Label.setBounds(21, 17 + 37 * Counter, 200, 35);// x, y, w, h

            Label.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    // Label.setText("Mouse Clicked");
                    NodeFrame current = new NodeFrame(t);
                    current.Print();
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

            Main.mainFrame.add(Label);

            Temp = Temp.Next;
            Counter++;
        }
        JTextField tit = new JTextField();
        JTextField des = new JTextField();
        JTextField du = new JTextField();
        JTextField im = new JTextField();
        JLabel l1 = new JLabel("Title");
        JLabel l2 = new JLabel("Description");
        JLabel l3 = new JLabel("Due Date");
        JLabel l4 = new JLabel("Important");
        l1.setBounds(21, 470, 150, 30);
        l2.setBounds(21, 570, 150, 30);
        l3.setBounds(300, 470, 150, 30);
        l4.setBounds(300, 570, 150, 30);

        tit.setBounds(21, 500, 150, 30);
        des.setBounds(21, 600, 150, 30);
        du.setBounds(300, 500, 150, 30);
        im.setBounds(300, 600, 150, 30);
        Main.mainFrame.add(l1);
        Main.mainFrame.add(l2);
        Main.mainFrame.add(l3);
        Main.mainFrame.add(l4);

        Main.mainFrame.add(tit);
        Main.mainFrame.add(des);
        Main.mainFrame.add(du);
        Main.mainFrame.add(im);

        JButton Binsert = new JButton("Add task");
        Binsert.setBounds(170, 700, 200, 40);
        Main.mainFrame.add(Binsert);
        Binsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Node te = new Node();
                te.Description = des.getText();
                try {
                    te.Due = new SimpleDateFormat("dd/MM/yyyy").parse(du.getText());
                } catch (Exception E) {
                    E.printStackTrace();
                }
                te.Important = Boolean.parseBoolean(im.getText());
                te.Title = tit.getText();
                Main.taskList.Insert(te);
                Main.taskListFrame = new ListFrame(Main.taskList);
                Main.taskListFrame.Print();
                Main.fh.printinFILE(Main.taskList.Head, "./Source/Data.txt");
            }
        });

        JLabel Label = new JLabel();
        Label.setVisible(false);
        Main.mainFrame.add(Label);

        Main.mainFrame.setVisible(true);
    }
}
