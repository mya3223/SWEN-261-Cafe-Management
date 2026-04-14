package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.models.Order;
import com.example.swen261cafemanagement.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/orders")
    public String orders(Model model,
                         @RequestParam(required = false) String search,
                         @RequestParam(required = false) String status,
                         @RequestParam(required = false) String from,
                         @RequestParam(required = false) String to) {

        List<Order> orders;

        if (search != null && !search.isEmpty()) {
            orders = orderService.searchByOrderId(search);
            
        } else if (status != null && !status.isEmpty()) {
            orders = orderService.filterByStatus(status);
            
        } else if (from != null && to != null && !from.isEmpty() && !to.isEmpty()) {
            LocalDate fromDate = LocalDate.parse(from);
            LocalDate toDate = LocalDate.parse(to);
            orders = orderService.filterByDateRange(fromDate, toDate);
            
        } else {
            orders = orderService.getAllOrders();
        }

        List<Order> active = orderService.getActiveOrders(orders);
        List<Order> completed = orderService.getCompletedOrders(orders);



        model.addAttribute("activeOrders", active);
        model.addAttribute("completedOrders", completed);
        model.addAttribute("hasOrders", !orders.isEmpty());
        model.addAttribute("noOrders", orders.isEmpty());
        model.addAttribute("resultCount", orders.size());

        // template name WITHOUT extension
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
}
