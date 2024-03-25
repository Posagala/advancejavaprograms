function dollarToINRConversion()
{
 const dollarInput=document.getElementById("dollar").value;
 const inrOutput=parseFloat( dollarInput)*82.90;
 document.getElementById("inr").value=inrOutput.toFixed(3);
}