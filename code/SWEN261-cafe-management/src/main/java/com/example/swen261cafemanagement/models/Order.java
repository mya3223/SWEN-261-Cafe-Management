package com.example.swen261cafemanagement.models;

public class Order {
    private String ordermessage;
    private String orderId;
    private String orderStatus;

    public Order (){}
    public Order(String ordermessage, String orderId, String orderStatus) {
        this.ordermessage = ordermessage;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public String getOrdermessage() {
        return ordermessage;
    }

    public void setOrdermessage(String ordermessage) {
        this.ordermessage = ordermessage;
    }

    public String getorderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getorderStatus() {
        return orderStatus;
    }

    public void setorderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public boolean isCompleted() {
        return "Delivered".equalsIgnoreCase(orderStatus);
    }
}