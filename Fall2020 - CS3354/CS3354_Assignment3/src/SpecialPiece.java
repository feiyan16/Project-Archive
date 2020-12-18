import java.util.ArrayList;

class Operation{
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	Operation() {}
	void addVehicles(Vehicle v) {
		vehicles.add(v);
	}
	ArrayList<Vehicle> Operate() {
		System.out.println("Override with actual operation in sub operation classes");
		return vehicles;
	}
}

class SpecialPiece {
	
	private String name;
	private boolean track;
	private Operation specialOperation;
	
	SpecialPiece() {}
	SpecialPiece(String n) {
		name = n;
	}
	
	void setName(String n) { name = n; }
	void setTrack(boolean b) { track = b; }
	void setOP(Operation s) { specialOperation = s; }
	
	String getName() { return name; }
	boolean getTrack() { return track; }
	Operation getOP() { return specialOperation; }
	
	void getPiece() {
		System.out.print("🚧");
	}

}

class Bridge extends SpecialPiece {
	Bridge(String n) {
		super(n);
		setTrack(true);
	}
	
	@Override
	void getPiece() {
		System.out.print("🌉");
	}
}

class Tunnel extends SpecialPiece {
	Tunnel(String n) {
		super(n);
		setTrack(true);
	}
	
	@Override
	void getPiece() {
		System.out.print("🚇");
	}
}

class Building extends SpecialPiece {
	
	private ArrayList<Vehicle> house = new ArrayList<Vehicle>();
	
	Building(String n, boolean b) {
		super(n);
		setTrack(b);
	}
	
	ArrayList<Vehicle> getHouse() {
		return house;
	}
	
	void addVehicle(Vehicle v) {
		house.add(v);
	}
	
	@Override
	void getPiece() {
		System.out.print("🏘");
	}
}
