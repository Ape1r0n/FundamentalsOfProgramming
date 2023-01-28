import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Started: " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished: " + id);
    }
}

public class tpool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i=0; i<5; i++) executorService.submit(new Processor(i));
        executorService.shutdown();
        System.out.println("All tasks submitted.");
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException("awaitTermination exception");
        }
    }
}