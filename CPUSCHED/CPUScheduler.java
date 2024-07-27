package cs471Project.CPUSCHED;
//import java.io.*;
//import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPUScheduler {
   public static void main(String[] args){
    if(args.length != 2){
        System.out.println("Usage: java CPUScheduler <input_file> <output_file>");
        return;
    }

    String inputFile = args[0];
    String algorithm =  args[1];
    List<Process> processes = readProcesses(inputFile);
    
    switch (algorithm.toUpperCase()) {
        case "FIFO":
            fifoSchedule(processes);
            break;
    
        case "SJF":
        sjfSchedule(processes);
            break;
        case "PRIORITY":
            prioritySchedule(processes);
            break;
        
        default:
        System.out.println("Invalid algorithm" + algorithm );
        break;

    }
   }

   private static List<Process> readProcesses(String inputFile){
    List<Process> processes = new ArrayList<>();
    try(Scanner scanner = new Scanner(new File(inputFile))){
        while(scanner.hasNext()){
            int id = scanner.nextInt();
            int arrivalTime = scanner.nextInt();
            int priority = scanner.nextInt();
            int cpuBurst = scanner.nextInt();
            processes.add(new Process(id, arrivalTime, priority, cpuBurst));
        }
    } catch (FileNotFoundException e){
        System.out.println("File not found");
    }
    return processes;
   }

   private static void fifoSchedule(List<Process> processes){
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

   private static void sjfSchedule(List<Process> processes){
    processes.sort((p1, p2) -> Integer.compare(p1.getCpuBurst(), p2.getCpuBurst()));
    fifoSchedule(processes);
   }

   private static void prioritySchedule(List<Process> processes){
    processes.sort((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()));
    fifoSchedule(processes);
   }
 
   }   

