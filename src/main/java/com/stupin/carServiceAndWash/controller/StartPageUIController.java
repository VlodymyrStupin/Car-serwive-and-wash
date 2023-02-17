package com.stupin.carServiceAndWash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageUIController {
    @GetMapping
    public String getStartPage() {
        return "start_page";
    }

}
