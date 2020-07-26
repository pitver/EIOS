package ru.stc23.eios.model;

import java.time.LocalDate;

/**
 * @author Петр Вершинин
 */
public class Mark {


    private long id;
    private User teacherName;
    private User studentName;
    private String nameLesson;
    private String grade;
    private LocalDate localDate;

    public Mark() {
    }

    public Mark(long id, User teacherName, User studentName, String nameLesson, String grade, LocalDate localDate) {
        this.id = id;
        this.teacherName = teacherName;
        this.studentName = studentName;
        this.nameLesson = nameLesson;
        this.grade = grade;
        this.localDate = localDate;
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

    public User getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(User teacherName) {
        this.teacherName = teacherName;
    }

    public User getStudentName() {
        return studentName;
    }

    public void setStudentName(User studentName) {
        this.studentName = studentName;
    }
}

