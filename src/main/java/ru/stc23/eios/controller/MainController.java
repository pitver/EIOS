package ru.stc23.eios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.stc23.eios.model.User;

import java.util.List;

/**
 * MainController
 *
 * @author Вершинин Пётр
 */
@Controller
public class MainController {
    @GetMapping("/mark")
    public String mark(Model model) {

        return "/mark";
    }

}
