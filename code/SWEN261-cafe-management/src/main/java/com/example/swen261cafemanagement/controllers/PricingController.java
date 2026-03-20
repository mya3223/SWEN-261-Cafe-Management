package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.service.PricingService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping("/pricing")
    public String getPricingPage(Model model) {
        model.addAttribute("plans", pricingService.getPricingPlans());
        return "pricing";
    }

}
