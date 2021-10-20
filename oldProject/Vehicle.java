public class Vehicle {

	private String manufactName;
	private String ownerName;
	private int numOfCylinder;
	
	//default
	public Vehicle() {
		this.manufactName = "Ford";
		this.ownerName = "\u0000";
		this.numOfCylinder = 4;
	}
	
	public Vehicle(String aManufactName, String aOwnerName, int aNumOfCylinder) {
		this.setMName(aManufactName);
		this.setOName(aOwnerName);
		this.setNumOfCyl(aNumOfCylinder);
	}
	
	//access
	public String getMName() {
		return this.manufactName;
	}
	public String getOName() {
		return this.ownerName;
	}
	public int getNumOfCyl() {
		return this.numOfCylinder;
	}
	
	//mutators
	public void setMName(String aManufactName) {
		if(aManufactName.equalsIgnoreCase("lexus") || aManufactName.equalsIgnoreCase("volvo") || aManufactName.equalsIgnoreCase("subaru") || aManufactName.equalsIgnoreCase("lincoln") || aManufactName.equalsIgnoreCase("toyota") || aManufactName.equalsIgnoreCase("audi") || aManufactName.equalsIgnoreCase("honda") || aManufactName.equalsIgnoreCase("mercedes") || aManufactName.equalsIgnoreCase("bmw") || aManufactName.equalsIgnoreCase("volkswagon") || aManufactName.equalsIgnoreCase("acura") || aManufactName.equalsIgnoreCase("mini") || aManufactName.equalsIgnoreCase("nissan") || aManufactName.equalsIgnoreCase("dodge") || aManufactName.equalsIgnoreCase("ford") || aManufactName.equalsIgnoreCase("hyundai") || aManufactName.equalsIgnoreCase("mazda") || aManufactName.equalsIgnoreCase("jeep") || aManufactName.equalsIgnoreCase("buick") || aManufactName.equalsIgnoreCase("kia") || aManufactName.equalsIgnoreCase("mitsubishi") || aManufactName.equalsIgnoreCase("chevorlet") || aManufactName.equalsIgnoreCase("infinity") || aManufactName.equalsIgnoreCase("fiat") || aManufactName.equalsIgnoreCase("chrysler")) {
			this.manufactName = aManufactName;
		} else {
			System.out.println("This manufacturer is unknown");
		}
	}
	public void setOName(String aOwnerName) {
		//if(aOwnerName.getClass().equals(ownerName.getClass())) {
			this.ownerName = aOwnerName;
	//}
	}
	public void setNumOfCyl(int aNumOfCylinder) {
		if(aNumOfCylinder > 0 && aNumOfCylinder <= 16) {
			this.numOfCylinder = aNumOfCylinder;
		} else {
			System.out.println("Invalid Input! \nPlease Enter a whole number greater than 0");
			setNumOfCyl(aNumOfCylinder);
		}
	}
	
	//returns true only if same vehicle
	public boolean vIsEqual(Vehicle comparedV) {
		return comparedV != null && this.manufactName.equals(getMName()) && comparedV.getNumOfCyl() == this.getNumOfCyl();	
	}
	
	//turns everything into a string
	public String turnToString() {
		return "Manufacturer Name: " + this.manufactName + "\nOwner Name: " + this.ownerName + "\nNumber of Cylinders: " + this.numOfCylinder;
	}
}
