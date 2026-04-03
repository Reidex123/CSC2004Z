package sampleI;

public class Check {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            String cardsFile = input.nextLine();

            CardsEvaluator cards = new CardsEvaluator(cardsFile);
        }
    }
}
