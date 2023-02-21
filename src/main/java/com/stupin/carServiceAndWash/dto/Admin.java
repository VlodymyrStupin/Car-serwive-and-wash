package com.stupin.carServiceAndWash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class Admin {
    private Integer id;

    private String name;

    private String surname;

    private String email;

    private String password;
    private String phoneNumber;

    public Admin(Integer id, String name, String surname, String email, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
