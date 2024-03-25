package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step-1: read the from request data
		int ProID=Integer.parseInt(request.getParameter("ProID"));
		String ProName=request.getParameter("ProName");
		double ProPrice=Double.parseDouble(request.getParameter("ProPrice"));
		double ProQuantity=Double.parseDouble(request.getParameter("ProQuantity"));
		
		//step-2: process the data  
		Double totalBill;
		totalBill = ProPrice*ProQuantity;
		double discount = 0.0;
		double netbalance;
		
		if(totalBill>1000 && totalBill<5000)
		{
			discount=(5*totalBill)/100;
			
		}
		else if (totalBill>5000 && totalBill<10000)
		{
			
			
			discount=(10*totalBill)/100;
		}
		else if (totalBill>10000)
		{
			discount=(15*totalBill)/100;
		}
		
		netbalance= totalBill-discount;
		
		 //Step-3:Render the response
	      response.setContentType("text/html");
	      PrintWriter writer=response.getWriter();
	      writer.println("<html>");
	      writer.println("ProID : "+ProID);
	      writer.println("ProductName : "+ProName);
	      writer.println("productPrice :"+ProPrice);
	      writer.println("ProductQuantity : "+ProQuantity);
	      writer.println("TotalBill : "+totalBill);
	      writer.println("Discount : "+discount);
	      writer.println("Net Balance : "+netbalance);
	      writer.println("</html>"); 
		
		}
	}


