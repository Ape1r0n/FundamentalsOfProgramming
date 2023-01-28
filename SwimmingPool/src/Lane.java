public class Lane extends Thread {
    private SwimWaitingQueue swq;
    private boolean stop = false;

    public Lane(SwimWaitingQueue swq) {
        this.swq = swq;
    }

    @Override
    public void run() {
        for(;;){
            try {
                Runnable swimmer;
                if(stop) break;
                swimmer = swq.assign();
                swimmer.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void doStop(){
        this.stop = true;
        this.interrupt();
    }
}
