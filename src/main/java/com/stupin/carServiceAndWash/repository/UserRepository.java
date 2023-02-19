package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserDao, Integer> {

    @Query("SELECT u FROM UserDao u WHERE u.email = ?1")
    UserDao findByEmail(String email);

}
