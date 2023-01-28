public class State {
    private double sum;
    private int count;
    public void inc(double d) {
        this.sum += d;
        this.count++;
    }
    public void add(State s) {
        this.count += s.count;
        this.sum += s.sum;
    }
    public double average() {
        return ((count == 0) ? 0 : (sum/count));
    }
} // sub-task 1