package com.sathya.jdbc;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	public class ProductDao {
	 //1.create product table
	 public int createProductTable() throws ClassNotFoundException, SQLException{
	  int res1=0;
	  try(Connection connection=Dbconnection.createConnection();
			  java.sql.Statement statement= connection.createStatement())
					  {
	   //create the table 
	   
	   res1=statement.executeUpdate("create table Pro(pId number,pName varchar2(30),pPrice number)");
	   System.out.println("Table Created Successfully..."+res1);
	  }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  return res1;
	 }
	 
	 //2.insert the data into pro table
	 public int saveProduct(Product prod) throws SQLException, ClassNotFoundException {
	  int res=0;
	  try(Connection connection=Dbconnection.createConnection();
	    PreparedStatement preparedStatement=connection.prepareStatement("insert into Pro values(?,?,?)"))
	  {
	   //read the data from pro and set into parameters
	   preparedStatement.setInt(1, prod.getpId());
	   preparedStatement.setString(2, prod.getpName());
	   preparedStatement.setDouble(3, prod.getpPrice());
	   
	   //EXECUTE THE QUERY
	   res=preparedStatement.executeUpdate();
	   
	  }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  return res;
	 }
	 
	 //3.getProductById()
	 public Product getProductById(int pId) throws ClassNotFoundException, SQLException {
		 Product product=null;
	  try(Connection connection=Dbconnection.createConnection();
	    PreparedStatement preparedStatement=connection.prepareStatement("select * from pro where pId=?"))
	  {
	   preparedStatement.setInt(1, pId);
	   
	   //store the data in resultSet object
	   ResultSet resultSet=preparedStatement.executeQuery();
	   if(resultSet.next()) {
	    product=new Product();
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
	 
	 
	 //4.getAllProducts
	 
	  public List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
	   List<Product> products=new ArrayList<>();
	   try(Connection connection=Dbconnection.createConnection();
	     java.sql.Statement statement=connection.createStatement())
	   {
	    ResultSet resultSet=statement.executeQuery("select * from pro");
	    while(resultSet.next())
	    {
	    	Product product=new Product();
	     product.setpId(resultSet.getInt(1));
	     product.setpName(resultSet.getString(2));
	     product.setpPrice(resultSet.getDouble(3));
	     
	     products.add(product);
	    }
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
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Pro where pId=?"))
             
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
      
      public int deleteBypSalary() throws SQLException
      {
        int res=0;
        
        
        try(Connection connection=Dbconnection.createConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Product where pSalary=?"))
        {
          
      int pPrice = 0;
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
      
      public int deleteProductTable() {
        int res1=0;
        try(Connection connection=Dbconnection.createConnection();
            Statement statement=connection.createStatement())
        {
          //create the table 
          
          res1=statement.executeUpdate("delete table Product(pId number,pName varchar(30),pSalary number)");
          System.out.println("Table deleted Successfully..."+res1);
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        return res1;
        
      }
	}
        
      
      
        
      
      
        


    
          
      
	  
	 
	
	