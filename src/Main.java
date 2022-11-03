import java.util.Arrays;

/** Class: Main
 * @author Coleman Barker
 * @version 1.0
 * Course : ITEC 2150 Fall 2022
 * Written : October 17, 2022
 * 
 * This class is for creating instances of the Numbers and Mergesort classes
 */


public class Main {
	
	public static final int ARRAY_SIZE = 32;
	
	public static void main(String[] args) {
		// Class for creating an ArrayList of Integers
		Numbers userNumbers = new Numbers(ARRAY_SIZE);
		Timer timer = new Timer();
		// CreateRandomNumbers method has userNumbers auto create a random ArrayList of Integers
		userNumbers.CreateRandomNumbers();
		userNumbers.PrintNumbers();
		// Create the Mergesort class with the ArrayList made in Numbers
		Mergesort ms = new Mergesort(ARRAY_SIZE, userNumbers.getNumbers());
		// Call methods in Mergesort that begin the mergesort algorithm
		timer.startTimer();
		ms.splitArray();
		ms.getHalves();
		timer.endTimer();
		System.out.println("RUN TIME (seconds)");
		System.out.println((double)timer.getRunTime() / 1000000000);
	}

}
