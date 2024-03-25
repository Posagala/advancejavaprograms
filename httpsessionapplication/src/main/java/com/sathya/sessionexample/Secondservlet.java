package com.sathya.sessionexample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Secondservlet")
public class Secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // get the client data
		  
		  String Qulification =  request.getParameter("Qulification");
		 String Designation =  request.getParameter("Desigination");

		 // locate the session object
		 HttpSession session = request.getSession(false);
		 session.setAttribute("Qulification", Qulification);
		 session.setAttribute("Designation", Designation);
		 
		 //place the data in session object
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Thirdform.html");
		   dispatcher.forward(request, response);;
		 
		 }
}


