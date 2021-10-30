package Source;

// import Source.linkedList.List;
import java.io.File;
import Source.linkedList.Node;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {

    public void printinFILE() {
        Node curr = new Node();
        try {
            FileWriter f = new FileWriter("try1.txt");
            while (curr != null) {
                f.write(curr.Title + "\t" + curr.Description + "\t" + curr.startDate + "\t" + curr.dueDate + "\t"
                        + curr.Important + "\n");
            }

            f.close();
        } catch (IOException exception) {
            System.out.println("Error occured");
            exception.printStackTrace();
        }
    }

    public void ScanFile() {
        File f = new File("try1.txt");

    }

    public static void main(String[] args) {
        // List taskList = new List();

        /**
         * FileWriter(String file) Creates a new file. It gets file name in string.
         * FileWriter(File file) Creates a new file. It gets file name in File object.
         */
    }
}