public interface Node<T>{
    int size();
    T get(int i);
    void update(int i, T x);
    Node<T> insert(int i, T x);
    Node<T> remove(int i);
}
