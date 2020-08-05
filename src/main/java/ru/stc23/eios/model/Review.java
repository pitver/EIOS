package ru.stc23.eios.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GenerationType;
import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Даянова Фаягуль
 */
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "text")
    private String text;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Work comment;

    @ManyToOne
    private User user;

    /* private WorkState state_id;*/


    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Work getComment() {
        return comment;
    }

    public void setComment(Work work) {
        this.comment = work;
    }

   /* public WorkState getState_id() {
        return state_id;
    }

    public void setState_id(WorkState state_id) {
        this.state_id = state_id;
    }*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setCreate_date(LocalDate create_date) {
        this.localDate = create_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                Objects.equals(text, review.text) &&
                Objects.equals(localDate, review.localDate) &&
                Objects.equals(comment, review.comment) &&
                Objects.equals(user, review.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, localDate, comment, user);
    }
}
