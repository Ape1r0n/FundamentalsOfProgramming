import java.util.Scanner;

class thrd extends Thread{
    private volatile boolean running = true; // Forces thread to read 'running' from cache(Cache Coherence)
    @Override
    public void run() {
        while(running){
            System.out.println("YOU SUCK");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void doStop(){
        running = false;
        System.out.println("Torment is over");
    }
}

public class BooleanStop {
    public static void main(String[] args) {
        System.out.println("Press any key to stop getting harassed...");
        thrd thrd = new thrd();
        thrd.start();
        Scanner scn = new Scanner(System.in);
        scn.nextLine();
        thrd.doStop();
    }
}