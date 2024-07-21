package jdbcAndDatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*********************
 * In this class we have demonstrated how to connect to PostgreSQL database
 * using the JDBC API
 *********************/
public class JDBCPostgreSQLConnectionSecondMethod {

	final String jdbc_url = "jdbc:postgresql://localhost:5432/mydatabase";

	final String jdbc_userName = "postgres";

	final String jdbc_password = "triveni";

	
	
	public Connection connectToPostgre() {
		
		
		Connection connection = null;
		
		// Have used try-catch block for handling exceptions like:
		// ClassNotFoundException or SQL Exception
		try {
			
			// Here we have registered the driver class or load the postgreSQL JDBC Driver
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(jdbc_url, jdbc_userName, jdbc_password);
			if (connection != null) {
				System.out.println("Connected to PostgreSQL Server Successfully");
			} else {
				System.out.println("Failed to connect Postgre server");
			}

			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT VERSION()");

			if (resultset.next()) {
				System.out.println(resultset.getString(1));

			}

			if (connection != null) {

				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block exceuted");
		}
		return connection;

		
	}
	
	//this is a function which is responsible for creation of table
	public void creationOfTable(Connection connection,String table_name)
	{
		//Here we are creating statement object inorder to take statements
		Statement statement_object;
		
		//Exception handling block inorder to handle some SQL based exceptions
		try {
			
				//Now we will give input query and stores it in a String type variable named 'query'
				String query="create table "+table_name+"(employeeID number(20), name varchar(20), address varchar(30),primary key(employeeID));";
				
				//now we intialize the statement object and create a statement with the createStatement()
				statement_object=connection.createStatement();
				
				//now we have executed the statement(query)
				statement_object.executeUpdate(query);
				
				System.out.println("Table is created");
		}
		catch(Exception e)
		{
			System.out.println("Catch block executed");
		}
	}
	

	
}
