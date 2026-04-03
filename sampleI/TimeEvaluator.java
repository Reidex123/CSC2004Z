package sampleI;

public class TimeEvaluator {

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

        return quarters.containsKey(this.time.getMinute()) ? firstInstance: secondInstance;
    }

    private String lastHalf() {

        int round = 60 - ((int) Math.round(this.time.getMinute() / 5.0) * 5);

        String firstInstance = this.quarters.get(this.time.getMinute()) + " to " + this.rollOver(this.time.getHour());
        String secondInstance;

        if (round == 0) {
            secondInstance = "about " + this.rollOver(this.time.getHour()) + " o'clock";
        } else {
            secondInstance = "about " + this.quarters.get(round) + " to " + this.rollOver(this.time.getHour());
        }


        return quarters.containsKey(this.time.getMinute()) ? firstInstance : secondInstance;

    }

    private String rollOver(int hourToRoll) {

        if (hourToRoll + 1 > 12) {
            return this.hours[0];
        }

        return this.hours[hourToRoll];
    }

    @Override
    public String toString() {

        if (this.time.equals(java.time.LocalTime.NOON))
            return this.time.toString();

        if (this.time.getMinute() == 0) {
            return String.valueOf(this.time.getHour()) + " o'clock";
        }

        if (this.time.getMinute() < 30) {
            return this.firstHalf();
        }

        if (this.time.getMinute() > 30) {
            return this.lastHalf();
        }

        return "half past " + this.time.getHour();
    }
}
