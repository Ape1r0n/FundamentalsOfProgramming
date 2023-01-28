import java.util.*;

public class IndexedTree<T> implements Iterable<T>{

    private Node<T> tree;
    public int size(){
        if(tree == null) return 0;
        return tree.size();
    }
    public T get(int i){
        if(tree == null) return null;
        return tree.get(i);
    }
    public void update(int i, T x){
        if(tree != null) tree.update(i,x);
       else throw new IndexOutOfBoundsException();
    }
    public void insert(int i, T x){
        if(tree == null) tree = new Leaf<>(x);
        else tree = tree.insert(i,x);
    }
    public void remove(int i){
        if(tree != null) tree.remove(i);
        else throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        var itr = new TreeIterator<T>(tree);
        return itr;
    }

    static class TreeIterator<T> implements Iterator<T>{
        int index = 0;
        Node<T> current;

        public TreeIterator(Node<T> t){
            current = t;
        }

        public boolean hasNext(){
            return (current != null && index < current.size());
        }

        public T next(){
            if(hasNext()) return current.get(index++);
            else return null;
        }
    }

    public static void main(String[] arr) {
        IndexedTree<String> t = new IndexedTree<>();
        for(String s : arr) t.insert(0,s);
        var n = t.size();
        System.out.println(n);
        for(String s: t) System.out.println(s);
        for(int i=n-1; i>=0; i--){
            System.out.println(t.get(i));
            t.remove(i);
        }
        System.out.println(t.size());
    }
}