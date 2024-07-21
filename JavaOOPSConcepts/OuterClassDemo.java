package objectOrientedPrograms;

//This class shows how inner classes/concept works
public class OuterClassDemo {

	//declaring a integer type variable in outer-class and assigning its value as 6
	int number =6;
	
	//This method a prints message indicating that its the outer class method
	public void outerClassMethod()
	{
		System.out.println("This is the outer class method.");
		
		//creating a local-inner class which is to create class into a outer-class method
		class LocalInnerClass{
			
			//declaring a String type variable in this local inner-class and assigning its value.
			String localInnerClassVariable="This is a local-inner class variable which is in outer-class method";
			
			//creating a local inner-class method to print the above variable
			public void printLocalInnerClassVariable()
			{
				System.out.println(localInnerClassVariable);
			}
			
		}
		
		//Inside the 
		LocalInnerClass localClassObject = new LocalInnerClass();
		localClassObject.printLocalInnerClassVariable();
		
	}
	

//	//Here we are creating inner class.Here inner-class is non-static class
	public class InnerClassDemo{
		//declaring a integer type variable in inner-class and assigning its value as 8
		int innerNumber =8;
		
		//This method a prints message indicating that its the inner class method
		public void innerClassMethod()
		{
			System.out.println("This is the (non-static) inner class method.");
			
			
		}
		
		
	}
	
	//Here we are creating inner class.Here inner-class is static class
	public static class InnerClassDemo2{
		//declaring a integer type variable in inner-class and assigning its value as 8
		int innerNumber =10;
		
		//This method a prints message indicating that its the inner class method
		public void innerClassMethod2()
		{
			System.out.println("This is the (static) inner class second method.");
		}
	}
	
}
