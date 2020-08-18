package ru.stc23.eios.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
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
    @Column(columnDefinition = "text")
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

    @OneToOne(cascade = CascadeType.ALL)
    private Mark mark;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


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

    @OneToOne
    @JoinColumn(name = "id")
    private FileBase64 fileBase64;

    public FileBase64 getFileBase64() {
        return fileBase64;
    }

    public void setFileBase64(FileBase64 fileBase64) {
        this.fileBase64 = fileBase64;
    }

    public Work() {

    }

    public long getId() {
        return id;
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

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work1 = (Work) o;
        return id == work1.id &&
                Objects.equals(title, work1.title) &&
                Objects.equals(work, work1.work) &&
                Objects.equals(state, work1.state) &&
                Objects.equals(createDate, work1.createDate) &&
                Objects.equals(author, work1.author) &&
                Objects.equals(mark, work1.mark) &&
                Objects.equals(teacher, work1.teacher) &&
                Objects.equals(review, work1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, work, state, createDate, author, mark, teacher, review);
    }
}
