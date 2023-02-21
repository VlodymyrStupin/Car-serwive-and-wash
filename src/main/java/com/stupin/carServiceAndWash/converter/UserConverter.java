package com.stupin.carServiceAndWash.converter;

import com.stupin.carServiceAndWash.dto.User;
import com.stupin.carServiceAndWash.dao.UserDao;

public class UserConverter {
    public static User toDto(UserDao userDao) {
        return new User(
                userDao.getId(),
                userDao.getName(),
                userDao.getSurname(),
                userDao.getEmail(),
                userDao.getPassword(),
                userDao.getPhoneNumber());
    }

    public static UserDao toDao(User user) {
        return new UserDao(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber());
    }
}
