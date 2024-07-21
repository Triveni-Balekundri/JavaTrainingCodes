package jdbcAndDatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * This class is responsible for performing different types of SQL operations and connectivity with the 
 * help of different assigned methods in it.
 */
public class EmployeeDetails {

	// This is method which returns Connection as its return type and is responsible
	// for connecting the postgres database to the eclipse
	public Connection connectDatabase(String databaseName, String user, String password) {
		// Here we have declared the connection object as NULL, this will hold a
		// reference to a connection object
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
			System.out.println("Catch block exceuted. The connectDatabase() has some problem");
		}
		// Here we are returning the connection object to the main class method
		return connection;

	}

	/***************************************************************************************************************************/
	
	// this is a function which is responsible for creation of employee table
	public void employeeTable(Connection connection, String table_name) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement_object;

		// Have used Exception handling block inorder to handle some SQL based
		// exceptions
		try {

			// Now we will give input query to create a table and store it in a String type
			// variable named 'query'
			String query = "create table " + table_name
					+ "(employeeID int, name varchar(20), city varchar(30),salary DECIMAL(7,2),primary key(employeeID));";

			// now we intialize the statement object and create a statement with the
			// createStatement()
			statement_object = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			statement_object.executeUpdate(query);

			System.out.println("Table is created");
		} catch (Exception e) {
			System.out.println("Catch block executed, the employeeTable() has some problem");
			e.printStackTrace();
		}
	}
	
	/**************************************************************************************************************************/

	// this is a function which is responsible for insertion of employeeData
	public void insert_data_into_employeeDataTable(Connection connection, String table_name, int ID,
			String employee_name, String city_name, int input_salary) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement;

		// Exception handling block inorder to handle some SQL based exceptions
		try {

			// Now we will give input query to insert some data into rows and store it in a
			// String type variable named
			// 'query'
			String query = String.format("insert into %s(employeeID,name,city,salary) values('%d','%s','%s','%d');",
					table_name, ID, employee_name, city_name, input_salary);

			// now we intialize the statement object and create a statement with the
			// help of createStatement()
			statement = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			statement.executeUpdate(query);
			System.out.println("Row inserted");

		} catch (Exception e) {

			System.out.println("Catch block executed, the insert_data_into_employeeDataTable() has some problem");
			System.out.println(e);
			e.printStackTrace();
		}
	}

	/************************************************************************************************************************/
	
	// this is a function which is responsible for creation of Department table
	public void employeeDepartmentTable(Connection connection, String table_name) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement_object;

		// Have used Exception handling block inorder to handle some SQL based
		// exceptions
		try {

			// Now we will give input query to create a table and store it in a String type
			// variable named 'query'
			String query = "create table " + table_name
					+ "(department_name varchar(20),employeeID int,role varchar(20),foreign key(employeeID)references EmployeeData(employeeID));";

			// now we intialize the statement object and create a statement with the
			// createStatement()
			statement_object = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			statement_object.executeUpdate(query);

			System.out.println("Table is created");
		} catch (Exception e) {
			System.out.println("Catch block executed, employeeDepartmentTable() has some problem");
			e.printStackTrace();
		}
	}

	/**********************************************************************************************************************************************************/
	
	// this is a function which is responsible for insertion of department details
	public void insert_data_into_employeeDepartmentTable(Connection connection, String table_name,
			String input_department, int input_id, String input_role) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement;

		// Exception handling block inorder to handle some SQL based exceptions
		try {

			// Now we will give input query to insert some data into rows and store it in a
			// String type variable named
			// 'query'
			String query = String.format("insert into %s(department_name,employeeID,role) values('%s','%d','%s');",
					table_name, input_department, input_id, input_role);

			// now we intialize the statement object and create a statement with the
			// help of createStatement()
			statement = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			statement.executeUpdate(query);
			System.out.println("Row inserted");

		} catch (Exception e) {

			System.out.println("insert_data_into_employeeDepartmentTable() has some problem");
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**************************************************************************************************************************************************/

	// this is a function which is responsible for joining of two tables
	public void performing_simpleJoin_Operation_on_the_two_Tables(Connection connection, String table_name1,String table_name2) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement;

		ResultSet resultObject = null;

		// Exception handling block inorder to handle some SQL based exceptions
		try {

			// Now we will give input query to insert some data into rows and store it in a
			// String type variable named
			// 'query'
			String query = String.format(
					"select e.employeeID,e.name,d.department_name from %s e JOIN %s d ON e.employeeID=d.employeeID",
					table_name1, table_name2);

			// now we intialize the statement object and create a statement with the
			// help of createStatement()
			statement = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			resultObject = statement.executeQuery(query);

			while (resultObject.next()) {

				System.out.print(resultObject.getInt("employeeID") + "  ");
				System.out.print(resultObject.getString("name") + "  ");
				System.out.println(resultObject.getString("department_name") + "  ");

			}

			System.out.println("Join operation");

		} catch (Exception e) {

			System.out.println("performing_simpleJoin_Operation_on_the_two_Tables() has some problem");
			System.out.println(e);
			e.printStackTrace();
		}
	}

	/*******************************************************************************************************************************************/
	
	// this is a function which is responsible for truncating the given table
	public void truncate_Table(Connection connection, String table_name) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement;

		// Exception handling block inorder to handle some SQL based exceptions
		try {

			// Now we will give input query to insert some data into rows and store it in a
			// String type variable named
			// 'query'
			String query = String.format("TRUNCATE table %s", table_name);

			// now we intialize the statement object and create a statement with the help of
			// createStatement()
			statement = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			statement.executeQuery(query);

			System.out.println("Table has been truncated");

		} catch (Exception e) {

			System.out.println("The table has not been truncated,  truncate_Table() has some problem");
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/******************************************************************************************************************************************/

	// this is a function which is responsible for dropping the given table
	public void drop_Table(Connection connection, String table_name) {
		
		// Here we are creating statement object inorder to take statements
		Statement statement;

		// Exception handling block inorder to handle some SQL based exceptions
		try {

			// Now we will give input query to insert some data into rows and store it in a
			// String type variable named
			// 'query'
			String query = String.format("DROP table %s", table_name);

			// now we intialize the statement object and create a statement with the help of
			// createStatement()
			statement = connection.createStatement();

			// now we have executed the query with the help of .executeQuery()
			statement.executeQuery(query);

			System.out.println("Table has been droped");

		} catch (Exception e) {

			System.out.println("The table has not been droped,  drop_Table() has some problem");
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

}
