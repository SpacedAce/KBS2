package BPP;

public class Timer {
	public long startTimer(){
		return System.currentTimeMillis();
	}
	
	public long endTimer(){
		return System.currentTimeMillis();
	}
	
	public float calculateTime(long start, long end){
		return (float) (end - start);
	}
}
