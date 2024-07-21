package excelAndCsvOperations;

import java.io.*;
import java.util.Scanner;

//Here in this class we are 
public class WriteDataInCSVUsingScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Have used exception handling to catch any errors that occur during File Operations
		try {
			// creating scanner object passing filepath into the File class constructor
			Scanner scannerObject = new Scanner(new File("D:\\CSV file.csv"));

			// Here delimiting pattern is been set i.e here ","
			scannerObject.useDelimiter(" , ");

			// Returns true if this scanner has another token in its input and then print
			// the token
			while (scannerObject.hasNext()) {
				System.out.print(scannerObject.next());
			}

			// Closes this scanner
			scannerObject.close();
			
		} catch (Exception e) {
			System.out.print("Catch block");
			e.getCause();
		}

	}

}
