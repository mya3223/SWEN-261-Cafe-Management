package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.PricingPlan;
import com.example.swen261cafemanagement.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class PricingService {

    private final ArrayList<PricingPlan> pricingPlans = new ArrayList<>();

    public PricingService() {
        pricingPlans.add(new PricingPlan(
                1, "Basic Package",
                "Package for small cafes who are just getting started",
                9.99,
                Arrays.asList("Up to 50 orders per day", "1 staff account", "Basic reporting"),
                false
        ));

        pricingPlans.add(new PricingPlan(
                2, "Advanced Package",
                "Package better suited for growing cafes with higher volumes",
                29.99,
                Arrays.asList("Up to 300 orders per day", "5 staff accounts", "Inventory tracking", "Advanced analytics", "Priority email and chat support"),
                true
        ));

        pricingPlans.add(new PricingPlan(
                3, "Enterprise Package",
                "Full featured package for large or multi-location cafes",
                79.99,
                Arrays.asList("Unlimited orders", "Unlimited staff accounts", "Inventory tracking", "Custom reporting", "API access", "Multi-location management", "24/7 dedicated support"),
                false
        ));

        pricingPlans.add(new PricingPlan(
                4, "Starter Trial",
                "A free 30-day trial for new cafes to explore the system",
                0.00,
                Arrays.asList("Up to 20 orders per day", "1 staff account", "Email support"),
                false
        ));

        pricingPlans.add(new PricingPlan(
                5, "Pro Package",
                "A step up from Advanced for cafes needing more flexibility",
                49.99,
                Arrays.asList("Up to 600 orders per day", "15 staff accounts", "Inventory tracking", "Advanced analytics", "Custom branding", "Priority phone support"),
                false
        ));
    }

    public ArrayList<PricingPlan> getPricingPlans() {
        return pricingPlans;
    }

    public PricingPlan findPlanById(int id) {
        for (PricingPlan plan : pricingPlans) {
            if (plan.getID() == id) {
                return plan;
            }
        }
        return null;
    }

    // Links a pricing plan to a user — simulates a relationship via selectedPlanId
    public boolean selectPlanForUser(User user, int planId) {
        PricingPlan plan = findPlanById(planId);
        if (plan == null) return false;
        user.setSelectedPlanId(planId);
        return true;
    }
}
