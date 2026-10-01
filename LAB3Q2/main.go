package main

import "fmt"


type Student struct {
	Name string
	Age  int
}


func modifyValue(ptr *int) {
	*ptr = *ptr + 10
}

func main() {
	
	fmt.Println("\n (1) Pointer Referencing & Dereferencing ")
	var num int = 25
	var ptr *int = &num

	fmt.Println("Original Value:", num)
	fmt.Println("Address using &:", ptr)
	fmt.Println("Value accessed using *:", *ptr)

	
	fmt.Println("\n (2) Pass-by-Reference using Pointer ")
	var count int = 50
	fmt.Println("Value before modifyValue():", count)
	modifyValue(&count)
	fmt.Println("Value after modifyValue():", count)

	
	fmt.Println("\n (3) Struct Allocation using new() ")
	s := new(Student)
	s.Name = "HARSH"
	s.Age = 21

	fmt.Println("Student Name:", s.Name)
	fmt.Println("Student Age:", s.Age)
}
