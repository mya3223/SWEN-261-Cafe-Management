package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class OrderService {
    private ArrayList<Order> orders = new ArrayList<>();
    public void createOrder(Order order) {
        orders.add(order);
    }
    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    public ArrayList<Order> searchByOrderId(String orderId) {
        ArrayList<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().contains(orderId)) {
                result.add(orders.get(i));
            }
        }
        return result;
    }

    public ArrayList<Order> filterByStatus(String status) {
        ArrayList<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getStatus().equalsIgnoreCase(status)) {
                result.add(orders.get(i));
            }
        }
        return result;
    }

    public ArrayList<Order> filterByDateRange(LocalDate from, LocalDate to) {
        ArrayList<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            LocalDate orderDate = orders.get(i).getCreatedAt();
            if (orderDate != null && !orderDate.isBefore(from) && !orderDate.isAfter(to)) {
                result.add(orders.get(i));
            }
        }
        return result;
    }
}
