function isPalindrome(number) {
    const originalNumber = number;
    const reversedNumber = parseInt(number.toString().split('').reverse().join(''));

    return originalNumber === reversedNumber;
}

// Example usage:
const number = 121;
if (isPalindrome(number)) {
    console.log( "is a palindrome.");
} else {
    console.log("is not a palindrome.");
}