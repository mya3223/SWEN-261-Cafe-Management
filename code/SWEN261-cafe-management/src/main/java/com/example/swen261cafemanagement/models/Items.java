package com.example.swen261cafemanagement.models;

public class Items {
    private Long id;
    private String name;
    private double price;
    private int quantity;

    public Items() {}

    public Items(Long id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isLowStock() {
        return this.quantity < 0;
    }
}
