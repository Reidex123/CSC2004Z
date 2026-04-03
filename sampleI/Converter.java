package sampleI;

public class Converter {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            String userInput;
            do {

                System.out.println("Enter a time or quit:");
                userInput = input.nextLine();

                java.time.LocalTime time = java.time.LocalTime.parse(userInput, java.time.format.DateTimeFormatter.ofPattern("HH:mm"));

                System.out.println(new TimeEvaluator(time));

            } while (userInput.equalsIgnoreCase("quit"));
        }
    }
}