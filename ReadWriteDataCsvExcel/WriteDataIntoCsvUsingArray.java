package excelAndCsvOperations;

import java.io.FileWriter;

import com.opencsv.CSVWriter;

/*
 * Here in this class we are writing the Employee data into CSV file:
 * using an Array and also with the help of a method named writeNext()
 */
public class WriteDataIntoCsvUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Have used exception handling to catch any errors that occur during File Operations
		try {

			// instantiating the CSVWriter class
			CSVWriter writerObject = new CSVWriter(new FileWriter("D:\\EmplyeeData.csv"));

			// This is String type array which stores different Info headings i.e:
			// Name|Country|ID|Department
			String headings[] = { "Name", "Country", "ID", "Department" };

			// This is String type array which stores basic details about first individual
			String firstIndividual[] = { "Ram", "USA", "001", "IT" };

			// This is String type array which stores basic details about second individual
			String secondIndividual[] = { "Ramesh", "USA", "002", "Operations" };

			// This is String type array which stores basic details about third individual
			String thirdIndividual[] = { "Raju", "India", "003", "Software" };

			// This is String type array which stores basic details about fourth individual
			String fourthIndividual[] = { "Ravi", "USA", "004", "IT" };

			/*
			 * writeNext(): this writes a single array of Strings as a new row in the CSV
			 * file. Here,each string in the array is treated as a cell in CSV row and is
			 * been written.
			 */
			writerObject.writeNext(headings);
			writerObject.writeNext(firstIndividual);
			writerObject.writeNext(secondIndividual);
			writerObject.writeNext(thirdIndividual);
			writerObject.writeNext(fourthIndividual);

			// flush data to create CSV file data
			writerObject.flush();

			System.out.println("Data entered successfully");

		} catch (Exception e) {

			System.out.println("Data not entered, Error");
			e.getMessage();
		}

	}

}
