package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.models.PricingPlan;
import com.example.swen261cafemanagement.models.User;
import com.example.swen261cafemanagement.service.PricingService;
import com.example.swen261cafemanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class PricingAPI {

    private final PricingService pricingService;
    private final UserService userService;

    public PricingAPI(PricingService pricingService, UserService userService) {
        this.pricingService = pricingService;
        this.userService = userService;
    }

    // GET all pricing plans
    @GetMapping("/api/pricing")
    public List<PricingPlan> getPricingPlans() {
        return pricingService.getPricingPlans();
    }

    // GET single pricing plan by ID
    @GetMapping("/api/pricing/{id}")
    public ResponseEntity<?> getPlanById(@PathVariable int id) {
        PricingPlan plan = pricingService.findPlanById(id);
        if (plan == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Plan not found with id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok(plan);
    }

    // POST - select a pricing plan for a user (US-005)
    @PostMapping("/api/pricing/{id}/select")
    public ResponseEntity<Map<String, Object>> selectPlan(
            @PathVariable int id,
            @RequestParam(defaultValue = "test@gmail.com") String email) {

        Map<String, Object> response = new HashMap<>();

        PricingPlan plan = pricingService.findPlanById(id);
        if (plan == null) {
            response.put("success", false);
            response.put("message", "Invalid plan ID. No plan found with id: " + id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        User user = userService.findByUserByEmail(email);
        if (user == null) {
            response.put("success", false);
            response.put("message", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        pricingService.selectPlanForUser(user, id);

        response.put("success", true);
        response.put("message", "Plan selected successfully");
        response.put("selectedPlanId", id);
        response.put("selectedPlanName", plan.getName());
        response.put("activatedFeatures", plan.getFeatures());
        response.put("price", plan.getPrice());

        return ResponseEntity.ok(response);
    }
}
