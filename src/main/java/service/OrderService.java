package com.example.assignment1.service;

import com.example.assignment1.models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private ArrayList<Order> orders = new ArrayList<>();
    public void createOrder(Order order) {
        orders.add(order);
    }
    public ArrayList<Order> getAllOrders() {
        return orders;
    }
}