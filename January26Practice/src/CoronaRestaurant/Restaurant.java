package CoronaRestaurant;

import java.util.*;

public class Restaurant {
    private GuestWaitingQueue tasks = null;
    private Table[] threads = null;
    private boolean stopped = false;

    public Restaurant(int threadCount){
        threads = new Table[threadCount];
        tasks = new GuestWaitingQueue();
        for(int i=0; i<threadCount; i++) threads[i] = new Table(tasks);
        for(Table thread : threads) thread.start();
    }

    public synchronized void reserve(Runnable task){
        if(stopped) throw new IllegalStateException("Can't reserve anything...");
        this.tasks.enqueue(task);
    }

    public synchronized void stop(){
        stopped = true;
        for(Table table : threads) table.doStop();
    }
}