package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stc23.eios.model.Role;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.UserRepo;
import ru.stc23.eios.service.UserService;

import java.util.Collections;
import java.util.Map;

/**
 * RegistrationController
 *
 * @author Вершинин Пётр
 */
@Controller
public class RegistrationController {



    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @PostMapping("/register")
    public String addUser(User user, Map<String,Object> model
) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());

        if (userFromDb!=null){
            model.put("message","User exists");
            return "register";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.addUser(user);
        return "redirect:/login";
    }
}
