import java.util.*;
import java.time.*;
public class Bookings{

	public static final ArrayList<time> requests = new ArrayList<time>();

	public static void main(String[] args){

		try(Scanner input = new Scanner(Systemn.in){
			System.out.println("Enter the number of bookings:");
			int N = input.nextInt();
			input.nextLine();

			System.out.println("Enter the bookings, one per line:");
			
			for (int i = 0; i < N; i++){
				String[] reservation = nextLine().split("-");

				if (isExclusive(reservation)){
					time request = new time(reservation[0], reservation[1]);
					requests.add(request);
				}
	
			}

			evaluateReservation(requests);
		}
	}

	private static boolean isExclusive(String[] reservation){
		boolean result = false;

		for (String time: reservation){
			String[] temp = time.split(" ");
			
			if (temp[1].equals("am") && LocalTime.parse(temp[0]).isAfter(LocalTime.parse("8:00"))){
				result = true;
			}
			if (temp[1].equals("pm") && LocalTime.parse(temp[0].isBefore(LocalTime.parse("10:00")))){
				result = true;
			}
		}

		return result;
	}

	private static void evaluateReservations(ArrayList<time> requests){
		
	}
}
