public final class Leaf<T> implements Node<T>{
    private T value;

    public Leaf(T value) {
        this.value = value;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public T get(int i) throws IndexOutOfBoundsException{
        if(i == 0) return this.value;
        throw new IndexOutOfBoundsException();
    }

    public void update(int i, T x) throws IndexOutOfBoundsException{
        if(i == 0) this.value = x;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Node<T> insert(int i, T x){
        if(i <= 0) return new Inner<T>(new Leaf<T>(x), this);
        else return new Inner<T>(this, new Leaf<T>(x));
    }

    @Override
    public Node<T> remove(int i) throws IndexOutOfBoundsException{
        if(i == 0) return null;
        throw new IndexOutOfBoundsException();
    }
}
