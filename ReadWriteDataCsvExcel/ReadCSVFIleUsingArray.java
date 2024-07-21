package excelAndCsvOperations;

//BufferedReader and FileReader classes are used in reading files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//this class is demonstrating how to read a CrimeSurvey CSV File Using String type Array
public class ReadCSVFIleUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// line is a String type variable which will hold each line, read from the csv
		// file
		String line = "";

		// splitBy is String type variable which acts as a delimiter used to split each
		// line
		String splitBy = ",";

		// Have used exception handling to catch any errors that occur during File
		// Operations
		try {

			/*
			 * Here we have used BufferReader as it reads and provides efficient buffering.
			 * FileReader is specified with file path and is used to read the file
			 */
			BufferedReader bufferobject = new BufferedReader(new FileReader("D:\\SacramentocrimeJanuary2006.csv"));

			// while loop reads each line from the file with the help of readLine() until the end of the file
			while ((line = bufferobject.readLine()) != null) {

				// here split() method is used
				String[] values = line.split(splitBy);

				//This print the firsttype values in the first column from the CSV file
				//System.out.println(values[0]);

				//Here we are printing a particular column (data) related to the Date and Crime description from the CSV file
				System.out.println("Date: " + values[0] + ", Crime Description: " + values[5]);

			}
		} catch (Exception e) {

			System.out.println("Catch block ");
			// To get the trace
			e.printStackTrace();

		}

	}

}
