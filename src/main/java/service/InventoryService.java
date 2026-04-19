package service;

import models.Items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InventoryService {

    private ArrayList<Items> items = new ArrayList<>();

    public InventoryService() {
        items.add(new Items("Milk", 2, 5));
        items.add(new Items("Coffee Beans", 10, 5));
        items.add(new Items("Sugar", 1, 3));
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