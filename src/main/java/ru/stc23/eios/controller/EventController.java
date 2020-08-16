package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.stc23.eios.exception.BadDateFormatException;
import ru.stc23.eios.model.*;
import ru.stc23.eios.service.EventService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
/*
    @GetMapping("/events")
    public List<Event> events() {
        return eventService.eventList();
    }*/

    @GetMapping("/events")
    public List<Event> events(@AuthenticationPrincipal User currentUser) {
        List<Event> events;
        events = eventService.eventListById(currentUser);
        return events;
    }

    @PostMapping("/events")
    public Event addEvent(@RequestParam("eventName") String eventName,
                          @AuthenticationPrincipal Student user
                          ) {
        Event event =new Event();
        event.setEventName(eventName);
        event.setAuthor(user);

       /* event.setStatus(Collections.singleton(EventStatus.PLANNED));
        event.setAuthor(user);
        event.setEventName(event.getEventName());
        event.setEventType(event.getEventType());
        event.setDescription(event.getDescription());
        event.setStartDateTime(event.getStartDateTime());
        event.setEndDateTime(event.getEndDateTime());*/
        Event created =  eventService.addEvent(event);
        return created;
    }
   /* public String addEvent(
            @AuthenticationPrincipal Student user,
            Model model,
            @ModelAttribute("events") Event event

    ) {
       event.setStatus(Collections.singleton(EventStatus.PLANNED));
        event.setAuthor(user);
        event.setEventName(event.getEventName());
          event.setEventType(event.getEventType());
        event.setDescription(event.getDescription());
        event.setStartDateTime(event.getStartDateTime());
        event.setEndDateTime(event.getEndDateTime());
        eventService.addEvent(event);
        return "/events";
    }*/
/*

    @GetMapping("/events")
    public List<Event> getEventsInRange(@RequestParam(value = "start", required = true) String start,
                                        @RequestParam(value = "end", required = true) String end,
                                        @AuthenticationPrincipal Student currentUser)
     {
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat inputDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDate = inputDateFormat.parse(start);
        } catch (ParseException e) {
            throw new BadDateFormatException("bad start date: " + start);
        }

        try {
            endDate = inputDateFormat.parse(end);
        } catch (ParseException e) {
            throw new BadDateFormatException("bad end date: " + end);
        }

        LocalDateTime startDateTime = LocalDateTime.ofInstant(startDate.toInstant(),
                ZoneId.systemDefault());

        LocalDateTime endDateTime = LocalDateTime.ofInstant(endDate.toInstant(),
                ZoneId.systemDefault());

        return eventService.eventListBetween(startDateTime, endDateTime, currentUser);
    }

*/

}


