public class SynchronizedIncrement {
    private int count = 0;

    public static void main(String[] args){
        SynchronizedIncrement synchronizedIncrement = new SynchronizedIncrement();
        synchronizedIncrement.doWork();
    }

    public synchronized void increment(){
        count++;
    }
    public void doWork(){
        Thread t1 = new Thread(() -> { for(int i=0; i<10000; i++) increment(); });
        Thread t2 = new Thread(() -> { for(int i=0; i<10000; i++) increment(); });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Join was incomplete");
        }

        System.out.println(count);

    }
}
