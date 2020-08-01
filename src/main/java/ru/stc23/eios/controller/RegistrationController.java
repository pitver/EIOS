package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stc23.eios.model.*;
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


    final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

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

                          Map<String, Object> model
    ) {
        User userFromDb = (User) userService.loadUserByUsername(username);
        if (userFromDb != null) {
            model.put("message", "User exists");
            return "register";
        }

        Teacher teacher= new Teacher();
        Student student= new Student();

        if(usertype.equals("teacher")){
            teacher.setSpecification(Collections.singleton(spec));
            userFromDb=teacher;
        }
        if(usertype.equals("student")){
            student.setStudentGroup(Collections.singleton(spec));
            userFromDb=student;
        }

        userFromDb.setUsername(username);
        userFromDb.setPassword(password);
        userFromDb.setEmail(email);
        userFromDb.setActive(true);
        userFromDb.setRoles(Collections.singleton(Role.USER));
        userService.addUser(userFromDb);


        return "redirect:/login";
    }
}
