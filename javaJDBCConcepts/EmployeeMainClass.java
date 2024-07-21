package jdbcAndDatabaseOperations;

import java.sql.Connection;

/*
 * This class is responsible for passing values/parameters to the methods which are defined in another class named 
 * "EmployeeDetails" which performs some sql operations and connectivity
 */
public class EmployeeMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//using the exception handling block in order to handle some sql based exceptions
		try {
			
			// creation of object of the class EmployeeDetails
			EmployeeDetails classObject = new EmployeeDetails();

			// Passing some input-parameters to the connectDatabase() in order to connect to the database
			Connection connection = classObject.connectDatabase("mydatabase", "postgres", "triveni");
			
			/*************************************************************************************************************************************/
			// creation of employee table
			// classObject.employeeTable(connection,"EmployeeData");
			/************************************************************************************************************************************/
			// creation of employeeDepartment table
			// classObject.employeeDepartmentTable(connection,"employeeDepartment");

			/***********************************************************************************************************************************/
			
			// inserting data into the employeeData table
			// classObject.insert_data_into_employeeDataTable(connection,"EmployeeData", 1,"Amish", "R.C", 40000);
			// classObject.insert_data_into_employeeDataTable(connection,"EmployeeData", 2,"Arun", "devanhalli", 30000);
			// classObject.insert_data_into_employeeDataTable(connection,"EmployeeData", 3,"Sameer", "pune", 70000);
			// classObject.insert_data_into_employeeDataTable(connection,"EmployeeData", 4,"Omkar", "Berlin", 90000);

			/*************************************************************************************************************************************/
			// inserting data into the employeeDepartment table
			// classObject.insert_data_into_employeeDepartmentTable(connection, "employeeDepartment","Marketing",3,"strategist");
			// classObject.insert_data_into_employeeDepartmentTable(connection, "employeeDepartment","Operations",1,"operator");
			// classObject.insert_data_into_employeeDepartmentTable(connection, "employeeDepartment","Sales",1,"sales-Person");
			// classObject.insert_data_into_employeeDepartmentTable(connection, "employeeDepartment","Tech",4,"developer");
			// classObject.insert_data_into_employeeDepartmentTable(connection, "employeeDepartment","Human Resource",2,"H.R");
			/****************************************************************************************************************************************/
			// This violates the foreign key constraint
			// classObject.insert_data_into_employeeDepartmentTable(connection, "employeeDepartment","Maintainance",7,"Maintainer");

			/*********************************************************************************************************************************************/
			// joining the two tables with the help of simple join
			// classObject.performing_simpleJoin_Operation_on_the_two_Tables(connection,"EmployeeData","employeeDepartment");
			/*********************************************************************************************************************************************/

			// truncating a table
			// classObject.truncate_Table(connection,"employeeDepartment");

			/*********************************************************************************************************************************************/

			// Here we are passing the name of the table as parameter to the below method inorder to drop that table
			// classObject.drop_Table(connection,"employeeDepartment");
			
		} catch (Exception e) {
			System.out.println("Catch block executed. The employee Main class has some problem");
			e.printStackTrace();
			e.getMessage();
		}
	}

}
