import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class kafkasor implements Runnable{
    private CountDownLatch latch;
    public kafkasor(CountDownLatch l){
        latch = l;
    }
    @Override
    public void run(){
        System.out.println("Started");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        latch.countDown();

    }
}

public class countdownLatches {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new kafkasor(countDownLatch));
        executorService.submit(new kafkasor(countDownLatch));
        executorService.submit(new kafkasor(countDownLatch));

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed...");
    }
}