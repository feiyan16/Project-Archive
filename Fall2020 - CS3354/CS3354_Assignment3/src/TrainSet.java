import java.util.ArrayList;

class TrainSet {
	
	String name;
	TrackPiece start;
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	ArrayList<SpecialPiece> specialpieces = new ArrayList<SpecialPiece>();

	TrainSet(String n, TrackPiece tp) { 
		name = n;
		start = tp;
	}
	
	void addv(Vehicle v) {
		vehicles.add(v);
	}
	
	void addsp(SpecialPiece sp) {
		specialpieces.add(sp);
	}
	
	void printTrack() {
		
		TrackPiece n = start;
		while(n != null) {
			n.getPiece();
			n = n.getConnection();
		}
	}
	
	void printVehicle() {
		
		for(int i = 0; i < vehicles.size(); i++) {
			vehicles.get(i).getVehicle();
		}
	}

}
