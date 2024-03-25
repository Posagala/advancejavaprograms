package com.satrhya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class myqle1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		  // step-1 LOad the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("my sql driver downloaded successfully...");

		// create the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/system","root","root");
		System.out.println("connection created my mysql successfully..."+connection);
	
	
	
	
	
	}
}