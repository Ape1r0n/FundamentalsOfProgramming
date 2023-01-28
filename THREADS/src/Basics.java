import java.util.concurrent.TimeUnit;

public class Basics {

    public static class FirstThread extends Thread{
        public void run(){
            System.out.println("1) Relearning threads");
            try {
                sleep(TimeUnit.SECONDS.toMillis(3));
            } catch (InterruptedException e) {
                System.out.println("1) try-catch blocks are hella important, but also, they are ugliest piece of shit on this planet");
            }
            System.out.println("1) All over again");
        }
    }

    public static class FirstRunnable implements Runnable{
        private boolean stopRequested = false;
        public synchronized void requestStop(){ this.stopRequested = true; }
        public synchronized boolean isStopRequested() { return this.stopRequested; }
        public void run(){
            while (!isStopRequested()){
                System.out.println("3) FirstRunnable running...");
                sleep(3);
            }
        }
    }

    public static void sleep(long sec){
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(sec));
        } catch (InterruptedException e) {
            System.out.println("try-catch blocks are hella important, but also, they are ugliest piece of shit on this planet");
        }
    }

    static Runnable r = () -> System.out.println("4) Run, " + Thread.currentThread().getName() + " , Run!");
    static Runnable anotherR = () -> {
        while(true){
            sleep(1);
            System.out.println("anotherR running in while(true) loop...");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        FirstRunnable runnableForThird = new FirstRunnable();
        Thread third = new Thread(runnableForThird); // 3
        third.start(); // 3
        Thread daemonThread = new Thread(anotherR); // daemon
        daemonThread.setDaemon(true); // daemon
        daemonThread.start(); // daemon
        sleep(4); // daemon
        FirstThread firstThread = new FirstThread(); // 1
        firstThread.start(); // 1
        new Thread(() -> System.out.println("2) Is this anonymous class?")).start(); // 2
        firstThread.join();
        sleep(10); // Main
        // third.setDaemon(true); // 3
        runnableForThird.requestStop(); // 3
        new Thread(r).start(); // 4
    }
}