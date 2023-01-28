package SynchronizedLists;

import java.util.LinkedList;
import java.util.List;

public class SynchronizedList<T> {
    private List<T> innerList = new LinkedList<>();
    RW lock = new RW();

    public void add(int index, T e) throws InterruptedException {
        lock.startWrite();
        innerList.add(index, e);
        lock.endWrite();
    }

    public T remove(int index) throws InterruptedException {
        lock.startWrite();
        T smth = innerList.remove(index);
        lock.endWrite();
        return smth;
    }

    public T get(int index) throws InterruptedException {
        lock.startRead();
        T smth = innerList.get(index);
        lock.endRead();
        return smth;
    }

    public boolean contains(T e) throws InterruptedException {
        lock.startRead();
        boolean smth = innerList.contains(e);
        lock.endRead();
        return smth;
    }
}
