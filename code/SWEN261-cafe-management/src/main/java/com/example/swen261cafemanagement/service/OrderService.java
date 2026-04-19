package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private ArrayList<Order> orders = new ArrayList<>();
    
    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    public ArrayList<Order> getActiveOrders(List<Order> orders) {
    ArrayList<Order> active = new ArrayList<>();

    for (int i = 0; i < orders.size(); i++) {
        if (!orders.get(i).isCompleted()) {
            active.add(orders.get(i));
        }
    }

    return active;
}

    public ArrayList<Order> getFilteredOrders(String search, String status, String from, String to) {
    if (search != null && !search.isEmpty()) {
        return searchByOrderId(search);

    } else if (status != null && !status.isEmpty()) {
        return filterByStatus(status);

    } else if (from != null && to != null && !from.isEmpty() && !to.isEmpty()) {
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        return filterByDateRange(fromDate, toDate);

    } else {
        return getAllOrders();
    }
}
    
    public ArrayList<Order> getCompletedOrders(List<Order> orders) {
    ArrayList<Order> completed = new ArrayList<>();

    for (int i = 0; i < orders.size(); i++) {
        if (orders.get(i).isCompleted()) {
            completed.add(orders.get(i));
        }
    }

    return completed;
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

    public boolean createOrder(Order order) {
        if (order.getItems() == null || order.getItems().isEmpty()) {
        return false;  // validation = business logic
    }
    order.setOrderId(String.valueOf(System.currentTimeMillis()));
    order.setStatus("pending");  
    orders.add(order);
    return true;
}
    
    public boolean updateOrderStatus(String orderId, String newStatus) {

    for (Order order : orders) {

        if (order.getOrderId().equals(orderId)) {

            String currentStatus = order.getStatus();

            if (currentStatus.equals("pending") && newStatus.equals("in-progress")) {
                order.setStatus(newStatus);
                return true;
            }

            if (currentStatus.equals("in-progress") && newStatus.equals("delivered")) {
                order.setStatus(newStatus);
                return true;
            }

            return false;
        }
    }

    return false;
}
}
