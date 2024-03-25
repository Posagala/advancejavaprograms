package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//step-1:Read the requested data
				     int proId=Integer.parseInt(request.getParameter("proId"));
				    String proName= request.getParameter("proName");
				     Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
				    int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
				    double totalbill=Double.parseDouble(request.getParameter("proPrice"))*Double.parseDouble(request.getParameter("proPrice"));
				    double discount=0.0;
				    double netPrice=0.0;
				    
				    //step-2:Process the data
				      //Total Bill <1000         :No discount
				      if(totalbill<1000) 
				      {
				        discount=0.0;
				      }
				      else if(totalbill>1000 & totalbill<5000)
				      {
				        discount=(5*totalbill)/100;
				      }
				      else if(totalbill>5000 & totalbill<10000)
				      {
				        discount=0.01*totalbill;
				      }
				      else if(totalbill>10000)
				      {
				        discount=(15*totalbill)/100;
				      }
				      netPrice=totalbill-discount;
				    
				    
				    //Step-3:Render the response
				      response.setContentType("text/html");
				      PrintWriter writer=response.getWriter();
				      writer.println("<html>");
				      writer.println("<body bgcolor = pink");
				      writer.println("<h1> <b>Product Bill Invoice:</b></h1>");
				      writer.println("<p><i>ProductId :</i>"+proId);
				      writer.println("<p><i>ProductName :</i>"+proName);
				      writer.println("<p><i>productPrice :</i>"+proPrice);
				      writer.println("<p><i>ProductQuantity :</i>"+proQuantity);
				      writer.println("<p><i>TotalBill :</i> "+totalbill);
				      writer.println("<p><i>Discount :</i> "+discount);
				      writer.println("<p><i>Net Price : </i>"+netPrice);
				      writer.println("</body>");
				      writer.println("</html>");
				     
				
	}

}
