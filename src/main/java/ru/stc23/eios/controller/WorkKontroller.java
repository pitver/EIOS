package ru.stc23.eios.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.*;
import ru.stc23.eios.service.WorkService;

import java.time.LocalDate;
import java.util.Collections;
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
        Set<Role> userRole = currentUser.getRoles();
        if (userRole.toString().contains("STUDENT")) {
            works = workService.workListById(currentUser);
        } else {
            works = workService.workList();
        }
        model.addAttribute("works", works);
        return "/worklist";
    }

    @PostMapping("/work")
    public String addWork(
            @AuthenticationPrincipal Student user,
            Model model,
            @RequestParam("title") String title,
            @RequestParam("work") String studentWork,
            @RequestParam("createDate") String createDate,
            Work wrk
    ) {
        wrk.setState(Collections.singleton(WorkState.NEW));
        wrk.setCreateDate(LocalDate.parse(createDate));
       /* wrk.setReview(new Review());*/
        wrk.setAuthor(user);
        wrk.setTitle(title);
        wrk.setWork(studentWork);
        workService.addWork(wrk);
        return "redirect:/work";
    }


    @GetMapping(value = {"workdelete", "/workdelete/{id}"})
    public String workDeleteForm(@PathVariable("id") Long id) throws RecordNotFoundException {
        Work workById = workService.findById(id);
        Review review=workService.findWorkByWorkId(workById);
        workService.deleteReview(review);
        workService.deleteWork(workById);
        return "redirect:/work";

    }

    @GetMapping(value = {"workedit", "/workedit/{id}"})
    public String editWork(@PathVariable("id") Long id, Model model) throws RecordNotFoundException {
        if (id != null) {
            Work works = workService.findById(id);
            model.addAttribute("works", works);
            return "workedit";
        }
        return "worklist";

    }

    @PostMapping("/workedit")
    public String workEditSave(
            @AuthenticationPrincipal Teacher user,
            @RequestParam("title") String title,
            @RequestParam("work") String studentWork,
            @RequestParam("createDate") String createDate,
            @RequestParam("workId") Long workId,
            @RequestParam("review.localDate") String createCommentDate,
            @RequestParam("review.work.work")String comment

    ) throws RecordNotFoundException {
        Work wrk = workService.findById(workId);

        Review review= workService.findWorkByWorkId(wrk);

        review.setText(comment);
        review.setCreate_date(LocalDate.parse(createCommentDate));
        review.setUser(user);
        review.setWork(wrk);

        wrk.setReview(review);
        wrk.setTeacher(user);
        wrk.setCreateDate(LocalDate.parse(createDate));
        wrk.setTitle(title);
        wrk.setWork(studentWork);
        workService.addWork(wrk);
        return "redirect:/work";
    }
}
