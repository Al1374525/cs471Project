package cs471Project.CPUSCHED;
import java.io.*;
import java.util.*;

public class CPUScheduler {
    public static void main(String[] args){
        List<Process> processList = readProcesses("input.txt");
        fifo(new ArrayList<>(processList));
        sjf(new ArrayList<>(processList));
        priorityScheduling(new ArrayList<>(processList));
    }

    //read Process
    static List<Process> readProcesses(String fileName){
        List<Process> processList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                int arrivalTime = Integer.parseInt(parts[1]);
                int priority = Integer.parseInt(parts[2]);
                int burstTime = Integer.parseInt(parts[3]);
                processList.add(new Process(id, arrivalTime, priority, burstTime));
            }
        
        } catch(IOException e){
            e.printStackTrace();
        }

        return processList;
    }

    

 
   }   

