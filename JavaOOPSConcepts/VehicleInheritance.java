package objectOrientedPrograms;

public class VehicleInheritance {


	private String vehicle_name;
	private int currentSpeed;
	private int currentDirection;

	public VehicleInheritance(String vehicle_name)
	{
		this.vehicle_name=vehicle_name;
		this.currentSpeed=0;
		this.currentDirection=0;
	}
	

	public void steer(int direction) {
		this.currentDirection=direction;
		System.out.println("Steer method  is called: Steering at : "+currentDirection+" degree");
	}
	
	public void move(int speed,int direction) {
		currentSpeed=speed;
		currentDirection=direction;
		System.out.println("Move method called: Moving at "+currentSpeed+" in the direction "+currentDirection);
		
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}
	
	public void stop() {
		this.currentSpeed=0;
		System.out.println("The vehicle is stopped as speed is zero or less than zero");
	}

}
