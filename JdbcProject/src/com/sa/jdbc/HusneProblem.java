package com.sa.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class HusneProblem {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter roll number:");
			int rollno = sc.nextInt();
			System.out.println("Enter name:");
			String name = sc.next();
			System.out.println("Enter marks:");
			int marks = sc.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// STEP 2: Register JDBC driver
			String query = "insert into oracle values(?,?,?)";
			PreparedStatement prSt = con.prepareStatement(query);
			prSt.setInt(1, rollno);
			prSt.setString(2, name);
			prSt.setInt(3, marks);
			prSt.executeUpdate();
			System.out.println("One record inserted is success full");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
