import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Class: Numbers
 * @author Coleman Barker
 * @version 1.0
 * Course : ITEC 2150 Fall 2022
 * Written : October 17, 2022
 * 
 * This class is for creating an ArrayList of Integers to be sorted
 */

public class Numbers {
	// Variable to define size of ArrayList created
	private int ARRAY_SIZE;
	
	private int[] numbersAL = new int[ARRAY_SIZE];
	private int userNum = 0;
	private Scanner input = new Scanner(System.in);
	
	/** Method: Numbers
	  * Zero param constructor
	  */
	public Numbers(int ARRAY_SIZE) {
		this.ARRAY_SIZE = ARRAY_SIZE;
	}
	
	/** Method: getNumbers
	  * This method returns an ArrayList of Integers
	  * @return an ArrayList of Integers
	  */
	
	public int[] getNumbers(){
		return this.numbersAL;
	}
	
	/** Method: CollectNumbers
	  * This method is for obtaining numbers from the user in the terminal to be
	  * stored in the numbersAL ArrayList.
	  */
	
	public void CollectNumbers() {
		// Ask user for numbers while numbersAL is smaller than the predefined ARRAY_SIZE
		int i = 0;
		while(numbersAL.length < ARRAY_SIZE) {
			System.out.println(ARRAY_SIZE - numbersAL.length + " numbers to go.");
			System.out.print("Please enter a whole number:\n> ");
			// Ensure user provided an int value
			try {
				userNum = input.nextInt();
				numbersAL[i] = userNum;
				i++;
			} catch(InputMismatchException ime) {
				System.out.println(input.nextLine() + " is not an exeptable number.\n");
			}
		}
		input.close();
	}
	
	/** Method: CreateRandomNumbers
	  * This method is for creating an ArrayList of random Integers to be stored in
	  * the numbersAL ArrayList
	  */
	
	public void CreateRandomNumbers() {
		int[] randNums = new int[ARRAY_SIZE];
		for(int i = 0; i < ARRAY_SIZE; i++) {
			randNums[i] = (1 + (int)(Math.random() * 1000));
		}
		numbersAL = randNums;
	}
	
	/** Method: PrintNumbers
	  * This method is for printing numbers stored in the numbersAL ArrayList
	  */
	
	public void PrintNumbers() {
		System.out.println("---UNSORTED NUMBERS---");
		for (int num: numbersAL) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
