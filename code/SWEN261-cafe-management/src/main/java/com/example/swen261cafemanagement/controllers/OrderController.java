package com.example.swen261cafemanagement.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.swen261cafemanagement.models.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.swen261cafemanagement.service.OrderService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/order")
    public String Order(Model model) {
        List<Order> orders = orderService.getAllOrders();

        List<Order> active = new ArrayList<>();
        List<Order> completed = new ArrayList<>();

        for (Order o : orders) {
            if (o.isCompleted()) {
                completed.add(o);
            } else {
                active.add(o);
            }
        }

        model.addAttribute("activeOrders", active);
        model.addAttribute("completedOrders", completed);
        model.addAttribute("hasOrders", !orders.isEmpty());

        return "order";
    }
}