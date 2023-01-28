package BookShop;

public class Main {
    public static void main(String[] args) {

        BookShop shop = new BookShop();
        shop.addBooksInStore(7500);

        Customer peter = new Customer("Peter", shop);
        Customer paul = new Customer("Pauls", shop);

        Thread petersCustomerThread = new Thread(peter);
        Thread paulsCustomerThread = new Thread(paul);

        petersCustomerThread.start();
        paulsCustomerThread.start();


        try {
            petersCustomerThread.join();
            paulsCustomerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Super Saiyan God Super Saiyan Kaio-Ken X20");
            return;
        }


        shop.printSummary();
        peter.printSummary();
        paul.printSummary();
    }
}
