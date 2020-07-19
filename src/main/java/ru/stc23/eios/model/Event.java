package ru.stc23.eios.model;

import java.time.LocalDateTime;

public class Event {
    private long id;
    private String eventName;
    private enum EventType {LESSON, EXAMINATION, HOMEWORK};
    private EventType eventType;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String description;
    private User Author;
    private enum Status {PLANNED, INWORK, CHECKED, CANCELLED};
    private Status status;

    public Event() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(EventType eventType) {
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
        Author = author;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public EventType getEventType() {
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
        return Author;
    }

    public Status getStatus() {
        return status;
    }
}
