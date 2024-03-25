<%@page import="com.sathya.productservlet.ProductDAO" import="java.util.Base64"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <title> Product List</title>
  <!-- BootStrap CDN link to Get the Support of BootStrap -->
   <link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
  <h1 class="text-success text-center">List of Products...</h1>
  
  <a href="Addproduct.html" class="btn btn-success">Save Product</a>
  
<div>
  <input type="text" placeholder="search">
</div>

<div>
  <c:if test="${saveResult==1}">
  <h1 class="text-primary text-center">Data Inserted Successfully....</h1>
  </c:if>
</div>

<div>
  <c:if test="${DeleteResult==1}">
  <h1 class="text-danger text-center">Data Deleted Successfully....</h1>
  </c:if>

  <c:if test="${DeleteResult==0}">
  <h1 class="text-danger text-center">Data Deleted Fail....</h1>
  </c:if>
</div>
  <table class="table table-bordered table-striped"> 
    <thead class="thead-dark">
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Product Brand</th>
        <th>Product MadeIn</th>
        <th>Product MfgDate</th>
        <th>Product ExpDate</th>
        <th>Product Image</th>
        <th>Product Audio</th>
        <th>Product Video</th>
        <th>Product Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="<%=new ProductDAO().findAll()%>">
      <tr>
        <td>${product.proId}</td>
        <td>${product.proName}</td>
        <td>${product.proPrice}</td>
        <td>${product.proBrand}</td>
        <td>${product.madeIn}</td>
        <td>${product.mfgDate}</td>
        <td>${product.expDate}</td>  
        
        <!--  Display image using img tag -->
        <td> 
        <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}"alt="Product Image"
         style="max-width:100px;max-height:100px;"></td>
         
         <!--  Display audio using audio tag -->
         <td>
           <audio controls>
           <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"type="audio/mpeg">
           </audio>
         </td>
         
         <!--  Display video using video tag -->
         <td>
           <video controls width="320" height="240">
           <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}"type="video/mp4">
           </video>
         </td>
           
         <td>
        <a href="./DeleteProductServlet?proId=${product.proId}"  class="btn btn-primary">Delete</a>
        
        <a href="./Editservlet?proId=${product.proId}"  class="btn btn-primary">Edit</a>
        
        
      </tr>
      </c:forEach>
    </tbody>
        
  </table>
</body>
</html>