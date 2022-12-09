package util;

public class StopWatch {
    private long startTime;
    private long stopTime;

    public StopWatch() {
        this.startTime = System.nanoTime();
    }
    public void stopTime(){
        this.stopTime = System.nanoTime();
        System.out.println(((float) stopTime - startTime)/1000000000 + " seconds");
    }
}
