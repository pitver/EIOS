package ru.stc23.eios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ru.stc23.eios.model.Work;

import ru.stc23.eios.service.EventService;


@Controller
public class CalendarController {

    private final EventService eventService;

    public CalendarController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/calendar")
    public String calendar(Model model,
                           @ModelAttribute("work") Work work) {
        model.addAttribute("work",work);
        return "/calendar";
    }


/* @GetMapping("/eventlist")
    public String events(HttpServletRequest request, Model model,
                         @AuthenticationPrincipal User currentUser)
    {
        List<Event> events;
        events = eventService.eventListById(currentUser);
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("events", events);
        return "/events";
    }*/
}
