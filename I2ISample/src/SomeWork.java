class SomeWork<T> implements Work<T> {
    private T x;
    private Work<T> work;
    public SomeWork(T x, Work<T> work) {
        this.x = x;
        this.work = work;
    }
    public boolean noWork() {
        return work.noWork();
    }
    public T viewWork() {
        return work.removeWork().viewWork();
    }
    public Work<T> removeWork() {
        return work.removeWork();
    }
    public Work<T> addWork(T x) {
        return work.addWork(x);
    }
    public Work<T> reverse() {
        return work.reverse();
    }
}