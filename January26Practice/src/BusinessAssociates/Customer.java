package BusinessAssociates;

public class Customer implements Runnable{
    BusinessPenguin salespenguin;

    public Customer(BusinessPenguin salesman) {
        this.salespenguin = salesman;
    }

    public void run(){
        for(int i=0; i<5000; i++) salespenguin.sellFish(2);
    }
}