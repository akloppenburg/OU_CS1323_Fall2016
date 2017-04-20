/* Alex Kloppenburg
 * Homework 2
 * 9/18/16
 */




import java.util.Scanner;				//Imported scanner

public class Homework2 {

	public static void main(String[] args) {
		String temp;
		Scanner keyboard = new Scanner(System.in);
		
		//Prompt user for first person's name and get input
		System.out.println("Please enter the first person's full name.");
		String name1 = new String();
		name1 = keyboard.nextLine();
		
		//Prompt user for hour first person woke up and get input
		System.out.println("Please enter the hour that " + name1 + " woke up.");
		int hours1 = keyboard.nextInt();
		temp = keyboard.nextLine();
		
		//Prompt user for minutes after that hour the first person woke up and get input
		System.out.println("Please enter the number of minutes after " + hours1 + " o'clock that " + name1 + " woke up.");
		int minutes1 = keyboard.nextInt();
		temp = keyboard.nextLine();
		
		//Prompt user for second person's name and get input
		System.out.println("Please enter the second person's full name.");
		String name2 = new String();
		name2 = keyboard.nextLine();
		
		//Prompt user for hour the second person woke up and get input
		System.out.println("Please enter the hour that " + name2 + " woke up.");
		int hours2 = keyboard.nextInt();
		temp = keyboard.nextLine();
		
		//Prompt user for minutes after that hour that the second person woke up and get input
		System.out.println("Please enter the number of minutes after " + hours2 + " o'clock that " + name2 + " woke up.");
		int minutes2 = keyboard.nextInt();
		temp = keyboard.nextLine();
		
		//Print names & time of waking in hours and minutes of first & second people
		System.out.println(name1 + " " + hours1 + " " + minutes1);
		System.out.print(name2 + " " + hours2 + " " + minutes2);
		
		keyboard.close();
	}
}
