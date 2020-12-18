import java.awt.Color;

class Vehicle {
	
	private String name;
	private Color color;

	Vehicle() {}
	Vehicle(String n, Color c) {
		name = n;
		color = c;
	}
	
	String getName() { return name; }
	Color getColor() { return color; }
	
	void setName(String n) { name = n; }
	void setColor(Color c) { color = c; }
	
	void getVehicle() {
		System.out.println("🚅");
	}
	
}

class Car extends Vehicle {
	
	private Object accessory;
	
	Car(String n, Color c) { super(n, c); }
	
	Object getAccessory() { return accessory; }
	void setAccessory(Object a) { accessory = a; }
	void getVehicle() {
		System.out.println("🚗");
	}
}

class Engine extends Vehicle {
	
	Engine(String n, Color c) { super(n, c); }
	void getVehicle() {
		System.out.println("🚂");
	}
}
