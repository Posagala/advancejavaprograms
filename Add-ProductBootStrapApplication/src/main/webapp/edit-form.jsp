<%@ page language="java" contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<title>Edit form....</title>
<!-- BootStrap CDN link to Get the Support of BootStrap -->
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- This is java script validation code location  -->
<script src="formvalidation.js"></script>
</head>
<body>
  <div class="container mt-5 text-center">
    <h2 class="text-center font-italic mb-1">Save Product Data...</h2>
    <form method="post" action="./UpdateProductServlet"
      enctype="multipart/form-data" onsubmit="return validateForm()">

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proId">Product
          ID:</label> <input type="text" class="form-control-sm" id="proId"
          name="proId" value="${existingProduct.proId}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proName">Product
          Name:</label> <input type="text" class="form-control-sm" id="proName"
          name="proName" value="${existingProduct.proName}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proId">Product
          Price:</label> <input type="text" class="form-control-sm" id="proPrice"
          name="proPrice" value="${existingProduct.proPrice}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proId">Product
          Brand:</label> <input type="text" class="form-control-sm" id="proBrand"
          name="proBrand" value="${existingProduct.proBrand}" required>
      </div>

      <div class="form-group">
        <label class="font-italic font-weight-bold" for="MadeIn">Made
          IN:</label> <input type="text" class="form-control-sm" id="MadeIn"
          name="MadeIn" value="${existingProduct.madeIn}" required>
      </div>


      <div class="form-group">
        <label class="font-italic font-weight-bold" for="MfgDate">Mfg
          Date:</label> <input type="Date" class="form-control-sm" id="MfgDate"
          name="MfgDate" value="${existingProduct.mfgDate}" required>
      </div>


      <div class="form-group">
        <label class="font-italic font-weight-bold" for="ExpDate">Exp
          Date:</label> <input type="Date" class="form-control-sm" id="ExpDate"
          name="ExpDate" value="${existingProduct.expDate}" required>
      </div>


    
      <!-- Display the current product image -->
      <div class="form-group">
        <label class="font-italic font-weight-bold" for="proImage"> Current Product
          Image:</label> 
        <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}"alt="Product Image"
         style="max-width:100px;max-height:100px;">
        <input type="hidden" id="existingImage" name="existingImage" 
        value="${Base64.getEncoder().encodeToString(existingProduct.proImage)}"/> 
          
      </div>
      
      <!-- Allow the user to upload a new image -->
      <div class="form-group">
        <label class="font-italic font-weight-bold" for="newproImage"> New Product
          Image:</label> 
          <input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*">
        </div>
        
        <div class="form-group">
        <input type="submit" class="btn btn-success" value="save product" />
        <a href="productList.jsp" class="btn btn-primary">List of Products</a>
      </div>
    </form>
    </div>

</body>
</html>