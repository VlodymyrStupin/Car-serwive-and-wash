package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.dao.User;
import com.stupin.carServiceAndWash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "all-users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
