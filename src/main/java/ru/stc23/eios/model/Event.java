package ru.stc23.eios.model;
import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String eventName;
    private EventStatus eventType;
    @Column(name="start")
    private LocalDateTime startDateTime;
    @Column(name="end")
    private LocalDateTime endDateTime;
    private String description;

    @ManyToOne(optional = false, cascade =CascadeType.ALL)
    @JoinColumn (name ="user_id")
    private User author;

    private EventStatus status;

    public Event() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(EventStatus eventType) {
        this.eventType = eventType;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(User author) {
        author = author;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public EventStatus getEventType() {
        return eventType;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public EventStatus getStatus() {
        return status;
    }
}
