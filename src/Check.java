import java.io.*;
import java.util.*;

public class Check {

	public static ArrayList<String> setCards = new ArrayList<String>();

	public static void evaluateCards(ArrayList<String> setCards){

		String[] set1 = setCards.get(0).split(",");
		String[] set2 = setCards.get(1).split(",");
		String[] set3 = setCards.get(2).split(",");

		boolean isValid = isValidSet_Cards(set1, set2, set3);
		
		if (isValid){
			System.out.println("Valid");
		}else{
			System.out.println("Invalid");
		}
	}

	private static boolean isValidSet_Cards(String[] set1, String[] set2, String set3){

		for (int i = 0; i < 3; i++){
			if ((set1[i] != set2[i] && set2[i] != set3[i]) && set1[i] != set3[i]){
			 	return false;
			}
		}

		return true;
	}

	private static void cards(String[] line){
		for (int i = 0; i < line.length; i++){
			setCards.add(line[i])
		}
	}

	public static void main(String[] args) {
        	try (Scanner input = new Scanner(System.in)) { // avoid memory leaks
            		String filename = input.nextLine();

            		try (BufferedReader file = new BufferedReader(new File(filename)){
		    		String line;

		    		while(line = filename.readLine() != null){
			    		cards(line.split(" "));
				}

				evaluateCards(setCards);
		    	}
                
           	 } catch (IOException e) {
            		System.out.println("Couldn't open the file");
            	}



        }
    }
}
