import java.util.concurrent.Semaphore;

public class semaphores {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1);
        System.out.println("Available permits at the start: " + sem.availablePermits());
        sem.release();
        System.out.println("Available permits after .release(): " + sem.availablePermits());
        sem.acquire();
        System.out.println("Available permits after .acquire(): " + sem.availablePermits());

    }
}
