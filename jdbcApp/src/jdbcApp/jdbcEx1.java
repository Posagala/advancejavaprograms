package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully");

		
		//step-2:created the connection.
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1512:xe","pinky","pinky");
						System.out.println("connection created sucessfully.......");

	}

}
