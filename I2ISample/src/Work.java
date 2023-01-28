import java.util.Iterator;
public interface Work<T> extends Iterable<T> {
    boolean noWork();
    Work<T> addWork(T x);
    T viewWork();
    Work<T> removeWork();
    Work<T> reverse();

    class WorkIterator<T> implements Iterator<T> {
    // todo
        private Work<T> work;

        public WorkIterator(Work<T> work) {
            this.work = work;
        }

        @Override
        public boolean hasNext() {
            return !work.noWork();
        }

        @Override
        public T next() {
            return work.removeWork().viewWork();
        }
    }

    default Iterator<T> iterator() {
    // todo
        return new WorkIterator<T>(this);
    }


}