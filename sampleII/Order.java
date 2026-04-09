package sampleII;

public class Order {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the word lists text file:");
            String filename = input.nextLine();

            Read wordLists = new Read(filename);

            for (String line : wordLists.list) {

                java.util.List<String> subWords = new java.util.ArrayList<>();
                java.util.List<Integer> counts = new java.util.ArrayList<>();

                for (String word : line.split(" ")) {

                    if (subWords.isEmpty()) {
                        subWords.add(word);
                    }
                    else {

                        if (subWords.get(subWords.size() - 1).compareTo(word) < 0) {
                            subWords.add(word);
                        }
                        else {
                            counts.add(subWords.size());
                            subWords.clear();
                            subWords.add(word);
                        }
                    }
                }

                if (!subWords.isEmpty()) {
                    counts.add(subWords.size());
                }

                int length = java.util.Collections.max(counts);

                if (java.util.Collections.frequency(counts, length) > 1) {
                    System.out.println("Multiple solutions length " + length + ".");
                } else {
                    System.out.println("Longest is " + length + ".");
                }
            }
            System.out.println("Done");
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
