package com.stupin.carServiceAndWash.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "car_parts")
public class CarPartDto {
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
    private CarDto carDto;

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }
}
