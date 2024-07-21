package excelAndCsvOperations;

import java.io.FileOutputStream;

//imported the package which are used to handle XSSF operations
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//This class is responsible for creation and writing of Customer-Balance (i.e Bank related) data in Excel type of file
public class CreateAndWriteDataIntoExcelUsingXSSF {
	//main-method
	public static void main(String[] args) {
		
		//Used try-catch block in order to handle the File or IO based exceptions
		try
		{
			//String type variable which holds the file-path and alos the name of the file to be created
			String filename = "D:\\Triveni Balekundri\\Balance.xlsx";
			
			//creating an instance of XSSFWorkbook class i.e creating a workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			
			//instantiating XSSFSheet object and then invoking createSheet() method and passing the name of the sheet to be created
			XSSFSheet sheet = workbook.createSheet("December");
			
			//creating a new 0th row by using createRow() method
			XSSFRow rowhead = sheet.createRow((short)0);
			
			/*********
			 * Now creating cells for Headings by using the createCell() method and
			 * setting the values to the cell by using the setCellValue() method
			 *********/
			rowhead.createCell(0).setCellValue("S.No.");
			rowhead.createCell(1).setCellValue("Customer Name");
			rowhead.createCell(2).setCellValue("Account Number");
			rowhead.createCell(3).setCellValue("E-mail");
			rowhead.createCell(4).setCellValue("Balance");
			
			//Now again we are creating the 1st row for inserting data according to heading by using createRow()
			XSSFRow rowData1 = sheet.createRow((short)1);
			
			/*********
			 * Now creating cells by using the createCell() method and
			 * setting the values to the cell by using the setCellValue() method.
			 * Here we are inputing the first customer details according the above headings
			 *********/
			rowData1.createCell(0).setCellValue("1");
			rowData1.createCell(1).setCellValue("Triveni Balekundri");
			rowData1.createCell(2).setCellValue("9999999");
			rowData1.createCell(3).setCellValue("triveni.b@gmail.com");
			rowData1.createCell(4).setCellValue("900000.00");
			
			
			//Now we are writing the data into the file by using the FileOutputStream class
			FileOutputStream fileoutputObject = new FileOutputStream(filename);
			
			//
			workbook.write(fileoutputObject);
			
			//closing the stream by using the close()
			fileoutputObject.close();
			
			//closing the workbook by using the close()
			workbook.close();
			
			//printing a message to indicate that the file has been generated at the given file location
			System.out.println("Excel file has been generated");
			
		}
		catch(Exception e)
		{
			//printing the message for exception block
			System.out.println("Catch Block executed,please check for exception/erros");
			
			e.printStackTrace();
		}

	}

}
