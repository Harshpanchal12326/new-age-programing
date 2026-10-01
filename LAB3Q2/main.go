package main

import "fmt"

type Student struct {
	Name string
	Age  int
}

func inputNumber(ptr *int) {
	*ptr = 50
}

func modifyValue(ptr *int) {
	*ptr = *ptr + 10
}

func inputStudent(s *Student) {
	fmt.Print("Enter Student Name: ")
	fmt.Scan(&s.Name)
	fmt.Print("Enter Student Age: ")
	fmt.Scan(&s.Age)
}

func main() {
	var num int
	inputNumber(&num)

	var ptr *int = &num
	fmt.Println("Original Value:", num)
	fmt.Println("Address using &:", ptr)
	fmt.Println("Value accessed using *:", *ptr)

	
	var count int
	inputNumber(&count)
	fmt.Println("Value before modifyValue():", count)
	modifyValue(&count)
	fmt.Println("Value after modifyValue():", count)

	s := new(Student)
	fmt.Println("Default Student Name:", s.Name)
	fmt.Println("Default Student Age:", s.Age)

	inputStudent(s)

	fmt.Println("Modified Student Name:", s.Name)
	fmt.Println("Modified Student Age:", s.Age)
}
