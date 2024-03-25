package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookies3servlet")
public class cookies3servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 // display the total details 4 cookies+2 request
		  response.setContentType("text/html");
		  PrintWriter writer = response.getWriter();

		  Cookie[] cookies = request.getCookies();

		  writer.println("<html>");
		  writer.println("<body bgcolor=sky blue >");
		  writer.println("<pre style ='color:pink'>");
		  writer.println("your  USERNAME..."+cookies[0].getValue());

		  writer.println("your AGE..."+cookies[1].getValue());

		  writer.println("your QUALIFICATION..."+cookies[2].getValue());

		  writer.println("your DESGINATION..."+cookies[03].getValue());


		  writer.println("your Email..."+request.getParameter("Email"));
		  writer.println("your Mobile..."+ request.getParameter("Mobile"));

		  writer.println("</pre>");
		  writer.println("</body>");
		  writer.println("</html>");
	}
}


