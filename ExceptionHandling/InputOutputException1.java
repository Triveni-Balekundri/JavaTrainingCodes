package exceptionHandling;

import java.io.*;

/*
 * in this class we have used nested try-catch block and 
 * showed how an exception is throwed with the help of 
 * 'throws' keyword and then handled with the help of 
 * try-catch block. Here in this class we have showcased
 * FileNotFoundException and arithmetic exception.
 */
public class InputOutputException1 {

	/*
	 * this method showcases divide by zero exception which will be throwed with the
	 * help of "throw" keyword and then handled in the main method.
	 */
	public static void divideByZero() {

		// throwing an Arithmetic exception with a message for the user
		throw new ArithmeticException("Trying to divide by zero which is also an exception");

	}

	/*
	 * In this method we are making a new file into the fileInput stream and we are
	 * manually declaring or throwing the exception in it.
	 */
	public static void findFile() throws IOException {

		// Here we are writing the code for creating a new file that may generate
		// IOException
		File newFile = new File("test.txt");
		FileInputStream streamObject = new FileInputStream(newFile);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Using exception handling blocks in-order to catch the exception throwed above
		try {
				findFile();
		} 
		catch (Exception e) {

			// Here it prints the exception and indicates that it has an exception i.e
			// FileNotFoundException
			System.out.println(e);

			// Here we have created another try-catch(nested) block to catch the arithmetic
			// exception
			try {
				divideByZero();
			} 
			catch (Exception exp) {
				System.out.println(exp);
				
				try {
						int divideByZero = 5 / 0;
						System.out.println("Rest of code in try block");

				} 
				catch (ArithmeticException excep) {
						System.out.println("ArithmeticException => " + excep.getMessage());
				}
			}
		}
	}

}
