import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Tester {
	
	public PrintWriter pw;
	public int arraySize;
	public int initialSize;
	public Numbers nums;
	public Mergesort ms;
	public Timer timer = new Timer();
	
	public int numOfTests = 10;
	public long startTime;
	public long endTime;
	public long[] runTimeArray = new long[(numOfTests) * 10];
	public int runTimeArrayIndex = 0;
	
	public Tester(int arraySize) {
		this.arraySize = arraySize;
		initialSize = arraySize;
		try {
			pw = new PrintWriter("MergeSorterTestData.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
	}
	
	public void runTests() {
		nums = new Numbers(arraySize);
		nums.CreateRandomNumbers();
		ms = new Mergesort(arraySize, nums.getNumbers());
		timer.startTimer();
		ms.splitArray();
		ms.getHalves();
		timer.endTimer();
		for (int j = 1; j < numOfTests; j++) {
			runTimeArray[runTimeArrayIndex++] = arraySize;
			pw.println("ARRAY SIZE: " + arraySize);
			for (int i = 0; i < 10; i++) {	
				nums = new Numbers(arraySize);
				nums.CreateRandomNumbers();
				ms = new Mergesort(arraySize, nums.getNumbers());
				timer.startTimer();
				ms.splitArray();
				ms.getHalves();
				timer.endTimer();
				runTimeArray[runTimeArrayIndex++] = timer.getRunTime();
				pw.println(timer.getRunTime());
			}
			arraySize = (j + 1) * initialSize;
		}
		for (long num: runTimeArray) {
			System.out.println(num);
		}
		pw.close();
	}
}
