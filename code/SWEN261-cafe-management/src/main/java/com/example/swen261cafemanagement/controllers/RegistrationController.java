package com.example.swen261cafemanagement.controllers;


import com.example.swen261cafemanagement.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showPage() { return "register"; }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String name, @RequestParam String email,
                                 @RequestParam String password, @RequestParam String confirmPassword, Model model) {

        String error = registrationService.validateAndRegister(name, email, password, confirmPassword);

        if (error != null) {
            model.addAttribute("errorMsg", error);
            return "register";
        }

        return "redirect:/pricing?success=true";
    }
}