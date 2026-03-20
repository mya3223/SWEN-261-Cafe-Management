package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.models.PricingPlan;
import com.example.swen261cafemanagement.service.PricingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PricingAPI {
    private final PricingService pricingService;

    public PricingAPI(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping("/api/pricing")
    public List<PricingPlan> getPricingPlans() {
        return pricingService.getPricingPlans();
    }
}
