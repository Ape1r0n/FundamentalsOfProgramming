public class SyncCounterMain {
    public static void main(String[] args) {
        SyncCounter counter = new SyncCounter();

        Thread t1 = new Thread(() -> {
            for(int i=0; i<1_000_000; i++) counter.incCount();
            System.out.println(counter.getCount());
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<1_000_000; i++) counter.incCount();
            System.out.println(counter.getCount());
        });

        t1.start();
        t2.start();
    }
}
