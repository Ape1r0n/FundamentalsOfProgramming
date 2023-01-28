package SynchronizedLists;

public class Main {
    public static void main(String[] args) {
        SynchronizedList<String> list = new SynchronizedList<>();

        try {
            for (int i = 0; i < 5000; i++) {
                list.add(i, "" + i);
            }

            // The 5 readers query 10000 times the  [1-5]000th value
            Thread[] readers = new Thread[5];
            for (int i = 0; i < readers.length; i++) {
                final int icopy = i * 1000;
                readers[i] = new Thread(() -> {
                    for (int j = 0; j < 10000; j++)
                        try {
                            list.get(icopy);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                });
            }
            // the writer inserts 10000 times an element and subsequently deletes it again
            Thread writer = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    try {
                        list.add(4, "4");
                        list.remove(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // We now start all and measure how long they run
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < readers.length; i++)
                readers[i].start();
            writer.start();
            for (int i = 0; i < readers.length; i++)
                readers[i].join();
            writer.join();
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Duration: " + (duration) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
