import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    static class Calculation{
        public static final int UNSPECIFIED = -1;
        public static final int ADDITION = 0;
        public static final int SUBTRACTION = 1;

        int type = UNSPECIFIED;
        public double value;

        public Calculation(int type, double value) {
            this.type = type;
            this.value = value;
        }
    }
    private long count = 0;
    private double result = 0.0D;
    Lock lock = new ReentrantLock(); // passing 'true' in constructor guarantees lock fairness. Default=false.

    public void add(double value){
        try {
            lock.lock();
            this.result += value;
        } finally {
            lock.unlock();
        }
    }

    public void subtract(double value){
        try {
            lock.lock();
            this.result -= value;
        } finally {
            lock.unlock();
        }
    }

    public void calculate(Calculation ... calculations){
        try {
            lock.lock();
            for(Calculation calculation : calculations){
                switch(calculation.type){
                    case Calculation.ADDITION -> add(calculation.value);
                    case Calculation.SUBTRACTION -> subtract(calculation.value);
                }
            }
        } finally {
            lock.unlock();
        }
    }

//    public void inc(){
//        try {
//            lock.lock();
//            this.count++;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public long getCount(){
//        try {
//            lock.lock();
//            return this.count;
//        } finally {
//            lock.unlock();
//        }
//    }

    public static void lockSleepUnlock(Lock lock, long milliseconds){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " holds the lock.");
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock l = new ReentrantLock(false);
        Runnable runnable = () -> lockSleepUnlock(l,2000);

        Thread t1 = new Thread(runnable, "Thread 1");
        Thread t2 = new Thread(runnable, "Thread 2");
        Thread t3 = new Thread(runnable, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
