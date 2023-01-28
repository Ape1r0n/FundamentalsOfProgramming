package ScrewStore;

public class Order {
    private Screw screw;
    private int amount;

    public Order(Screw screw, int amount) {
        this.screw = screw;
        this.amount = amount;
    }

    public Screw getScrew() {
        return screw;
    }

    public int getAmount() {
        return amount;
    }
}