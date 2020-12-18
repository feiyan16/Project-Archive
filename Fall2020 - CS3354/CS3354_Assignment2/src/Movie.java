
public class Movie {

	String title;
	int days;
	double basePrice;
	double pricePerDay;
	
	// default constructor
	public Movie() {}
	
	// costructor to construct a movie with the default values for a regular movie
	public Movie(String t) {
		this.title = t;
		this.days = 2;
		this.basePrice = 2;
		this.pricePerDay = 1.5;
	}
	
	// constructor for all attributes
	public Movie(String t, int g, double bP, double p) {
		
		this.title = t;
		this.days = g;
		this.basePrice = bP;
		this.pricePerDay = p;
		
	}
	
	// get title
	public String getTitle() {
		return this.title;
	}

}