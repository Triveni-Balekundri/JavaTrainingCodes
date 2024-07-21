/**
 * 
 */
package jdbcAndDatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;


/*********************
 * In this class we have demonstrated how to connect to PostgreSQL database
 * using the JDBC API
 *********************/
public class JDBCPostgreSQLConnection {

	public static void main(String[] args) {

		
		// Here we have declared the connection object as NULL, this will hold a
		// reference to a connection object
		Connection connection = null;

		// Have used try-catch block for handling exceptions like:
		// ClassNotFoundException or SQL Exception
		try {

				// Here we have registered the driver class or load the postgreSQL JDBC Driver
				Class.forName("org.postgresql.Driver");

			/*
			 * We have defined the JDBC url in String type variable declaring it as final.
			 * That is we have created the connnection URL Syntax for the url :
			 * "jdbc:postgresql://hostname:port-No/database-name";
			 */
				final String jdbc_url = "jdbc:postgresql://localhost/mydatabase";

			/*
			 * We have declared a String type variable jdbc_userName where we assign our
			 * username that is given to our database
			 */
			final String jdbc_userName = "postgres";

			/*
			 * We have declared a String type variable jdbc_password where we assign our
			 * password which was given to access our database
			 */
			final String jdbc_password = "triveni";

			// Now we establish the connection with the help of
			// .getConnection(url,user-name,password) from the DriverManager class
			connection = DriverManager.getConnection(jdbc_url, jdbc_userName, jdbc_password);

			// Now we print the message indicating that the connection is established with
			// postgre
			System.out.println("Connected to the postgre");

		} catch (Exception e) {

			e.printStackTrace();

		}
		try {

			if (connection != null) {

				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
