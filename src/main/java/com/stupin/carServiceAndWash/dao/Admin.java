package com.stupin.carServiceAndWash.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String email;
    private String password;
    private int enabled;

    public Admin(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;

    }
}
