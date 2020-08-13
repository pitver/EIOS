package ru.stc23.eios.service;

import org.springframework.stereotype.Service;
import ru.stc23.eios.model.Event;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.EventJpaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    private final EventJpaRepository eventJpaRepository;

    public EventService(EventJpaRepository eventJpaRepository) {
        this.eventJpaRepository = eventJpaRepository;
    }
    public Event addEvent(Event event){return eventJpaRepository.save(event);}
    public void deleteEvent(Event event){eventJpaRepository.delete(event);}
    public List<Event> eventList(){return eventJpaRepository.findAll();}

    public List<Event> eventListBetween(LocalDateTime start, LocalDateTime end, Student user)
    {
        return eventJpaRepository.findByDateBetween(start, end, user);
    }
    public List<Event> eventListById(User user){return eventJpaRepository.findByAuthor(user);}
}
