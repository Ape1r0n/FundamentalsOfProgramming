import java.util.List;
import java.util.LinkedList;

public class SwimWaitingQueue {
    private final List<Runnable> list = new LinkedList();

    public void enqueue(Runnable r){
        synchronized(list){
            list.add(r);
            list.notify();
        }
    }

    public Runnable assign() throws InterruptedException{
        synchronized(list){
            while(list.size() == 0){
                list.wait();
            }
            return list.remove(0);
        }
    }

    public List<Runnable> getRunnableList(){
        return list;
    }
}