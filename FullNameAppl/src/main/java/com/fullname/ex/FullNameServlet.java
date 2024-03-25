package com.fullname.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FullNameServlet")
public class FullNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// step-1:Read the form data
				String firstname = request.getParameter("firstname");
				String middlename= request.getParameter("middlename");
				String lastname= request.getParameter("lastname");
				
				//step-2: process the data
				String FullName;
		
				
					FullName=firstname+" "+middlename+" "+lastname;
		
				
				//step-3:Render the response to client
				PrintWriter writer = response.getWriter();
				response.setContentType("text/html");
				
				writer.println("<html/>");
				writer.println("<h1> your fullname...</h1>"+FullName);
				writer.println("</html>");
	}
} 
