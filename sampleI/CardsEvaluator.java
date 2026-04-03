package sampleI;

public class CardsEvaluator {

    private final java.util.List<String> cards = new java.util.ArrayList<>();

    public CardsEvaluator(String filename) {

        try (java.io.BufferedReader file = new java.io.BufferedReader(new java.io.FileReader(filename))) {

            while (file.readLine() != null) {
                this.cards.add(file.readLine());
                file.readLine();
            }
        } catch (java.io.IOException e) {
            System.out.println("Cannot read file!!");
        }
    }
}
