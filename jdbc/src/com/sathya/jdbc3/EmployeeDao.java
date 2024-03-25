package com.sathya.jdbc3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sathya.jdbc.Ddconnection;

public class EmployeeDao {
	public int Save(Employee emp) {
		  // Declare the Resources
		  Connection connection = null;
		  PreparedStatement preparedStatement = null;
		  int count = 0;
		  try {
		  //  get the connection
		   connection = Ddconnection .createConnetion();
		   // create ps object
		   preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");

		   // read the data from emp object and set to parameters

		   preparedStatement.setInt(1, emp.getEmpID());

		   preparedStatement.setString(2, emp.getEmpName());

		   preparedStatement.setDouble(3, emp.getEmpSalary());
		   count = preparedStatement.executeUpdate();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }

		  finally {
		   // before release connection check the (connection [resent ot not)
		   try {
		    if (connection != null)
		     connection.close();
		    if (preparedStatement != null)
		     preparedStatement.close();
		   } catch (SQLException e) {
		    e.printStackTrace();
		   }
		  }
		  return count;

		 }
	public Employee findById(int empId)  
	 {
	  // try with resources
	 Employee employee = null;

	  try(Connection connection = Ddconnection.createConnetion();
	    PreparedStatement preparedStatement = connection.prepareStatement("select * from emp where empId=?"))
	  {
	   // set the data to parameter
	   preparedStatement.setInt(1, empId);
	   // execute the query
	   ResultSet resultset = preparedStatement.executeQuery();

	   if(resultset.next()) {
		    // read the data and set to employee object
		     employee = new Employee(empId, null, empId);
		    employee.setEmpID(resultset.getInt(1));
		    employee.setEmpName(resultset.getString(2));
		    employee.setEmpSalary(resultset.getDouble(3));


		   }
		  }
		  catch(SQLException e)
		  { 
		   e.printStackTrace();
		  }

		 

		 return employee ;

		}
	// delete by id method
	 
	 public int deleteById(int empId)
	 {
	  int count = 0;
	  // try with resources
	  try(Connection connection = Ddconnection.createConnetion();
	    PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empId=?"))
	  {
	   preparedStatement.setInt(1, empId);
	  
	   count = preparedStatement.executeUpdate();
	   
	  }
	  catch (SQLException e)
	  {e.printStackTrace();
	  
	  }
	  return count;
	  }
	 public double deleteBySalary(double empSalary)
	 {
	  int count = 0;
	  // try with resources
	  try(Connection connection = Ddconnection.createConnetion();
	    PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empId=?"))
	  {
	   preparedStatement.setDouble(1, empSalary);
	   count = preparedStatement.executeUpdate();
	  }
	 catch(SQLException e)
	  {
	  e.printStackTrace();
	  }
	  
	 return count;
	 
	 
	 }
	 // find by All method
	 public   List<Employee> findAll()
	 { // creating employee object
	  List<Employee> emps = new ArrayList<Employee>();

	// try with resources
	 try(Connection connection = Ddconnection.createConnetion();
	   java.sql.Statement statement =connection.createStatement())
	 {
	  ResultSet resultset = statement.executeQuery("select * from emp");
	  
	  // reading step by step
	  while(resultset.next())
	  { Employee employee = new Employee();
	  employee.setEmpID(resultset.getInt(1));
	  employee.setEmpName(resultset.getString(2));
	  employee.setEmpSalary(resultset.getDouble(3));
	   
	  emps.add(employee);
	  }
	  
	 }
	 
	  
	catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	return emps;

	 }
	 public int updateSalary(double CurrentSalary,double incSalary)
	 {
	  int updateCount=0;
	  // try with resources
	  try(Connection connection = Ddconnection.createConnetion();
	    PreparedStatement preparedStatement = connection.prepareStatement("update emp set empSalary=empSalary+? where empSalary>?"))
	  {
	   // set data into parameter
	   preparedStatement.setDouble(1, incSalary);
	   preparedStatement.setDouble(2, CurrentSalary);
	   // execute the query
	   updateCount = preparedStatement.executeUpdate();
	  } 
	  catch(SQLException e)
	  {
	   e.printStackTrace();
	  }

	  return updateCount;
	}
}