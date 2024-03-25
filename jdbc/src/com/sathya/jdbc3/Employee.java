package com.sathya.jdbc3;

public class Employee {
	
	 private int empID;
	 private String empName;
	 private double empSalary;
	public Employee(int empID, String empName, double empSalary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empSalary = empSalary;
	
	}
	public Employee() {
	
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
}
	