package com.cookies.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // get the client data

		  String qualification =  request.getParameter("qualification");
		  String Designation =  request.getParameter("Designation");



		  // create cookies object
		  Cookie cookie3 = new Cookie("qualification", qualification);
		  Cookie cookie4 = new Cookie("Designation", Designation);


		  //add the cookie into response object
		  response.addCookie(cookie3);

		  response.addCookie(cookie4);
		  RequestDispatcher dispatcher = request.getRequestDispatcher("thirdform.html");
		  dispatcher.forward(request, response);; 
		 }

		}
	


