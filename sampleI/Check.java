package sampleI;

public class Check {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the cards file:");
            String cardsFile = input.nextLine();

            CardsEvaluator cards = new CardsEvaluator(cardsFile);

            cards.process();

            System.out.println("Done");
        }
    }
}

class card {

    private String shape;
    private String color;
    private String pattern;

    public card(String[] cardAttributes) {

        this.shape = cardAttributes[0];
        this.color = cardAttributes[1];
        this.pattern = cardAttributes[2];
    }

    public String getShape() {
        return this.shape;
    }

    public String getColor() {
        return this.color;
    }

    public String getPattern() {
        return this.pattern;
    }

    public boolean equal(card other) {
        return this.getShape().equals(other.getShape()) && this.getColor().equals(other.getColor())
                && this.getPattern().equals(other.getPattern());
    }

    // Two cards are distinct if they do not have the same shape or colour or pattern i.e. none of their attributes match.
    public boolean distinct(card other) {
        return !this.getShape().equals(other.getShape()) && !this.getColor().equals(other.getColor())
                && !this.getPattern().equals(other.getPattern());
    }

    // A set of three cards is valid if it consists of (i) three distinct cards, or (ii) three of the same card.
    public boolean equals(card other1, card other2) {

        boolean identical = this.equal(other1) && this.equal(other2);

        boolean notIdentical = this.distinct(other1) && this.distinct(other2) && other1.distinct(other2);

        return identical || notIdentical;
    }

}

class CardsEvaluator {

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
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
