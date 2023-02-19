package com.stupin.carServiceAndWash.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "car_parts")
public class CarPartDao {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column
    private String name;
    @Column
    private String status;
    @Column
    private int durability;
    @Column
    private boolean isReplaced;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_entity")
    private CarDao carDao;

    public CarDao getCarDao() {
        return carDao;
    }

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }
}
