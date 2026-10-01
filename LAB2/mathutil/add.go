package mathutil


func Factorial(n int) int {
	fact := 1
	for i := 1; i <= n; i++ {
		fact = fact * i
	}
	return fact
}


func Power(base int, exp int) int {
	result := 1
	for i := 1; i <= exp; i++ {
		result = result * base
	}
	return result
}