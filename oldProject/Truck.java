public class Truck extends Vehicle {
	private double loadCapacity;
	private double towingCapacity;
	
	//default
	public Truck() {
		super();
		this.loadCapacity = 1.0;
		this.towingCapacity = 1.0;
	}
	
	public Truck(String aManufactName, String aOwnerName, int aNumOfCylinder, double aLoadCap, double aTowingCap) {
		super(aManufactName, aOwnerName, aNumOfCylinder);
		this.setLoadCap(aLoadCap);
		this.setTowingCap(aTowingCap);
	}
	
	//access
	public double getLoadCap() {
		return this.loadCapacity;
	}
	public double getTowingCap() {
		return this.towingCapacity;
	}
	
	//mutators
	public void setLoadCap(double aLoadCap) {
		if(aLoadCap > 0) {
			this.loadCapacity = aLoadCap;
		} else {
			System.out.println("Invalid Input! \nPlease Enter a non negative number");
			setLoadCap(aLoadCap);
		}
	}
	public void setTowingCap(double aTowingCap) {
		if(aTowingCap > 0) {
			this.towingCapacity = aTowingCap;
		} else {
			System.out.println("Invalid Input! \nPlease Enter a non Negavtice Number");
			setTowingCap(aTowingCap);
		}
	}
	
	//overrides and compares two trucks
	public boolean vIsEqual(Vehicle comparedTruck) {
		return super.equals(comparedTruck); //&& comparedTruck.getLoadCap() == this.getLoadCap() && comparedTruck.getTowingCap() == this.getTowingCap();//comparedTruck.getLoadCap() == this.getLoadCap() && comparedTruck.getTowingCap() == this.getTowingCap();	
	}
	
	public String turnToString() {
		return super.turnToString() + " \nLoad Capacity: " + this.loadCapacity + " \nTowing Capacity: " + this.towingCapacity;
	}
}
