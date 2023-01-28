public class SyncCounter {
    private long count = 0;
    public synchronized void incCount(){
        this.count++;
    }
    public synchronized long getCount(){
        return this.count;
    }
}
