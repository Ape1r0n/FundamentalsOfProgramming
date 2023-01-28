public class SharedObjects {
    public static class SharedRunnable implements Runnable{
        private int count = 0;
        @Override
        public void run() {
            for(int i=0; i<1_000_000; i++) this.count++;
            System.out.println(Thread.currentThread().getName() + " : " + this.count + " : " + Thread.currentThread().getName().length());
        }
    }

    public static void main(String[] args) {
        SeperateObjects.MyRunnable myRunnable = new SeperateObjects.MyRunnable();
        Thread T1 = new Thread(myRunnable, "UwU");
        Thread T2 = new Thread(myRunnable, "(>_<)");
        T1.start();
        T2.start();
    }
}
