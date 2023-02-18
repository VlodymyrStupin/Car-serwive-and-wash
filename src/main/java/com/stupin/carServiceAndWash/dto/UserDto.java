package com.stupin.carServiceAndWash.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserDto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String surname;
    @Column(unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 64)
    private String password;
    @Column(unique = true, length = 12)
    private String phoneNumber;
    @Column
    private Integer enabled = 1;
    @Column
    private String role = "ROLE_USER";

    @OneToMany(mappedBy = "userDto", cascade = CascadeType.ALL)
    private List<CarDto> cars = new ArrayList<>();

    public UserDto(Integer id, String name, String surname, String email,
                   String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public List<CarDto> getCarEntities() {
        return cars;
    }

    public void setCarEntities(List<CarDto> carEntities) {
        this.cars = carEntities;
    }
}
