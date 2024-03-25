package com.sathya.jdbc;

import java.sql.SQLException;
import java.util.List;


public class databaseclient {
		 
		 public static void main(String[] args) throws ClassNotFoundException, SQLException {
			 ProductDao dao=new ProductDao();
		     //   int res=dao.createProductTable();
		  //  System.out.println("Table Created Successfully..."+res);
		//---------------------------------------------------------------------------------------------
		        
		        //call saveProduct() method
		   // int res1=dao.saveProduct(new Product(1001, "keyboard", 40));
		  // System.out.println("Record created successfully" +res1);
		   //  int res2=dao.saveProduct(new Product(1002, "salt", 20));
		    //  System.out.println("Record created successfully" +res2);
		//---------------------------------------------------------------------------------------------
		        
		        //call getProductById
		    // Product product=dao.getProductById(1002);
		     // System.out.println(product);
		//---------------------------------------------------------------------------------------------
		        
		        //getAllProducts
		        
		    //    List<Product> list=dao.getAllProducts();
		   //   list.stream().forEach(a ->System.out.println(a));
		//------------------------------------------------------------------------------------------
		      
		      
		      //Updated Price
		      
		    // int res1=dao.updateByPrice(10,50);
		    // System.out.println("rows are Updated"+res1);
		      
		//------------------------------------------------------------------------------------------
		    
		        
		    //deletebyId
		        
		     //  int res2=dao.deleteById(1001);
		     //   System.out.println("Recorded deleted succesfully"+res2);
		//------------------------------------------------------------------------------------------

		      //deletedbyPrice
		        
		    //  int res=dao.deleteByPrice(80);
		     // System.out.println("Record deleted succesfuly"+res);
		      
		//------------------------------------------------------------------------------------------

		      //delete Product table
		      
		      int res1=dao.deleteProductTable();
		      System.out.println("table deleted succesfully..."+res1);
		      }
		      

		    }