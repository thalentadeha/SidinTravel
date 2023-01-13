package com.example.sidin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sidin.administration.userdatalogin;
import com.example.sidin.service.data;
import com.example.sidin.service.userData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class controller{
    
    @Autowired
    private data dataTiket;
    @Autowired
    private userData dataUser;

    @GetMapping
    public String land(Model model){
        return "landing";
    }
    @GetMapping("/login")
    public String logs(Model model){
        model.addAttribute("userdatalogin", new userdatalogin("","",""));
        return "login";
    }
    @PostMapping("/login")
    public String logPost(userdatalogin currUser,Model model){
        model.addAttribute("currUser", currUser);
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
    @PostMapping("/register")
    public String regPost(Model model){
        return "register";
    }
    @GetMapping("viewticket/{param}")
    public String ticketView(@PathVariable("param") String param,Model model){
        if(param.equals("Bus")){
            model.addAttribute("tickets", dataTiket.showBis());
        }else if (param.equals("Kereta")){
            model.addAttribute("tickets", dataTiket.showKereta());
        }else if(param.equals("Pesawat")){
            model.addAttribute("tickets", dataTiket.showPesawat());
        }
        return "ticketview";
    }
    @GetMapping("/Sidinerror")
    public String siderror(Model model){
        return "register";
    }

}