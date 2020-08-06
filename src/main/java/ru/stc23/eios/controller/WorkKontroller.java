package ru.stc23.eios.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.*;
import ru.stc23.eios.service.WorkService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        work.setCreateDate(work.getCreateDate());
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
            @RequestParam Map<String, String> form,
            @AuthenticationPrincipal Teacher user

    ) throws RecordNotFoundException {
        Work wrk = workService.findById(work.getId());
        Review review = workService.findReviewByWorkId(wrk);
        review.setText(work.getReview().getText());
        review.setCreate_date(work.getReview().getLocalDate());
        review.setUser(user);
        review.setComment(work);
        work.setReview(review);

        Set<String> state = Arrays.stream(WorkState.values())
                .map(WorkState::name)
                .collect(Collectors.toSet());
        wrk.getState().clear();
        for (String key : form.keySet()) {
            if (state.contains(key)) {
             /*   work.setState(wrk.getState().add(WorkState.valueOf(key)));*/
                if(key.contains("NEW")){
                    work.setState(Collections.singleton(WorkState.NEW));
                }else {
                    work.setState(Collections.singleton(WorkState.PUBLISH));
                }


            }
        }



/*        work.getReview().setText(work.getReview().getText());
        work.getReview().setUser(user);
        work.getReview().setComment(work);
        work.getReview().setCreate_date(work.getReview().getLocalDate());*/

        work.setTeacher(user);
        /*work.setState(Collections.singleton(WorkState.NEW));*/
        work.setCreateDate(work.getCreateDate());
        work.setTitle(work.getTitle());
        work.setWork(work.getWork());
        workService.addWork(work);
        return "redirect:/work";
    }
}
