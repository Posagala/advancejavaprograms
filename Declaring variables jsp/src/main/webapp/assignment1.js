var mRatan=parseInt(prompt("enter the mass of Ratan"));
var hRatan=parseInt(prompt("enter the height of Ratan"));
var mAnu=parseInt(prompt("enter the mass of Anu"));
var hAnu=parseInt(prompt("enter the height of Anu")); 
var BMIRatan,BMIAnu;
 BMIRatan=mRatan/(hRatan+hRatan);
  BMIAnu=BMIAnu/(hAnu+hAnu);
  //alert("Body Mass Index of(BMI)of Ratan :"BMIRatan);
  //alert("Body Mass Index of(BMI)of Anu :"BMIAnu);
  
  console.log("Body Mass Index of(BMI)of Ratan :"+BMIRatan);
  console.log("Body Mass Index of(BMI)of Anu :"+BMIAnu);

  document.write("Body Mass Index of(BMI)of Ratan :"+BMIRatan);
  document.write("Body Mass Index of(BMI)of Anu :"+BMIAnu);
  if(BMIRatan>BMIAnu)
  {
	  var RatanHigherBMI=true;
	  console.log(RatanHigherBMI);
	  document.write(RatanHigherBMI)
  }

   