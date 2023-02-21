package com.stupin.carServiceAndWash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Integer id;

    private String email;
    private String date;
    private String service;
    private String description;
    private User user;
}
