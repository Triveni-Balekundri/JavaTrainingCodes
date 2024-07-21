package excelAndCsvOperations;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

/*
 * Here in this class we are writing the Student data into CSV file:
 * using an ArrayList and also with the help of a method named writeAll()
 */
public class WriteDataIntoCSVUsingArrayList {

	// Main method
	public static void main(String[] args) {

		// Have used exception handling to catch any errors that occur during File
		// Operations
		try {

			// instantiating the CSVWriter class
			CSVWriter writerObject = new CSVWriter(new FileWriter("D:\\StudentData.csv"));

			// This is String type array which stores different Info headings i.e:
			// Name|Country|ID|University
			String headings[] = { "Name", "Country", "ID", "University" };

			// This is String type array which stores basic details about first individual
			String firstIndividual[] = { "Ram", "USA", "01", "Harvard" };

			// This is String type array which stores basic details about second individual
			String secondIndividual[] = { "Ramesh", "USA", "04", "Christopher" };

			// This is String type array which stores basic details about third individual
			String thirdIndividual[] = { "Raju", "India", "09", "Parul" };

			// This is String type array which stores basic details about fourth individual
			String fourthIndividual[] = { "Ravi", "USA", "01", "Richards" };

			// arrayList is created to store all the String arrays and the data in it
			List list = new ArrayList();

			// Adding all the arrays to the List
			list.add(headings);
			list.add(firstIndividual);
			list.add(secondIndividual);
			list.add(thirdIndividual);
			list.add(fourthIndividual);

			// Now Writing the data into the CSV File using writeAll()
			writerObject.writeAll(list);

			// flush data to create CSV file data
			writerObject.flush();

			System.out.println("Data entered successfully, please check");

		} catch (Exception e) {
			System.out.println("Data not entered, Error");
			e.getMessage();
		}

	}

}
