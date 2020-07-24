package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.UserRepo;
import ru.stc23.eios.service.UserService;

import java.util.Optional;

/**
 * UserController
 *
 * @author Вершинин Пётр
 */
@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String userList(Model model){
        model.addAttribute("users",userService.findUserAll());
        return "userlist";
    }

    @GetMapping(value ={"edit","/edit/{id}"})
    public String userEditForm(@PathVariable("id") Long id, Model model)throws RecordNotFoundException {

        if (id !=null) {
            User userById = userService.getUserById(id);
            model.addAttribute("user", userById);
            return "useredit";
        }
            return "userlist";

    }
}
