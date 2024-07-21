package jdbcAndDatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProductsDatabase {

	// This is method which returns Connection as its return type and is responsible for connecting the postgres database to the eclipse
	public Connection connectDatabase(String databaseName, String user, String password) {
		
		
		// Here we have declared the connection object as NULL, this will hold a reference to a connection object
		Connection connection = null;

		// Exception handling block inorder to handle some SQL based exceptions
		try {

			// Here we have registered the driver class or load the postgreSQL JDBC Driver
			Class.forName("org.postgresql.Driver");

			/*
			 * Here we have defined the connecting url by taking the values from the main
			 * class method for: databse,user and password And we establish the connection
			 * with the help of.getConnection() and store it in connection object
			 */
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databaseName, user,
					password);

			// Now we print the message indicating that the connection is established with
			// postgre database
			if (connection != null) {
				System.out.println("Connected to PostgreSQL Server Successfully");
			} else {

				System.out.println("Failed to connect Postgre server");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block exceuted");
		}

		// Here we are returning the connection object to the main class method
		return connection;
	}

	// this is a function which is responsible for creation of table
	public void creationOfTable(Connection connection, String table_name) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement_object;

		// Have used Exception handling block inorder to handle some SQL based
		// exceptions
		try {

			// Now we will give input query to create a table and store it in a String type
			// variable named 'query'
			String query = "create table " + table_name
					+ "(productID int, name varchar(20)NOT NULL, price DECIMAL(7,2) NOT NULL,primary key(productID));";

			// now we intialize the statement object and create a statement with the
			// createStatement()
			statement_object = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			statement_object.executeUpdate(query);

			System.out.println("Table is created");
			
		} catch (Exception e) {
			System.out.println("Catch block executed");
			e.printStackTrace();
		}
	}
	
	// this is a function which is responsible for insertion of row
			public void insert_row(Connection connection, String table_name,int ID, String name,int productprice) {
				// Here we are creating statement object inorder to take statements
				Statement statement;

				// Exception handling block inorder to handle some SQL based exceptions
				try {

					// Now we will give input query to insert some data into rows and store it in a String type variable named
					// 'query'
					String query = String.format("insert into %s(productID,name,price) values('%d','%s','%d');", table_name,ID, name,productprice);
					
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
			
			// this is a function which is responsible for insertion of row
						public void insert_row_using_batch(Connection connection,String table_name,int ID,String name,int productprice) {
							// Here we are creating statement object inorder to take statements
							Statement statement;

							// Exception handling block inorder to handle some SQL based exceptions
							try {
								statement = connection.createStatement();
					
								//setting auto-commit false
								connection.setAutoCommit(false);
								
								//Giving the input-query Statement to insert it into the table.
							      String query1 = String.format("insert into %s(productID,name,price) values('%d','%s','%d');", table_name,ID,name,productprice);
							      
							      //Here we are adding the statement to the batch
							      statement.addBatch(query1);
							      
							      //executing the batch which will have mulitple statements
							      statement.executeBatch();
							      
							      connection.commit();
							      
								System.out.println("batch-Row inserted");
								
							} catch (Exception e) {
								
								System.out.println(e);
								e.printStackTrace();
							}
						}
			
			
	

}
