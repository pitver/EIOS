package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stc23.eios.model.Mark;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String mark(Model model) {

        //получаем список студентов
        ru.stc23.eios.model.User user = new ru.stc23.eios.model.User(1L, "t", "t", "r", "ivan", "t", "t");
        ru.stc23.eios.model.User user1 = new ru.stc23.eios.model.User(1L, "t", "t", "r", "ivan1", "t", "t");


        List<ru.stc23.eios.model.User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        /*list.add(user2);
        list.add(user3);*/

        model.addAttribute("usr", list);

        //получаем список оценок по id_User
        LocalDate date = LocalDate.of(2020, 7, 10);
        Mark mark = new Mark(1L, user, user, "t", "2", date);


        List<Mark> listMarktoUserId = new ArrayList<>();

        listMarktoUserId.add(mark);
        model.addAttribute("mrk", listMarktoUserId);


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
