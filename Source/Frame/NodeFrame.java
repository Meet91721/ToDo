package Source.Frame;

import Source.Main;
import Source.linkedList.Node;

import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;

public class NodeFrame extends Node implements Frame {
    Node node;

    public NodeFrame(Node N) {
        super();
        this.node = N;
        this.Title = N.Title;
        this.Description = N.Description;
        this.Next = N.Next;
        this.Prev = N.Prev;
        this.Important = N.Important;
        this.Due = N.Due;
    }

    public void Print() {
        Main.mainFrame.setVisible(false);

        Main.mainFrame = new JFrame();
        Main.mainFrame.setSize(1000, 800);

        Main.taskListFrame.Print();

        JTextField title = new JTextField(this.Title);
        title.setBounds(400, 50, 400, 40);// x, y, w, h
        JTextField description = new JTextField(this.Description);
        description.setBounds(400, 120, 400, 40);
        JTextField due = new JTextField(String.valueOf(this.Due));
        due.setBounds(400, 180, 400, 40);
        JTextField imp = new JTextField(String.valueOf(this.Important));
        imp.setBounds(400, 240, 400, 40);
        Main.mainFrame.add(title);
        Main.mainFrame.add(description);
        Main.mainFrame.add(due);
        Main.mainFrame.add(imp);

        JButton delete = new JButton("Delete Task");
        delete.setBounds(800, 90, 200, 40);
        JButton edit = new JButton("Edit Task");
        edit.setBounds(800, 230, 200, 40);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.taskList.Delete(node);
                Main.taskListFrame = new ListFrame(Main.taskList);
                Main.taskListFrame.Print();
                Main.fh.printinFILE(Main.taskList.Head, "./Source/Data.txt");
            }
        });

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Node te = new Node();
                node.Description = description.getText();
                try {
                    node.Due = new SimpleDateFormat("dd/MM/yyyy").parse(due.getText());
                } catch (Exception E) {
                    E.printStackTrace();
                }
                node.Important = Boolean.parseBoolean(imp.getText());
                node.Title = title.getText();
                Main.taskList.ReInsert(node);
                Main.taskListFrame = new ListFrame(Main.taskList);
                Main.taskListFrame.Print();
                Main.fh.printinFILE(Main.taskList.Head, "./Source/Data.txt");
            }
        });
        Main.mainFrame.add(delete);
        Main.mainFrame.add(edit);

        JLabel extra = new JLabel();
        extra.setBounds(400, 240, 600, 40);
        extra.setVisible(false);
        Main.mainFrame.add(extra);

        Main.mainFrame.setVisible(true);
    }

}
