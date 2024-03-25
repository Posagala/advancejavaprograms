package Com.Sathya.Servlet;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	//get the data from client  String qualification=request.getParameter("Qualification");
	  String desigination=request.getParameter("Desigination");  
	  //create the cookies object  Cookie cookie3=new Cookie("Qualification",qualification);
	  Cookie cookie4=new Cookie("Desigination",desigination);  
	  //add the cookies to response object.
	  response.addCookie(cookie4);  response.addCookie(cookie4);
	  //Give the next form to client
	  RequestDispatcher dispatcher=request.getRequestDispatcher("thirdfrorm.html"); 
	  dispatcher.forward(request, response);
	 }
	}

