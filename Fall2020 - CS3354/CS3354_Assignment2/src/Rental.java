
public class Rental {

	private int daysRented;
	private Movie movie;
	private double rent;
	
	// default constructor
	public Rental() {}
	
	// construct a rental with movie info and days rented info
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	// get amount of days rented
	public int getDaysRented() {
		return this.daysRented;
	}
	
	// get the movie
	public Movie getMovie() {
		return this.movie;
	}
	
	/* Extracted Method to calculate the rent for each movie */
	/* Moved method from switch case in Customer Class to Rental Class */
	public double calculateRent() {
		
		this.rent = 0;
		this.rent += this.movie.basePrice;
		if(this.daysRented > this.movie.days) {
			this.rent += (this.daysRented - this.movie.days) * this.movie.pricePerDay;
		}
		
		return this.rent;
	}

}
