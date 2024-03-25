package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/anitha")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloWorldServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer = response.getWriter();
		response.setContentType("html");
		
		writer.println("<h1>hello welcome to sathya tech...</h1>");
		
		writer.println("<h2>adv java class by ratan sir....</h2>");
		
		writer.println("<h3>this is my first servlet...</h3>");
		writer.println("<h4>this is my second servlet...</h4>");
		writer.println("<h5>this is my third servlet...</h5>");
		writer.println("<h6>this is my four servlet...</h6>");
		
		
		}
	
	}


