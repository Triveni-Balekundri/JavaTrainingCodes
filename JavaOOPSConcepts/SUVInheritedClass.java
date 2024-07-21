package objectOrientedPrograms;

public class SUVInheritedClass extends CarInheritance {

	public SUVInheritedClass(String vehicle_name, boolean isManual) {
		super(vehicle_name,4,5,6, isManual,"SUV");
	}

	public void accelerate(int rate) {
		
		int newSpeed=getCurrentSpeed()+rate;
		/*
		 * speed 0 the g= 1
		 * if speed is 0-10 the g=1
		 * speed 10-20 the g=2
		 * speed 20-30 the g=3
		 * speed 30-50 the g=4
		 * speed 50-70 the g=5
		 */
		
		if(newSpeed==0)
		{
			stop();
			changeGear(1);
		}
		else if(newSpeed>0 && newSpeed <=10) {
			changeGear(1);
		}
		else if(newSpeed>10 && newSpeed <=20) {
			changeGear(2);
		}
		else if(newSpeed>20 && newSpeed <=30) {
			changeGear(3);
		}
		else if(newSpeed>30 && newSpeed <=50) {
			changeGear(4);
		}
		else if(newSpeed>50 && newSpeed <=70) {
			changeGear(5);
		}
		else
		{
			changeGear(6);
		}
		
		if(newSpeed > 0)
		{
			changeSpeed(newSpeed,getCurrentDirection());
		}
	}

}
