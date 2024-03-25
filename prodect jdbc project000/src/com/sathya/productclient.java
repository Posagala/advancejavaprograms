package com.sathya;

import java.sql.SQLException;
import java.util.List;

public class productclient {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		productdao dao=new productdao();
		//  int res=dao.createProductTable();
		 // System.out.println("Table Created Successfully..."+res);
		//---------------------------------------------------------------------------------------------
		  
		  //call saveProduct() method
		 // int res1=dao.saveProduct(new product(1001, "mobiles", 40000));
		//  System.out.println("Record created successfully" +res1);
		//  int res2=dao.saveProduct(new product(1002,"tv",10000));
		 // System.out.println("Record created successfully" +res2);
		//---------------------------------------------------------------------------------------------
		  
		  //call getProductById
		 product product=dao.getProductById(1002);
		  System.out.println(product);
		//---------------------------------------------------------------------------------------------
		  
		  //getAllProducts
		  
		//  List<product> list=dao.getAllProducts();
		 //list.stream().forEach(a ->System.out.println(a));
		//---------------------------------------------------------------------------------------------
		  
		   //Updated Price
	      
	     // int res=dao.updateByPrice(10,50);
	      //System.out.println("rows are Updated"+res);
	      
	//------------------------------------------------------------------------------------------
	    
	        
	    //deletebyId
	        
	       //int res=dao.deleteById(1001);
	       // System.out.println("Recorded deleted succesfully"+res);
	//------------------------------------------------------------------------------------------

	      //deletedbyPrice
	        
	   //  int res=dao.deleteByPrice(50);
	    //  System.out.println("Record deleted succesfuly"+res);
	      
	//------------------------------------------------------------------------------------------

	      //delete Product table
	      
	  //    int res1=dao.deleteProductTable();
	    // System.out.println("table deleted succesfully..."+res1);
	      }
	      

		  
		 }
		 

		


