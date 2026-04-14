package com.example.swen261cafemanagement.models;

import java.time.LocalDate;

public class Order {
    private String orderId;
    private String orderMessage;
    private String items;
    private String status;
    private double totalPrice;
    private LocalDate createdAt;
    private String pending;
    private String in-progress;
    private String delivered;

    public Order() {}

    public Order(String orderId, String status, String orderMessage, String items, String status, double totalPrice) {
        this.orderId = orderId;
        this.orderMessage = orderMessage;
        this.items = items;
        this.status = status;
        this.totalPrice = totalPrice;
        this.createdAt = LocalDate.now();
    }

    public void setId(String orderId) {
        this.orderId = orderId;
    }
    public String getItems(){
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }


    public String getOrderMessage() {
        return orderMessage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isCompleted() {
        return "Delivered".equalsIgnoreCase(status);
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt; 
    }
}
