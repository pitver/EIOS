package ru.stc23.eios.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.Mark;
import ru.stc23.eios.model.Role;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.User;
import ru.stc23.eios.service.MarkService;
import ru.stc23.eios.service.UserService;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Controller
public class JournalController {

    private final UserService userService;
    private final MarkService markService;

    public JournalController(UserService userService, MarkService markService) {
        this.userService = userService;
        this.markService = markService;
    }


    @GetMapping("mark")
    public String getMark(
            Model model,
            @AuthenticationPrincipal User currentUser,
            @PageableDefault(size = 10) Pageable pageable) {

        Set<Role> userRole = currentUser.getRoles();
        Page<Student> page;
        if (userRole.toString().contains("STUDENT")) {
             page=userService.findByID(currentUser.getId(),pageable);
        }else{
            page = userService.findStudentAll(pageable);
        }
        List<Integer> dateList = new ArrayList<>();

        /*************получаем название текущего месяца на русском языке+коллекцию заполненную днями месяца**********/
        String monthName = getNameMonthAndMonthLength(dateList, LocalDate.now());


        List<Mark> markAll = markService.findMarkAll();
        model.addAttribute("monthValue", LocalDate.now());
        model.addAttribute("marks", markAll);
        model.addAttribute("month", monthName);
        model.addAttribute("dateList", dateList);
        model.addAttribute("student", page);
        model.addAttribute("curentuser",currentUser);
        return "mark";
    }


    @PostMapping("mark")
    public String setMark(Model model,
                          @RequestParam("markDate") String markDate,
                          @AuthenticationPrincipal User currentUser,
                          @PageableDefault(size = 10) Pageable pageable) {
        Set<Role> userRole = currentUser.getRoles();
        Page<Student> page;
        if (userRole.toString().contains("STUDENT")) {
            page=userService.findByID(currentUser.getId(),pageable);
        }else{
            page = userService.findStudentAll(pageable);
        }

        List<Integer> dateList = new ArrayList<>();
/*************получаем название выбранного месяца на русском языке**********/
        String monthName = getNameMonthAndMonthLength(dateList, LocalDate.parse(markDate));

        List<Mark> markAll = markService.findMarkAll();


        model.addAttribute("monthValue", LocalDate.parse(markDate));
        model.addAttribute("marks", markAll);
        model.addAttribute("month", monthName);
        model.addAttribute("dateList", dateList);
        model.addAttribute("student", page);
        model.addAttribute("curentuser",currentUser);
        return "mark";
    }


    @PostMapping("addmark")
    public String add(Model model,
                      @RequestParam("studentid") Long studentId,
                      @RequestParam("gradedata") String data,

                      @RequestParam("gradenew") String gradenew,
                      @ModelAttribute("mark") Mark mark) throws RecordNotFoundException {

        Student st = (Student) userService.getUserById(studentId);
        mark.setGrade(gradenew);
        mark.setLocalDate(LocalDate.parse(data));
        mark.setStudent(st);
        markService.add(mark);

        return "redirect:mark";
    }

    private String getNameMonthAndMonthLength(List<Integer> dateList, LocalDate localDate) {
        Locale localeRu = new Locale("ru", "RU");
        int daysInMonth = localDate.lengthOfMonth();
        String monthName = localDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, localeRu);
        for (int i = 1; i <= daysInMonth; i++) {
            dateList.add(i);
        }
        return monthName;
    }

}
