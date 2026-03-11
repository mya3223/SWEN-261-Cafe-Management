package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.models.Order;
import com.example.swen261cafemanagement.service.OrderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductAPI {

    OrderService orderService;

    public ProductAPI(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/product")
    public Order getProduct() {
        return this.orderService.getAllOrders().get(0);
    }

    @GetMapping("/prod")
    public ResponseEntity<List<Order>> getOrders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("testheader", "testvalue");
        List<Order> orders = this.orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(orders);
    }


}
