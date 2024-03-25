package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step 1:Read  the Requested Data
	      int empId=Integer.parseInt(request.getParameter("empId"));
	      String empName=(request.getParameter("empName"));
	      double bsal=Double.parseDouble(request.getParameter("bsal"));

	      
	      //step 2:Process the data
	      
	      double HRA;
	      double DA,PF,Gross_Salary;
	      if(bsal>=50000)
	      {
	        HRA=bsal*0.3;
	        DA=bsal*0.1;
	        PF=bsal*0.6;
	        Gross_Salary=bsal+HRA+DA-PF;
	      }
	      else if(bsal<50000 & bsal>25000)
	      {

	        HRA=bsal*0.2;
	        DA=bsal*0.5;
	        PF=bsal*0.3;
	        Gross_Salary=bsal+HRA+DA-PF;
	      }
	      else 
	      {

	        HRA=bsal*0.1;
	        DA=bsal*0.3;
	        PF=bsal*0.2;
	        Gross_Salary=bsal+HRA+DA-PF;
	      }
	        
	      //Step 3: render the response
	      
	      response.setContentType("text/html");
	          PrintWriter writer = response.getWriter();
	          writer.println("<html>");
	          writer.println("<body bgcolor = skyblue");
	          writer.println("<h1><b>Employee Salary Info:</b></h1>");
	          writer.println("<p><i>Employee Id:</i>"+empId);
	          writer.println("<p><i>Employee Name:</i>"+empName);
	          writer.println("<p><i>Employee BasicSalary:</i>"+bsal);
	          writer.println("<p><i>HRA Amount:</i>"+HRA);
	          writer.println("<p><i>DA Amount:</i>"+DA);
	          writer.println("<p><i>PF Amount:</i>"+PF);
	          writer.println("<p><i>Gross Salary:</i>"+Gross_Salary);
	          writer.println("</body>");
	          writer.println("</html>");
	}

}
