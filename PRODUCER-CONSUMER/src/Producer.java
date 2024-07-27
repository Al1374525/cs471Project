import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    
    private BlockingQueue<Integer> buffer;
    private int id;

    public Producer(BlockingQueue<Integer> buffer, int id){
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        try{
            while (true){
                buffer.put(id);
                System.out.println("Producer " + id + " produced a product");
            }
        } catch(InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }
}
