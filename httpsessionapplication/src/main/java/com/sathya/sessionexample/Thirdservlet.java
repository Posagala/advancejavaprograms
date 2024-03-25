package com.sathya.sessionexample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Thirdservlet")
public class Thirdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // create the session object
		  HttpSession session = request.getSession(false);
		  
		  //get the form details
		  response.setContentType("text/html");
		  PrintWriter writer = response.getWriter();
		
		  writer.println("<html>");
		  writer.println("<body bgcolor=yellow>");
		  writer.println("<pre>");
		  writer.println(" username..."+session.getAttribute("username"));

		  writer.println(" Age..."+session.getAttribute("Age"));
		 
		  writer.println(" Qulification..."+session.getAttribute("Qulification"));
		 
		  writer.println(" Desigination..."+session.getAttribute("Designation"));
		 
		  
		  writer.println(" Email..."+request.getParameter("Email"));
		  writer.println(" Mobile..."+ request.getParameter("Mobile"));
		        
		  writer.println("</pre>");
		  writer.println("</body>");
		  writer.println("</html>");

		  
		 }

		}
	


