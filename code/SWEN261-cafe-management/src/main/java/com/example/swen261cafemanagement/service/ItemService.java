package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.Items;
import com.example.swen261cafemanagement.models.Items;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService {

    private final Map<Long, Items> items = new HashMap<>();
    private Long idCounter = 1L;

    public List<Items> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public Items addItem(Items item) {
        item.setId(idCounter++);
        items.put(item.getId(), item);
        return item;
    }

    public Items updateItem(Long id, Items updatedItem) {
        if (!items.containsKey(id)) return null;

        updatedItem.setId(id);
        items.put(id, updatedItem);
        return updatedItem;
    }

    public void deleteItem(Long id) {
        items.remove(id);
    }

    public Items getItem(Long id) {
        return items.get(id);
    }
}