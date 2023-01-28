package HashJoins;

import java.time.LocalDate;
import java.util.Arrays;

public class Order {
    int orderKey;
    int custKey;
    private char orderStatus;
    private float totalPrice;
    private LocalDate orderDate;
    private char[] orderPriority;
    private char[] clerk;
    private int shippingPriority;
    private char[] comment;

    public Order(int orderKey, int custKey, char orderStatus, float totalPrice, LocalDate orderDate,
                 char[] orderPriority, char[] clerk, int shippingPriority, char[] comment) {
        this.orderKey = orderKey;
        this.custKey = custKey;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.orderPriority = orderPriority;
        this.clerk = clerk;
        this.shippingPriority = shippingPriority;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderKey=" + orderKey +
                ", custKey=" + custKey +
                ", orderStatus=" + orderStatus +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                ", orderPriority=" + Arrays.toString(orderPriority) +
                ", clerk=" + Arrays.toString(clerk) +
                ", shippingPriority=" + shippingPriority +
                ", comment=" + Arrays.toString(comment) +
                '}';
    }

    public void output() {
        System.out.println(this.toString());
    }
}