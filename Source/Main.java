package Source;

import Source.linkedList.List;

import Source.Frame.ListFrame;

import javax.swing.*;

public class Main {
    public static JFrame mainFrame;
    public static List taskList;
    public static ListFrame taskListFrame;
    public static FileHandling fh;

    public static void main(String[] args) throws Exception {

        mainFrame = new JFrame();
        mainFrame.setSize(1000, 800);

        fh = new FileHandling();
        taskList = fh.ScanFile();

        taskListFrame = new ListFrame(taskList);
        taskListFrame.Print();

    }
}