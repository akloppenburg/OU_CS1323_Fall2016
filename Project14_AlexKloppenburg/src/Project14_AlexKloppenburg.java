/*
 * Project 14
 * @author Alex Kloppenburg
 */

//Import necessary classes
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Project14_AlexKloppenburg {

	public static void main(String[] args) throws FileNotFoundException { 
		
		//Creates dictionary arrays for main and personal dictionaries
		ArrayList<String> mainDictionary = new ArrayList<String>();
		ArrayList<String> personalDictionary = new ArrayList<String>();
		
		//scanner is constructed to accept words
		Scanner input = new Scanner(System.in);
		
		//Imports main dictionary and current version of personal dictionary
		importDictionary(mainDictionary, "main", args[0]);
		importDictionary(personalDictionary, "personal", args[1]);
		
		//Gets word and enters loop, aka priming read
		System.out.println("Enter a word or QUIT to stop");
		String word = input.nextLine();
		
		//while word isn't "quit", it first checks against the main and then personal dictionaries, and adds it if it isn't
		while(!word.equalsIgnoreCase("quit")){
			int isSpelledCorrectly = spellChecker(word, mainDictionary);
			
			//If the method returns a positive number, word is spelled right
			if(isSpelledCorrectly >= 0){
				System.out.println("That word is spelled correctly.");
			}
			
			//If the method returns a negative number or zero, word is spelled wrong or in personal dictionary
			else{
				
				//Checks to see if the word is in the personal dictionary
				if(spellChecker(word, personalDictionary) >= 0){
					System.out.println("That word is spelled correctly.");
				}
				
				//Otherwise, it says it is spelled wrong and asks if you'd like to add it to the personal dictionary
				else{
					System.out.println("That word is not spelled correctly.");
					System.out.println("Would you like to add it to your personal dicationary?  Y/N");
					
					/* SpellChecker method uses binary search so if the number is not in there, this equation gives us the
					 * index of the insertion point
					 */
					int personalInsertionPoint = -(spellChecker(word, personalDictionary)) - 1;
					
					//This accepts the y or n
					String addToPersonal = input.nextLine();
				
					//If user inputs y, it updates the 
					if(addToPersonal.equalsIgnoreCase("y")){
						addToPersonalDictionary(word, personalDictionary, personalInsertionPoint);
					}
				}		//close else statement
			}		//close else statement
			
			//Prompts user and gets another word
			System.out.println("Enter a word or QUIT to stop");
			word = input.nextLine();
		}		//close while loop
		
		//Writes updated personal dictionary to a file to be read in next time
		writePersonalDictionaryToFile(personalDictionary, args[1]);
		
		//Polite message and closing of scanner
		System.out.println("Thanks for checking your spelling!");
		input.close();
	}		//close main menthod
	
	//Does binary search on the main dictionary for the word and returns stuff
	public static int spellChecker(String word, ArrayList<String> mainDictionary){
		
		int isInDictionary = Collections.binarySearch(mainDictionary, word);
		
		return isInDictionary;
	}
	
	//Adds a word to the personal dictionary at the specified index 
	public static void addToPersonalDictionary(String word, ArrayList<String> personalDictionary, int index){
		personalDictionary.add(index, word);
	}
	
	//Allows for importing of either the main or personal dictionary to an ArrayList<String> from a file
	public static void importDictionary(ArrayList<String> dictionary, String whichDictionary, String filename) throws FileNotFoundException { 
		
		if(whichDictionary.equals("main")){
			Scanner importer = new Scanner(new File(filename));
			
			while(importer.hasNextLine()){
				dictionary.add(importer.nextLine());
			}
		}
		
		else if(whichDictionary.equals("personal")){
			Scanner importer = new Scanner(new File(filename));
			
			while(importer.hasNextLine()){
				dictionary.add(importer.nextLine());
			}
		}
		
	}
	
	//Writes the final ArrayList<String> personalDictionary to the file
	public static void writePersonalDictionaryToFile(ArrayList<String> personalDictionary, String filename) throws FileNotFoundException{
		
		//Constructs printwriter
		PrintWriter pw = new PrintWriter(new File(filename));
		
		//Writes personal dictionary to file
		for(int i = 0; i < personalDictionary.size(); ++i){
			pw.write(personalDictionary.get(i) + "\n");
		}
		
		//Closes the file so we actually get results
		pw.close();
	}
}
