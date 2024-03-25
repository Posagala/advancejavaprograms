package com.sathya.sessionexample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  // get the client data
		  
		  String username =  request.getParameter("username");
		 int Age =  Integer.parseInt(request.getParameter("Age"));
		 
		 
		 
		 // create session object
		 HttpSession session = request.getSession();
		 session.setAttribute("username", username);
		 session.setAttribute("Age",Age);
		 
		 
		 //place the data in session object
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Secondfrom.html");
		   dispatcher.forward(request, response);;
		 
		 }

		}
	


