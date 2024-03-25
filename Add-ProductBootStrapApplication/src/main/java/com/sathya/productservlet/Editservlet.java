package com.sathya.productservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Editservlet")
public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String proId=request.getParameter("proId");
	    
	    ProductDAO dao=new ProductDAO();
	    Product existingProduct=dao.findById(proId);
	    
	    request.setAttribute("existingProduct",existingProduct);
	    
	    RequestDispatcher dispatcher=request.getRequestDispatcher("edit-form.jsp");
	    dispatcher.forward(request, response);
	    
	  }
	}