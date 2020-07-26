package ru.stc23.eios.model;
import java.time.LocalDateTime;

/**
 * @author Даянова Фаягуль
 */

public class Review {

    private long id;
    private String text;
    private LocalDateTime localDateTime;
    private Work work;
    private User user;
    private Work_state state_id;


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

    public Work_state getState_id() {
        return state_id;
    }

    public void setState_id(Work_state state_id) {
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
