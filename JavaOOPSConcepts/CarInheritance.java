package objectOrientedPrograms;

public class CarInheritance extends VehicleInheritance {

	private int wheels;
	private String type;
	private int door;
	private int gear;
	private boolean isManual;
	private int currentGear;
	
	public CarInheritance(String vehicle_name,int wheels,int door,int gear,boolean isManual,String type) {
		super(vehicle_name);
		
		this.type=type;
		this.gear=gear;
		this.door=door;
		this.isManual=isManual;
		this.wheels=wheels;
		currentGear=1;
		
	}
	
	public void changeGear(int newGear) {
		this.currentGear=newGear;
		System.out.println("ChangeGear method called: Changed the gear to : "+this.currentGear+ " gear");
	}
	
	public void changeSpeed(int newSpeed,int newDirection) {
		//inherited the move() method
		move(newSpeed,newDirection);
		
		System.out.println("change speed method called: Speed ->"+newSpeed+" direction is: "+newDirection);
	}

	public int getCurrentGear() {
		return currentGear;
	}

	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}
	

}
