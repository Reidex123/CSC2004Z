package sampleI;

public class Check {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the cards file:");
            String cardsFile = input.nextLine();

            CardsEvaluator cards = new CardsEvaluator(cardsFile);

            cards.process();
        }
    }
}
