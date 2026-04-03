package sampleI;

public class CardsEvaluator {

    private final java.util.List<String> cards = new java.util.ArrayList<>();

    public CardsEvaluator(String filename) {

        try (java.io.BufferedReader file = new java.io.BufferedReader(new java.io.FileReader(filename))) {

            String Line = file.readLine();

            while (Line != null) {
                this.cards.add(Line);
                Line = file.readLine();
            }
        } catch (java.io.IOException e) {
            System.out.println("Cannot read file!!");
        }
    }

    public void process() {

        for (int i = 0; i < this.cards.size(); i++) {
            card set1 = new card(this.cards.get(i).split(" ")[0].split(","));
            card set2 = new card(this.cards.get(i).split(" ")[1].split(","));
            card set3 = new card(this.cards.get(i).split(" ")[2].split(","));

            System.out.println("Processing: " + this.cards.get(i));

            if (set1.equals(set2, set3)) {
                System.out.println("Valid");
            }
            else {
                System.out.println("Invalid");
            }
        }
    }
}
