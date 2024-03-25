package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SathyaServlet")
public class SathyaServlet extends HttpServlet {
	
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read the form data 
		String  FirstName = request.getParameter("Firstname");
		String  Middlename = request.getParameter("Middle name");
		String  LastName = request.getParameter("Lastname name");
		
		//process the data
		String status = null;
		if(FirstName.equals("anitha")&& MiddleName.equals("sir")&& LastName.equals("Anu"))
		{
			status = "anitha sir Anu";
		}
		//step-3: Render the Response to client
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Full Name...</h1>"+ status);
		writer.println("</html>");
		
	}

}
