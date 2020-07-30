package ru.stc23.eios.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Даянова Фаягуль
 */

@Entity
@Table(name= "Work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String work;
    private WorkState state;
    private LocalDateTime localDateTime;

    @ManyToOne(optional = false, cascade =CascadeType.ALL)
    @JoinColumn (name ="student_id")
    private Student student;


    @ManyToOne(optional = false, cascade =CascadeType.ALL)
    @JoinColumn (name ="teacher_id")
    private Teacher teacher;

    @OneToMany
    private List<Review> review;

    public Work() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDateTime getCreate_date() {
        return localDateTime;
    }

    public String getWork() {
        return work;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Review> getReview() {
        return review;
    }

    public WorkState getState() {
        return state;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudent (Student user) {
        this.student = user;
    }

    public void setCreate_date(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public void setState(WorkState state_id) {
        this.state = state_id;
    }
}
