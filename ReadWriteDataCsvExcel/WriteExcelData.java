package excelAndCsvOperations;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.*;
/*
 * This class is responsible for showcasing writing of data into excel using apache poi classes, 
 * fileoutputstream classes , List etc
 */
public class WriteExcelData {

	public static void main(String[] args) {
		
		
		try {
		// Here we are creating a XSSFWorkbook object
					XSSFWorkbook workbook = new XSSFWorkbook();

					// Here we are creating a sheet with the help of createSheet() into the workbook
					// which we have created. We named the sheet as Employee Info
					XSSFSheet sheet = workbook.createSheet("Employee Info");

					Scanner scannerobject = new Scanner(System.in);

//						This is an object type 2-D array which can hold all kinds of data.
//						Object employeedata[][]= {
//								
//											{"EmployeeID","Name","Job"},
//											{101,"David","Engineer"},
//											{102,"Smith","Manager"},
//											{103,"Scott","Analyst"}
//									};
//				
					//We are creating a List (basically a lists of lists or 2D data structure) which stores elements in arrayList of type object
					List<ArrayList<Object>> employeedata = new ArrayList<>();

					// Taking input until the user stops entering data
					do {
						
						//Here we are creating a List which stores Object type elements i.e will store all types employee data
						ArrayList<Object> data = new ArrayList<>();


						//Here we ask the user to enter employeeID and give the option to break from the menu
						System.out.print("Enter EmployeeID (Enter 0 to break from the code): ");
						int id = scannerobject.nextInt();

						
						//Here we break or come out of the do-while loop if the user enters the number zero
						if (id == 0) {
							break; // Break the loop if user enters 0
						}

						//Here we take the next line as input as not to close the program
						scannerobject.nextLine(); // Consume newline
						
						//Here we take the employee Name and store it in a String variable
						System.out.print("Enter Name: ");
						String name = scannerobject.nextLine();

						//Here we take the employee Job and store it in a String variable
						System.out.print("Enter Job: ");
						String job = scannerobject.nextLine();

						
						//Here we Add the input data into the list created above
						data.add(id);
						data.add(name);
						data.add(job);

						
						//Here we add all the elements of the List data into the employeeData list
						employeedata.add(data);

					} while (true);

					
					//size() Returns the number of elements in this list and gets stored in the row variable
					int rows = employeedata.size();
					
					//Here we determine the number of columns in the first row of the employeedata
					int columns = (employeedata.get(0)).size();

					//We print the number of rows and columns based on the data which is entered.
					System.out.println("Number of rows are: " + rows); // 4
					System.out.println("Number of columns are: " + columns); // 3

					//Loop to create rows and cells and then set the value according to the Type of element
					for (int row_number = 0; row_number < rows; row_number++) {

						//We create a row with the help of createRow() which is a part of XSSFSheet class 
						XSSFRow row = sheet.createRow(row_number);

						for (int column_number = 0; column_number < columns; column_number++) {
							
							//We create a cell within the current row with the help of createCell() which is a part of XSSFRow class 
							XSSFCell cell = row.createCell(column_number);
							
							//Here we get the value from the employeeData object
							/*
							 * It accesses the values at the specified row and column in employeedata with the help of .get() method
							 * and stores it in a object type variable named 'value'
							 */
							Object value = employeedata.get(row_number).get(column_number);

							
							//Here we enter the data in the cell based on their data-type .This is done with the help of .setCellValue()method 
							if (value instanceof String) {
								cell.setCellValue((String) value);
							}
							if (value instanceof Integer) {
								cell.setCellValue((Integer) value);
							}
							if (value instanceof Boolean) {
								cell.setCellValue((Boolean) value);
							}
						}
					}

					//We create a filepath to store the excel file
					String filePath = "D:\\Triveni Balekundri\\employee.xlsx";
					
					//Here we pass the filepath into the FileOutputStream()
					FileOutputStream outputstreamobject = new FileOutputStream(filePath);
					
					//Here we add the data from the workbook object to the output stream(destination).
					workbook.write(outputstreamobject);

					//WE close the outputstream 
					outputstreamobject.close();
					System.out.println("Employee.xls file written successfully");


}
		catch(Exception e)
		{
			System.out.println("WriteExcelData Catch block Error");
			e.printStackTrace();
		}

}
}
