package ru.stc23.eios.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        Work work = new Work();
        model.addAttribute("works", works);
        model.addAttribute("work", work);
        return "/worklist";
    }

    @PostMapping("/work")
    public String addWork(
            @AuthenticationPrincipal Student user,
            Model model,
            @ModelAttribute("work") Work work

    ) {

        work.setState(Collections.singleton(WorkState.NEW));
        work.setCreateDate(LocalDate.now());
        work.setAuthor(user);
        work.setTitle(work.getTitle());
        work.setWork(work.getWork());
        workService.addWork(work);
        return "redirect:/work";
    }


    @GetMapping(value = {"workdelete", "/workdelete/{id}"})
    public String workDeleteForm(@PathVariable("id") Long id) throws RecordNotFoundException {
        Work workById = workService.findById(id);
        Review review = workService.findReviewByWorkId(workById);
        workService.deleteReview(review);
        workService.deleteWork(workById);
        return "redirect:/work";

    }

    @GetMapping(value = {"workedit", "/workedit/{id}"})
    public String editWork(@PathVariable("id") Long id, Model model) throws RecordNotFoundException {
        if (id != null) {
            Work work = workService.findById(id);
            model.addAttribute("workstate", WorkState.values());
            model.addAttribute("work", work);
            return "workedit";
        }
        return "worklist";

    }

    @PostMapping("/workedit")
    public String workEditSave(
            @ModelAttribute("works") Work work,
            /*@RequestParam Map<String, String> form,*/
            @AuthenticationPrincipal Teacher user

    ) throws RecordNotFoundException {
        Work wrk = workService.findById(work.getId());
        Review review = workService.findReviewByWorkId(wrk);
        Mark mark = workService.findMarkByWorkId(wrk);
        review.setText(work.getReview().getText());
        review.setCreate_date(work.getReview().getLocalDate());
        review.setUser(user);
        review.setComment(work);
        work.setReview(review);


        mark.setGrade(work.getMark().getGrade());
        mark.setLocalDate(work.getCreateDate());
        mark.setNameLesson(work.getTitle());
        mark.setStudent(wrk.getAuthor());
        mark.setTeacher(user);
        mark.setWork(work);
        work.setMark(mark);

        work.setTeacher(user);
        work.setState(work.getState());
        work.setAuthor(wrk.getAuthor());
        work.setCreateDate(work.getCreateDate());
        work.setTitle(work.getTitle());
        work.setWork(work.getWork());
        workService.addWork(work);
        return "redirect:/work";
    }
}
