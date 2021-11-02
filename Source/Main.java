package Source;

import Source.linkedList.List;
import Source.linkedList.Node;

import Source.FileHandling;

import Source.Frame.ListFrame;
import Source.Frame.NodeFrame;

public class Main {

    public static void main(String[] args) throws Exception {

        FileHandling fh = new FileHandling();
        List taskList = fh.ScanFile();
        Node curr = taskList.Head;

        ListFrame taskListFrame = new ListFrame(taskList);
        taskListFrame.Display1();
        taskListFrame.Display2();

        ConsoleFun.GetCh();
    }
}