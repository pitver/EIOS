package ru.stc23.eios.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * @author Даянова Фаягуль
 */

@Entity
@Table(name = "Work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String work;

    @ElementCollection(targetClass = WorkState.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "work_state", joinColumns = @JoinColumn(name = "work_id"))
    @Enumerated(EnumType.STRING)
    private Set<WorkState> state;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student author;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rewiew_id")
    private Review review;

    public String getAuthorOfWork(){
        //после внедрения  author заменить на
        //author.getFirstName()+" "+author.getLastName()+" "+author.getPatronymic()
        return author !=null? author.getUsername():"<none>";
    }
    public String getAuthorComentOfWork(){
        //после внедрения teacher заменить на
        //teacher.getFirstName()+" "+teacher.getLastName()+" "+teacher.getPatronymic()
        return teacher !=null? teacher.getUsername():"<none>";
    }

    public Work() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Student getAuthor() {
        return author;
    }

    public String getWork() {
        return work;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Review getReview() {
        return review;
    }

    public Set<WorkState> getState() {
        return state;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Student user) {
        this.author = user;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public void setState(Set<WorkState> state) {
        this.state = state;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }


}
