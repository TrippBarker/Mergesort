
public class Timer {
	
	long startTime;
	long endTime;
	
	public Timer() {
		
	}
	
	public void startTimer() {
		this.startTime = System.nanoTime();
	}
	
	public void endTimer() {
		this.endTime = System.nanoTime();
	}
	
	public long getRunTime() {
		return endTime - startTime;
	}
}
