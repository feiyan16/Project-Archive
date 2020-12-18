
public class Rental {
    private Movie _movie;
    private int   _daysRented;
    RentalPrice rent;
    Points points;
    
    public Rental(Movie movie, int d) {
    	_movie      = movie;
        _daysRented = d;
	}

	public int getDaysRented() {
        return _daysRented;
    }
    
    public Movie getMovie() {
        return _movie;
    }
    
    // parent function
    public double calculateRent() {
    	return rent.calculate(_daysRented);
    }
    
    // parent function
    public int calculatePoints() {
    	return points.calculate();
    }
}

class RentalAdults extends Rental {

	public RentalAdults(Movie movie, int d) {
		super(movie, d);
		
		// set rent to specific class inherited from RentalPrice
		rent = new AdultsRentalPrice();
		
		// set points to specific class inherited from Points
		points = new RenterPoints();
	}
	
}

class RentalChildrens extends Rental {

	public RentalChildrens(Movie movie, int d) {
		super(movie, d);
		
		// set rent to specific class inherited from RentalPrice
		rent = new ChildrensRentalPrice();
		
		// set points to specific class inherited from Points
		points = new RenterPoints();
	}
	
}

class RentalNewReleased extends Rental {

	public RentalNewReleased(Movie movie, int d) {
		super(movie, d);
		
		// set rent to specific class inherited from RentalPrice
		rent = new NewReleasedRentalPrice();
		
		// set points to specific class inherited from Points
		if (d > 1) {
			points = new RenterPointsBonus();
		} else {
			points = new RenterPoints();
		}
	}
	
}
