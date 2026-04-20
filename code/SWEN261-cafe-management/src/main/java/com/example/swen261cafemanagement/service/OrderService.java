package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final ArrayList<Order> orders = new ArrayList<>();

    public void createOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    // FIXED: missing List import issue resolved
    public ArrayList<Order> getActiveOrders(List<Order> orderList) {
        ArrayList<Order> active = new ArrayList<>();

        for (Order order : orderList) {
            if (!order.isCompleted()) {
                active.add(order);
            }
        }
        return active;
    }

    public ArrayList<Order> getCompletedOrders(List<Order> orderList) {
        ArrayList<Order> completed = new ArrayList<>();

        for (Order order : orderList) {
            if (order.isCompleted()) {
                completed.add(order);
            }
        }
        return completed;
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

    public ArrayList<Order> searchByOrderId(String orderId) {
        ArrayList<Order> result = new ArrayList<>();

        for (Order order : orders) {
            if (order.getOrderId().contains(orderId)) {
                result.add(order);
            }
        }
        return result;
    }

    public ArrayList<Order> filterByStatus(String status) {
        ArrayList<Order> result = new ArrayList<>();

        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase(status)) {
                result.add(order);
            }
        }
        return result;
    }

    public ArrayList<Order> filterByDateRange(LocalDate from, LocalDate to) {
        ArrayList<Order> result = new ArrayList<>();

        for (Order order : orders) {
            LocalDate orderDate = order.getCreatedAt();

            if (orderDate != null &&
                !orderDate.isBefore(from) &&
                !orderDate.isAfter(to)) {
                result.add(order);
            }
        }
        return result;
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

public Order findById(String orderId) {
    for (Order order : orders) {
        if (order.getOrderId().equals(orderId)) {
            return order;
        }
    }
    return null;
}

public boolean canBeCancelled(Order order) {
    return order != null && "pending".equalsIgnoreCase(order.getStatus());
}

public boolean cancelOrder(String orderId) {
    Order order = findById(orderId);

    if (order == null || !canBeCancelled(order)) {
        return false;
    }

    order.setStatus("cancelled");
    return true;
}}
