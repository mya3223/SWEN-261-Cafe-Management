package com.example.assignment1.controllers;

import com.example.assignment1.models.Order;
import com.example.assignment1.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        model.addAttribute("activeOrders", active);
        model.addAttribute("completedOrders", completed);
        model.addAttribute("hasOrders", !orders.isEmpty());

        // template name WITHOUT extension
        return "orders";
    }
    @PostMapping("/saveorder")
    public String saveOrder(Order order) {
        order.setOrderId(String.valueOf(System.currentTimeMillis()));
        order.setStatus("pending");
        order.setItems(order.getItems());
        order.setTotalPrice(order.getTotalPrice());
        orderService.createOrder(order);
        return "redirect:/orders";
    }
}