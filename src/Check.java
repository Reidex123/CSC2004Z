import java.io.*;
import java.util.*;

public class Check {

	public static ArrayList<String> setCards = new ArrayList<String>();

	public static void evaluateCards(ArrayList<String> setCards){

		for (int i = 0; i < setCards.size(); i++){
			String[] sets_cards = setCards.get(i).split(" ");

			String[] set1 = sets_cards[0].split(",");
			String[] set2 = sets_cards[1].split(",");
			String[] set3 = sets_cards[2].split(",");

			boolean isValid = isValidSet_Cards(set1, set2, set3);

			System.out.println("Processing: " + setCards.get(i));

			if (isValid){
				System.out.println("Valid");
			}
			else{
				System.out.println("Invalid");
			}
		}

		System.out.println("Done");
	}

	private static boolean isValidSet_Cards(String[] set1, String[] set2, String[] set3){

		for (int i = 0; i < 3; i++){
			if ((set1[i] != set2[i] && set2[i] != set3[i]) && set1[i] != set3[i]){
			 	return false;
			}
		}

		return true;
	}

	private static void cards(String line){
		setCards.add(line);
	}

	public static void main(String[] args) {
        	try (Scanner input = new Scanner(System.in)) { // avoid memory leaks
							       //
            	System.out.println("Enter the name of the file: ");
				String filename = input.nextLine();

            	try (BufferedReader file = new BufferedReader(new FileReader(filename))){
		    		String line = file.readLine();

		    		while(line != null){
			    		cards(line);

						line = file.readLine();
					}

					evaluateCards(setCards);
		    	}
				catch(IOException e){
					System.out.println("Couldn't open the file.");
				}
           	 }
        }
}
