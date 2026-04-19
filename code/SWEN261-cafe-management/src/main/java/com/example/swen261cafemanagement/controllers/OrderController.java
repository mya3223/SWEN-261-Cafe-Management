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
    private final InventoryService inventoryService;

    public OrderController(OrderService orderService, InventoryService inventoryService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
    }

    @RequestMapping("/orders")
    public String orders(Model model,
                         @RequestParam(required = false) String search,
                         @RequestParam(required = false) String status,
                         @RequestParam(required = false) String from,
                         @RequestParam(required = false) String to) {

        
        List<Order> orders = orderService.getFilteredOrders(search, status, from, to);
        List<Order> active = orderService.getActiveOrders(orders);
        List<Order> completed = orderService.getCompletedOrders(orders);

        List<Items> lowStock = inventoryService.getLowStockItems();

        model.addAttribute("lowStockItems", lowStock);
        model.addAttribute("lowStockCount", lowStock.size());
        model.addAttribute("hasLowStock", !lowStock.isEmpty());
        model.addAttribute("noLowStock", lowStock.isEmpty());
       


        model.addAttribute("activeOrders", active);
        model.addAttribute("completedOrders", completed);
        model.addAttribute("hasOrders", !orders.isEmpty());
        model.addAttribute("noOrders", orders.isEmpty());
        model.addAttribute("resultCount", orders.size());
        model.addAttribute("successMsg", "Status updated successfully");
        
        return "orders";
    }
    @PostMapping("/saveorder")
    public String saveOrder(Order order) {

        orderService.createOrder(order);

        return "redirect:/orders";
    }
    @PostMapping("/updatestatus")
    public String updateStatus(
        @RequestParam String orderId,
        @RequestParam String status,
        Model model) 
    {

    boolean success = orderService.updateOrderStatus(orderId, status);

    if (!success) {
        model.addAttribute("errorMsg", "Invalid status update");
    }

    return "redirect:/orders";
}
}
