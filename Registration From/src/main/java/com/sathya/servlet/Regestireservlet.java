package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class Regestireservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 
		 //Step-1: Read the Data
		  
	    String Username=request.getParameter("userName");
	    String Password=request.getParameter("password");
	    Long  Mobile=Long.parseLong(request.getParameter("userMobile"));
	    String  Email=request.getParameter("userEmail");
	          String  gender=request.getParameter("gender");
	    String[] quals = request.getParameterValues("Qualification");
	    
	    String  DOB=request.getParameter("DOB");
	    String  Country=request.getParameter("Country");
	    String[] Languages=request.getParameterValues("Languages");
	    String  Comments=request.getParameter("COMMENTS");
	    
	    //step-2: Process the Request
	    
	    String q=String.join(",", quals);
	    String l=String.join(",", Languages);//telugu,hindi,english
	    
	    //step-3:Render the Request   

	    response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
	    writer.println("<html>");
	    writer.println("<body bgcolor = pink>");
	    writer.println("your Username..."+Username+"<br><br>");
	    writer.println("your Password..."+Password+"<br><br>");
	    writer.println("your mobile number..."+ Mobile+"<br><br>");
	    writer.println("your User Email..."+Email+"<br><br>");
	    writer.println("your gender..."+gender+"<br><br>");
	    writer.println("your Qualification..."+q+"<br><br>");
	    writer.println("your DOB..."+DOB+"<br><br>");
	    writer.println("your Country..."+Country+"<br><br>");
	    writer.println("your Languages..."+l+"<br><br>");
	    writer.println("your Comments..."+Comments+"<br><br>");
	    writer.println("</body>");
	    writer.println("</html>");
	 }
	}
	