import java.util.Scanner;

/** This class runs a campaign for Donald Duck.
 * 
 * @author Alex Kloppenburg
 *
 */
public class Fall2016 {

	// These constants are used for a menu system
	private static final int ADD_DONOR = 1;
	private static final int DONATION = 2;
	private static final int SUM_DONATIONS = 3;
	private static final int SINGLE_DONOR_DETAILS = 4;
	private static final int QUIT = 5;
	
	public static void main(String[] args) 
	{
		//New campaign object is created and a scanner is opened for user input
		Campaign candidate = new Campaign("Donald Duck");
		Scanner keyboard = new Scanner(System.in);
		
		//Allows for use of the menu in a while loop
		int menuChoice = 0;
		while (menuChoice != QUIT)
		{
			menuChoice = menu(keyboard);
			
			if (menuChoice == ADD_DONOR)
				addDonor(keyboard, candidate);
			else if (menuChoice == DONATION)
				addDonation(keyboard, candidate);
			else if (menuChoice == SUM_DONATIONS)
				sumDonations(candidate);
			else if (menuChoice == SINGLE_DONOR_DETAILS)
				singleDonorDetails(keyboard, candidate);
			else if (menuChoice == QUIT)
				System.out.println("Goodbye");
			else
				System.out.println("Unanticipated case");
		}
		
	}
	
	//Gives different options for different inputs, allows methods to be executed in the main using a menu
	private static final int menu(Scanner keyboard)
	{
		System.out.println("Please enter your choice below");
		System.out.println(ADD_DONOR + ": Add new donor");
		System.out.println(DONATION + ": Make donation");
		System.out.println(SUM_DONATIONS + ": Find total donations");
		System.out.println(SINGLE_DONOR_DETAILS + ": Single donor details");
		System.out.println(QUIT + ": Quit");
		
		int value = keyboard.nextInt();
		keyboard.nextLine();
		
		//Catches values outside of the allowed choices
		if (value < ADD_DONOR || value > QUIT)
		{
			System.out.println(value + " is not in the legal range. Please re-enter");
			return menu(keyboard); // this is a cool trick called recursion
		}
		else // it was legal
		{
			return value;
		}
	}
	
	//Uses campaign class method to add a new donor from user input
	private static void addDonor(Scanner keyboard, Campaign candidate)
	{
		System.out.println("Please enter the name of the donor");
		String  name = keyboard.nextLine();
		candidate.addDonor(name);
	}
	
	//Uses campaign class method to add a new donation to a certain donor in the campaign from user input
	private static void addDonation(Scanner keyboard, Campaign candidate)
	{
		System.out.println("Please enter the name of the donor.");
		String donorName = keyboard.nextLine();
		System.out.println("Please enter the donation amount.");
		double donation = keyboard.nextDouble();
		candidate.addDonation(donorName, donation);
	}
	
	//Adds up all the donations for a candidate and returns it in a pretty way
	private static void sumDonations(Campaign candidate)
	{
		System.out.println(candidate.getCandidateName() + " has $" + candidate.getAllDonations()
				+ " of donations");
	}
	
	//Tells how much a single donor has donated
	private static void singleDonorDetails(Scanner keyboard, Campaign candidate)
	{
		System.out.println("Please enter the name of the donor.");
		String donorName = keyboard.nextLine();
		System.out.println(donorName + " has donated $" + candidate.getDonation(donorName));
	}
}