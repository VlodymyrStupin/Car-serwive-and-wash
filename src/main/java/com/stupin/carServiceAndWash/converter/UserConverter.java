package com.stupin.carServiceAndWash.converter;

import com.stupin.carServiceAndWash.dto.User;
import com.stupin.carServiceAndWash.dao.UserDao;

public class UserConverter {
    public static User fromDto(UserDao entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getPhoneNumber());
    }

    public static UserDao toDto(User user) {
        return new UserDao(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber());
    }
}
