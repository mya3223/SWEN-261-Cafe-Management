package com.example.swen261cafemanagement.controllers;


import com.example.swen261cafemanagement.models.User;
import com.example.swen261cafemanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {

        User user = userService.findByUserByEmail(email);

        if (user == null) {
            return "login";
        }

        // comparaison
        if (password.equals(user.getPassword())) {
            return "dashboard";
        } else {
            return "login";
        }
    }

}
