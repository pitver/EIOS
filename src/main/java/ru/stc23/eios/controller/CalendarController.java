package ru.stc23.eios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
    @GetMapping("/calendar")
    public String calendar(Model model) {
        return "/calendar";
    }

}
