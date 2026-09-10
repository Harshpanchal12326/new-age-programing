package main

import (
	"fmt"
	"LAB2/mathutil"
	"LAB2/strop"
)

func main() {
	
	fmt.Println("===== String Utilities =====")
	var str string
	fmt.Print("Enter a string: ")
	fmt.Scan(&str)

	fmt.Printf("Original string: %s\n", str)
	fmt.Printf("Reversed string: %s\n", strop.Reverse(str))
	fmt.Printf("Vowel count: %d\n\n", strop.CountVowels(str))

	
	fmt.Println("===== Math Utilities =====")
	var num int
	fmt.Print("Enter a number for Factorial: ")
	fmt.Scan(&num)
	fmt.Printf("Factorial of %d is: %d\n\n", num, mathutil.Factorial(num))

	var base, exp int
	fmt.Print("Enter base: ")
	fmt.Scan(&base)
	fmt.Print("Enter exponent: ")
	fmt.Scan(&exp)
	fmt.Printf("%d to the power of %d is: %d\n", base, exp, mathutil.Power(base, exp))
}