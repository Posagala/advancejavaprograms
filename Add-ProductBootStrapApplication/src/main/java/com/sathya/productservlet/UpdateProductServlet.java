package com.sathya.productservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
	    String updatedproductName=request.getParameter("proName");
	    
	    double updatedproductPrice = Double.parseDouble(request.getParameter("proPrice"));
	    String updatedproductBrand=request.getParameter("proBrand");
	    
	    String updatedproductMadeIn=request.getParameter("MadeIn");
	    Date updatedproducMfgDate=Date.valueOf(request.getParameter("MfgDate"));
	    Date updatedproductExpDate=Date.valueOf(request.getParameter("ExpDate"));
	    
	    Product product=new Product();
	    product.setProId(proId);
	    product.setProName(updatedproductName);
	    product.setProPrice(updatedproductPrice);
	    product.setProBrand(updatedproductBrand);
	    product.setMadeIn(updatedproductMadeIn);
	    product.setMfgDate(updatedproducMfgDate);
	    product.setExpDate(updatedproductExpDate);
	    
	    Part filePart=request.getPart("newProImage");//"newProImage" is the name of your file input field
	      if(filePart != null && filePart.getSize()>0)
	      {
	        InputStream inputStream=filePart.getInputStream();
	        byte[] newProImage=IOUtils.toByteArray(inputStream);
	        product.setProImage(newProImage);
	      }
	      else
	      {
	       String s=request.getParameter("existingImage");  
	        
	        byte[] existingImage=Base64.getDecoder().decode(s);
	        product.setProImage(existingImage);
	        
	      }
	        
	      ProductDAO productDao=new ProductDAO();
	      int result=0;
	      
	      
	      result = productDao.updateById(product);
	      
	      if(result==1)
	      {
	        
	        RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
	        dispatcher.forward(request, response);
	      }
	      else
	      {
	        response.setContentType("text/html");
	        PrintWriter writer=response.getWriter();
	        writer.println("Data Updated  Fail Check Once..."+result);
	        RequestDispatcher dispatcher=request.getRequestDispatcher("UpdateProductServlet");
	        dispatcher.include(request, response);
	      }
	      
	  }
	
	}


