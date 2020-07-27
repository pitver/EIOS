package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stc23.eios.model.*;
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
    public String register(Model model) {
        model.addAttribute("usrtype", UserType.values());
        return "/register";
    }

    @PostMapping("/register")
    public String addUser(@RequestParam String usertype,
                          @RequestParam String spec,
                          @RequestParam String username,
                          @RequestParam String email,
                          @RequestParam String password,
                          User user,
                          Map<String, Object> model
    ) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User exists");
            return "register";
        }


        if (usertype.equals("student")) {
            Student student =new Student();
            student.setUsername(username);
            student.setPassword(password);
            student.setActive(true);
            student.setRoles(Collections.singleton(Role.USER));
            userService.addUser(student);

        } else {
            Teacher teacher=new Teacher();
            teacher.setUsername(username);
            teacher.setPassword(password);
            teacher.setActive(true);
            teacher.setRoles(Collections.singleton(Role.USER));
            teacher.setSpecification(Collections.singleton(spec));
            userService.addUser(teacher);

        }


        return "redirect:/login";
    }
}
