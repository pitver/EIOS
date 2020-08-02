package ru.stc23.eios.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stc23.eios.model.Role;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.User;
import ru.stc23.eios.model.Work;
import ru.stc23.eios.service.WorkService;

import java.util.List;
import java.util.Set;

/**
 * @author Петр Вершинин
 */
@Controller
public class WorkKontroller {

    private final WorkService workService;

    public WorkKontroller(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/work")
    public String workList(
            @AuthenticationPrincipal User currentUser,
            Model model
    ) {
        List<Work> works;
        Set<Role> userRole=currentUser.getRoles();
        if(userRole.toString().contains("TEACHER")){
           works  = workService.workList();
        }else if (userRole.toString().contains("STUDENT")){
            works = workService.workListById(currentUser);
        }else {
            return "/worklist";
        }

        model.addAttribute("works", works);
        return "/worklist";
    }

    @PostMapping("/work")
    public String addWork(
            @AuthenticationPrincipal Student user,
            Model model,
            @RequestParam String title,
            @RequestParam String work,
            Work wrk
    ) {
        wrk.setAuthor(user);
        wrk.setTitle(title);
        wrk.setWork(work);
        workService.addWork(wrk);
        return "redirect:/work";
    }

}
