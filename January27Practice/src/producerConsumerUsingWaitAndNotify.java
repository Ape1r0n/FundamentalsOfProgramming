import java.util.Scanner;

public class producerConsumerUsingWaitAndNotify {
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized(this){
            System.out.println("Waiting for return key");
            scanner.nextLine();
            System.out.println("Return key pressed");
            notify();
        }
    }

    public static void main(String[] args) {
        final producerConsumerUsingWaitAndNotify pcuwan = new producerConsumerUsingWaitAndNotify();

        Thread t1 = new Thread(() -> {
            try {
                pcuwan.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pcuwan.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
