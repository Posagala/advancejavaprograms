package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ddconnection {
	public static Connection createConnetion()
	 {
	  Connection connection = null;
	  {
	   try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
	   }
	   catch(ClassNotFoundException | SQLException e)
	  { 
	    e.printStackTrace();
	   }
	   return connection;
	  }





	 }
}
