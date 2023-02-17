package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.dao.User;
import com.stupin.carServiceAndWash.repository.UserRepository;
import com.stupin.carServiceAndWash.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.stupin.carServiceAndWash.converter.UserConverter.toEntity;

@Controller
public class RegisterAndLoginController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final Logger log = LogManager.getLogger(RegisterAndLoginController.class);

    @Autowired
    public RegisterAndLoginController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegistrationFormPage(Model model) {
        model.addAttribute("user", new User());
        return "register/register_page";
    }

    @PostMapping("process-register")
    public String processRegister(@ModelAttribute User user,
                                  @RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam String email,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String password
    ) {
        if (userRepository.findByEmail(email) != null) {
            return "redirect:/register-error";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(encodedPassword);
        user.setName(name);
        user.setSurname(surname);
        userRepository.save(toEntity(user));
        return "redirect:/register-success";
    }

    @GetMapping("/register-success")
    public String getSuccessRegisterPage() {
        return "register/register_success";
    }
    @GetMapping("/register-error")
    public String getRegistrationErrorPage() {
        return "register/register_error";
    }


    @GetMapping("/login")
    public String getLoginPage() {

        return "login_page";
    }
}
