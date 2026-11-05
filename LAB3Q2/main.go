package main

import (
	"errors"
	"fmt"
)

type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

type Inventory struct {
	items []Item
}

type Stats struct {
	TotalCount int
	TotalValue float64
}

func (inv *Inventory) AddItem(item Item) error {
	if item.ID <= 0 {
		return errors.New("invalid id")
	}
	if item.Name == "" {
		return errors.New("invalid name")
	}
	if item.Quantity < 0 {
		return errors.New("invalid quantity")
	}
	if item.Price < 0 {
		return errors.New("invalid price")
	}
	for _, it := range inv.items {
		if it.ID == item.ID {
			return errors.New("item already exists")
		}
	}
	inv.items = append(inv.items, item)
	return nil
}

func (inv *Inventory) UpdateItem(id int, name string, qty int, price float64) error {
	if name == "" {
		return errors.New("invalid name")
	}
	if qty < 0 {
		return errors.New("invalid quantity")
	}
	if price < 0 {
		return errors.New("invalid price")
	}
	for i, it := range inv.items {
		if it.ID == id {
			inv.items[i].Name = name
			inv.items[i].Quantity = qty
			inv.items[i].Price = price
			return nil
		}
	}
	return errors.New("item not found")
}

func (inv *Inventory) RemoveItem(id int) error {
	for i, it := range inv.items {
		if it.ID == id {
			inv.items = append(inv.items[:i], inv.items[i+1:]...)
			return nil
		}
	}
	return errors.New("item not found")
}

func (inv *Inventory) GetStats() Stats {
	ch := make(chan Stats)
	go func() {
		var count int
		var value float64
		for _, it := range inv.items {
			count += it.Quantity
			value += float64(it.Quantity) * it.Price
		}
		ch <- Stats{TotalCount: count, TotalValue: value}
	}()
	return <-ch
}

func main() {
	inv := &Inventory{}

	err := inv.AddItem(Item{ID: 1, Name: "Book", Quantity: 10, Price: 15.5})
	if err != nil {
		fmt.Println("Error:", err)
	}

	err = inv.AddItem(Item{ID: 2, Name: "Pen", Quantity: 20, Price: 2.0})
	if err != nil {
		fmt.Println("Error:", err)
	}

	err = inv.UpdateItem(2, "Gel Pen", 25, 2.5)
	if err != nil {
		fmt.Println("Error:", err)
	}

	stats := inv.GetStats()
	fmt.Printf("Total Items: %d\n", stats.TotalCount)
	fmt.Printf("Total Value: %.2f\n", stats.TotalValue)

	err = inv.RemoveItem(1)
	if err != nil {
		fmt.Println("Error:", err)
	}

	stats = inv.GetStats()
	fmt.Printf("After Removal - Total Items: %d\n", stats.TotalCount)
	fmt.Printf("After Removal - Total Value: %.2f\n", stats.TotalValue)
}
