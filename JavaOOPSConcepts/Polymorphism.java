package objectOrientedPrograms;

class Bird{
	public void fly()
	{
		System.out.println("Yes, it is a bird and can fly");
	
	}
}

class Robin extends Bird{
	public void fly()
	{
		System.out.println("Yes, it is a Robin-bird and can fly");
	
	}
}

class Pelican extends Bird{
	public void fly()
	{
		System.out.println("Yes, it is a Pelican-bird and can fly");
	
	}
}
/*******************************************************************************/
//Method overriding or Run-Time Polymorphism : This is handled by jvm
class Calculator 
{
	public int add(int number1,int number2)
	{
		return number1+number2;
	}
}

class AdvancedCalculation extends Calculator
{
	public int add(int number1,int number2)
	{
		return number1+number2+1;
	}
}


class Cal
{
	//values input
	public void name(String input)
	{
		//operations
		String nameS = input;
		System.out.println(nameS);
	}
}
/************************************************************************************************/
public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		Bird birdObject = new Bird();
//		birdObject.fly();

//		Robin object2 = new Robin();
//		object2.fly();
		
		Pelican object3 = new Pelican();
		object3.fly();
		
		 AdvancedCalculation object4 = new  AdvancedCalculation();
		 int result=object4.add(10, 10);
		 
		 System.out.println("REsult is: "+result);
		
		 Cal obj = new Cal();
		 
		 //passing value
		 obj.name("Triveni");
		
		 
		 /*
		  * join(c,t1,t2)
		  * {
		  * 		operations -> join
		  * 		query=" ";
		  * }
		  */
	}

}
