import java.util.ArrayList;

public class ObserverDP {

	public static void main(String[] args) {
		
		// create object with name and original price (state)
		Book b = new Book("Green Eggs & Ham", 13.65);
		
		// 2 observers attached to book b
		Price p1 = new Price(b);
		Price p2 = new Price(b);

		// update state 1
		b.setPrice(24.99);
		
		// update state 2
		b.setPrice(32.22);
	}

}

interface Observer {
	
	void update(double price);
}

class Price implements Observer {
	
	double price;
	String observer = "Observer ";
	int observerID;
	
	static int updateTracker = 1;
	
	Subject book;

	Price(Subject b) {
		book = b;
		observerID = updateTracker++;
		book.register(this);
		System.out.println("Observer " + observerID + " from " + this.getClass() + " attached to object from " + b.getClass());
	}
	
	@Override
	public void update(double price) {
		this.price = price;
		print();
	}
	
	void print() {
		System.out.println(observer + observerID + ":\n" 
				+ book.getName() + ":\t Updated Price: $" + price + "\n");
	}
	
}

interface Subject {
	
	String getName();
	void register(Observer o);
	void unregister(Observer o);
	void notifyObserver();
	
}

class Book implements Subject {
	
	ArrayList<Observer> observers;
	double price;
	String name;
	
	Book(String n, double p) {
		price = p;
		name = n;
		System.out.println("Book: " + name + "\t\tOriginal Price: $" + price + "\n");
		observers = new ArrayList<Observer>();
	}
	
	void setPrice(double p) {
		price = p;
		System.out.println("\n" + observers.size() + " Observer(s) notified of price update for " + name  + " to $" + price + "\n");
		notifyObserver();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		int i = observers.indexOf(o);
		observers.remove(i);
		
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).update(price);
		}
		
	}

	@Override
	public String getName() {
		return name;
	}
	
}