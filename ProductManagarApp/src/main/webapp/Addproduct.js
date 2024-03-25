function validateForm()
{
	//read the form data
	var proId = document. getElementById("proId").value;
	var proName = document. getElementById("proName").value;
	var proPrice = document. getElementById("proPrice").value;
	var proBrand= document. getElementById("proBrand").value;
	var proMadeIN= document. getElementById("MadeIN").value;
	var mfgDate= document. getElementById("mfgDate").value;
	var ExpDate= document. getElementById("ExpDate").value;
	var proImage= document. getElementById("proImage").value;
	
	
	if(proId.trim()===""||proName.trim()===""||
	 proPrice.trim()===""||proBrand.trim()===""||
	 proMadeIN.trim()===""||mfgDate.trim()==""||
	ExpDate.trim()===""||proImage.trim()==="" ){
	 alert("All fields must be faild out");
	 return false;
	 }
	 
	 if(parseFloat(proPrice) <0){
		 alert("proPrice must be non-neative value");
		 return false;
	 }
	if(proName.length > 50 || proBrand.length >50){
		alert("product name and proBrand must be less than 50 charaters");
		return false;
	}
	
	//get the mfg & exp dates
	var mfgDate = document.getElementById("mfgDate").value;
	var ExpDate = document.getElementById("ExpDate").value;
	
	//convert in to Data format
	var manufacturingDataobj = new Data(mfgDate);
	var expiryDataobj = new Data(ExpDate);
	
	//check the validation of dates
	if(manufacturingDataobj>expiryDataobj){
		alert("manufacturing date can not be greater than expiry date");
		return false;
		}
		return true;
		
	}
	
	
	
	
	
	
	