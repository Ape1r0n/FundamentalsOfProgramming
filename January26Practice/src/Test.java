import java.util.Random;
import java.util.concurrent.*;

public class Test {
    static class Task implements Callable<Integer> {
        public Integer call(){
            return new Random().nextInt();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(new Task());
        try {
            Integer result = future.get();
            System.out.println(result);
        }catch (InterruptedException | ExecutionException e){
            System.out.println("Exception has occured");
            return;
        }
    }
}
