package excelAndCsvOperations;

//imported BufferWriter class
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

//This class is responsible for writing employee data into a CSV file in a .txt form with the help a user defined method
public class WritingDataInCSVUsingUserDefinedMethod {

	public static void main(String[] args) {
		
		// This is String type array which stores employee IDs
		String[] employeeIDs = { "101", "102", "103" };

		// This is String type array which stores employee Name
		String[] employeeName = { "Triveni", "Omkar", "Shiv" };

		// This is String type array which stores employee Age
		String[] employeeAge = { "21", "30", "28" };

		// This is String type variable which stores the file-path
		String filepath = "D:\\info.txt";

		// Here we are calling and passing the parameters to the saveRecords() method
		saveRecords(employeeIDs, employeeName, employeeAge, filepath);

	}

	/*
	 * This methods is responsible to save all the data/records to the csv files
	 */
	public static void saveRecords(String[] ID, String[] name, String[] age, String filepath) {

		// Have used exception handling to catch any errors that occur during File Operations
		try {

			// Here we are appending the data into the file
			FileWriter fileObject = new FileWriter(filepath, true);

			// The data is more efficiently written in the file with the help of buffer
			BufferedWriter bufferObject = new BufferedWriter(fileObject);

			// PrintWriter object to write formatted representations of objects to a text-output stream
			PrintWriter printObject = new PrintWriter(bufferObject);

			// Looping is used to iterate through array and write each record to the file
			for (int intialized_number = 0; intialized_number < ID.length; intialized_number++) {
				printObject.println(ID[intialized_number] + "," + name[intialized_number] + "," + age[intialized_number] + ",");
			}

			// Here we have flushed the stream and forced any buffered output bytes to be written out
			printObject.flush();

			// closes the stream and releases any system resources associated with it
			printObject.close();

			// Message to indicate that the file is successfully created
			System.out.println("File created");

		} catch (Exception e) {

			System.out.println("File not created");

			// get the trace of exception
			e.getStackTrace();

		}
	}
}
