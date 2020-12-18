import java.util.Vector;

public class Statement {
	
	String statement;
	
	// default constructor
	public Statement() {}
	
	/* extracted method to format statement */
	// construct a statement
	public Statement(Customer c) {
		statement = "Rental Record for " + c.getName() + "\n";
		Vector<Rental> rentals = c.getRentals();
		c.setTotal(calculateTotal(rentals));
		c.setPoints(calculatePoints(rentals));
		int n = rentals.size();
		
		for(int i = 0; i < n; i++) {
			
			Rental r = rentals.get(i);
			Movie movie = r.getMovie();
			
			statement += String.format("\t%s\t$%.2f\n", movie.getTitle(), r.calculateRent());
		}
		
		statement += footer(c.getTotal(), c.getPoints());
	}
	
	// get the constructed statement
	public String getStatement() {
		return this.statement;
	}
	
	// print in XML format function
	public String printXMLStatement(Customer c) {
	
		String statement = "Rental Record\n";
		String Rentals = "";
		Vector<Rental> rentals = c.getRentals();
		c.setTotal(calculateTotal(rentals));
		c.setPoints(calculatePoints(rentals));
		int n = rentals.size();
		
		for (int i = 0; i < n; i++) {
			
			Rental r = rentals.get(i);
			Movie m = r.getMovie();
			
			String name = String.format("<name> %s </name>\n", c.getName());
			Rentals += name;
			String movie = String.format("\t<movie> %s </movie>", m.getTitle());
			String days = String.format("\t<days> %d </days>", r.getDaysRented());
			String rent = String.format("\t<rent> %.2f </rent>", r.calculateRent());
			String rentalAll = String.format("\t<rental>\n\t%s\n\t%s\n\t%s\n\t</rental>\n\t", movie, days, rent);
			Rentals += rentalAll;
			
		}
		
		String totalCost = String.format("<total> %.2f </total>", c.getTotal());
		String points = String.format("<points> %d </points>", c.getPoints());
		statement += String.format("<statement>\n\t%s\n\t%s\n\t%s\n</statement>", Rentals, totalCost, points);
		
		return statement;
	}

	/* Extracted Method for statement footer */
	/* Moved method from statement() Customer Class */
	public String footer(double total, int points) {
		return String.format("Amount owed is $%.2f \nYou earned %d frequent renter points", total, points);
	}
	
	/* Extracted Method to calculate total rental price */
	/* Moved method from statement() Customer Class */
	public double calculateTotal(Vector<Rental> rentals) {
		
		double total = 0;
		int n = rentals.size();
		
		for(int i = 0; i < n; i++) {
			
			Rental r = rentals.get(i);
			total += r.calculateRent();
			
		}
		
		return total;
	}
	
	/* Extracted Method to calculate frequent rental points */
	/* Moved method from statement() Customer Class */
	public int calculatePoints(Vector<Rental> rentals) {
		
		int points = 0;
		int n = rentals.size();
		
		for (int i = 0; i < n; i++) {
			Rental r = rentals.get(i);
			Movie movie = r.getMovie();
			
			if(movie.getClass() == NewReleasedMovie.class && r.getDaysRented() > 1) {
				points += 2;
			} else {
				points++;
			}
			
		}
		
		return points;
		
	}
}