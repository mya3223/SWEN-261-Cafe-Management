package com.example.assignment1.models;

public class Order {
    private String orderId;
    private String orderMessage;
    private String items;
    private String status;
    private double totalPrice;

    public Order() {}

    public Order(String orderId, String orderStatus, String orderMessage, String items, String status, double totalPrice) {
        this.orderId = orderId;
        this.orderMessage = orderMessage;
        this.items = items;
        this.status = status;
        this.totalPrice = totalPrice;
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
}