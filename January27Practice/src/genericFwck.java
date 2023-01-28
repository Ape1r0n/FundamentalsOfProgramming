import java.util.Arrays;

class FenwickTree<T> {
    private T[] tree;
    private T[] original;
    private int size;
    private T initialValue;
    private T zeroValue;
    private T addIdentity;
    private T multiplyIdentity;
    private T add(T a, T b) {
        // Implement add operation for type T
    }
    private T multiply(T a, T b) {
        // Implement multiply operation for type T
    }
    private T getValue(int index) {
        // Implement method to get value at index for type T
    }
    private void setValue(int index, T value) {
        // Implement method to set value at index for type T
    }

    public FenwickTree(T[] arr, T zeroValue, T addIdentity, T multiplyIdentity) {
        this.size = arr.length;
        this.original = Arrays.copyOf(arr, size);
        this.tree = (T[]) new Object[size + 1];
        this.zeroValue = zeroValue;
        this.addIdentity = addIdentity;
        this.multiplyIdentity = multiplyIdentity;
        Arrays.fill(tree, zeroValue);
        for (int i = 0; i < size; i++) {
            update(i, arr[i]);
        }
    }

    public void update(int index, T value) {
        setValue(index, value);
        for (int i = index + 1; i <= size; i += (i & -i)) {
            tree[i] = add(tree[i], value);
        }
    }

    public T query(int index) {
        T result = zeroValue;
        for (int i = index + 1; i > 0; i -= (i & -i)) {
            result = add(result, tree[i]);
        }
        return result;
    }

    public T queryRange(int left, int right) {
        return add(query(right), multiply(query(left - 1), -1));
    }

    public T getOriginal(int index) {
        return getValue(index);
    }

    public void setOriginal(int index, T value) {
        T diff = add(value, multiply(getOriginal(index), -1));
        update(index, diff);
    }
}

