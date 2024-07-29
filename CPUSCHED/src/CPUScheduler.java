package cs471Project.CPUSCHED.src;

//import java.io.*;
import java.util.List;

//this is the main file, but just named it CPUScheduler

 public class CPUScheduler {
   

   public static void fifoSchedule(List<Process> processes){
    int currentTime = 0;
    int totalWaitTime = 0;
    int totalTurnaroundTime = 0;

    for(Process process :  processes){
        int waitingTime = Math.max(0, currentTime - process.getArrivalTime());
        int turnaroundTime = waitingTime + process.getCpuBurst();

        totalWaitTime += waitingTime;
        totalTurnaroundTime += turnaroundTime;

        currentTime = Math.max(currentTime, process.getArrivalTime());

        //Will take a look at this later
        System.out.println("Process ID: " + process.getId() + ", Waiting Time: "+ waitingTime + ", Turnaround Time: " + turnaroundTime);

    }

    System.out.println("Average Waiting Time: " + (double) totalWaitTime /  processes.size());
    System.out.println("Average Turnaround Time: " + (double)totalTurnaroundTime / processes.size());
   }

   public static void sjfSchedule(List<Process> processes){
    processes.sort((p1, p2) -> Integer.compare(p1.getCpuBurst(), p2.getCpuBurst()));
    fifoSchedule(processes);
   }

   public static void prioritySchedule(List<Process> processes){
    processes.sort((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()));
    fifoSchedule(processes);
   }
 
   }   

