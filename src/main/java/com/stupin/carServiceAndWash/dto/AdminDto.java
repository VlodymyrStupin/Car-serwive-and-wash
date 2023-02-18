package com.stupin.carServiceAndWash.dto;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "admins")
@NoArgsConstructor
public class AdminDto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    @Column(unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 64)
    private String password;
    @Column
    private Integer enabled = 1;
    @Column
    private String role = "ROLE_ADMIN";

    public AdminDto(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
