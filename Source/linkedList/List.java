package Source.linkedList;

import ConsoleFunJNI.ConsoleFun;
import ConsoleFunJNI.CFOpts;

public class List {
    public Node Head;

    public void Insert(Node N) {
        // Node N to be inserted in the list;
        // Linked list structure
        // U = Urgent, I = Important
        // [UI]->[U?]->[?I]->[??]
        // Insertion in [??] - Begining of section
        // Insertion in [?I] - Begining of section
        // Insertion in [U?] - According to time left
        // Insertion in [UI] - According to time left

        if (Head == null) {
            // Linked List is null,
            // N should be at Head

            Head = N;
            Head.Prev = null;
            Head.Next = null;
        } else {
            // Check where N belongs
            Node temp = Head;

            if (N.Urgent()) {
                // N belongs to [UI] or [U?]

                if (N.Important) {
                    // N belongs to [UI]
                    // Skip all Nodes where Nodes.dueIn() is < N.dueIn();
                    while (temp.Next != null && temp.Next.dueIn() < N.dueIn()) {
                        temp = temp.Next;
                    }
                } else {
                    // N belongs to [U?]
                    // Skip all Nodes in [UI], and in [U?] where Nodes.dueIn() is < N.dueIn();

                    while (temp.Next != null && (temp.Next.Urgent() && temp.Next.Important)) {
                        temp = temp.Next;
                    }
                    // Skipped all Nodes in [UI]
                    // Now skip all Nodes where Nodes.dueIn() is < N.dueIn();
                    while (temp.Next != null && temp.Next.dueIn() < N.dueIn()) {
                        temp = temp.Next;
                    }
                }
            } else if (N.Important) {
                // N belongs to [?I]
                // Skip all Nodes which are [UI] or [U?] and insert before [?I]
                while (temp.Next != null && temp.Next.Urgent()) {
                    temp = temp.Next;
                }
            } else {
                // N belongs to [??]
                // Skip all Nodes which are [UI], [U?] or [?I] and insert before [??]

                while (temp.Next != null && (temp.Next.Urgent() || temp.Next.Important)) {
                    temp = temp.Next;
                }
            }

            if (temp == Head) {
                // temp is Head
                if (N.Urgent() && N.Important) {
                    if (Head.Urgent() && Head.Important && Head.dueIn() < N.dueIn()) {
                        N.Next = Head.Next;
                        N.Prev = Head;
                        Head.Next = N;
                    } else {
                        N.Next = Head;
                        N.Prev = null;
                        Head = N;
                    }
                } else if (N.Urgent() && !N.Important) {
                    if (Head.Urgent() && (Head.Important || Head.dueIn() < N.dueIn())) {
                        N.Next = Head.Next;
                        N.Prev = Head;
                        Head.Next = N;
                    } else {
                        N.Next = Head;
                        N.Prev = null;
                        Head = N;
                    }
                } else if (!N.Urgent() && N.Important) {
                    if (Head.Urgent()) {
                        N.Next = Head.Next;
                        N.Prev = Head;
                        Head.Next = N;
                    } else {
                        N.Next = Head;
                        N.Prev = null;
                        Head = N;
                    }
                } else {
                    if (Head.Urgent() || Head.Important) {
                        N.Next = Head.Next;
                        N.Prev = Head;
                        Head.Next = N;
                    } else {
                        N.Next = Head;
                        N.Prev = null;
                        Head = N;
                    }
                }
            } else {
                N.Next = temp.Next;
                N.Prev = temp;
                temp.Next = N;
            }

            if (N.Next != null) {
                N.Next.Prev = N;
            }
        }

        return;

    } // Insert

    public Node Delete(Node N) {
        if (N == Head) {
            // deletion at beginning
            Head = N.Next;
            Head.Prev = null;
        } else {
            N.Prev.Next = N.Next;

            if (N.Next != null) {
                N.Next.Prev = N.Prev;
            }
        }

        N.Next = null;
        N.Prev = null;

        return N;
    } // Delete

    public void ReInsert(Node N) {
        Insert(Delete(N));
    } // ReInsert
}