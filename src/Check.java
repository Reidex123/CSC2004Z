import java.io.*;
import java.util.*;

public class Check {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) { // avoid memory leaks
            String filename = input.nextLine();

            try (FileInputStream file = new FileInputStream(new File(filename))) {
                
            } catch (IOException e) {
                System.out.println("Couldn't open the file");
            }



        }
    }
}
