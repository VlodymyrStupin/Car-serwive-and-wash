package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.dao.User;
import com.stupin.carServiceAndWash.repository.UserRepository;
import com.stupin.carServiceAndWash.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("ui/users/")
public class UserUIController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final Logger log = LogManager.getLogger(UserUIController.class);

    @Autowired
    public UserUIController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("user")
    public String viewLoginUserPage() {
        return "user_page";
    }

    @GetMapping("/all-users")
    public String listUsers(Model model) {
        List<User> users = userService.getAll();
        log.info("List of users: {}", users);
        model.addAttribute("listUsers", users);
        return "users";
    }

}

