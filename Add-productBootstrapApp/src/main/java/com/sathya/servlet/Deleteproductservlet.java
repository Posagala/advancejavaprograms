package com.sathya.servlet;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Deleteproductservlet")
public class Deleteproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String proId=request.getParameter("proId");
		    
		    productdao dao=new productdao();
		    int result=dao.deleteById(proId);
		    
		    if(result==1) {
		      //To send the data to JSP file add the result
		      request.setAttribute("DeleteResult",result);
		      RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
		      dispatcher.forward(request, response);
		    }
		    else {
		      request.setAttribute("DeleteResult",result);
		      RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
		      dispatcher.forward(request, response);
		    }
		  }

		}