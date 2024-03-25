function ConvertToFahrenheit()
{
// Read the Fahrenheit input store in variable
const fahrenheitInput=document.getElementById('fahrenheitInput').value;

// convert the FahrenheitInput to celsius
const celsiusTemparature =(parseFloat(fahrenheitInput)-32)*5/9;

// set the Output to Celsius to field
document.getElementById('celsiusOutput').value =celsiusTemparature.toFixed(2);
}