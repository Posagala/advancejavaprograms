package com.sathya;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//step-1: Load the drive
		Class.forName("oracle.jdbc.drive.OracleDrive");
		
		//step2 Create the Connection
		Connection connection DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","manager"
		``
			//step-3 static query execution
		Statement statement=(Statement) connection.createStatement();
		String q1 ="create table emp("id number"," name varchar2(30)",salary number)";
		int res1 = statement.execute Update(q1);
		System.out.println("table created Sucessfully...."+res1);
		
		String q2 ="drop table emp";
		int res2 = statement.execute update(q2);
		System.out.println("Table Droped Sucessfully...."+res2);
		
		//step4- Relase the connection
		connection.close();
		System.out.println("connection closed sucessfully...");
	}
}