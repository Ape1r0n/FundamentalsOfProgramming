package BookShop;

public class Customer implements Runnable {

	private String name;
	private int booksBought;
	private BookShop shop;

	public Customer(String name, BookShop shop) {
		this.name =  name;
		this.shop = shop;
	}

	public void buy5000Books() {
		for(int i = 1; i <= 5000; i++)
			if(shop.buyBook())
				booksBought++;
	}

	@Override
	public void run() {
		this.buy5000Books();
	}

	public void printSummary() {
		System.out.println(name + " bought " + booksBought + " books.");
	}

}