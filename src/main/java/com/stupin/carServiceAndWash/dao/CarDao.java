package com.stupin.carServiceAndWash.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cars")
public class CarDao {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column
    private int odometer;
    @Column
    private int year;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String registrationPlate;
    @Column
    private String vinCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserDao userDao;

    @OneToMany(mappedBy = "carDao", cascade = CascadeType.ALL)
    private final List<CarPartDao> carParts = new ArrayList<>();

}
