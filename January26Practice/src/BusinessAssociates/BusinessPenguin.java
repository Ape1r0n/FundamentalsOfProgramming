package BusinessAssociates;

public class BusinessPenguin {
    String name;
    int balance;
    BusinessPenguin partner;

    public BusinessPenguin(String name) {
        this.name = name;
        this.balance = 0;
    }

    public void setPartner(BusinessPenguin partner) {
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void sellFish(int price) {
        balance += price/2;
        partner.balance += price/2;
    }
}