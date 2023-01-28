import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(5); // this BlockingQueue is bounded, which means we can't insert more than 5 elements

        new Thread(() -> {
            int i = 0;
            try {
                while(true) {
                    q.put(++i);
                    System.out.println("Put -> " + i);
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while(true){
                    Integer poll = q.take();
                    System.out.println("Polled -> " + poll);
                    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
