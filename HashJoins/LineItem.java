package HashJoins;

import java.time.LocalDate;
import java.util.Arrays;

public class LineItem {
    int orderKey;
    int quantity;
    private int partKey;
    private int suppKey;
    private int lineItem;
    private float extendedPrice;
    private float discount;
    private float tax;
    private char returnFlag;
    private char lineStatus;
    private LocalDate shipDate;
    private LocalDate commitDate;
    private LocalDate receiptDate;
    private char[] shipInstruct;
    private char[] shipMode;
    private char[] comment;

    public LineItem(int orderKey, int partKey, int suppKey, int lineItem, int quantity, float extendedPrice,
                    float discount, float tax, char returnFlag, char lineStatus, LocalDate shipDate,
                    LocalDate commitDate, LocalDate receiptDate, char[] shipInstruct, char[] shipMode, char[] comment) {
        this.orderKey = orderKey;
        this.partKey = partKey;
        this.suppKey = suppKey;
        this.lineItem = lineItem;
        this.quantity = quantity;
        this.extendedPrice = extendedPrice;
        this.discount = discount;
        this.tax = tax;
        this.returnFlag = returnFlag;
        this.lineStatus = lineStatus;
        this.shipDate = shipDate;
        this.commitDate = commitDate;
        this.receiptDate = receiptDate;
        this.shipInstruct = shipInstruct;
        this.shipMode = shipMode;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "orderKey=" + orderKey +
                ", partKey=" + partKey +
                ", suppKey=" + suppKey +
                ", lineItem=" + lineItem +
                ", quantity=" + quantity +
                ", extendedPrice=" + extendedPrice +
                ", discount=" + discount +
                ", tax=" + tax +
                ", returnFlag=" + returnFlag +
                ", lineStatus=" + lineStatus +
                ", shipDate=" + shipDate +
                ", commitDate=" + commitDate +
                ", receiptDate=" + receiptDate +
                ", shipInstruct=" + Arrays.toString(shipInstruct) +
                ", shipMode=" + Arrays.toString(shipMode) +
                ", comment=" + Arrays.toString(comment) +
                '}';
    }

    public void output() {
        System.out.println(this.toString());
    }
}