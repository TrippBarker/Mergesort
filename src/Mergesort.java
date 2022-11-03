import java.util.ArrayList;

/** Class: Main
 * @author Coleman Barker
 * @version 1.0
 * Course : ITEC 2150 Fall 2022
 * Written : October 25, 2022
 * 
 * This class sorts an int Array via the merge sort method
 */

public class Mergesort {
	
	// Instance variables to be used by sorting method
	private int arrayArrayCounter = 0;
	private int passCounter = 1;
	
	// Arrays for storing the Array before and after it is sorted
	private int[] unsortedArray;
	private int[] sortedArray;
	
	// 2D Arrays for storing unsorted split int array
	private int[][] arrayArray;
	private int[][] arrayArray2;
	
	// Arrays for temporarily storing split arrays being sorted
	private int[] firstHalfArray;
	private int[] secondHalfArray;
	
	// 2 argument constructor
	public Mergesort(int ARRAY_SIZE, int[] unsortedArray) {
		this.unsortedArray = new int[ARRAY_SIZE];
		this.arrayArray = new int[ARRAY_SIZE][];
		this.unsortedArray = unsortedArray;
	}
	
	/** Method: splitArray
	  * This method is called in order to split unsorted int Array into a 2D int Array for sorting via mergesort method
	  */
	
	public void splitArray() {
		int index = 0;
		for(int num: unsortedArray) {
			arrayArray[index] = new int[1];
			arrayArray[index][0] = num;
			index++;
		}
	}
	
	/** Method: getHalves
	  * This method is called to collect arrays stored in arrayArray to be merged together
	  */
	
	public void getHalves() {
		// Set arrayArrayCounter to 0
		System.out.printf("--------PASS %d--------\n", passCounter++);
		arrayArrayCounter = 0;
		// check length of arrayArray in order to initialize temp arrayArray2 length
		if (arrayArray.length % 2 == 0) {
			arrayArray2 = new int[(arrayArray.length / 2)][];
		} else {
			arrayArray2 = new int[(arrayArray.length / 2) + 1][];
		}
		// for each array stored in pass arrays to firstHalfArray and secondHalfArray to be merged together
		for (int i = 0; i < arrayArray.length; i++) {
			firstHalfArray = new int[arrayArray[i].length];
			firstHalfArray = arrayArray[i++];
			if(i < arrayArray.length) {
				secondHalfArray = new int[arrayArray[i].length];
				secondHalfArray = arrayArray[i];
			}
			// Call mergeHalves method
			mergeHalves();
		}
		arrayArray = arrayArray2;
		if(arrayArray.length > 1) {
			getHalves();
		} else {
			sortedArray = arrayArray[0];
		}
		
	}
	
	/** Method: mergeHalves
	 * 
	  * This method merges 2 int arrays together into one, sorted by lowest number to highest
	  */
	
	public void mergeHalves() {
		// ArrayList for storing mergedHalves
		ArrayList<Integer> mergedHalves = new ArrayList<>();
		// Set indexes to 0
		int firstIndex = 0;
		int secondIndex = 0;
		// Iterate for loop for length of first and second arrays
		for (int i = 0; i < firstHalfArray.length + secondHalfArray.length; i++) {
			// Add number to mergedHalves according to whichever is smallest
			if (firstIndex < firstHalfArray.length && secondIndex < secondHalfArray.length) {
				if (firstHalfArray[firstIndex] <= secondHalfArray[secondIndex]) {
					mergedHalves.add(firstHalfArray[firstIndex++]);
				} else {
					mergedHalves.add(secondHalfArray[secondIndex++]);
				}
			} else if (firstIndex < firstHalfArray.length){
				mergedHalves.add(firstHalfArray[firstIndex++]);
			} else {
				mergedHalves.add(secondHalfArray[secondIndex++]);
			}
		}
		// print mergedHalves to terminal to visualize merging step
		for (int num: mergedHalves) {
			System.out.print(num + " ");
		}
		// set first and second arrays to empty arrays to be used again
		firstHalfArray = new int[0];
		secondHalfArray = new int[0];
		System.out.println();
		// read mergeHalves ArrayList into an int Array
		arrayArray2[arrayArrayCounter++] = mergedHalves.stream().mapToInt(i -> i).toArray();
	}
	
	/** Method: getSortedArray
	 * 
	  * Getter method for retrieving sorted array
	  * @return an int array sorted from lowest to highest number
	  */
	
	public int[] getSortedArray() {
		return this.sortedArray;
	}
}
