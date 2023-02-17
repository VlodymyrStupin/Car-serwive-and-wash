package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/send")
    public String sendEmail() {
//create page with field to send email
//        emailSenderService.sendSimpleMail();
        return "home";
    }

}
