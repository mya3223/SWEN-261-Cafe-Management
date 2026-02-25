package com.example.swen261cafemanagement.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @RequestMapping("/Welcome")
    public String getWelcome(){
        return "Welcome.html";
    }
}