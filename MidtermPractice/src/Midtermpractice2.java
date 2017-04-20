import java.util.Scanner;

public class Midtermpractice2 {
	
	public static void main(String[] args) {
		
		int seatsUpperLevel = 9000;
		int seatsLowerLevel = 2000;
		int seatsOrdered;
		String whichDeck = new String();
		Scanner input = new Scanner(System.in);
		double totalCost = 0;
		
		//
		System.out.println("Enter the number and type of seat (upper level or lower level) or -1 to exit");
		seatsOrdered = input.nextInt();
		whichDeck = input.nextLine();
		
		
		while(seatsOrdered > 0) {
			if((seatsUpperLevel - seatsOrdered) < 0){
				System.out.print("");
			}
			if(whichDeck.equals("upper level")){
				seatsUpperLevel = seatsUpperLevel - seatsOrdered;
				totalCost = totalCost + (5 * seatsOrdered);
			}
			else if(whichDeck.equals("lower level")){
				seatsLowerLevel = seatsLowerLevel - seatsOrdered;
				totalCost = totalCost + (15 * seatsOrdered);
			}
			else{
				System.out.print("Invalid input");
			}
		}
		input.close();
	}

}
