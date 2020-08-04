package ru.stc23.eios.model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GenerationType;
import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Даянова Фаягуль
 */
@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;


    @ManyToOne(optional = false, cascade =CascadeType.ALL)
    private Work work;

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

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
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


}
