import java.util.Scanner;

public class MidtermPractice {

	public static void main(String[] args) {

		double base;  // the base cost of the ticket 
		int suitcases; // the number of suitcases 
		String premium; // Yes if the user wants a premium seat, no otherwise 
		double cost;  // the cost of the ticket 
		Scanner input = new Scanner(System.in); // Assume this is previously constructed
		
		
		System.out.println("What is the base cost of your ticket?"); // input base below
		base = input.nextInt();
		
		System.out.println("How many suitcases need to be checked?");  // input suitcases below
		suitcases = input.nextInt();
		
		System.out.println("Do you want to sit in a premium seat? Yes/No");  // input premium below
		premium = input.next();
		
		
		// Perform cost calculation below
		if (premium.equals("Yes"))
			cost = base + ((suitcases * 35) - 10) + 20;
		else
			cost = base + ((suitcases * 35) - 10);
		
	}

}
