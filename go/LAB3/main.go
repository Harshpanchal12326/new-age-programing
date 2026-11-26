package main

import "fmt"

type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float64
}


func (p *Person) ReadData() {
	fmt.Print("Enter Name: ")
	fmt.Scan(&p.Name)

	fmt.Print("Enter Age: ")
	fmt.Scan(&p.Age)

	fmt.Print("Enter Job: ")
	fmt.Scan(&p.Job)

	fmt.Print("Enter Salary: ")
	fmt.Scan(&p.Salary)
}

func (p Person) PrintDetails() {
	fmt.Printf("Name: %s | Age: %d | Job: %s | Salary: %.2f\n", p.Name, p.Age, p.Job, p.Salary)
}

func main() {
	
	var p1, p2 Person

	fmt.Println("--- Enter details for Person 1 ---")
	p1.ReadData()
	fmt.Println("\n--- Details of Person 1 ---")
	p1.PrintDetails()

	fmt.Println("\n--- Enter details for Person 2 ---")
	p2.ReadData()
	fmt.Println("\n--- Details of Person 2 ---")
	p2.PrintDetails()

	totalSalary := p1.Salary + p2.Salary
	fmt.Println("\n----------------------------------------")
	fmt.Printf("Total Combined Salary: %.2f\n", totalSalary)
	fmt.Println("----------------------------------------")
}
