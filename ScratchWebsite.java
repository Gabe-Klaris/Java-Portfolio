package JavaProjects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
class ScratchWebsite {
    public static String splitting(String line) {
        String[] splitter = line.split(">", 2);
        String[] splitter2 = splitter[1].split("<", 2);
        return splitter2[0];
    }
    public static void main(String[] args) throws IOException {
        System.out.println("What user would you like to search for?");
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();
        URL url = new URL("https://scratch.mit.edu/users/" + user + "/");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        // System.out.println(br.readLine());

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            if (line.contains("Joined <span title=")) {
                String joined = splitting(line);
                System.out.println("User " + user + " joined " + joined + " ago.");
            }
            if (line.contains("<span class=\"location\">")) {
                String location = splitting(line);
                System.out.println("User " + user + " location is " + location + ".");
            }
            if (line.contains("bio-readonly")) {
                br.readLine();
                String aboutmeline = null;
                aboutmeline = br.readLine();
                String aboutme = splitting(aboutmeline);
                System.out.println("User " + user + " About me is " + aboutme + ".");
            }
            if (line.contains("status-readonly")) {
                br.readLine();
                String whatimworkingonline = null;
                whatimworkingonline = br.readLine();
                String whatimworkingon = splitting(whatimworkingonline);
                System.out.println("What " + user + " is working on is " + whatimworkingon + ".");
                }
             }
    }
}
