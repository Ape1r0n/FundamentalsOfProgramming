package BusinessAssociates;

public class Main {
    public static void main(String[] args) {
        BusinessPenguin peter = new BusinessPenguin("Peter");
        BusinessPenguin paul = new BusinessPenguin("Paul");

        peter.setPartner(paul);
        paul.setPartner(peter);

        Customer petersCustomer = new Customer(peter);
        Customer paulsCustomer = new Customer(paul);

        Thread petersCustomerThread = new Thread(petersCustomer);
        Thread paulsCustomerThread = new Thread(paulsCustomer);

        petersCustomerThread.start();
        paulsCustomerThread.start();

        try {
            petersCustomerThread.join();
            paulsCustomerThread.join();
        }catch(InterruptedException e){
            return;
        }

        System.out.println("Balances: [ Peter: " + peter.getBalance() + ", Paul: " + paul.getBalance() + " ]");
    }
}