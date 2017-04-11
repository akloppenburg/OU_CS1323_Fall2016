/*
 * Project 11, Alex Kloppenburg with partner Kevin Le
 * 11/1/16, 9:00 AM
 */


import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Project11_AlexKloppenburg {
	
	public static int ROW = 1000;
	public static int COL = 1000;

	public static void main(String[] args) throws FileNotFoundException{
		
		//creates vertical Stripe array and then image
		char[][] vertStripes = createVerticalStripes(ROW, COL, 20);
		writePGMFile("vertical.pgm", vertStripes, ROW, COL);
		
		//Creates horizontal stripe array and then image
		char[][] horizStripes = createHorizontalStripes(ROW, COL, 20);
		writePGMFile("horizontal.pgm", horizStripes, ROW, COL);
		
		//Creates diagonal stripe array and then image
		char[][] diagStripes = createDiagonalStripes(ROW, COL, 20);
		writePGMFile("diagonal.pgm", diagStripes, ROW, COL);
		
		//Checkerboard image
		char[][] checkerboard = createCheckerboard(ROW, COL, 20);
		writePGMFile("checkerboard.pgm", checkerboard, ROW, COL);
	}
	
	public static char[][] createVerticalStripes(int height, int width, int stripeWidth){
		char[][] image = new char[height][width];
		
		//Array is initialized to black, so we only need to do every other column of width stripeWidth as white
		boolean isWhite = false;
		
		for(int rows = 0; rows < height; rows++){
			
			for(int cols =0; cols < width; cols++){
				
				if((cols % stripeWidth) == 0){
					isWhite = !isWhite;
				}
				if(isWhite = true){
					image[rows][cols]=;
				}
			}
		}
		return image;
	}
		

	
	public static char[][] createDiagonalStripes(int height, int width, int stripeSize){
		char[][] image = new char[height][width];
		
		
		
		return image;
	}
	
	public static char[][] createCheckerboard(int height, int width, int stripeSize){
		
		char[][] image = new char[width][height];
		boolean isWhite = false;
		
		for(int rows=0; rows < height; rows++){
			for(int cols = 0; cols < width; cols++){
				
				int squareHeight = rows/stripeSize;
				int squareWidth = cols/stripeSize;
				
				//Makes a "square" with sides stripeSize and checks to see if it's even or odd
				isWhite = (((squareHeight + squareWidth) % 2) == 0);
				
				//Changes the odd squares to white because background defaults to black
				if (isWhite){
					image[rows][cols]=(char)0;
				}
			}
		}
		return image;
	}
	
	public static char[][] createHorizontalStripes(int height, int width, int stripeHeight){
		
		char[][] image = new char[height][width];
		//Only need to change white rows since array is initialized to black
		boolean isWhite = false;
		
		for(int rows=0; rows < height; rows++){
			
			if(rows % stripeHeight == 0){
				isWhite = !isWhite;
			}
			for(int columns =0; columns<width; columns++){
				if(isWhite){
					image[rows][columns]=255; //only changes for white
				}
			}
		}
		
		return image;
	}
	
	public static void writePGMFile(String fileName, char[][] image, int height, int width) throws FileNotFoundException{
		
		PrintWriter file = new PrintWriter(new File(fileName));
		
		file.println("P5");
		file.println(height + " " + width);
		file.println((int)255);	//should be a constant
		for(int row = 0; row < height; ++row){
			file.write(image[row]);
		}
		
		file.close();
	}
	
	
	//not sure how to write this method, come back to it
	//public static char[] createVerticalStripes(int height, int width,)
}
