package ru.stc23.eios.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Даянова Фаягуль
 */
public class Work {

    private long id;
    private String title;
    private String work;
    private enum State {NEW, PUBLISH};
    private State state_id;
    private LocalDateTime localDateTime;
    private User user;
    private User teacher;
    private List<Review> review;

    public Work() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreate_date() {
        return localDateTime;
    }

    public String getWork() {
        return work;
    }

    public User getTeacher() {
        return teacher;
    }

    public List<Review> getReview() {
        return review;
    }

    public State getState_id() {
        return state_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreate_date(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public void setState_id(State state_id) {
        this.state_id = state_id;
    }
}
