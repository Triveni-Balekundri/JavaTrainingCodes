package objectOrientedPrograms;

public class InheritanceMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		SUVInheritedClass fortuner = new SUVInheritedClass("Fortuner", false);
		fortuner.move(40, 0);

		fortuner.accelerate(20);
//		fortuner.accelerate(-60);
	
		System.out.println("Current Gear: "+fortuner.getCurrentGear());
		System.out.println("Current speed: "+fortuner.getCurrentSpeed());
		
		

	}

}
