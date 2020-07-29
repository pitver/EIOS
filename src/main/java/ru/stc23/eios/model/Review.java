package ru.stc23.eios.model;
import javax.persistence.GenerationType;
import javax.persistence.*;

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
    private LocalDateTime localDateTime;

    @ManyToOne(optional = false, cascade =CascadeType.ALL)
    @JoinColumn (name ="id")
    private Work work;

    @ManyToOne(optional = false, cascade =CascadeType.ALL)
    @JoinColumn (name ="id")
    private User user;

    private WorkState state_id;


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

    public WorkState getState_id() {
        return state_id;
    }

    public void setState_id(WorkState state_id) {
        this.state_id = state_id;
    }

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

    public LocalDateTime getCreate_date() {
        return localDateTime;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.localDateTime = create_date;
    }

}
