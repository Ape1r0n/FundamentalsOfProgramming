public final class Inner<T> implements Node<T>{
    public int lsize, rsize;
    public Node<T> left, right;

    public Inner(Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int size() {
        return lsize + rsize;
    }

    @Override
    public T get(int i) {
        if(!(i >= 0 && i < size())) throw new IndexOutOfBoundsException();
        if(lsize >= i+1) return left.get(i);
        return right.get(i-lsize);
    }

    @Override
    public void update(int i, T x) {
        if(!(i >= 0 && i < size())) throw new IndexOutOfBoundsException();
        if(lsize >= i + 1) left.update(i,x);
        else right.update(i-lsize,x);
    }

    @Override
    public Node<T> insert(int i, T x) {
        if(lsize >= i+1){
            if(left != null) left = left.insert(i, x);
            else left = new Leaf<>(x);
            lsize = left.size();
        }else{
            if(right != null) right.insert(i, x);
            else right = new Leaf<>(x);
            rsize = right.size();
        }
        return this;
    }

    @Override
    public Node<T> remove(int i) {
        if(!(i >= 0 && i < size())) throw new IndexOutOfBoundsException();
        if(lsize >= i+1){
            left = left.remove(i);
            if(left == null) return right;
            else lsize = left.size();
        }else{
            right = right.remove(i-lsize);
            if(right == null) return left;
            else rsize = right.size();
        }
        return this;
    }
}
