package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * MainController
 *
 * @author Вершинин Пётр
 */
@Controller
@EnableWebSecurity
public class MainController {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public MainController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/mark")
    public String mark() {
        
        return "/mark";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @PostMapping("/register")
    public String addUser(
            @RequestParam("username") String name,
            @RequestParam("password") String password/*,
            @RequestParam("email") String email*/
    ) {

            inMemoryUserDetailsManager.createUser(User.withUsername(name).password(password).roles("USER").build());

        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
