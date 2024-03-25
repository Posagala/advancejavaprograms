package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

				   
				//step1:Read the Requested Data
				    
				    int num1=Integer.parseInt(request.getParameter("First"));
				    int num2=Integer.parseInt(request.getParameter("Second"));
				    String operation=(request.getParameter("operation"));
				    
				    //step 2: process the data
				    
				    int result=0;
				    switch(operation)
				    {
				    case "+" : result=num1+num2;
				                break;
				                
				    case "-" : result=num1-num2;
				                     break;
				        
				    case "*" : result=num1*num2;
				                     break;
				        
				    case "/" : result=num1/num2;
				                   break;
				        
				    case "%" : result=num1%num2;
				                     break;
				    }
				    
				    //step 3: Render the response
				    
				    response.setContentType("text/html");
				    PrintWriter writer=response.getWriter();
				    writer.println("<html>");
				    writer.println("<body bgcolor = pink");
				        writer.println("<h1>My Results:</h1>");
				        writer.println("<p>My FirstNumber:"+num1+"</p>");
				        writer.println("<p>My SecondNumber:"+num2+"</p>");
				        writer.println("<p>My operation:"+operation+"</p>");
				        writer.println("<p>My Result:"+result+"</p>");
				        writer.println("</body>");
				        writer.println("</html");
		

}
}