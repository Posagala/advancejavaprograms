package com.sathya.productservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	
				public int saveProduct(Product product) throws SQLException, ClassNotFoundException {

					int count=0;
					try(Connection connection=DbConnection.createConnection();
					
					
						PreparedStatement preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)");)
					{
				        // read the data from pro and set into parameters
				        preparedStatement.setString(1, product.getProId());
				        preparedStatement.setString(2, product.getProName());

				        preparedStatement.setDouble(3, product.getProPrice());
				        preparedStatement.setString(4, product.getProBrand());
				        preparedStatement.setString(5, product.getMadeIn());

				        preparedStatement.setDate(6, product.getMfgDate());
				        preparedStatement.setDate(7, product.getExpDate());

				        preparedStatement.setBytes(8, product.getProImage());
				        preparedStatement.setBytes(9, product.getProAudio());
				        preparedStatement.setBytes(10, product.getProVideo());
				        

				        count = preparedStatement.executeUpdate();

				      }
				     catch (SQLException e) {
				      e.printStackTrace();
				    }

				    return count;
				  }


				  // 2.findAll() get all products
				  public List<Product> findAll() {
				    List<Product> productList = new ArrayList<>();
				    try (Connection connection = DbConnection.createConnection();
				    Statement statement=   connection.createStatement()){
				      ResultSet resultSet = statement.executeQuery("select * from product_data");
				      while (resultSet.next()) {
				        Product product = new Product();
				        product.setProId(resultSet.getString("proId"));
				        product.setProName(resultSet.getString("proName"));
				        product.setProPrice(resultSet.getDouble("proPrice"));
				        product.setProBrand(resultSet.getString("proBrand"));
				        product.setMadeIn(resultSet.getString("MadeIn"));
				        product.setMfgDate(resultSet.getDate("MfgDate"));
				        product.setExpDate(resultSet.getDate("ExpDate"));
				        product.setProImage(resultSet.getBytes("proImage"));
				        product.setProAudio(resultSet.getBytes("proAudio"));
				        product.setProVideo(resultSet.getBytes("proVideo"));
				        
				        productList.add(product);
				      }
				    } catch (SQLException e) {
				      e.printStackTrace();
				    }
				    return productList;
				  }

				  // 3.Delete by id

				  public int deleteById(String proId) {
				    int res = 0;

				    try (Connection connection = DbConnection.createConnection();
				        PreparedStatement preparedStatement = connection
				            .prepareStatement("delete from product_data where proId=?"))

				    {

				      // set the data to parameter

				      preparedStatement.setString(1, proId);

				      // execute the updated
				      res = preparedStatement.executeUpdate();
				    } catch (SQLException e) {
				      e.printStackTrace();
				    }
				    return res;

				  }
				  //find by id
				  public Product findById(String proId) 
				    {
				     // try with resources
				    Product product  = null;

				     try(Connection connection = DbConnection.createConnection();
				       PreparedStatement preparedStatement = connection.prepareStatement("select * from product_data where proId=?"))
				     {
				      // set the data to parameter
				      preparedStatement.setString(1, proId);
				      // execute the query
				      ResultSet resultset = preparedStatement.executeQuery();

				
				if(resultset.next()) {
				         // read the data from ResultSet to product object
				          product = new Product();
				           product.setProId(resultset.getString("ProId"));
				       product.setProName(resultset.getString("ProName"));
				       product.setProPrice(Double.parseDouble(resultset.getString("ProPrice")));
				       product.setProBrand(resultset.getString("ProBrand"));
				       product.setMadeIn(resultset.getString("MadeIn"));
				       product.setMfgDate(resultset.getDate("MfgDate"));
				       product.setExpDate(resultset.getDate("ExpDate"));
				       product.setProImage(resultset.getBytes("proImage"));           
				       }
				     }
				       catch(SQLException e)
				       { 
				        e.printStackTrace();
				       }

				      return product;
				    }

				  // update byId
				  public int updateById(Product product) 
				    {
				      String sql="update product_data SET proName=?,proPrice=?,proBrand=?,proMadeIn=?,MfgDate=?,ExpDate=?, proImage=? where proId=?";
				      
				      int updateResult = 0;
				      try(Connection connection=DbConnection.createConnection()){
				          PreparedStatement preparedStatement=connection.prepareStatement(sql);
				          preparedStatement.setString(1, product.getProName());
				          preparedStatement.setDouble(2, product.getProPrice());
				          preparedStatement.setString(3, product.getProBrand());
				          preparedStatement.setString(4, product.getMadeIn());
				          preparedStatement.setDate(5, product.getMfgDate());
				          preparedStatement.setDate(6, product.getExpDate());
				          preparedStatement.setBytes(7, product.getProImage());
				          preparedStatement.setString(8, product.getProId());
				          updateResult = preparedStatement.executeUpdate();
				            
				          }
				      catch(SQLException e)
				      {
				        e.printStackTrace();
				      }
				      
				      return updateResult;
				    }
				}