package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	    String proId=request.getParameter("proId");
	    
	    productdao dao=new productdao();
	    product existingProduct=dao.findById(proId);
	    
	    request.setAttribute("existingProduct",existingProduct);
	    
	    RequestDispatcher dispatcher=request.getRequestDispatcher("editform.jsp");
	    dispatcher.forward(request, response);
	    
	  }
	}
