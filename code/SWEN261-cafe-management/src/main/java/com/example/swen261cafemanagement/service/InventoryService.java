package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.Items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InventoryService {

    private ArrayList<Items> items = new ArrayList<>();

    public InventoryService() {
        items.add(new Items(1234L,"Milk", 2, 5));
        items.add(new Items(3452L,"Coffee Beans", 10, 5));
        items.add(new Items(3059L,"Sugar", 1, 3));
    }

    public ArrayList<Items> getAllItems() {
        return items;
    }

    public ArrayList<Items> getLowStockItems() {
        ArrayList<Items> low = new ArrayList<>();

        for (Items item : items) {
            if (item.isLowStock()) {
                low.add(item);
            }
        }

        return low;
    }
}