package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.PricingPlan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class PricingService {

    private final ArrayList<PricingPlan> pricingPlans = new ArrayList<>();

    public PricingService() {
        pricingPlans.add(new PricingPlan(
                1,
                "Basic Package",
                "Package for small cafes who are just getting started",
                9.99,
                Arrays.asList("All the way up to 50 Orders per day", "1 staff account", "Basic reporting"),
                false
        ));

        pricingPlans.add(new PricingPlan(
                2,
                "Advanced Package",
                "Package that is better used within growing cafes that contain higher volumes",
                29.99,
                Arrays.asList("All the way up to 300 Orders per day", "5 staff accounts", "Inventory is trackable", "Advanced Analytics", "Email and chat support are prioritized"),
                true
        ));

        pricingPlans.add(new PricingPlan(
                3,
                "Enterprise Package",
                "Full featured package for large cafes or multi location cafes.",
                79.99,
                Arrays.asList("NO limit for orders", "Custom Reporting", "No limit for staff account creation", "Inventory Tracking", "API access", "Management of multi-locations", "24/7 dedicated support"),
                false
        ));

    }

    public ArrayList<PricingPlan> getPricingPlans() {
        return pricingPlans;
    }
}
