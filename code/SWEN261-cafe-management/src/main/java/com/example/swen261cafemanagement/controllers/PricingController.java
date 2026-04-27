package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.models.User;
import com.example.swen261cafemanagement.service.PricingService;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping("/pricing")
    public String getPricingPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || user.getRole() == null || !user.getRole().equals("OWNER")) {
            model.addAttribute("errorMsg", "You cannot change the pricing plan");
            return "dashboard";
        }
        model.addAttribute("plans", pricingService.getPricingPlans());
        return "pricing";
    }

}
