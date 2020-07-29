package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.Role;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.Teacher;
import ru.stc23.eios.model.User;
import ru.stc23.eios.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * UserController
 *
 * @author Вершинин Пётр
 */
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String userList(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<User> page = userService.findUserAll(pageable);
        model.addAttribute("users", page);
        return "userlist";
    }

    @GetMapping("/student")
    public String studentList(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Student> page = userService.findStudentAll(pageable);
        model.addAttribute("students", page);
        return "studentList";
    }

    @GetMapping("/teacher")
    public String teacherList(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Teacher> page = userService.findTeacherAll(pageable);
        model.addAttribute("teachers", page);
        return "teacherList";
    }

    @GetMapping(value = {"edit", "/edit/{id}"})
    public String userEditForm(@PathVariable("id") Long id, Model model) throws RecordNotFoundException {
        if (id != null) {
            User userById = userService.getUserById(id);
            model.addAttribute("user", userById);
            model.addAttribute("roles", Role.values());
            return "useredit";
        }
        return "userlist";

    }

    @PostMapping("/edit")
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") Long userId
    ) throws RecordNotFoundException {
        User user = userService.getUserById(userId);
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping(value = {"delete", "/delete/{id}"})
    public String userDeleteForm(@PathVariable("id") Long id, Model model) throws RecordNotFoundException {
        User userById = userService.getUserById(id);
        userService.deleteUser(userById);
        return "redirect:/user";


    }


}
