
public class Main {

	public static void main(String[] args) {
		
		// Create some movies
		Movie rm1 = new Movie("Avengers:Infinity War");
		Movie rm2 = new Movie("6 Underground");
		Movie nrm1 = new Movie("Tenet");
		Movie nrm2 = new Movie("Mulan");
		Movie cm1 = new Movie("Frozen");
		Movie cm2 = new Movie("Onward");
		
		// Create customers and add rentals to his/her account
		Customer c1 = new Customer("John Smith");
		c1.addRental(new RentalAdults(rm1, 5));
		c1.addRental(new RentalAdults(rm2, 5));
		c1.addRental(new RentalNewReleased(nrm1, 5));
		c1.addRental(new RentalNewReleased(nrm2, 5));
		c1.addRental(new RentalChildrens(cm1, 5));
		c1.addRental(new RentalChildrens(cm2, 5));
		
		Customer c2 = new Customer("Jane Doe");
		c2.addRental(new RentalAdults(rm1, 7));
		c2.addRental(new RentalNewReleased(nrm1, 7));
		c2.addRental(new RentalChildrens(cm1, 7));
		
		System.out.println(c1.statement());
		System.out.println();
		System.out.println(c2.statement());
	}

}
