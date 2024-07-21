package objectOrientedPrograms;

public class SimpleInheritance {

	

		int returnSum(int number1,int number2)
		{
			return number1+number2;
			
		}
		
	}
	class Child1 extends SimpleInheritance{
		void displaySum()
		{
			
			int result = returnSum(10,20);
			System.out.println("Sum of 10 and 20 is: "+result+" This is printed with the help of using the concept of multiple inheritance");
		}
	}








