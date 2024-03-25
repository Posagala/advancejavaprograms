package com.sathya.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcEx1 {

	private static Statement statement;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully");

		
		//step-2:created the connection.
Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
				System.out.println("connection created sucessfully.......");
				
				
				
				//step- 3 process the query
				 // Statement statement = (Statement) connection.createStatement();
				 // String q = "create table employee5 (eid number,ename varchar2(25),esalary number)" ;
				 //int res1 = statement.executeUpdate(q);
				       // System.out.println("table created succtessfully...."+res1 );
				        
				        String q2 = "drop table employee1 ";
				        int res2 = statement.executeUpdate(q2);
				        System.out.println("table droped successfully...."+res2);
				        
				        
				        
				        //step4 connection
				        System.out.println("table droped successfully...."+res2);
				        
				        connection.close();
				        
	}
}