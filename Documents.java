package JavaProjects;   
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class Documents {
    public static void main(String[] args) throws IOException {
        System.out.println("what would you like to do: read or write data");
        Scanner input = new Scanner(System.in);
        String task = input.nextLine();
        if (task.equals("read")) {
            ArrayList<String> Titles = new ArrayList<String>();
            ArrayList<String> content = new ArrayList<String>();
            File myObj = new File("C:\\Users\\gckyo\\.vscode\\Programs\\Test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitter = data.split(":", 2);
                Titles.add(splitter[0]);
                content.add(splitter[1]);
            }
            myReader.close();
            System.out.println("What are you looking for");
            Scanner chose = new Scanner(System.in);
            String info = chose.nextLine();
            for (int i = 0; i < Titles.size() -1; i ++) {
                if (Titles.get(i).equals(info)) {
                    System.out.println("the data related to " + info + " is " + content.get(i));

                }
            }
        }
        if (task.equals("write")) {
            System.out.println("what would you like to add");
            Scanner write = new Scanner(System.in);
            String newline = write.nextLine();
            File file = new File("C:\\Users\\gckyo\\.vscode\\Programs\\Test.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(newline);
            pw.close();
            System.out.println("you have added " + newline);


        }   
    }
}
// # https:// stackoverflow.com/questions/20841980/read-a-file-and-split-lines-in-java
// #when reading file split lines into seperate lists, and append into title and info and the idexes in the list should match up    
