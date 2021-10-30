package Source.linkedList;

import java.util.Date;
import java.util.Calendar;

public class Node {
    public Node Prev;
    public Node Next;

    public int Value;

    public Date Due;
    public Boolean Important;

    public Boolean Urgent() {
        return dueIn() < 7;
    }

    public Boolean OverDue() {
        return dueIn() < 0;
    }

    public long dueIn() {
        if (Due != null) {
            Date Today = Calendar.getInstance().getTime();
            long DiffMS = Due.getTime() - Today.getTime();

            long DiffDAYS = DiffMS / (1000 * 60 * 60 * 24);
            return DiffDAYS;
        } else {
            return 8;
        }
    }
}
