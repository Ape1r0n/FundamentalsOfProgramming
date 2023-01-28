package BusinessAssociates2;

public class Customer extends Thread {
    BusinessPenguin salespenguin;

    public Customer(BusinessPenguin salesman) {
        this.salespenguin = salesman;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println(
                    salespenguin.getName() + "'s Customer buys number " + i);
            salespenguin.sellFish(2);
        }
    }
}