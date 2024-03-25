package Com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		  //display the total details 
	    //total 6=req(2)+Cookies(4) 
	   
	     
	    response.setContentType("text/html"); 
	    PrintWriter writer=response.getWriter(); 
	    Cookie cookie5=new Cookie("Email", request.getParameter("Email"));     
	    Cookie cookie6=new Cookie("mobile", request.getParameter("Mobile")); 
	    response.addCookie(cookie5); 
	    response.addCookie(cookie6); 
	    Cookie[]cookies=request.getCookies();  
	     
	     
	    writer.println("<html>"); 
	    writer.println("<body bgcolor='yellow'>"); 
	    writer.println("<pre>"); 
	     
	    writer.println("Username: "+cookies[0].getValue()); 
	    writer.println("Age: "+cookies[1].getValue()); 
	    writer.println("Qualification: "+cookies[2].getValue()); 
	    writer.println("Desigination: "+cookies[3].getValue()); 
	    writer.println("Email: "+cookies[4].getValue()); 
	    writer.println("Mobile: "+cookies[5].getValue()); 
	   writer.println("</pre>"); 
	    writer.println("</body>"); 
	    writer.println("</html"); 
	 
	 } 
	 
	}