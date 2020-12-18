import java.util.Vector;

public class Customer {

	private String name;
	private double total;
	private int points;
	private Vector<Rental> rentals = new Vector<Rental>();
	
	// default constructor
	public Customer() {}
	
	// constructor
	public Customer(String name) {
		this.name = name;
	}
	
	// Setters
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	// Add rental to customer's account
	public void addRental(Rental rental) {
		rentals.addElement(rental);
	}
	
	// get rentals
	public Vector<Rental> getRentals() {
		return this.rentals;
	}
	
	// printing 
	public void printStatement() {

		Statement s = new Statement(this);
		System.out.println(s.getStatement());
		
	}
	
	// print in xml format
	public void printXMLStatement() {

		Statement s = new Statement();
		System.out.println(s.printXMLStatement(this));
		
	}

}
