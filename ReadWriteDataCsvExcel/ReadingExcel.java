package excelAndCsvOperations;

// This package is Used for reading files.
import java.io.FileInputStream;

// this package has the Classes related to working with Excel files using Apache POI library.
import org.apache.poi.xssf.usermodel.*; 

/*******************
 * This class is responsible for showcasing how all the data from a ExcelSheet
 * is fetched or Read and then printed.
 * Here we are reading data from a WorkSheet "CountryInfo"
 *****************/

public class ReadingExcel {

	public static void main(String[] args) {
		 
		
		
		/***********************
		 * Here We need to get the location of the file
		 * Here ".//" is representing our current project location >> datafiles >> CountryInfo
		 * This location is stored in a String type of varibale called 'excelFilePath' 
		 **********************/
		String excelFilePath=".\\datafiles\\CountryInfo.xlsx";

		
			// We have to travel through : Workbook-->Sheet-->Rows-->Cells
		
	
		// Here try and catch block is used in order to catch some exceptions if occured.
		 
		try
		{
			//now we need to open this above file by using input stream with the help of fileinputstream class
			FileInputStream fileinputstreamobject = new FileInputStream(excelFilePath);
			
			/************************************
			 * Now we have to fetch the workbook from the input stream with the help of
			 *  XSSFWorkBook class by passing the file inputstream object to XSSFWorkBook constructor
			 ***********************************/
			XSSFWorkbook workbook= new XSSFWorkbook(fileinputstreamobject);
			
			
			
		/***********
		 * Now from that workbook we have to get the sheet which we want, with the
		 * help of method getSheet("Name of the sheet"); 
		 * OR :
		 * instead we can use .getSheetAt(index of the sheet);
		 */
		 XSSFSheet sheet = workbook.getSheet("Sheet1"); //Or: XSSFSheet sheet = workbook.getSheetAt(0);
			
			
			
			//USING FOR LOOP TO ITERATE THROUGH ROWS AND COLUMNS IN THE SHEET
			
			
			
			/**
			 * now firstly we have to find how many number of rows and columns are there
			 * in the sheet with the help of a method .getLastRowNum(); this method returns last row index number containing the data in the sheet which 
			 * will be stored in a variable named "row"
			 */
				int row_variable = sheet.getLastRowNum();
			
	/****************************************************************************************************************************************/
			
			/*
			 *  By .getRow() we will get the row which we want particularly or the index of it and the
			 *  .getLastCellNum() will get number of cells in that row or the number of columns which will help us to iterate through the 
			 *  rows and columns. This method helps in iterating through cells in a row effectively.
			 *  This all of the data which is fetched is going to be saved into a variable named 'column'
			 */
			int column_variable=sheet.getRow(1).getLastCellNum();
			
	/****************************************************************************************************************************************/		
			
			
			
			//Here comes the nested 'for' loop now, in order to iterate through rows and columns of the sheet
			
			/*
			 * Here outerloop is representing the rows in the sheet. This loop wille execute multiple times to fetch the data from the cells
			 */
			
			for(int row_number=0;  row_number<=row_variable;  row_number++)
			{	
				//Here sheet.getRow(row) will return the row object and then we store that data into a variable
				XSSFRow row =sheet.getRow( row_number);
				
				
				/***********************************************************************************************/
				
				//this inner loop will read all the types of cells
				for(int column_number =0;  column_number<column_variable; column_number++)
				{
					
					//This method returns the Cell object which will be stored in cell object variable
					XSSFCell cell = row.getCell(column_number);
					
					
					//Switch is used to get the data type of the cell and print the values according to the data type 
					//Like: Sheet contains data of type: String,Numeric,Boolean
					//We will get the cell-type with the help of .getCellType() and pass it in the switch condition
					switch(cell.getCellType())
					{
					
					
					case STRING: System.out.print(cell.getStringCellValue());
									break;
					case NUMERIC: System.out.print(cell.getNumericCellValue() );
									break;
					case BOOLEAN:System.out.print(cell.getBooleanCellValue() );
									break;
					
					}
					
					System.out.print("    ");
					
				}
				
				System.out.println();
			}
			
			
			
			///////////////Iterator/////////////////
			/*
			 * 
			 */	
			
		}
		catch(Exception e)
		{
			System.out.println("ReadExcel Catch block");
			e.printStackTrace();
			
		}
		
		
		
	}	
	

}
