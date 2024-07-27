import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> buffer;
    private int id;

    public Consumer(BlockingQueue<Integer> buffer, int id){
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        try{
            while(true){
                buffer.take();
                System.out.println("Consumer "+id+" consumed: "+buffer.take());
            }
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
