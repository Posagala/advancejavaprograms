package com.Sathya.Servlet;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@WebServlet("/NumberServlet")
public class NumberServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

    
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //step:1 Read the required data
    int start = Integer.parseInt(request.getParameter("First"));
    int end = Integer.parseInt(request.getParameter("End"));
    String operation = request.getParameter("operation");
    
    //step:2 Process the data
    ArrayList<Integer> al = new ArrayList<Integer>();
    switch(operation)
    {
    case "Even" :
     for(int i=start;i<=end;i++)
     {
      if(i%2==0)
       al.add(i);
     }
     break;
    case "Odd" :
     for(int i=start;i<=end;i++)
     {
      if(i%2!=0)
       al.add(i);
     }
     break;
    case "Prime" :
     for(int i=start;i<=end;i++)
     {
      int count=0;
      for(int j=2;j<i;j++)
      {
       if(i%j==0)
        count++;
      }
      if(count==0)
       al.add(i);
     }
     break;
    case "Perfect" :
     for (int i=start;i<=end;i++)
     {
              int sum = 0;
              for (int j=1; j<i;j++) 
              {
                  if (i%j==0)
                  {
                      sum+=j;
                  }
              }
              if (sum==i)
              {
               al.add(i);
      }
     }
     break;
    case "Strong" :
     for (int i=start;i<=end;i++) {
              int num=i;
              int sum=0;
              int temp=num;
              int factorialSum=0;

              while (temp != 0) {
                  int digit=temp % 10;
                  int fact=1;
                  for (int j=1; j<=digit; j++) {
                      fact *=j;
                  }
                  factorialSum+=fact;
                  temp/=10;
              }
              if (factorialSum==num) {
                  al.add(num);
              }
          }
     break;
    }
    
    
    //step:3 Render the response 
    response.setContentType("text/html");
          PrintWriter writer = response.getWriter();
    writer.println("<html>");
    writer.println("<body>");
    writer.println("<p>First Number:"+start+"</p>");
         writer.println("<p>Second Number:"+end+"</p>");
         writer.println("<p>your oparetion Symble: " +operation+ "</p>");
    writer.println("<p>Your Result:"+al+"</p>");
    writer.println("<body>");
    writer.println("</html>");  
        }
 }