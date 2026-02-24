import java.util.*;

public static  Map<Integer, String> mapTimeHr = new HashMap<>();
public static  Map<Integer, String> mapTimeMin = new HashMap<>();
public static final String[] hours = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
public static final String[] min = {"five", "ten", "quater", "twenty", "twenty five", "half"};
/**Map every int value to the corresponding word
  */
public static void populateMaps(String[] hours, String[] min){
	for (int i = 1; i <= hours.length; i++) {
		mapTimeHr.put(i, hours[i - 1]);
	}

	int pointer = 0;
	for (int j = 5; j <= 30; j += 5) {
		mapTimeMin.put(j, min[pointer++]);
	}
}

/**Evaluate time in English format
 *@param time - time to be evaluated
 * */
public static void evaluateTime(String[] time) {
	int hour = Integer.parseInt(time[0]);
	int minutes = Integer.parseInt(time[1]);

	String roundMinutes = round(minutes);

}

private static String round(int minutes) {

	if (minutes % 5 == 0 || minutes % 5 == minutes) {
		return "o'clock";
	}
	if (minutes < 30) {

	}
	return null;
}

/**Main program
 * */
public static void main(String[] args){

	populateMaps(hours, min);
	Scanner input = new Scanner(System.in);

	while(true){
		System.out.println("Enter time or 'quit':\n");
		String userInput = input.nextLine();

		if (userInput.equals("quit")){
			break;
		}

		evaluateTime(userInput.split(":"));

	}

	System.out.println("Done");
	input.close();
}
