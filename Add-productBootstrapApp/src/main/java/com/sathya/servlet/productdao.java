package com.sathya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class productdao {

	public int saveProduct(product product) throws SQLException,ClassNotFoundException {

		// Declare the resources
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int count = 0;
		try {
			connection = Dbconnection.createConnection();

			PreparedStatement prepareStatement = connection
					.prepareStatement("insert into product_Data values(?,?,?,?,?,?,?,?,?,?)");

			// read the data from pro and set into parameters
			prepareStatement.setString(1, product.getProId());
			prepareStatement.setString(2, product.getProName());
			prepareStatement.setDouble(3, product.getProPrice());
			prepareStatement.setString(4, product.getProBrand());
			prepareStatement.setString(5, product.getProMadeIn());
			prepareStatement.setDate(6, product.getProMfgDate());
			prepareStatement.setDate(7, product.getProExpDate());
			prepareStatement.setBytes(8, product.getProImage());
			prepareStatement.setBytes(9, product.getProAudio());
			prepareStatement.setBytes(10, product.getProVideo());
	        
;
			count = prepareStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// Before release the connection check the connection prsnt or not
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return count;
	}
	// 4.find AllProducts

	public List<product> findAll1() throws ClassNotFoundException {
		List<product> productList = new ArrayList<>();
		try (Connection connection = Dbconnection.createConnection();
				Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from product_data");
			while (resultSet.next()) {
				product product = new product();
				product.setProId(resultSet.getString("ProId"));
				product.setProName(resultSet.getString("ProName"));
				product.setProPrice(resultSet.getDouble("ProPrice"));
				product.setProBrand(resultSet.getString("ProBrand"));
				product.setProMadeIn(resultSet.getString("ProMadeIn"));
				product.setProMfgDate(resultSet.getDate("ProMfgDate"));
				product.setProExpDate(resultSet.getDate("ProExpDate"));
				product.setProImage(resultSet.getBytes("proImage"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

//6.deletebyId

	public int deleteById1(String proId) throws ClassNotFoundException, SQLException {
		int result = 0;

		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from Product_Data where proId=?"))

		{

			// set the data to parameter

			preparedStatement.setString(1, proId);

			result = preparedStatement.executeUpdate();
		}
		return result;
	}

	

			  public int saveProduct1(product product) throws SQLException, ClassNotFoundException {

			    // Declare the resources
			    Connection connection = null;
			    PreparedStatement preparedStatement = null;

			    int count = 0;
			    try {
			      // get the connection
			      connection = Dbconnection.createConnection();

			      // create the PreparedStatement Object

			      preparedStatement = connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)");
			      {
			        // read the data from pro and set into parameters
			        preparedStatement.setString(1, product.getProId());
			        preparedStatement.setString(2, product.getProName());

			        preparedStatement.setDouble(3, product.getProPrice());
			        preparedStatement.setString(4, product.getProBrand());
			        preparedStatement.setString(5, product.getProMadeIn());

			        preparedStatement.setDate(6, product.getProMfgDate());
			        preparedStatement.setDate(7, product.getProExpDate());

			        preparedStatement.setBytes(8, product.getProImage());
			        preparedStatement.setBytes(9, product.getProAudio());
			        preparedStatement.setBytes(10, product.getProVideo());
			        

			        count = preparedStatement.executeUpdate();

			      }
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }

			    finally {

			      // before release connection check the connection present or not

			      if (connection != null)
			        connection.close();
			      if (preparedStatement != null)
			        preparedStatement.close();
			    }
			    return count;
			  }

			  // 2.findAll() get all products
			  public List<product> findAll() {
			    List<product> productList = new ArrayList<>();
			    try (Connection connection = Dbconnection.createConnection();
			        Statement statement = connection.createStatement()) {
			      ResultSet resultSet = statement.executeQuery("select * from product_data");
			      while (resultSet.next()) {
			        product product = new product();
			        product.setProId(resultSet.getString("proId"));
			        product.setProName(resultSet.getString("proName"));
			        product.setProPrice(resultSet.getDouble("proPrice"));
			        product.setProBrand(resultSet.getString("proBrand"));
			        product.setProMadeIn(resultSet.getString("MadeIn"));
			        product.setProMfgDate(resultSet.getDate("proMfgDate"));
			        product.setProExpDate(resultSet.getDate("proExpDate"));
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

			    try (Connection connection = Dbconnection.createConnection();
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
			  public product findById(String proId) 
			    {
			     // try with resources
			    product product  = null;

			     try(Connection connection = Dbconnection.createConnection();
			       PreparedStatement preparedStatement = connection.prepareStatement("select * from product_data where proId=?"))
			     {
			      // set the data to parameter
			      preparedStatement.setString(1, proId);
			      // execute the query
			      ResultSet resultset = preparedStatement.executeQuery();

			if(resultset.next()) {
			         // read the data from ResultSet to product object
			          product = new product();
			           product.setProId(resultset.getString("ProId"));
			       product.setProName(resultset.getString("ProName"));
			       product.setProPrice(Double.parseDouble(resultset.getString("ProPrice")));
			       product.setProBrand(resultset.getString("ProBrand"));
			       product.setProMadeIn(resultset.getString("proMadeIn"));
			       product.setProMfgDate(resultset.getDate("proMfgDate"));
			       product.setProExpDate(resultset.getDate("proExpDate"));
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
			  public int updateById(product product) 
			    {
			      String sql="update product SET proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpDate=?, proImage=? where proId=?";
			      
			      int updateResult = 0;
			      try(Connection connection=Dbconnection.createConnection()){
			          PreparedStatement preparedStatement=connection.prepareStatement(sql);
			          preparedStatement.setString(1, product.getProName());
			          preparedStatement.setDouble(2, product.getProPrice());
			          preparedStatement.setString(3, product.getProBrand());
			          preparedStatement.setString(4, product.getProMadeIn());
			          preparedStatement.setDate(5, product.getProExpDate());
			          preparedStatement.setDate(6, product.getProExpDate());
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

			 