/* Project 9
 * Alexander Kloppenburg
 * 10/18/2016 8:30 AM
 */
import java.util.Arrays;
import java.util.Scanner;
public class Project9_AlexanderKloppenburg {
	
	//Constants for menu choices
	public static final int ADD = 1;
	public static final int SEARCH = 2;
	public static final int QUIT = 3;
	public static final int ADD_FIRST_TIME = 4;
	
	//Array size constant
	public static final int ARRAY_SIZE = 100;
	
	//Global size variable
	public static int currentSize = 0;
	
	//Variable to allow first time email entry
	public static boolean firstTime;
	
	//main method
	public static void main(String[] args){
	
		//Open scanner, declare oversized array
		Scanner input = new Scanner(System.in);
		String[] emailsList = new String[ARRAY_SIZE];
		
		//Variables to hold a new email and check if it's in the list
		String newEmail;
		int isInList;
		
		//Allows for entering of new emails the first time around
		firstTime = true;
		
		//Priming read using menuChoice function
		int choiceFromMenu = menuChoice(input);
		
		//While loop to allow for multiple email insertions
		while(choiceFromMenu != QUIT){
		
			//if this is the first time an email is added, it doesn't perform a search because there are no values to search
			if(choiceFromMenu == ADD_FIRST_TIME){
				
				//gets user input
				System.out.println("Please enter the email address.");
				newEmail = input.nextLine();
				
				//adds the email to the list
				currentSize = addNewEmail(emailsList, currentSize, newEmail);
				
				//makes the firstTime variable false, allows for searching next time
				firstTime = false;
			}
			
			else if(choiceFromMenu == ADD){
				
				//Gets user input and finds if the email is in the list already
				System.out.println("Please enter the email address.");
				newEmail = input.nextLine();
				
				//Finds whether or not email is already in list
				isInList = Arrays.binarySearch(emailsList, 0, currentSize, newEmail);
				 
				//Prints out error message if the email is already in the list
				if(isInList >= 0){
					System.out.println("That email address has already been inserted.");
				}
				
				//Otherwise, adds the email to the list
				else if(isInList < 0){
					addNewEmail(emailsList, currentSize, newEmail);
				}
				else{
					System.out.print("Cannot insert email address");
				}
			}	//close if statement
			
			//Allows for searching of new email addresses
			else if(choiceFromMenu == SEARCH){
				
				System.out.println("Please enter the partial email address.");
				newEmail = input.nextLine();
				search(emailsList, currentSize, newEmail);
			}
			
			//Calls menuChoice function to get input again
			choiceFromMenu = menuChoice(input);
		}	//close while loop
		input.close();
		
		System.out.print("Goodbye.");
	}	//close main method
	
	
	//Search function, finds if target is in the array
	public static void search(String[] data, int size, String target){
		
		int i;
		int searchCount = 0;
		for(i = 0; i < currentSize; ++i){
			if(data[i].startsWith(target)){
				++searchCount;
				System.out.print(searchCount + ". ");
				System.out.println(data[i]);
			}	//close if statement
		}	//close for loop
		if(searchCount == 0){
			System.out.println("No email addresses found starting with " + "\"" + target + "\".");
		}
	}	//close search method
	
	
	//Finds if the input is a valid choice within the menu
	public static int menuChoice(Scanner input){
		
		System.out.println("Please choose from the following menu of choices:");
		System.out.println("1.  Enter a new email address");
		System.out.println("2.  Find an existing email address");
		System.out.println("3.  Quit");
		int choiceFromMenu = 0;
		
		//Verifies that the input is actually an integer
		//If not, the next if statement will then generate an error message
		if(input.hasNextInt()){
			choiceFromMenu = input.nextInt();
		}
		
		//Outputs error message if input is not a valid input
		if(!(choiceFromMenu == ADD || choiceFromMenu == SEARCH || choiceFromMenu == QUIT || 
				choiceFromMenu == ADD_FIRST_TIME)){
					System.out.println("Please enter an option from the menu.");
		}
		
		//Simplifies main method if this is the first email entry
		if(choiceFromMenu == 1 && firstTime == true){
			choiceFromMenu = ADD_FIRST_TIME;
		}
		
		//Eats newline character
		String newlineHolder = input.nextLine();
		
		return choiceFromMenu;
	}	//close menuChoice method
	
	
	//Allows you to put a new email in the list
	public static int addNewEmail(String[] data, int size, String insertMe){
		
		//If this is the first data entry, it doesn't sort
		if(firstTime == true){
				data[0] = insertMe;
				++currentSize;
		}
		
		//If this isn't the first time, it inserts the value at the end and then sorts it
		else if(size < data.length){
			data[size] = insertMe;
			Arrays.sort(data, 0, currentSize);
			++currentSize;
		}
		
		//Outputs error message if the array is full
		else{
			System.out.println("The email address cannot be inserted, our database is too full.");
		}
		return currentSize;
	}	//close addNewEmail method
}	//close class Homework9