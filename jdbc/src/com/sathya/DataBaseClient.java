package com.sathya;

import com.sathya.jdbc3.Employee;
import com.sathya.jdbc3.EmployeeDao;

public class DataBaseClient {
	 public static void main(String[] args) {
		 
		 EmployeeDao employeeDao = new EmployeeDao();
		 int res1 = employeeDao.Save(new Employee(101, "anu", 116.0));
		  System.out.println("Data inserted successfully..." + res1);

		 int res2 = employeeDao.Save(new Employee(102, "ani", 118.0));
		  System.out.println("Data inserted successfully..." + res2);
		 
		 int res3 = employeeDao.Save(new Employee(103,"radha",3000));
		// System.out.println("Data inserted successesfully.."+res3);	
		 //find id method
		 Employee emp = employeeDao.findById(102);
		 System.out.println(emp);
		 //
		 Employee emp1 = employeeDao.findById(103);
		 System.out.println(emp1);
		 
		 /*int count = employeeDao.deleteById(101);
		  if (count==0)
		  {
		    System.out.println("data deleted failed.."+count);
		  } 
		  else
		  {
		   System.out.println("data deleted successfully...."+count);

		  }
		  */
		  /*double delcount = employeeDao.deleteBySalary(116);
		    System.out.println("data deleted ..."+delcount);

		    
		 List<Employee> emps = employeeDao.findAll();
		 emps.forEach(emp -> System.out.println(emp)) ;*/
		  
		  
		  // reading the data
		  //int updateCount = employeeDao.updateSalary(100, 50);
		  //System.out.println("updated rows affected "+updateCount);
	 }
}