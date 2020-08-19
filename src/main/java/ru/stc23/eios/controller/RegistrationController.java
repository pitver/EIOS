package ru.stc23.eios.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("usrtype", UserType.values());
        return "register";
    }

    @PostMapping("register")
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
            userFromDb.setRoles(Collections.singleton(Role.TEACHER));
        }
        if(usertype.equals("student")){
            student.setStudentGroup(Collections.singleton(spec));
            userFromDb=student;
            userFromDb.setRoles(Collections.singleton(Role.STUDENT));
        }

        userFromDb.setUsername(username);
        userFromDb.setPassword(password);
        userFromDb.setEmail(email);
        userFromDb.setActive(true);
        userFromDb.setPassword(passwordEncoder.encode(userFromDb.getPassword()));
        userService.addUser(userFromDb);


        return "redirect:user";
    }
}
