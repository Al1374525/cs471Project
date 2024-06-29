package cs471Project.CPUSCHED;
public class Process{
int id, arrivalTime, priority, burstTime;
int startTime, finishTime, waitingTime, turnaroundTime, responseTime;

public Process(int id, int arrivalTime, int priority, int burstTime){
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.priority = priority;
    this.burstTime = burstTime;
}
}
