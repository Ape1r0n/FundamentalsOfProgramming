import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void stageOne(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized(list1){
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized(this) {
            list2.add(random.nextInt(100));
        }
    }

    public void process(){
        for(int i=0; i<1000; i++){
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();
        new Worker().process();
        long total = System.currentTimeMillis() - start;
        System.out.println("Time taken: " + total);
    }
}
