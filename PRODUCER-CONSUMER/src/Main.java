import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int BUFFER_SIZE = 10;
    private static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Usage: java Main <numThreads> <numItems>");
            return;
        }

        int numProducers = Integer.parseInt(args[0]);
        int numConsumers = Integer.parseInt(args[1]);

        ExecutorService executor = Executors.newFixedThreadPool( numProducers + numConsumers);

        for(int i = 0; i < numProducers; i++){
            executor.execute(new Producer(buffer, i + 1));
        }

        for(int i = 0; i < numConsumers; i++){
            executor.execute(new Consumer(buffer, i + 1));
        }

        executor.shutdown();
    }
}
