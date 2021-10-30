package Source.linkedList;

public class List {
    public Node head;

    public Node insert(Node n) {
        Node temp = head;

        if (n.dueDate != null) {
            // insert according to due date
            // more urgent first

            if (temp.dueDate != null) {
                // n has due date, temp doesn't
                // n is more urgent than temp

                // if(t)
            }
        }

        return n;
    } // insert
}