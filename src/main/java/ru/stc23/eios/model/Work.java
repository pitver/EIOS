package ru.stc23.eios.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private WorkState state;
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student author;


    /*@ManyToOne(optional = false, cascade =CascadeType.ALL)*/
    @Transient
    private Teacher teacher;

    /*@OneToMany*/
    @Transient
    private List<Review> review;

    public String getAuthorOfWork(){
        //после внедрения заменит на
        //author.getFirstName()+" "+author.getLastName()+" "+author.getPatronymic()
        return author !=null? author.getUsername():"<none>";
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

    public void setAuthor(Student user) {
        this.author = user;
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
