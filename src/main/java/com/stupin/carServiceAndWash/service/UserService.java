package com.stupin.carServiceAndWash.service;

import com.stupin.carServiceAndWash.dto.User;
import com.stupin.carServiceAndWash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(it -> users.add(new User(it.getId(), it.getName(), it.getSurname(),
                it.getEmail(), it.getPassword(), it.getPhoneNumber())));
        return users;
    }
}
