package com.example.swen261cafemanagement.models;

import java.util.List;

public class PricingPlan {

        private int id;
        private String name;
        private String description;
        private double price;
        private List<String> features;
        private boolean recommended;

    public PricingPlan(int id, String name, String description, double price, List<String> features, boolean recommended){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.features = features;
        this.recommended = recommended;
    }

    public int getID() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getPrice() {return price;}
    public List<String> getFeatures() {return features;}
    public boolean isRecommended() {return recommended;}
}
