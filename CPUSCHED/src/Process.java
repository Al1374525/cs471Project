package cs471Project.CPUSCHED.src;






 public class Process {
    private int id;
    private int arrivalTime;
    private int priority;
    private int cpuBurst;

    public Process(int id, int arrivalTime, int priority, int cpuBurst) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.cpuBurst = cpuBurst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getCpuBurst() {
        return cpuBurst;
    }

    public void setCpuBurst(int cpuBurst) {
        this.cpuBurst = cpuBurst;
    }
}
