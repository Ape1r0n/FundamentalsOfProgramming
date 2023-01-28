public class Bistro {
    private int seats;
    private Thread order, meal, waiter;
    public Bistro(int n){
        this.seats = n;
        waiter = new Thread(() -> server());
        waiter.start();
    }
    public void shutdown(){
        waiter.interrupt();
    }

    public synchronized void dine(int price){
        while(seats <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Waiting for seats has been interrupted..");
            }
        }
        seats--;

        while(order != null){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Waiting for order has been interrupted..");
            }
        }
        order = Thread.currentThread();
        System.out.println("Guest " + Thread.currentThread().threadId() + " orders for " + price + " Lari");
        notifyAll(); // notify();

        while(meal != Thread.currentThread()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Waiting for meal has been interrupted..");
            }
        }
        System.out.println("Guest " + Thread.currentThread().threadId() + " eats ...");
        meal = null;

        seats++;
        notifyAll();
    }


    public synchronized void server(){
        while(!waiter.isInterrupted()) {
            while(order == null){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Waiter: order is not null, thread has been interrupted..");
                }
            }
            Thread temp = order;
            order = null;
            notifyAll();

            while(meal != null){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Waiter: meal is null, thread has been interrupted..");
                }

            }
            meal = temp;
            System.out.println("Enjoy!");
            notifyAll();
        }
    }

    public static void main(String[] args) {
        Bistro b = new Bistro(2);
        Thread g1 = new Thread(() -> b.dine(10));
        Thread g2 = new Thread(() -> b.dine(20));
        Thread g3 = new Thread(() -> b.dine(30));
        Thread g4 = new Thread(() -> b.dine(40));
        g1.start();
        g2.start();
        g3.start();
        g4.start();
        try {
            g1.join();
            g2.join();
            g3.join();
            g4.join();
        } catch (InterruptedException e) {
            System.out.println("Joining has been interrupted");
            e.printStackTrace();
        }
        b.shutdown();
    }
}