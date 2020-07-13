package ru.stc23.eios.model;

import java.sql.Clob;
import java.util.Date;

/**
 * @author Даянова Фаягуль
 */
public class Work {

    private long id;
    private String title;
    private int user;
    private Date create_date;
    private Clob work;
    private int teacher;
    private int review;
    private String state_id;

    public Work() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getUser() {
        return user;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Clob getWork() {
        return work;
    }

    public int getTeacher() {
        return teacher;
    }

    public int getReview() {
        return review;
    }

    public String getState_id() {
        return state_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setWork(Clob work) {
        this.work = work;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }
}
