package com.sa.jdbc;
import java.sql.*;
public class JDBCExample {
   // JDBC driver name and database URL
public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("oracle.jdbc.driver.OracleDriver");
     //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
      System.out.println("Connected database successfully...");
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql = "select * from emp where rownum<=5";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int empno  = rs.getInt("EMPNO");
         String ename = rs.getString("ENAME");
         String job = rs.getString("JOB");
         float sal = rs.getFloat("SAL");
         //Display values
         System.out.print("EMPNO: " + empno);
         System.out.print(", ENAME: " + ename);
         System.out.print(", JOB: " + job);
         System.out.println(", SAL: " + sal);
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample