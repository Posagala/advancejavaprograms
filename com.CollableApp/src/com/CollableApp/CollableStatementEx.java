package com.CollableApp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CollableStatementEx {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","welcome");
		// call the procedure
		 CallableStatement collableStatement = connection.prepareCall("{ call getsal(?,?)}");
		 
		 // set the input data
		 collableStatement.setInt(1, 105);
		 
		 
		 // register one variable to store the output
		 collableStatement.registerOutParameter(2,Types.FLOAT);

		 // execute the procedure 
		 collableStatement.executeUpdate();
		 // print output
		 System.out.println(collableStatement.getFloat(2));
		}
		}