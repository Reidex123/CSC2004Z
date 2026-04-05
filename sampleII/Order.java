package sampleII;

public class Order {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the word lists text file:");
            String filename = input.nextLine();

            Read wordLists = new Read(filename);

            for (String word : wordLists.list) {
                
            }
        }
    }

}

class Read {
    public java.util.List<String> list = new java.util.ArrayList<>();

    public Read(String filename) {
        this.store(filename);
    }

    private void store(String filename) {

        try (java.io.BufferedReader file = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String line = file.readLine();

            while (line != null) {
                list.add(line);

                line = file.readLine();
            }
        }
        catch (java.io.IOException e) {
            System.out.println("File not found!!");
        }
    }
}
