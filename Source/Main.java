package Source;

import Source.linkedList.List;
import Source.linkedList.Node;

import Source.FileHandling;

import Source.Frame.ListFrame;
//import Source.Frame.NodeFrame;

import javax.swing.*;
import java.awt.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(400, 500);
        mainFrame.setVisible(true);

        FileHandling fh = new FileHandling();
        List taskList = fh.ScanFile();
        Node curr = taskList.Head;

        ListFrame taskListFrame = new ListFrame(taskList);
        taskListFrame.Print(mainFrame);

        Scanner SC = new Scanner(System.in);
        SC.nextInt();
    }
}