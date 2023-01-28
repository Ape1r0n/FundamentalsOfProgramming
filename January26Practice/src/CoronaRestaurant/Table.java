package CoronaRestaurant;

import java.util.*;

public class Table extends Thread {
    private GuestWaitingQueue tasks = null;
    private boolean stopped = false;

    public Table(GuestWaitingQueue wr) {
        tasks = Objects.requireNonNull(wr);
    }

    public void run() {
        while(!stopped){
            try {
                Runnable r = tasks.assign();
                r.run();
            }catch(Exception e){
                System.out.println("Run has been interrupted");
            }
        }
    }

    public synchronized void doStop() {
        stopped = true;
        this.interrupt();
    }
}