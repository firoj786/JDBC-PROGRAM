package com.sa.jdbc;

//STEP 1. Import required packages
import java.sql.*;

public class FirstExample {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "alibaba");
			// STEP 2: Register JDBC driver

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = con.createStatement();
			String query = "SELECT name, salary FROM emp1";
			ResultSet rs = stmt.executeQuery(query);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String name = rs.getString("name");
				int sl = rs.getInt("salary");

				// Display values
				System.out.println("name: " + name);
				System.out.println("Salary: " + sl);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end FirstExample