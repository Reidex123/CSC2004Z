package sampleIII;

public class BucketList {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the categories file:");
            String filename = input.nextLine();

            categories storedCategories = new categories(filename);

            System.out.println("Enter a comma-separated list of words:");
            String[] words = input.nextLine().split(", ");

            for (String category : storedCategories.getCateg()) {

            }
        }
    }

}

class categories {

    public java.util.List<String> categ;

    public categories(String filename) {
        this.categ = new java.util.ArrayList<>();
        this.readFile(filename);
    }

    private void readFile(String filename) {

        try (java.io.BufferedReader file = new java.io.BufferedReader(new java.io.FileReader(filename))) {

            String line = file.readLine();

            while (line != null) {
                this.categ.add(line);
                line = file.readLine();
            }
        } catch (java.io.IOException e) {
            System.out.println("file not found");
        }
    }

    public java.util.List<String> getCateg() {

        return this.categ;
    }
}
