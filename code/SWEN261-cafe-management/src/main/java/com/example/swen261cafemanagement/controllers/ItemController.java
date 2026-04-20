package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.models.Items;
import com.example.swen261cafemanagement.models.Items;
import com.example.swen261cafemanagement.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // VIEW PAGE
    @GetMapping
    public String viewItems(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "items";
    }

    // ADD ITEM
    @PostMapping("/add")
    public String addItem(@RequestParam String name,
                          @RequestParam double price,
                          @RequestParam int quantity) {

        service.addItem(new Items(name, (int) price, quantity));
        return "redirect:/items";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return "redirect:/items";
    }
}
