<%@ page language="java" contentType="text/html"%> 
<!DOCTYPE html> 
<html> 
<head> 

  
  <title> Edit form   </title> 
 <!-- BootStrap CDN link to Get the Support of BootStrap --> 
 <link rel="stylesheet" 
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"> 
  
 <!-- This is Java Script validation code location --> 
 <script src="Addproduct.js"></script> 
   
</head>
<body>
  <div class="container mt-5 text-center">
    <h2 class="text-center font-italic mb-1">Save Product Data...</h2>
    <form method="post" action="./UpdateProductServlet"
      enctype="multipart/form-data" onsubmit="return Addproduct()">

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proId">product
          ID:</label> <input type="text" class="form-control-sm" id="proId"
          name="proId" value="${existingproduct.proId}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proName">product
          Name:</label> <input type="text" class="form-control-sm" id="proName"
          name="proName" value="${existingproduct.proName}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proId">product
          Price:</label> <input type="text" class="form-control-sm" id="proPrice"
          name="proPrice" value="${existingproduct.proPrice}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proId">product
          Brand:</label> <input type="text" class="form-control-sm" id="proBrand"
          name="proBrand" value="${existingproduct.proBrand}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="MadeIn">Made
          IN:</label> <input type="text" class="form-control-sm" id="proMadeIn"
          name="proMadeIn" value="${existingproduct.proMadeIn}" required>
      </div>


      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proMfgDate">Mfg
          Date:</label> <input type="Date" class="form-control-sm" id="proMfgDate"
          name="proMfgDate" value="${existingproduct.proMfgDate}" required>
      </div>


      <div class="form-group">
        <label class="font-italic font-weight-bold" for="ExpDate">Exp
          Date:</label> <input type="Date" class="form-control-sm" id="proExpDate"
          name="proExpDate" value="${existingproduct.proExpDate}" required>
      </div>


    
      <!-- Display the current product image -->
      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proImage"> Current Product
          Image:</label> 
        <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingproduct.proImage)}"alt="product Image"
         style="max-width:100px;max-height:100px;">
        <input type="hidden" id="existingImage" name="existingImage" 
        value="${Base64.getEncoder().encodeToString(existingproduct.proImage)}"/> 
          
      </div>
      
      <!-- Allow the user to upload a new image -->
      <div class="form-group">
        <label class="font-italic font-weight-bold" for="newproImage"> New Product
          Image:</label> 
          <input type="file" class="form-control-file-sm" id="newproImage" name="newproImage" accept="image/*">
        </div>
        
        <div class="form-group">
        <input type="submit" class="btn btn-success" value="UpdateProductServlet" />
        <a href="productList.jsp" class="btn btn-primary">List of Products</a>
      </div>
    </form>
    </div>

</body>
</html>