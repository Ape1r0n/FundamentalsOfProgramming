public class SeperateObjects {

    public static class MyRunnable implements Runnable{
        private int count = 0;

        @Override
        public void run() {
            for(int i=0; i<1_000_000; i++) this.count++;
            System.out.println(Thread.currentThread().getName() + " : " + this.count + " : " + Thread.currentThread().getName().length());
        }
    }

    public static void main(String[] args) {
        Thread T1 = new Thread(new MyRunnable(), "UwU");
        Thread T2 = new Thread(new MyRunnable(), "(>_<)");
        T1.start();
        T2.start();
    }
}
