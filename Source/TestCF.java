package Source;

import ConsoleFunJNI.ConsoleFun;
import ConsoleFunJNI.CFOpts;

import Source.linkedList.List;
import Source.linkedList.Node;

public class TestCF {
    public static void main(String[] args) {
        ConsoleFun.LoadLib("./ConsoleFun/ConsoleFunJNI");

        List taskList = new List();

        for (int i = 0; i < 5; i += 1) {
            Node task = new Node();

            task.Important = (Math.floor(2 * Math.random()) == 1);
            task.Value = i;
            taskList.Insert(task);
        }

        taskList.Print();
    }
}