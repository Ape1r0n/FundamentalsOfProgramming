package CoronaRestaurant;

import java.util.*;

public class GuestWaitingQueue {
    private List<Runnable> list;

    public GuestWaitingQueue() {
        this.list = new LinkedList<>();
    }

    public synchronized void enqueue(Runnable r) {
        list.add(r);
        notifyAll();
    }

    public synchronized Runnable assign() {
        while(list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Assign has been interrupted");
            }
        }
        return list.remove(0);
    }
}

