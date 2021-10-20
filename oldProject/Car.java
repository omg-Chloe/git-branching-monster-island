public class Car extends Vehicle {
	private double gasM;
	private int numOfP;
	
	//default
	public Car() {
		super();
		this.gasM = 1.0;
		this.numOfP = 1;
	}
	
	//parameters
	public Car(String aManufactName, String aOwnerName, int aNumOfCylinder, double aGasM, int aNumOfP) {
		super();
		this.setGasM(aGasM);
		this.setNumOfP(aNumOfP);
	}
	
	//access
	public double getGasM() {
		return this.gasM;
	}
	public int getNumOfP() {
		return this.numOfP;
	}
	
	//mutators
	public void setGasM(double aGasM) {
		if(aGasM > 0) {
			this.gasM = aGasM;
		} else {
			System.out.println("Invalid Input! \nPlease Enter a decimal greater than 0");
		}
	}
	public void setNumOfP(int aNumOfP) {
		if(aNumOfP > 0 && aNumOfP <= 8) {
			this.numOfP = aNumOfP;
		} else if (aNumOfP > 8) {
			System.out.println("Does everyone have a seat? The law states everyone must have a seatbelt!");
		} else {
			System.out.println("Invalid Input! \nPlease Enter a whole number greater than 0");
		}
	}
	
	public boolean vIsEqual(Vehicle comparedCar) {
		return super.equals(comparedCar); //&& comparedCar.getGasM() == this.getGasM() && comparedCar.getNumOfP() == this.getNumOfP();
	}
	
	public String turnToString() {
		return super.turnToString() + " \nLoad Capacity: " + this.gasM + " \nTowing Capacity: " + this.numOfP;
	}
}
