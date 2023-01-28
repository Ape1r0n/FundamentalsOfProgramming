public class FenwickTree{
    private int[] tree;

    public FenwickTree(int n) {
        tree = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i < tree.length) {
            tree[i] += delta;
            i += (i & -i);
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int queryRange(int i, int j) {
        return query(j) - query(i - 1);
    }
}
