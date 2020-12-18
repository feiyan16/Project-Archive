
public class Main {

	public static void main(String[] args) {
		
		// Create some movies
		Movie rm1 = new Movie("Avengers:Infinity War");
		Movie rm2 = new Movie("6 Underground");
		NewReleasedMovie nrm1 = new NewReleasedMovie("Tenet");
		NewReleasedMovie nrm2 = new NewReleasedMovie("Mulan");
		ChildrensMovie cm1 = new ChildrensMovie("Frozen");
		ChildrensMovie cm2 = new ChildrensMovie("Onward");
		
		// Create a customer and add rentals to his/her account
		Customer c1 = new Customer("John Smith");
		c1.addRental(new Rental(rm1, 5));
		c1.addRental(new Rental(rm2, 7));
		c1.addRental(new Rental(nrm1, 9));
		c1.addRental(new Rental(nrm2, 3));
		c1.addRental(new Rental(cm1, 2));
		c1.addRental(new Rental(cm2, 1));
		
		c1.printStatement();
		System.out.println("\n");
		c1.printXMLStatement();
	}

}
