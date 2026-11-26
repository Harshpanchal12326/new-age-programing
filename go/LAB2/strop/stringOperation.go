package strop


func Reverse(s string) string {
	reversed := ""
	for i := len(s) - 1; i >= 0; i-- {
		reversed = reversed + string(s[i])
	}
	return reversed
}


func CountVowels(s string) int {
	count := 0
	for i := 0; i < len(s); i++ {
		ch := s[i]
		if ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
			ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' {
			count++
		}
	}
	return count
}