/* This is Project 5 done on September 20
* This was done by Junaid Ahmed and partner Alex Kloppenburg
* This was completed at 9:50 AM
*/ 

import java.util.Scanner;
public class Project5_JunaidAhmed{

	public static void main(String[] args)
	{
	
		//These variables are setting up for the dial and the number entry
		Scanner keyboard = new Scanner(System.in);
		int dialPrevious=3;
		int dialCurrent = 0;
		
		//These variables are to see the change in the polling number
		int qtyOfPos = 0;
		int qtyOfNeg = 0;
		int qtyOfNoChange = 0;
		
		//These variables to see how many times each polling number was used
		int qtyOfOne = 0;
		int qtyOfTwo = 0;
		int qtyOfThree = 0;
		int qtyOfFour = 0;
		int qtyOfFive = 0;
		
		//Priming read asking for poll data in the beginning
		System.out.println("Enter the polling data or -1 to stop");
	
		
		dialCurrent = keyboard.nextInt();
		
		
		//This is the loop that gathers the poll data
		//Sentinel value is any negative number because it is > 0
		while (dialCurrent > 0) 	
		{
			//This conditional statement is to find how many times each value was chosen
			if (dialCurrent == 1)
				++qtyOfOne;
			
			else if (dialCurrent == 2)
				++qtyOfTwo;
			
			else if (dialCurrent == 3)
				++qtyOfThree;
			
			else if (dialCurrent == 4)
				++qtyOfFour;
			
			else
				++qtyOfFive;

		
			//This conditional statement is to find the positive, negative, and zero changes
			if (dialCurrent - dialPrevious >= 1)
				++qtyOfPos;
			
			else if (dialCurrent - dialPrevious <= -1) 
				++qtyOfNeg;
			
			else if (dialCurrent - dialPrevious == 0)
				++qtyOfNoChange;
			
			else
				System.out.println("Invalid Input");
			
		System.out.println("Enter the polling data or -1 to stop");
		dialPrevious = dialCurrent;
		dialCurrent = keyboard.nextInt();
		
		}
		
		//This prints the results of the polling data
		System.out.println ("1 was chosen " + qtyOfOne + " times.");
		System.out.println ("2 was chosen " + qtyOfTwo + " times.");
		System.out.println ("3 was chosen " + qtyOfThree + " times.");
		System.out.println ("4 was chosen " + qtyOfFour + " times.");
		System.out.print ("5 was chosen " + qtyOfFive + " times.");
		
		//This newline separates the polling data and the change in polling data
		System.out.println('\n');
		
		//This prints the change in polling data
		System.out.println("There were:");
		System.out.println(qtyOfPos + " Positive changes");
		System.out.println(qtyOfNeg + " Negative changes");
		System.out.println(qtyOfNoChange + " No changes");
		
		keyboard.close();
		return;
	}
}
