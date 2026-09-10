package mathutil

// Factorial calculates factorial using a simple loop
func Factorial(n int) int {
	fact := 1
	for i := 1; i <= n; i++ {
		fact = fact * i
	}
	return fact
}

// Power calculates base^exp using a simple loop
func Power(base int, exp int) int {
	result := 1
	for i := 1; i <= exp; i++ {
		result = result * base
	}
	return result
}