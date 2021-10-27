package Source.linkedList;

public class List {
    public Node head;

    public void insertAtStart(Node n) {
        head.Prev = n;
        n.Next = head;
        head = n;
    }
}