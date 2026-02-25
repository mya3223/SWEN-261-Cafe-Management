package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.Order;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    public List<Order> getAllOrders() {
        return List.of(
                new Order("ORD-001", "Pending Order", "Preparing order"),
                new Order("ORD-002", "In Progress", "On the way"),
                new Order("ORD-003", "Delivered", "Completed")
        );
    }
}
