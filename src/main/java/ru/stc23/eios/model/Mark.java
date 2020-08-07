package ru.stc23.eios.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Петр Вершинин
 */
@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Teacher teacherName;

    @ManyToOne(fetch = FetchType.EAGER)
    private Student studentName;


    private String nameLesson;
    private String grade;
    private LocalDate localDate;

    @OneToOne
    private Work work;

    public Mark() {
    }

    public Mark(long id, Teacher teacherName, Student studentName, String nameLesson, String grade, LocalDate localDate) {
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

    public void setTeacherName(Teacher teacherName) {
        this.teacherName = teacherName;
    }

    public User getStudentName() {
        return studentName;
    }

    public void setStudentName(Student studentName) {
        this.studentName = studentName;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}

