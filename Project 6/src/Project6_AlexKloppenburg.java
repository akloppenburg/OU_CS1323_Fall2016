/*
 * Project6_JunaidAhmed with partner Alex Kloppenburg
 * This project was completed on Tuesday, September 27th, 9:49 AM
 */

//Imported scanner
import java.util.Scanner;

public class Project6_AlexKloppenburg 
{

	public static void main(String[] args) 
	{
		int numBoxes = 100;
		int userWidth;
		int userHeight;
		final int SQUARE_FEET_PER_BOX = 155;
		
		//Open up scanner
		Scanner keyboard = new Scanner(System.in);
		
		//Tell user beginning number of boxes
		System.out.println("We now have " + numBoxes + " boxes left.");
		
		//Get user input for room size
		System.out.println("What is the size of your room: enter the width and depth in feet.");
		userWidth = keyboard.nextInt();
		userHeight = keyboard.nextInt();
		
		//Calculate number of boxes needed
		int numBoxesOrdered = calculateFlooring(userWidth, userHeight, SQUARE_FEET_PER_BOX);
		
		//while loop so user can order flooring while there are still boxes left
		while (numBoxes > 0)
		{
			//process of ordering if there are enough boxes left
			if (numBoxes > numBoxesOrdered)
			{
				System.out.println("Your " + numBoxesOrdered + " boxes will be shipped to you.");
				numBoxes -= numBoxesOrdered;
			}
			
			//Process for ordering if there are less boxes left than the user wants to order
			else if(numBoxes <= numBoxesOrdered)
			{
				System.out.println("We only have " + numBoxes + " left.");
				System.out.println("Would you like to purchase all of them?  Yes or No");
				
				//Eats newline character left over from the Int input earlier
				String temp = new String(keyboard.nextLine());
				
				//Allows user to order all the boxes left
				String confirmOrderAll = new String(keyboard.next());
				
				if(confirmOrderAll.equalsIgnoreCase("yes")) 
				{
					System.out.println("Your " + numBoxes + " boxes will be shipped to you.");
					numBoxes = 0;
				}
			}
			
			//Priming read if there are still boxes left, otherwise while loop exits
			if(numBoxes > 0)
			{
			System.out.println("We now have " + numBoxes + " boxes left.");
			System.out.println("What is the size of your room: "
					+ "enter the width and depth in feet");
			userWidth = keyboard.nextInt();
			userHeight = keyboard.nextInt();
			numBoxesOrdered = calculateFlooring(userWidth, userHeight, SQUARE_FEET_PER_BOX);
			}
		}	//End of while loop	
		
		System.out.println("I'm sorry, but we're all sold out of Bamboo Dream Flooring");
		
		//close keyboard
		keyboard.close();
		
		//close main
		return;
	}   //close main
	
	
	public static int calculateFlooring(int width, int height, int squareFeetPerBox)
	{
		//Calculate square footage of room
		double squareFeetOfRoom = width * height;
		
		//Add 5% for waste
		squareFeetOfRoom = Math.ceil(squareFeetOfRoom * 1.05);
		
		//Find number of boxes needed and round up
		int numBoxesNeeded = (int)Math.ceil(squareFeetOfRoom / squareFeetPerBox);
		
		//returns an int for main to use
		return numBoxesNeeded;
	}
}