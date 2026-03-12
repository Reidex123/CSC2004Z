
/**
 *
 * @author Koketso
 * @version 20/02/26
 */


import java.util.*;

public class Convertor {

    public static Map<Integer, String> mapTimeHr = new HashMap<>();
    public static Map<Integer, String> mapTimeMin = new HashMap<>();
    public static final String[] hours = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve"};
    public static final String[] min = {"five", "ten", "quarter", "twenty", "twenty five", "half"};

    /**
     * Map every int value to the corresponding word
     * @param hour
     * @param min
     */
    public static void populateMaps(String[] hours, String[] min) {
        for (int i = 1; i <= hours.length; i++) {
            mapTimeHr.put(i, hours[i - 1]);
        }

        int pointer = 0;
        for (int j = 5; j <= 30; j += 5) {
            mapTimeMin.put(j, min[pointer++]);
        }
    }

    /**
     * Evaluate time in English format
     *
     * @param time - time to be evaluated
	 *
     */
    public static void evaluateTime(String[] time) {
        int hour = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);

        // compute time
        String roundTime = round(minutes, hour);

        System.out.println(roundTime);

    }

    /**
     * Round the given minutes to the nearest multiple of 5
     * @param minutes
     * @param hour
     */
    private static String round(int minutes, int hour) {
        double div = (double) minutes / 5;
        int result = (int) (5 * (Math.round(div)));

        if (minutes == 0 || result == 0) {
            return oClock(hour, minutes);
        }

        if (minutes < 30 && result < 30) {
            return pastHr(hour, minutes, result);
        } else if (minutes > 30 && result > 30) {
            return toHr(hour, minutes, result);
        }

        return halfHr(hour, minutes, result);
    }

    private static String oClock(int hour, int minutes) {
        return (minutes != 0) ? "about " + mapTimeHr.get(hour) + " o'clock " : mapTimeHr.get(hour) + " o'clock";
    }

    /**
     * minutes < 30
     * @param hour
     * @param minutses
     * @param result
     */
    private static String pastHr(int hour, int minutes, int result) {
        if (result != minutes) {
            return "about " + mapTimeMin.get(result) + " past " + mapTimeHr.get(hour);
        }

        return mapTimeMin.get(result) + " past " + mapTimeHr.get(hour);
    }

    /**
     * minutes > 30
     * @param hour
     * @param minutses
     * @param result
     */
    private static String toHr(int hour, int minutes, int result) {
        if ((60 - result != 60 - minutes)) {
            if (60 - result != 0) {
                return "about " + mapTimeMin.get(60 - result) + " to " + mapTimeHr.get(hourRollOver(hour));
            }

            return "about " + mapTimeHr.get(hourRollOver(hour)) + " o'clock";
        } else {
            if (60 - result != 0) {
                return mapTimeMin.get(60 - result) + " to " + mapTimeHr.get(hour + 1);
            }

            return mapTimeHr.get(hour + 1) + " o'clock";
        }

    }

    /**
     * RollOver the hour back to 1 after 12
     * @param hour: hour to rollover
     */
    private static int hourRollOver(int hour) {
        return hour != 12 ? hour + 1 : 1;
    }

    private static String halfHr(int hour, int minutes, int result) {
        return (minutes != result) ? "about half past " + mapTimeHr.get(hour) : "half past " + mapTimeHr.get(hour);
    }

    /**
     * Main program
	 *
     */
    public static void main(String[] args) {

        populateMaps(hours, min);

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a time or 'quit':\n");
                String userInput = input.nextLine();

                if (userInput.equals("quit")) {
                    break;
                }

                evaluateTime(userInput.split(":"));

            }

            System.out.println("Done");
        }
    }
}
