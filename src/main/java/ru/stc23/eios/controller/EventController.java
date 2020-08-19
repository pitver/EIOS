package ru.stc23.eios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.stc23.eios.model.*;
import ru.stc23.eios.service.EventService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> events(@AuthenticationPrincipal User currentUser, Model model) {
        List<Event> events=null ;
        Set<Role> userRole = currentUser.getRoles();
        if (userRole.toString().contains("STUDENT")){
            events = eventService.findEventByStudentGroup(currentUser.getId());
        }else if (userRole.toString().contains("TEACHER")) {
            events = eventService.findEventByTeacher(currentUser);
        }
        return events;
    }

    @PostMapping("/event")
    public RedirectView addEvent(@RequestParam("eventName") String eventName,
                                 @RequestParam("eventtype") String eventType,
                                 @RequestParam("description") String description,
                                 @RequestParam("startdateandtime") String startDateTime,
                                 @RequestParam("enddateandtime") String endDateTime,
                                 @RequestParam("spec") String spec,
                                 @AuthenticationPrincipal Teacher user
    ) {
        Event event =new Event();
        event.setStatus(Collections.singleton(EventStatus.PLANNED));
        event.setAuthor(user);
        event.setEventName(eventName);
        if(eventType.equals("lecture")){
            event.setEventType(Collections.singleton(EventType.LECTURE));
        }else{
            event.setEventType(Collections.singleton(EventType.EXAM));
        }
        event.setDescription(description);
        event.setStudentGroup(spec);
        event.setStartDateTime(LocalDateTime.parse(startDateTime));
        event.setEndDateTime(LocalDateTime.parse(endDateTime));
        eventService.addEvent(event);
        return new RedirectView("calendar");
    }

}


