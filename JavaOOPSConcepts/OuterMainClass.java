package objectOrientedPrograms;



/*
 * This class shows how Outer-class and inner class works together 
 * it also shows how to create inner class object with the help of outer class object
 * as an instance of a non-static inner class can only be created within an instance 
 * method of the outer class or within the constructor of the outer class.
 */
public class OuterMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating OuterClass class object 
		OuterClassDemo outer = new OuterClassDemo();
		
		//invoking or calling the outer-class method
		outer.outerClassMethod();
		
		/*
		 *--------Here we are calling the method from non-static class
		 *
		 *
		 * We are using the instance of the outer class in order to call the
		 * (inner-class) constructor in order to make a new inner class instance which 
		 * is of type InnerClassDemo and with that instance variable we will call the method
		 * from the inner-class
		 */
		
		OuterClassDemo.InnerClassDemo inner = outer.new InnerClassDemo();
		inner.innerClassMethod();
		
		
		//--Here we are calling the method from a static class named InnerClassDemo2
		OuterClassDemo.InnerClassDemo2 innerObject = new OuterClassDemo.InnerClassDemo2();
		innerObject.innerClassMethod2();
		
		
	}

}
