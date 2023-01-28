package BusinessAssociates2;

public class Main {
    public static void main(String[] args) {
        BusinessPenguin peter = new BusinessPenguin("Peter");
        BusinessPenguin paul = new BusinessPenguin("Paul");

        peter.setPartner(paul);
        paul.setPartner(peter);

        Customer petersCustomer = new Customer(peter);
        Customer paulsCustomer = new Customer(paul);

        petersCustomer.start();
        paulsCustomer.start();

        try {
            petersCustomer.join();
            paulsCustomer.join();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong. Interrupted!");
            return;
        }

        System.out.println("Peter hat " + peter.getBalance());
        System.out.println("Paul hat " + paul.getBalance());
    }
}