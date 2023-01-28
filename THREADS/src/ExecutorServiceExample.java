import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        executorService.execute(() -> {
//            System.out.println(Thread.currentThread().getName() + " : Task 1");
//        });
//        executorService.execute(() -> {
//            System.out.println(Thread.currentThread().getName() + " : Task 2");
//        });
//        executorService.execute(() -> {
//            System.out.println(Thread.currentThread().getName() + " : Task 3");
//        });
//
//        executorService.shutdown();

        int corePoolSize = 10;
        int maxPoolSize = 20;
        long keepAliveTime = 3000; // milliseconds

        // threadPoolExecutor შეეცდება შეძლებისდაგვარად მალე გაუშვას task
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(128));
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        // ეს ჯიგო კიდე რაღაც გრაფიკის მიხედვით გაუშვებს
        ExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);
        scheduledExecutorService = Executors.newScheduledThreadPool(10);

        Future future = threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + ": Task 4"));
        Future returnableFuture = threadPoolExecutor.submit(newCallable("Task 5"));
        String result = "";
        try {
            future.get();
            System.out.println("Got future...");
            result = (String) returnableFuture.get();
        } catch (InterruptedException e){
            // do smth
        } catch (ExecutionException e) {
            // do smth
        }
        System.out.println(result + " yoo");
        threadPoolExecutor.shutdownNow();
    }

    private static Callable newCallable(String msg){
        return new Callable(){
            public Object call() throws Exception{
                return Thread.currentThread().getName() + ": " +  msg;
            }
        };
    }

    private static Runnable newRunnable(String msg){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": " + msg);
            }
        };
    }
}