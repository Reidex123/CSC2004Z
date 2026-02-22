/**
 * @author Koketso
 * @version 21/02/2026
 */

import java.util.*;
public static final Map<Integer, String> mapTime = new HashMap<Integer, String>();
public static final String[] intWord = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};

/**Map every int value to the corresponding word
 * @param timeWord - List containing strings corresponding to the relevant int
 * */
public static void populateMap(String[] timeWord){
	for (int i = 1; i <= timeWord.length; i++){
		mapTime.put(i, timeWord[i-1]);
	}
}

/**Evaluate time in English format
 *@param time - time to be evaluated
 * */
public static void evaluateTime(String[] time){
	int hour = Integer.parseInt(time[0]);
	int minutes = Integer.parseInt(time[1]);

}

/**Main program
 * */
public static void main(String[] args){

	populateMap(intWord);
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
