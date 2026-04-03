package sampleI;

public class Convertor {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            String userInput;

            System.out.println("Enter a time or 'quit':");
            userInput = input.nextLine();

            while (!userInput.equalsIgnoreCase("quit")) {

                java.time.LocalTime time = java.time.LocalTime.parse(userInput,
                        java.time.format.DateTimeFormatter.ofPattern("H:mm"));

                TimeEvaluator results = new TimeEvaluator(time);
                System.out.println(results.toString());

                System.out.println("Enter a time or 'quit':");
                userInput = input.nextLine();

            }

            System.out.println("Done");
        }
    }
}

class TimeEvaluator {

    private final java.util.Map<Integer, String> quarters = new java.util.HashMap<>();
    private final String[] hours = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
    private final java.time.LocalTime time;

    public TimeEvaluator(java.time.LocalTime time) {
        this.time = time;
        this.populateMap();
    }

    private void populateMap() {

        String[] wordQ = {"five", "ten", "quarter", "twenty", "twenty five", "half"};
        int count = 0;

        for (int i = 5; i <= 30; i += 5) {
            this.quarters.put(i, wordQ[count++]);
        }

    }

    private String firstHalf() {

        int round = (int) Math.round(this.time.getMinute() / 5.0) * 5;

        String firstInstance = this.quarters.get(this.time.getMinute()) + " past " + this.hours[this.time.getHour() - 1];

        String secondInstance = "about " + this.quarters.get(round) + " past " + this.hours[this.time.getHour() - 1];

        if (round == 0) {
            secondInstance = "about " + this.hours[this.time.getHour() - 1] + " o'clock";
        }

        return quarters.containsKey(this.time.getMinute()) ? firstInstance : secondInstance;
    }

    private String lastHalf() {

        int round = 60 - ((int) Math.round(this.time.getMinute() / 5.0) * 5);

        String firstInstance = this.quarters.get(round) + " to " + this.rollOver(this.time.getHour());
        String secondInstance;

        if (round == 0) {
            secondInstance = "about " + this.rollOver(this.time.getHour()) + " o'clock";
        } else if (round == 30) {
            secondInstance = "about " + this.quarters.get(round) + " past " + this.hours[this.time.getHour() - 1];
        }
        else {
            secondInstance = "about " + this.quarters.get(round) + " to " + this.rollOver(this.time.getHour());
        }

        return quarters.containsKey(60 - this.time.getMinute()) ? firstInstance : secondInstance;

    }

    private String rollOver(int hourToRoll) {

        if (hourToRoll + 1 > 12) {
            return this.hours[0];
        }

        return this.hours[hourToRoll];
    }

    @Override
    public String toString() {

        if (this.time.equals(java.time.LocalTime.NOON)) {
            return this.hours[this.time.getHour() - 1] + " o'clock";
        }

        if (this.time.getMinute() == 0) {
            return this.hours[this.time.getHour() - 1] + " o'clock";
        }

        if (this.time.getMinute() < 30) {
            return this.firstHalf();
        }

        if (this.time.getMinute() > 30) {
            return this.lastHalf();
        }

        return "half past " + this.hours[this.time.getHour() - 1];
    }
}
