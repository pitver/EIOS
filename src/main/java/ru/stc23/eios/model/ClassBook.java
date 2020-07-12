package ru.stc23.eios.model;

import java.time.LocalDate;

/**
 * @author Петр Вершинин
 */
public class ClassBook {
    //private User teacherName;
    //private User teacherSpecialty;
    //private List<User> listStudent;

    private long id;
    private String nameLesson;
    private LocalDate localDate;

    private String grade;// возможно тут тип byte, завист от того будет ли отмечатся болен или отсутсвует

    public ClassBook() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
