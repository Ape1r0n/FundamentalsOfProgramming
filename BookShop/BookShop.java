package BookShop;

public class BookShop {

	private int booksInStore;
	private int booksSold;

	public BookShop() {
		booksInStore = 0;
		booksSold = 0;
	}

	public void addBooksInStore(int amount) {
		booksInStore += amount;
	}

	public synchronized boolean buyBook() {
		if (booksInStore - booksSold > 0) {
			booksSold++;
			return true;
		}

		return false;
	}

	public void printSummary() {
		System.out.println(booksSold + " books sold" +
				" out of " + booksInStore);
	}

}