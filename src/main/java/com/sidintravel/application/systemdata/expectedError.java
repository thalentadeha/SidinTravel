package com.sidintravel.application.systemdata;

import org.springframework.ui.Model;

public class expectedError {
    static <T,V> void giveError(T param1,Model model)
    {
        model.addAttribute("param1", param1);
    }
}