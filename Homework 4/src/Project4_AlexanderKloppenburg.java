/* Alexander Kloppenburg with partner Junaid Ahmed 
 * Lab 04
 * September 13th, 2016
 */

//Imported the scanner
import java.util.Scanner;

public class Project4_AlexanderKloppenburg 
{
	public static void main(String[] args) 
	{
		//Initial score
		int score = 0;
		
		//Adding a scanner
		String answer = new String();
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Please enter yes or no for each question.");			  //Prompt to tell user what to write
																		
		//This is the actual quiz										
		System.out.println("Are you losing your sense of humor?");   				  //First question	
		answer = scnr.next();														  //Gets user input for first question
		
		//This is to add points to the quiz
		if (answer.equalsIgnoreCase("yes"))
			score = score + 1;
		
		System.out.println("Do you feel tired most of the time?");      			  //Second question
		answer = scnr.next();														  //Gets user input for second question
		
		if (answer.equalsIgnoreCase("yes"))
			score = score + 1;
			
		System.out.println("Do you try to get away from people as soon as you can?"); //Third question
		answer = scnr.next();														  //Gets user input for third question
		
		if (answer.equalsIgnoreCase("yes"))
			score = score + 1;
		
		//These are the results of the quiz
		if (score == 0)
			System.out.println("0 points: More exhausted than stressed out");
		
		else if (score == 1)
			System.out.println("1 point: Beginning to stress out");
		
		else
		{
			if (score == 2)
				System.out.println("2 points: Possibly stressed out");
			
			else
				System.out.println("3 points: Probably stressed out");
		}

		scnr.close();
		return;
	}

}
