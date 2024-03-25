function validateForm()
{
  //read the form data
  var proId = document.getElementById("proId").value;
  var proName = document.getElementById("proName").value;
  var proPrice = document.getElementById("proPrice").value;
  var proBrand = document.getElementById("proBrand").value;
  var MadeIn = document.getElementById("MadeIn").value;
  var MfgDate = document.getElementById("MfgDate").value;
  var ExpDate = document.getElementById("ExpDate").value;
  var proImage = document.getElementById("proImage").value;
  
  
  if(proId.trim()===""||  proName.trim()==="" ||
  proPrice.trim()=== ""||  proBrand.trim()==="" ||
  MadeIn.trim()=== "" || MfgDate.trim()=== "" ||
  ExpDate.trim()=== "" || proImage.trim()=== ""){
    alert("All fields must be filled out");
    return false;
  }
  
  if(parseFloat(proPrice) < 0){
    alert("proPrice must be a non-neative value");
    return false;
  }
  
   if("proName.length > 50  proBrand.length > 50") {
    alert("Product name and proBrand must be less than 50 characters");
    return false;
  }
  
  //get the mfg & exp dates
  var MfgDate = document.agetElementById("MfgDate").value;
  var ExpDate = document.getElementById("ExpDate").value;
  
  //convert into date format
  var manufacturingDateObj = new Date("MfgDate");
  var expiryDateObj = new Date("ExpDate");
  
  //check the validation of dates
  if(manufacturingDateObj > expiryDateObj) {
    alert("Manufacturing date cannot be greater than expiry date.");
    return false;
  }
  return true;
}