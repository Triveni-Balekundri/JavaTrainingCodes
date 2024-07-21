package jdbcAndDatabaseOperations;

import java.sql.Connection;

/**************************************************************************************************
 * This is a Main class which is responsible for calling/invoking and passing
 * some parameters to the methods which are in another class and which perform
 * some function like:
 * 
 *  1.Connecting to the database
 *   2.creation of table
 * 3.insertion of data
 *  4.updation of data 
 *  5.reading the data
 *   6.deletion of a row/data
 *    7.Droping/deletion of the table
 **************************************************************************************************/
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// creation of object of the class DatabaseConnection
			DatabaseConnectionAndOperations classObject = new DatabaseConnectionAndOperations();

			// Passing some input-parameters to the connectDatabase() in order to connect to
			// the database
			Connection connection = classObject.connectDatabase("mydatabase", "postgres", "triveni");

			// Passing the required type of parameter values to the creationOfTable() and
			// invoking it
			// classObject.creationOfTable(connection,"employee");

			// Passing the required type of parameter values to the insert_row() and
			// invoking it
//			classObject.insert_row(connection,"employee","abhishek","india");
//			classObject.insert_row(connection,"employee","triveni","india");
//			classObject.insert_row(connection,"employee","Sam","America");

			// Passing the required type of parameter values to the update_data() and
			// invoking it
//			classObject.update_data(connection,"employee","abhishek","Ishaan");

			// Passing the required type of parameter values to the read_data() and invoking
			// it
			classObject.read_data(connection, "employee");

			// Passing the required type of parameter values to the delete_by_row() and
			// invoking it
//			classObject.delete_by_row(connection, "employee", "Triveni");

			// Passing the required type of parameter values to the delete_table() and
			// invoking it
//			classObject.delete_table(connection,"employee");

/*************************************************************************************************************************/

			// creation of object of the class ProductsDatabase
			ProductsDatabase databaseObject = new ProductsDatabase();

			// Passing the required type of parameter values to the creationOfTable() and
			// invoking it
			 //databaseObject.creationOfTable(connection,"products");

			 //databaseObject.insert_row(connection,"products",1,"Keyboard",1500);
			//databaseObject.insert_row(connection,"products",2,"Mouse",700);

			// databaseObject.insert_row_using_batch(connection,"products",3,"Monitor",
			// 20000);
			
			

		} catch (Exception e) {

			System.out.println("Catch block executed");
			e.printStackTrace();
			e.getMessage();

		}

	}

}
