package com.sathya.servlet;

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


@WebServlet("/Upadteproductservlet")
public class Upadteproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Read the data 
		  String UpadteproductproId=request.getParameter("proId"); 
		  String UpadteproductproName=request.getParameter("proName"); 
		  
		  double UpadteproductproPrice=Double.parseDouble(request.getParameter("proPrice")); 
		  String UpadteproductproBrand=request.getParameter("proBrand"); 
		  
		  String UpadteproductMadeIn=request.getParameter("proMadeIn"); 
		  Date UpadteproductMfgDate=Date.valueOf(request.getParameter("proMfgDate")); 
		  Date UpadteproductExpDate=Date.valueOf(request.getParameter("proExpDate")); 
		  
		//create product object
		  product product=new product();
			product.setProId(UpadteproductproId);
			product.setProName(UpadteproductproName);
			product.setProPrice(UpadteproductproPrice);
			product.setProBrand(UpadteproductproBrand);
			product.setProMadeIn(UpadteproductMadeIn);
			product.setProMfgDate(UpadteproductMfgDate);
			product.setProExpDate(UpadteproductExpDate);
			
	//Reading image and validating
			
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
		      
		      productdao productDao=new productdao();
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
		        RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
		        dispatcher.include(request, response);
		      }
		      
		  }
		}