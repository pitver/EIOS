package ru.stc23.eios.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.Mark;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.Work;
import ru.stc23.eios.service.MarkService;
import ru.stc23.eios.service.UserService;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

@Controller
public class JournalController {

    private final UserService userService;
    private final MarkService markService;

    public JournalController(UserService userService, MarkService markService) {
        this.userService = userService;
        this.markService = markService;
    }


    @GetMapping("/mark")
    public String getMark(
            Model model,
            @PageableDefault(size = 10) Pageable pageable) {
        Page<Student> page = userService.findStudentAll(pageable);

        List<Integer> dateList = new ArrayList<>();
        /*************получаем номер текущего месяца**********/
        LocalDate localDate = LocalDate.now();
        int monthValue = localDate.getMonthValue();
        /*************получаем название текущего месяца на русском языке+коллекцию заполненную днями месяца**********/
        String monthName = getNameMonthAndMonthLength(dateList, localDate);


        List<Mark> markAll = markService.findMarkAll();
        model.addAttribute("monthValue", monthValue);
        model.addAttribute("marks", markAll);
        model.addAttribute("month", monthName);
        model.addAttribute("dateList", dateList);
        model.addAttribute("student", page);
        return "mark";
    }


    @PostMapping("/mark")
    public String setMark(Model model,
                          @RequestParam("markDate") String markDate,
                          @PageableDefault(size = 10) Pageable pageable) {
        Page<Student> page = userService.findStudentAll(pageable);

        List<Integer> dateList = new ArrayList<>();
        /*************получаем номер выбранного месяца**********/
        LocalDate ld = LocalDate.parse(markDate);
        int monthValue = ld.getMonthValue();
/*************получаем название выбранного месяца на русском языке**********/
        String monthName = getNameMonthAndMonthLength(dateList, ld);

        List<Mark> markAll = markService.findMarkAll();

        /*Map<Page<Student>,List<Mark>> studentMarkMap=new HashMap<>();
        studentMarkMap.put(page,markAll);
        model.addAttribute("studentMarkMap",studentMarkMap);*/

        model.addAttribute("monthValue", monthValue);
        model.addAttribute("marks", markAll);
        model.addAttribute("month", monthName);
        model.addAttribute("dateList", dateList);
        model.addAttribute("student", page);
        return "mark";
    }

    @GetMapping("/addmark")
    public String getNewMark(Model model) {
        model.addAttribute("mark",new Mark());
        return "addmark";
    }

    @PostMapping("/addmark")
    public String add(Model model,
            @RequestParam("studentid")Long studentId,
            /*@RequestParam("gradedata")String data,*/
            @ModelAttribute("mark") Mark mark) throws RecordNotFoundException {

        Student st= (Student) userService.getUserById(studentId);
        mark.setGrade(mark.getGrade());
        mark.setLocalDate(mark.getLocalDate());
        mark.setStudent(st);
        markService.add(mark);

        return "redirect:/mark";
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
