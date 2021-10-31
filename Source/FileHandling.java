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

public class FileHandling {
    public void printinFILE(Node curr, String FileName) {
        // Node curr = new Node();/
        try {
            FileWriter f = new FileWriter(FileName);
            while (curr != null) {
                // f.write(curr.Value + "\t" + curr.Due + "\t" + curr.Important + "\n");
                f.write(curr.Title + "\t" + curr.Description + "\t" + curr.Due + "\t" + curr.Important + "\n");
                curr = curr.Next;
            }

            f.close();
        } catch (IOException exception) {
            System.out.println("Error occured");
            exception.printStackTrace();
        }
    }

    public static List ScanFile() throws Exception {
        List taskList = new List();
        try {
            File f = new File("D://Submissions//TRIES//JAVA INNVOTIVE//Source//try1.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String st;
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
        return taskList;
    }
}
