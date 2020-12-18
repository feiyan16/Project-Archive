class ConnectionEnd {
	
	private boolean male;
	private boolean female;
	
	ConnectionEnd() {
		male = female = false;
	}
	boolean getM() { return male; }
	boolean getF() { return female; }
	void setM(boolean b) { male = b; }
	void setF(boolean b) { female = b; }
}

class TrackPiece  {
	
	private int length;
	private ConnectionEnd connector;
	private String s1;
	private String s2;
	private TrackPiece connection;
	
	TrackPiece() {}
	TrackPiece(int l) { 
		length = l;
		setS1("Track");
		setS2("Track");
		connector = new ConnectionEnd();
	}
	
	int getLength() { return length; }
	ConnectionEnd getConnector() { return connector; }
	String getS1() { return s1; }
	String getS2() { return s2; }
	TrackPiece getConnection() { return connection; }
	
	void setLength(int l) { length = l; }
	void setMEnd(boolean b) { connector.setM(b); }
	void setFEnd(boolean b) { connector.setF(b); }
	void setS1(String s) { s1 = s; }
	void setS2(String s) { s2 = s; }
	void setConnection(TrackPiece connection) { this.connection = connection; }
	
	void connect(TrackPiece t) {
		if(connector.getM() == false) {
			connector.setM(true);
			t.connector.setF(true);
		} else {
			connector.setF(true);
			t.connector.setM(true);
		}
		setConnection(t);
	}
	
	void getPiece() {
		for(int i = 0; i < length; i++) {
			System.out.print("🛤");
		}
	}

}

class CurvedPiece extends TrackPiece {
	
	CurvedPiece(int length) {
		super(length);
	}
	
	@Override
	void getPiece() {
		System.out.print("∟");
	}
	
}

class StraightPiece extends TrackPiece {
	
	StraightPiece(int length) {
		super(length);
		setS2("Road");
	}
}

class Switch extends TrackPiece {
	
	Switch(int length) { super(length); }
	
	@Override
	void getPiece() {
		System.out.print("∠");
	}
}

class Adapter extends TrackPiece {
	
	Adapter() {
		super(2);
	}
	
	@Override
	void connect(TrackPiece t) {
		if(getConnector().getM() == false) {
			getConnector().setM(true);
			t.getConnector().setF(true);
		} else {
			getConnector().setF(true);
			t.getConnector().setM(true);
		}
		setConnection(t);
	}
	
	@Override
	void getPiece() {
		System.out.print("⟥");
	}
}
