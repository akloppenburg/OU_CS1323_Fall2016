/* Project 7 done by Alex Kloppenburg with partner Carter Dennis
 * October 4th, 2016
 */

import java.util.Scanner;				//Imports scanner
import java.io.File;					//Imports File class
import java.io.FileNotFoundException;	//Imports FileNotFoundException needed for methods


public class Project7_AlexKloppenburg {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		//Create a new scanner to get user input
		Scanner input = new Scanner(System.in);
		
		//Priming read
		System.out.println("Enter a file name or quit to exit.");
		String nameOfFile = input.nextLine();
		
		//while loop allows for multiple files to be analyzed in one runnign of the program
		while(!(nameOfFile.equalsIgnoreCase("quit"))){
			
			//call analyzeText method to analyze file
			analyzeText(nameOfFile);
			
			System.out.println("Enter a file name or quit to exit.");
			nameOfFile = input.nextLine();
			
		}	//close while loop from line 26
		
		System.out.println("That's all, folks!");
		
		//close input Scanner
		input.close();
		
	}	//close main method
		
	
	
	
	
	
	
	
	public static void analyzeText(String fileName) throws FileNotFoundException {
		
		//create increment variable
		int i;
		
		//make an int array to store the numbers of each type of punctuation
		int[] numPunctuation = {0, 0, 0, 0, 0, 0};

		//imports text file
		Scanner file = new Scanner(new File(fileName));
			
			
		//Finds number of lines and eats the newline character
		int numLines = file.nextInt();
		String temp = file.nextLine();
		
		//for loop to call the countOccurrences 6 times for each line
		for(i = 0; i < numLines; ++i){
		
			String lineContent = file.nextLine();
			
			//calls countOccurrences 6 times to count each character & increments the array
			numPunctuation[0] += countOccurrences(lineContent, '.');	//finds and stores number of periods
			numPunctuation[1] += countOccurrences(lineContent, '?');	//finds and stores number of question marks
			numPunctuation[2] += countOccurrences(lineContent, '!');	//finds and stores number of exclamation marks
			numPunctuation[3] += countOccurrences(lineContent, ',');	//finds and stores number of commas
			numPunctuation[4] += countOccurrences(lineContent, ';');	//finds and stores number of colons
			numPunctuation[5] += countOccurrences(lineContent, ':');	//finds and stores number of semicolons
			
		}	//closes for loop

		//finds average punctuation per line
		double[] avgPunctuationPerLine = {0, 0, 0, 0, 0, 0};
		for(i=0; i < 6; ++i){
			avgPunctuationPerLine[i] = numPunctuation[i] / (double)numLines;
		}	//closes for loop
			
		//outputs average punctuation per line using the array and 6 print statements
		System.out.println("There were " + avgPunctuationPerLine[0] + " periods per sentence.");
		System.out.println("There were " + avgPunctuationPerLine[1] + " question marks per sentence.");
		System.out.println("There were " + avgPunctuationPerLine[2] + " exclamation marks per sentence.");
		System.out.println("There were " + avgPunctuationPerLine[3] + " commas per sentence.");
		System.out.println("There were " + avgPunctuationPerLine[4] + " semicolons per sentence.");
		System.out.println("There were " + avgPunctuationPerLine[5] + " colons per sentence.");
		
		//close file Scanner
		file.close();
		
	}	//close analyzeText method
		
	public static int countOccurrences(String line, char punctuation){
			
		//Uses an array to count number of punctuation
		int numPunctuation = 0;
			
		//counts number of characters in line
		int numChars = line.length();
			
		//for loop counts number of different types of punctuation
		int i = 0;
		for(i = 0; i < numChars; ++i){
			
			if(line.charAt(i) == punctuation){
				++numPunctuation;		//first element increments periods
			}	//close if statement
			
		}	//close for loop
			
		return numPunctuation;
		
	}	//close countOccurrences method
	
}	//close class Project7