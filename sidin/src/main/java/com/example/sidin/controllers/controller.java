package com.example.sidin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sidin.service.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class controller{
    
    @Autowired
    private data semuadata;
    @GetMapping
    public String land(Model model){
        return "landing";
    }
    @GetMapping("/login")
    public String logs(Model model){
        return "login";
    }
    @GetMapping("/home")
    public String hms(Model model){
        return "home";
    }
    @GetMapping("/register")
    public String reg(Model model){
        return "register";
    }
    @GetMapping("viewticket/{param}")
    public String ticketView(@PathVariable("param") String param,Model model){
        if(param.equals("Bus")){
            model.addAttribute("tickets", semuadata.showBis());
        }
        return "ticketview";
    }
}