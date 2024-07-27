package cs471Project.CPUSCHED.src.cs471project.cpusched;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main <input file> <scheduling algorithm>");
            return;
        }

        String inputFile = args[0];
        String algorithm = args[1];
        List<Process> processes = readProcesses(inputFile);

        switch (algorithm.toUpperCase()) {
            case "FIFO":
                CPUScheduler.fifoSchedule(processes);
                break;
            case "SJF":
                CPUScheduler.sjfSchedule(processes);
                break;
            case "PRIORITY":
                CPUScheduler.prioritySchedule(processes);
                break;
            default:
                System.out.println("Unknown algorithm: " + algorithm);
                break;
        }
    }

    private static List<Process> readProcesses(String inputFile) {
        List<Process> processes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                int arrivalTime = scanner.nextInt();
                int priority = scanner.nextInt();
                int cpuBurst = scanner.nextInt();
                processes.add(new Process(id, arrivalTime, priority, cpuBurst));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFile);
        }
        return processes;
    }
}
