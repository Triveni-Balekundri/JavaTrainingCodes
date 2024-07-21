package excelAndCsvOperations;

//File class imported to handle Files
import java.io.File;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


//Here in this class we are going to write our CSV file using PrintWriter class
public class WriteDataIntoCsvUsingPrintWriterClass {

	public static void main(String[] args) {
		
		// Have used exception handling to catch any errors that occur during File Operations
		try
		{
			//PrintWriter object is created to write a file, by passing filepath to the File class constructor
			PrintWriter writerObject = new PrintWriter(new File("D:\\Triveni Balekundri\\books_table.csv"));
			
			//Creating a StringBuilder Object
			StringBuilder stringobject = new StringBuilder();
			
			
			//appending data into the file
			stringobject.append("SI");
			stringobject.append(",");
			stringobject.append("Book Name");
			stringobject.append(",");
			stringobject.append("Category");
			
			stringobject.append("\n");
			
			stringobject.append("1");
			stringobject.append(",");
			stringobject.append("Book Name 1");
			stringobject.append(",");
			stringobject.append("Category 1");
			
			stringobject.append("\n");
			
			stringobject.append("2");
			stringobject.append(",");
			stringobject.append("Book Name 2");
			stringobject.append(",");
			stringobject.append("Category 2");
			
			stringobject.append("\n");
			
			stringobject.append("3");
			stringobject.append(",");
			stringobject.append("Book Name 3");
			stringobject.append(",");
			stringobject.append("Category 3");
			
			stringobject.append("\n");
			
			//write() writes the contents of the 'StringBuilder' to the file
			writerObject.write(stringobject.toString());
			writerObject.close();
			
			
			JOptionPane.showMessageDialog(null,"Records saved");
			
			
		}
		catch(Exception e)
		{
			System.out.print("Catch block message");
			e.getCause();
		}
	}

}
