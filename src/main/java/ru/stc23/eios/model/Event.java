package ru.stc23.eios.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "event")

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String eventName;
    private String description;
    @ElementCollection(targetClass = EventType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "event_type", joinColumns = @JoinColumn(name = "event_id"))
    @Enumerated(EnumType.STRING)
    private Set<EventType> eventType;

    @Column(name = "start")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime startDateTime;
    @Column(name = "end")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime endDateTime;


    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private Teacher author;

    private String studentGroup;

    @ElementCollection(targetClass = EventStatus.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "event_state", joinColumns = @JoinColumn(name = "event_id"))
    @Enumerated(EnumType.STRING)
    private Set<EventStatus> status;


    public Event() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(Set<EventType> eventType) {
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

    public void setAuthor(Teacher author) {
        this.author = author;
    }

    public void setStatus(Set<EventStatus> status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public Set<EventType> getEventType() {
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

    public Teacher getAuthor() {
        return author;
    }

    public Set<EventStatus> getStatus() {
        return status;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

}
