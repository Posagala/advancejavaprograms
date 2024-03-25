package com.sathya.productservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import java.util.Base64;

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
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read the Data
		String proId=request.getParameter("proId");
	    String updatedProductName=request.getParameter("proName");
	    
	    double updatedProductPrice = Double.parseDouble(request.getParameter("proPrice"));
	    String updatedProductBrand=request.getParameter("proBrand");
	    
	    String updatedProductMadeIn=request.getParameter("MadeIn");
	    Date updatedProductMfgDate=Date.valueOf(request.getParameter("MfgDate"));
	    Date updatedProductExpDate=Date.valueOf(request.getParameter("ExpDate"));
	    
	    Product product=new Product();
	    product.setProId(proId);
	    product.setProName(updatedProductName);
	    product.setProPrice(updatedProductPrice);
	    product.setProBrand(updatedProductBrand);
	    product.setMadeIn(updatedProductMadeIn);
	    product.setExpDate(updatedProductMfgDate);
	    product.setExpDate(updatedProductExpDate);
	    
	    Part Part=request.getPart("ProImage");//"newProImage" is the name of your file input field
	        InputStream inputStream=Part.getInputStream();
	        byte[] ProImage=IOUtils.toByteArray(inputStream);
	      
	     //taking the input and convert to inputstream and bytearray
	        
	        Part Part1=request.getPart("ProAudio");//"newProImage" is the name of your file input field
	        InputStream inputStream1=Part1.getInputStream();
	        byte[] ProAudio=IOUtils.toByteArray(inputStream1);
	        
	        
	        Part Part2=request.getPart("ProVideo");//"newProImage" is the name of your file input field
	        InputStream inputStream2=Part2.getInputStream();
	        byte[]ProVideo=IOUtils.toByteArray(inputStream2);
	      
	        //using above details created the product object
	        
	        Product Product=new Product();
		    product.setProId(proId);
		    product.setProName(updatedProductName);
		    product.setProPrice(updatedProductPrice);
		    product.setProBrand(updatedProductBrand);
		    product.setMadeIn(updatedProductMadeIn);
		    product.setExpDate(updatedProductMfgDate);
		    product.setExpDate(updatedProductExpDate);
		    product.setProImage(updatedProductProImage);
		    product.setProAudio(updatedProductProAudio);
		    product.setProVideo(updatedProductProVideo);
		    
		    //giving the product object to dao layer
	      