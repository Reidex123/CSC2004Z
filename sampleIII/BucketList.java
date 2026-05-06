package sampleIII;

public class BucketList {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the categories file:");
            String filename = input.nextLine();

            categories storedCategories = new categories(filename);

            System.out.println("Enter a comma-separated list of words:");
            String[] words = input.nextLine().split(", ");

            java.util.LinkedHashMap<String, java.util.List<String>> buckets = new java.util.LinkedHashMap<>();
            for (String cat : storedCategories.getCateg()) {
                buckets.put(cat, new java.util.ArrayList<>());
            }

            java.util.List<String> uncategorised = new java.util.ArrayList<>();

            for (String word : words) {
                String bestMatch = null;

                for (String category : storedCategories.getCateg()) {
                    if (word.startsWith(category)) {
                        if (bestMatch == null || bestMatch.length() < category.length()) {
                            bestMatch = category;
                        }
                    }
                }

                if (bestMatch != null) {
                    buckets.get(bestMatch).add(word);
                } else {
                    uncategorised.add(word);
                }
            }

            System.out.println("Categorised:");
            for (java.util.Map.Entry<String, java.util.List<String>> entry : buckets.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    java.util.List<String> value = entry.getValue();
                    System.out.println(entry.getKey() + ": " + String.join(", ", (value.toString().replace("[", "")).replace("]", "") + "."));
                } else {
                    System.out.println(entry.getKey() + ": ");
                }
            }

            if (!uncategorised.isEmpty()) {
                System.out.println("Uncategorised:");
                System.out.println(String.join(", ", uncategorised) + ".");
            }

            System.out.println("Done");

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
