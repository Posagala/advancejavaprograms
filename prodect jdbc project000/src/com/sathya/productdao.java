package com.sathya;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class productdao {
	 //1.create product table
	 public int createProductTable() throws ClassNotFoundException, SQLException{
	  int res1=0;
	  try(Connection connection=Dbconnection.createConnection();
	    Statement statement=connection.createStatement())
	  {
	   //create the table 
	   
	   res1=statement.executeUpdate("create table product(pId number,pName varchar(30),pPrice number)");
	   System.out.println("Table Created Successfully..."+res1);
	  }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  return res1;
	 }
	 
	 //2.insert the data into pro table
	 public int saveProduct(product product) throws SQLException, ClassNotFoundException {
	  int res=0;
	  try(Connection connection=Dbconnection.createConnection();
	    PreparedStatement preparedStatement=connection.prepareStatement("insert into product values(?,?,?)"))
	  {
	   //read the data from pro and set into parameters
	   preparedStatement.setInt(1, product.getpId());
	   preparedStatement.setString(2, product.getpName());
	   preparedStatement.setDouble(3, product.getpPrice());
	   
	   //EXECUTE THE QUERY
	   res=preparedStatement.executeUpdate();
	   
	  }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  return res;
	 }
	 
	 //3.getProductById()
	 public product getProductById(int pId) throws ClassNotFoundException, SQLException {
		 product product=null;
	  try(Connection connection=Dbconnection.createConnection();
	    PreparedStatement preparedStatement=connection.prepareStatement("select * from product where pId=?"))
	  {
	   preparedStatement.setInt(1, pId);
	   
	   //store the data in resultSet object
	   ResultSet resultSet=preparedStatement.executeQuery();
	   if(resultSet.next()) {
	    product=new product();
	    product.setpId(resultSet.getInt(1));
	    product.setpName(resultSet.getString(2));
	    product.setpPrice(resultSet.getDouble(3));
	   }
	   
	   
	  }
	  catch(SQLException e) {
	   e.printStackTrace();
	  }
	  return product;
	 }
	 
	 
	 //4.find AllProducts
	 
	  public List<product> getAllProducts() throws ClassNotFoundException{
	   List<product> products=new ArrayList<>();
	   try(Connection connection=Dbconnection.createConnection();
	     Statement statement=connection.createStatement())
	   {
	    ResultSet resultSet=statement.executeQuery("select * from product");
	    while(resultSet.next()) {
	    	product product=new product();
	     product.setpId(resultSet.getInt(1));
	     product.setpName(resultSet.getString(2));
	     product.setpPrice(resultSet.getDouble(3));
	     
	     products.add(product);
	    }
	   }
	   catch(SQLException e) {
	    e.printStackTrace();
	   }
	   return products;
	  }
	  
//5.UbdateByPrice
      
      public int updateByPrice(double currentValue,double IncrementValue)
      {
        int res=0;
    
      
      //try with Resources
      try(Connection connection=Dbconnection.createConnection();
          PreparedStatement preparedStatement=connection.prepareStatement("update Product  set pPrice=pPrice+?  where pPrice>?"))
      {
        //set the data to parameter
        preparedStatement.setDouble(1, IncrementValue);
        preparedStatement.setDouble(2, currentValue);
        
        //Excute Update
        
        res=preparedStatement.executeUpdate();
      }
      catch(SQLException e)
      {
        e.printStackTrace();
      }
      return res;
      }
     
      //6.deletebyId
      
      public int deleteById(int pId) throws SQLException
      {
        int res=0;
        
        try(Connection connection=Dbconnection.createConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Product where pId=?"))    
        {
          
          // set the data to parameter
          
          preparedStatement.setInt(1, pId);
          
          //excute the updated
          res=preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
          e.printStackTrace();
        }
        return res;
      }
      
      //7.delete by Price
      
      public int deleteByPrice(int pPrice) throws SQLException
      {
        int res=0;
        
        
        try(Connection connection=Dbconnection.createConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Product where pPrice=?"))
        {
          
      //set the daata to parameter
          preparedStatement.setInt(1, pPrice);
          
        //Excute updated
          res=preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
          e.printStackTrace();
        }
        return res;
      }
      
      //8.deleteProductTbale
      
      public int deleteProductTable(String proId ) {
        int result=0;
        try(Connection connection=Dbconnection.createConnection();
            PreparedStatement statement=connection.prepareStatement("delete table Product_data where proId=?)"))
        {
          //create the table 
          statement.setString(1,proId);
          result=statement.executeUpdate();
      
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        return result;
        
      }
}