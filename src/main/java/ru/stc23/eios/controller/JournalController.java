package ru.stc23.eios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.stc23.eios.model.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JournalController {
    List<Student> studentList = new ArrayList<>();

    @GetMapping("/journal")
    public String getJournal(Model model){
        List<String> dateList = new ArrayList<>();

        addStudent(new Student(), "Ivanov");
        addStudent(new Student(), "Petrov");
        addStudent(new Student(), "Sidorov");
        addStudent(new Student(), "Smirnov");
        addStudent(new Student(), "Ivanova");
        addStudent(new Student(), "Petrova");
        addStudent(new Student(), "Sidorova");

        dateList.add("01.10.2020");
        dateList.add("02.10.2020");
        dateList.add("03.10.2020");
        dateList.add("04.10.2020");
        dateList.add("05.10.2020");
        dateList.add("06.10.2020");
        dateList.add("07.10.2020");
        dateList.add("08.10.2020");
        dateList.add("09.10.2020");
        dateList.add("10.10.2020");

        model.addAttribute("dateList", dateList);
        model.addAttribute("students", studentList);
        return "journal";
    }

    private void addStudent(Student student, String firstName) {
        student.setFirstName(firstName);
        studentList.add(student);
    }
}
