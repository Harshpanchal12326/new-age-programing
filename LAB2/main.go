package main

import (
	"fmt"
	"LAB2/mathutil"
)

func main() {
	var a int
	var b int

	fmt.Print("enter number 1 :")
	fmt.Scan(&a)

	fmt.Print("enter number 2 :")
	fmt.Scan(&b)

	fmt.Printf("sum is = %d\n", mathutil.Add(a, b))
}

func PrintStr(s string){
	fmt.Println(s)

}
