package com.stupin.carServiceAndWash.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password, enabled from users where email=?")
                .authoritiesByUsernameQuery("select email, role from users where email=?");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("ui/users/**").hasRole("USER")
                .mvcMatchers("ui/admin/**").hasAuthority("ADMIN")
                .mvcMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .defaultSuccessUrl("/", true)
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }



    //    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withUsername("user")
//                        .password(encoder().encode("user"))
//                        .roles("USER")
//                        .build();
//        UserDetails admin =
//                User.withUsername("admin")
//                        .password(encoder().encode("admin"))
//                        .roles("ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    //    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withUsername("user")
//                        .password(encoder().encode("user"))
//                        .roles("USER")
//                        .build();
//        UserDetails admin =
//                User.withUsername("admin")
//                        .password(encoder().encode("admin"))
//                        .roles("ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withUsername("5@5")
//                .password(passwordEncoder().encode("user1Pass"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}