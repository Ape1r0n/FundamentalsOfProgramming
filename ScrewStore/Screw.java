package ScrewStore;

public class Screw{
    private final ScrewDrive head;
    private final double diameter, length;
    private double price;

    public Screw(ScrewDrive head, double diameter, double length, double price) {
        this.head = head;
        this.diameter = diameter;
        this.length = length;
        this.price = price;
    }

    public ScrewDrive getHead() {
        return head;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int hashCode(){
        return head.hashCode() + 7 * Double.hashCode(diameter) + 11 * Double.hashCode(length);
    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Screw)) return false;
        Screw other = (Screw) obj;
        return head.equals(other) && diameter == other.diameter && length == other.length;
    }
}