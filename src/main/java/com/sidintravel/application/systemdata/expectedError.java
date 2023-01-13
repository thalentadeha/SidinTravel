package com.sidintravel.application.systemdata;

import org.springframework.ui.Model;

public class expectedError {
    static <T,V> void giveError(T param1,V param2,Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
    }
}