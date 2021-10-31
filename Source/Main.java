package Source;

import java.io.BufferedReader;
import Source.linkedList.List;
import java.io.File;
import Source.linkedList.Node;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public void printinFILE() {
        Node curr = new Node();
        try {
            FileWriter f = new FileWriter("try1.txt");
            while (curr != null) {
                // f.write(curr.Value + "\t" + curr.Due + "\t" + curr.Important + "\n");
                f.write(curr.Title + "\t" + curr.Description + "\t" + curr.Due + "\t" + curr.Important + "\n");
            }

            f.close();
        } catch (IOException exception) {
            System.out.println("Error occured");
            exception.printStackTrace();
        }
    }

    public static void ScanFile() throws Exception {
        try {
            File f = new File("D://Submissions//TRIES//JAVA INNVOTIVE//Source//try1.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String st;
            List taskList = new List();
            while ((st = br.readLine()) != null) {
                // Print the string
                // System.out.println(st);
                String words[] = st.split("\t");
                SimpleDateFormat formatter = new SimpleDateFormat("E MMM DD HH:mm:ss yyyy");
                Node temp = new Node();
                temp.Title = words[0];
                temp.Description = words[1];
                temp.Due = formatter.parse(words[2]);
                try {
                    temp.Due = formatter.parse(words[2]);
                } catch (ParseException e) {
                    System.out.println("Error occurred");
                    e.printStackTrace();
                }
                temp.Important = Boolean.parseBoolean(words[3]);
                taskList.Insert(temp);
            }
            br.close();
            // f.close();
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        List taskList = new List();
        Node curr = taskList.Head;
        /**
         * FileWriter(String file) Creates a new file. It gets file name in string.
         * FileWriter(File file) Creates a new file. It gets file name in File object.
         */
        try {
            ScanFile();
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }

        while (curr != null) {
            System.out.println("Hello");
            System.out.println("TITLE: " + curr.Title + "\nDescription: " + curr.Description + "\nDue: " + curr.Due
                    + "\nIs Important? " + curr.Important + "\n\n");
            curr = curr.Next;
        }
    }
}