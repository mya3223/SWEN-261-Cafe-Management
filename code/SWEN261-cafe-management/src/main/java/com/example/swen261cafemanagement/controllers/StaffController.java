package com.example.swen261cafemanagement.controllers;

import com.example.swen261cafemanagement.models.User;
import com.example.swen261cafemanagement.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StaffController {

    private UserService userService;

    public StaffController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/staff")
    public String showStaffPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || !user.getRole().equals("OWNER")) {
            model.addAttribute("errorMsg", "Only owner can access staff creation.");
            return "dashboard";
        }

        model.addAttribute("users", userService.getAllUsers());
        return "staff";
    }

    @PostMapping("/users/staff")
    public String createStaff(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String role, HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || !user.getRole().equals("OWNER")) {
            model.addAttribute("errorMsg", "Only owner can create staff accounts.");
            return "dashboard";
        }

        String error = userService.createStaff(name, email, password, role);

        if (error != null) {
            model.addAttribute("errorMsg", error);
            model.addAttribute("users", userService.getAllUsers());
            return "staff";
        }

        return "redirect:/users/staff";
    }
}
