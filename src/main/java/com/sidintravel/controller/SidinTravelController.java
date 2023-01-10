package com.sidintravel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SidinTravelController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome to sidin travek";
    }
}
