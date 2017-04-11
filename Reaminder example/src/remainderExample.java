import java.util.Scanner;

public class remainderExample {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Get 2 integers from the user
		int first;
		int second;
		
		//Prompt user
		System.out.println("Please enter a number...");
		first = keyboard.nextInt();
		keyboard.nextLine(); //Read newline character
		
		//Prompt user
		System.out.println("Please enter a second number...");
		second = keyboard.nextInt();
		keyboard.nextLine(); //Rean newline character
		
		//Calculate the % operator
		int mod = first % second;
		
		//Return the result to the user
		System.out.println(first + " % " + second + " = " + mod);
		
		//Close the input
		keyboard.close();
	}
}
