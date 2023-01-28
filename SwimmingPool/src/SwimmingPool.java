public class SwimmingPool {
    private final SwimWaitingQueue queue;
    private final Lane[] lanes;
    private boolean stopped;

    public SwimmingPool(int threadCount) {
        queue = new SwimWaitingQueue();
        lanes = new Lane[threadCount];
        for (int i = 0; i < threadCount; i++) {
            lanes[i] = new Lane(queue);
            lanes[i].start();
        }
    }

    public synchronized void reserve(Runnable task) throws IllegalStateException {
        if(stopped) throw new IllegalStateException("Swimming pool is already stopped");
        queue.enqueue(task);
    }

    public synchronized void stop() {
        stopped = true;
        for (Lane lane : lanes) lane.doStop();
    }
}