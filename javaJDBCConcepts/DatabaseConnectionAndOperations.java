/**
 * 
 */
package jdbcAndDatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author DELL
 *
 */

/*********************
 * In this class we have demonstrated how to connect to PostgreSQL database
 * using the JDBC API and defined methods which will perform CRUD operations
 *********************/
public class DatabaseConnectionAndOperations {

	//This is method which returns Connection as its return type and is responsible for connecting the postgres database to the eclipse 
	public Connection connectDatabase(String databaseName,String user,String password)
	{
		// Here we have declared the connection object as NULL, this will hold a reference to a connection object
		Connection connection = null;
		
		//Exception handling block inorder to handle some SQL based exceptions
		try {
			
			// Here we have registered the driver class or load the postgreSQL JDBC Driver
			Class.forName("org.postgresql.Driver");
			
			/*
			 * Here we have defined the connecting url by taking the values from the main class method for: databse,user and password
			 * And we establish the connection with the help of.getConnection() and store it in connection object
			 */
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+databaseName,user,password);
			
			// Now we print the message indicating that the connection is established with postgre database
			if (connection != null) {
				System.out.println("Connected to PostgreSQL Server Successfully");
			} else {
				
				System.out.println("Failed to connect Postgre server");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Catch block exceuted");
		}
		
		//Here we are returning the connection object to the main class method
		return connection;
	}
	
	//this is a function which is responsible for creation of table
		public void creationOfTable(Connection connection,String table_name)
		{
			//Here we are creating statement object inorder to take statements
			Statement statement_object;
			
			//Have used Exception handling block inorder to handle some SQL based exceptions
			try {
				
					//Now we will give input query to create a table and store it in a String type variable named 'query'
					String query ="create table "+ table_name+"(employeeID SERIAL, name varchar(20), address varchar(30),primary key(employeeID));";
					
					//now we intialize the statement object and create a statement with the createStatement()
					statement_object=connection.createStatement();
					
					//now we have executed the query with the help of .executeQuery()
					statement_object.executeUpdate(query);
					
					System.out.println("Table is created");
			}
			catch(Exception e)
			{
				System.out.println("Catch block executed");
				e.printStackTrace();
			}
		}
		
		// this is a function which is responsible for insertion of row
		public void insert_row(Connection connection, String table_name, String name, String address) {
			// Here we are creating statement object inorder to take statements
			Statement statement;

			// Exception handling block inorder to handle some SQL based exceptions
			try {

				// Now we will give input query to insert some data into rows and store it in a String type variable named
				// 'query'
				String query = String.format("insert into %s(name,address) values('%s','%s');", table_name, name, address);

				// now we intialize the statement object and create a statement with the
				// help of createStatement()
				statement = connection.createStatement();

				//now we have executed the query with the help of .executeQuery()
				statement.executeUpdate(query);
				System.out.println("Row inserted");
				
			} catch (Exception e) {
				
				System.out.println(e);
				e.printStackTrace();
			}
		}
		
		// this is a function which is responsible for reading data from the table
		public void read_data(Connection connection, String table_name) {
			// Here we are creating statement object inorder to take statements
			Statement statement;

			// Here we have created ResultSet Object in order to store the data into it
			ResultSet resultObject = null;

			// Have used Exception handling block inorder to handle some SQL based exceptions
			try {

				// Now we will give input query to read data from the table and store it in a String type variable named'query'
				String query = String.format("select * from %s order by employeeID asc", table_name);

				// now we intialize the statement object and create a statement with the createStatement()
				statement = connection.createStatement();

				//now we have executed the query with the help of .executeQuery() and stored it into resultObject
				resultObject = statement.executeQuery(query);

				 System.out.println("EmployeeID Name Address");
				 
				// Here we print the all the data which is stored into the resultSet object "resultObject"
				while (resultObject.next()) {
					
					System.out.print(resultObject.getString("employeeID") + "  ");
					System.out.print(resultObject.getString("Name") + "  ");
					System.out.println(resultObject.getString("Address") + "  ");

				}
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		

		// This method is responsible for updating the data into a table
		public void update_data(Connection connection, String table_name, String old_name, String new_name) {
			
			// Here we are creating statement object inorder to take statements
			Statement statement;

			// Have used Exception handling block inorder to handle some SQL based exceptions
			try {

				// Now we will give input query to update data and store it in a String type variable named'query'
				String query = String.format("update %s set name='%s' where name='%s'", table_name, new_name, old_name);
				
				// now we intialize the statement object and create a statement with the createStatement()
				statement = connection.createStatement();
				
				//now we have executed the query with the help of .executeQuery(input_query) method
				statement.executeQuery(query);

				System.out.println("Updated data");
				
			} catch (Exception e) {
				
				System.out.println(e);
				e.printStackTrace();

			}
		}
		
		// THis method is responsible for deletion of row into the table
		public void delete_by_row(Connection connection, String table_name, String name) {
			
			// Here we are creating statement object inorder to take statements
			Statement statement;

			// Have used Exception handling block inorder to handle some SQL based exceptions
			try {

				// Now we will give input query to delete a particular row's data and store it in a String type variable named'query'
				String query = String.format("delete from %s where name='%s'", table_name,name);
				
				// now we intialize the statement object and create a statement with the createStatement()
				statement = connection.createStatement();
				
				//now we have executed the query with the help of .executeQuery(input_query) method
				statement.executeQuery(query);

				System.out.println("Data deleted");

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();

			}
		}


		// this method is responsible for the deletion of the table
		public void delete_table(Connection connection, String table_name) {
			
			// Here we are creating statement object inorder to take statements
			Statement statement;

			// Have used Exception handling block inorder to handle some SQL based exceptions
			try {

				// Now we will give input query for drop table and store it in a String type variable named'query'
				String query = String.format("drop table %s", table_name);

				// now we intialize the statement object and create a statement with the createStatement()
				statement = connection.createStatement();
				
				//now we have executed the query with the help of .executeQuery(input_query) method
				statement.executeQuery(query);

				System.out.println("table deleted");

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();

			}
		}
		






}
