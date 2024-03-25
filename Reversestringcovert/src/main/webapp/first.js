function reverseString() {
	
				var inputText = document.getElementById("NameInput").value;
				
				var reversedText = inputText.split('').reverse().join('');
				
				document.getElementById("ReverseOutput").value = reversedText;
				}