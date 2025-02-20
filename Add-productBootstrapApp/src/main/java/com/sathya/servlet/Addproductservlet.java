package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class Addproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response, Date proMfgDate) throws ServletException, IOException {
	
		// Read the data 
		  String proId=request.getParameter("proId"); 
		  String proName=request.getParameter("proName"); 
		  double proPrice=Double.parseDouble(request.getParameter("proPrice")); 
		  String proBrand=request.getParameter("proBrand"); 
		  String proMadeIn=request.getParameter("proMadeIn"); 
		   
		  Date proMfgDate1=Date.valueOf(request.getParameter("proMfgDate1")); 
		  Date proExpDate=Date.valueOf(request.getParameter("proExpDate")); 
		  
		  Part part=request.getPart("proImage"); 
		  InputStream inputStream=part.getInputStream(); 
		  
		  //conversion of InputStream into Byte[]
		  byte[]proImage = IOUtils.toByteArray(inputStream);
		  
		  //taking the input and coversion to inputstream and byte array
		  Part part1=request.getPart("proAudio");
		    InputStream inputStream1=part1.getInputStream();
		    byte[] proAudio = IOUtils.toByteArray(inputStream1);
		    
		    Part part2=request.getPart("proVideo");
		    InputStream inputStream2=part2.getInputStream();
		    byte[] proVideo= IOUtils.toByteArray(inputStream2);
		    
		  
		    //using above details create the product object
		    
		    product product=new product();
		    product.setProId(proId);
		    product.setProName(proName);
		    product.setProPrice(proPrice);
		    product.setProBrand(proBrand);
		    product.setProMadeIn(proMadeIn);
		    product.setProMfgDate(proMfgDate1);
		    product.setProExpDate(proExpDate);
		    product.setProImage(proImage);
		    product.setProAudio(proAudio);
		    product.setProVideo(proVideo);
		    
		    //giving the product object to productdDao layer save method to save the data
		    productdao productDao=new productdao();
		    int result=0;
		    
		    try {
		      result=productDao.saveProduct(product);
		    } catch (Exception e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
		     
	
		    
		  
		    if(result==1) {
		      //To send the data to JSP file add the result
		      request.setAttribute("saveResult",result);
		      RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
		      dispatcher.forward(request, response);
		    }
		    else
		    {
		      response.setContentType("text/html");
		      PrintWriter writer=response.getWriter();
		      writer.println("Data Inserted Fail Check Once..."+result);
		      RequestDispatcher dispatcher=request.getRequestDispatcher("Addproduct.html");
		      dispatcher.include(request, response);
		      
		    }
		  }

		}