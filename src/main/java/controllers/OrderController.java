package com.example.assignment1.controllers;

import com.example.assignment1.models.Order;
import com.example.assignment1.service.OrderService;
import models.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.InventoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("order",new Order());

        List<Order> orders = orderService.getAllOrders();

        List<Order> active = new ArrayList<>();
        List<Order> completed = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            if (o.isCompleted()) {
                completed.add(o);
            } else {
                active.add(o);
            }
        }

        List<Items> lowStock = inventoryService.getLowStockItems();

        model.addAttribute("lowStockItems", lowStock);
        model.addAttribute("lowStockCount", lowStock.size());
        model.addAttribute("hasLowStock", !lowStock.isEmpty());
        model.addAttribute("noLowStock", lowStock.isEmpty());

        model.addAttribute("activeOrders", active);
        model.addAttribute("completedOrders", completed);
        model.addAttribute("hasOrders", !orders.isEmpty());


        return "orders";
    }
    @PostMapping("/saveorder")
    public String saveOrder(Order order) {

        if (order.getItems() == null || order.getItems().isEmpty()) {
            return "redirect:/orders";
        }

        order.setOrderId(String.valueOf(System.currentTimeMillis()));
        order.setStatus("pending");

        orderService.createOrder(order);

        return "redirect:/orders";
    }

    @Autowired
    private InventoryService inventoryService;
}
