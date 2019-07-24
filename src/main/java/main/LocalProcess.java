package main;

/**
 * How many simulated processes should you create before each algorithm run?
 * Create enough so that the CPU is never idle for more than 2 consecutive quanta waiting for work to do,
 * except possibly at the very beginning of each run. It’s OK to create more processes for a run than you can actually use.
 */
public class LocalProcess implements Comparable<LocalProcess>{

    private char name;
    private float arrivalTime;
    private float expectedTotalRunTime;
    private int priority;

    private float turnAroundTime;
    private float waitingTime;
    private float responseTime;

    public LocalProcess(char name, float arrivalTime, float expectedTotalRunTime, int priority){
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.expectedTotalRunTime = expectedTotalRunTime;
        this.priority = priority;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public float getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(float arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public float getExpectedTotalRunTime() {
        return expectedTotalRunTime;
    }

    public void setExpectedTotalRunTime(float expectedTotalRunTime) {
        this.expectedTotalRunTime = expectedTotalRunTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public float getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(float turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public float getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(float waitingTime) {
        this.waitingTime = waitingTime;
    }

    public float getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(float responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public int compareTo(LocalProcess p) {
        if (this.arrivalTime < p.arrivalTime) return -1;
        else if (this.arrivalTime > p.arrivalTime) return 1;
        else return 0;
    }

}
