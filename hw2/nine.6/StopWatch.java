//import current time

public class StopWatch {
	private long startTime;
	private long stopTime;
	
	//initializes startTime with current time.
	public StopWatch() {
		startTime = System.currentTimeMillis();
	}
	
	//getter methods
	//when did stopwatch start?
	public long getStartTime() {
		return startTime;
	}
	
	//when did stopwatch end?
	public long getStopTime() {
		return stopTime;
	}
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime() {
		System.out.println("stop time is: " + stopTime);
		System.out.println("start time is " + startTime);
		return stopTime-startTime;
	}
}
