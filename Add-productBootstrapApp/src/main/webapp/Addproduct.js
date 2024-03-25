function Addproduct() 
{ 
 //Read the form data 
 var proId=document.getElementById("proId").value; 
 var proName=document.getElementById("proName").value; 
 var proPrice=document.getElementById("proPrice").value; 
 var proBrand=document.getElementById("proBrand").value; 
 var proMadeIn=document.getElementById("proMadeIn").value; 
 var proMfgDate=document.getElementById("proMfgDate").value; 
 var proExpDate=document.getElementById("proExpDate").value; 
 var proImage=document.getElementById("proImage").value; 
 
     if(proId.trim()===""|| proName.trim()===""|| 
     proPrice.trim()===""|| proBrand.trim()===""|| 
     proMadeIn.trim()===""){ 
      alert("All fields must be filled out"); 
      return false; 
} 
 
 if(parseFloat(proPrice)< 0){ 
  alter("proPrice must  be a non-neative value"); 
  return false 
 } 
  
 if(proName.length > 50|| proBrand.length > 50){ 
  alert("Product name and proBrand must be less than 50 characters"); 
  return false; 
 } 
 //get the &exp dates 

  
 //convert into date format 
  
 var manufacturingDateObj = new Date("proMfgDate"); 
 var ExpiryDateObj=new Date("proExpDate"); 
  
 //check the validation of dates 
 if(manufacturingDateObj>ExpiryDateObj){ 
  alert("Manufacturing date cannot greater than expiry date"); 
  return false; 
  } 
  return true; 
  }