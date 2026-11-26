package main

import "testing"

func TestAddItem(t *testing.T) {
	inv := &Inventory{}

	err := inv.AddItem(Item{ID: 1, Name: "Book", Quantity: 5, Price: 10.0})
	if err != nil {
		t.Fatalf("expected no error, got %v", err)
	}

	if len(inv.items) != 1 {
		t.Fatalf("expected 1 item, got %d", len(inv.items))
	}

	err = inv.AddItem(Item{ID: 1, Name: "Book", Quantity: 5, Price: 10.0})
	if err == nil {
		t.Fatalf("expected error for duplicate id, got nil")
	}

	err = inv.AddItem(Item{ID: 0, Name: "Invalid", Quantity: 1, Price: 1.0})
	if err == nil {
		t.Fatalf("expected error for invalid id, got nil")
	}
}

func TestUpdateItem(t *testing.T) {
	inv := &Inventory{}
	inv.AddItem(Item{ID: 1, Name: "Book", Quantity: 5, Price: 10.0})

	err := inv.UpdateItem(1, "Notebook", 8, 12.0)
	if err != nil {
		t.Fatalf("expected no error, got %v", err)
	}

	if inv.items[0].Name != "Notebook" || inv.items[0].Quantity != 8 || inv.items[0].Price != 12.0 {
		t.Fatalf("item not updated correctly")
	}

	err = inv.UpdateItem(99, "None", 1, 1.0)
	if err == nil {
		t.Fatalf("expected error for non-existent id, got nil")
	}
}

func TestRemoveItem(t *testing.T) {
	inv := &Inventory{}
	inv.AddItem(Item{ID: 1, Name: "Book", Quantity: 5, Price: 10.0})

	err := inv.RemoveItem(1)
	if err != nil {
		t.Fatalf("expected no error, got %v", err)
	}

	if len(inv.items) != 0 {
		t.Fatalf("expected 0 items, got %d", len(inv.items))
	}

	err = inv.RemoveItem(1)
	if err == nil {
		t.Fatalf("expected error for non-existent item, got nil")
	}
}

func TestGetStats(t *testing.T) {
	inv := &Inventory{}
	inv.AddItem(Item{ID: 1, Name: "Book", Quantity: 2, Price: 10.0})
	inv.AddItem(Item{ID: 2, Name: "Pen", Quantity: 3, Price: 2.0})

	stats := inv.GetStats()
	if stats.TotalCount != 5 {
		t.Fatalf("expected count 5, got %d", stats.TotalCount)
	}
	if stats.TotalValue != 26.0 {
		t.Fatalf("expected value 26.0, got %f", stats.TotalValue)
	}
}
