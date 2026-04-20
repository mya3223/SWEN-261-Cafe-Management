package com.example.swen261cafemanagement.models;

public class Items {
    private String name;
    private int quantity;
    private int threshold;

    public Items(String name, int quantity, int threshold) {
        this.name = name;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setThreshold(int threshold) { this.threshold = threshold; }

    public String getName()
    { return name; }

    public int getQuantity()
    { return quantity; }

    public int getThreshold() {
        return threshold; }

    public boolean isLowStock() {
        return quantity <= threshold;
    }
}
