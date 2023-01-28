import java.util.ArrayList;
import java.util.List;

public class VirtualThreads {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for( int i=0; i<10; i++) System.out.println(Thread.currentThread().getName() + " | Index: " + i);
        };

        Thread vThread1 = Thread.ofVirtual().start(runnable); // Will start immediately
        Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable); // Won't start immediately

        vThreadUnstarted.start();

        try {
            vThreadUnstarted.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Thread> vThreads = new ArrayList<>();

        int vThreadCount = 100_000;

        for(int i=0; i<vThreadCount; i++){
            int vThreadIndex = i;
            Thread vThread = Thread.ofVirtual().start(() ->{
                int result = 1;
                for(int j=0; j<10; j++) result *= (j+1);
                System.out.println("Result[" + vThreadIndex + "] == " + result);
            });

            vThreads.add(vThread);
        }

        for(int i=0; i<vThreads.size(); i++){
            try {
                vThreads.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}