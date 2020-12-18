
/*
 * 1)
 * You are required to modify the code to make the function of computing 
 * rental prices into a strategy design pattern (That is, you will have 
 * strategy classes to compute rental prices).
 * 
 */

public interface RentalPrice {
	
	/*
	 * function to calculate rent will be overridden by the functions 
	 * from classes that implements the interface, each overriding 
	 * function will be specific to the type of movie that rental is.
	 */
	double calculate(int d);
	
}

class AdultsRentalPrice implements RentalPrice {
	
	@Override
	public double calculate(int daysRented) {
		
		double rent = 0;
		rent += 2;
		if(daysRented > 2) {
			rent += (daysRented - 2) * 1.5;
		}
		
		return rent;
	}
}

class ChildrensRentalPrice implements RentalPrice {
	
	@Override
	public double calculate(int daysRented) {
		
		double rent = 0;
		rent += 1.5;
		if(daysRented > 3) {
			rent += (daysRented - 3) * 1.5;
		}
		
		return rent;
	}
}

class NewReleasedRentalPrice implements RentalPrice {
	
	@Override
	public double calculate(int daysRented) {
		
		double rent = 0;
		rent += 0;
		if(daysRented > 0) {
			rent += (daysRented - 0) * 1.5;
		}
		
		return rent;
	}
}
