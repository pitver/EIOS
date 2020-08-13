package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.stc23.eios.model.Event;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.EventJpaRepository;
import ru.stc23.eios.service.EventService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CalendarController {

    private final EventService eventService;

    public CalendarController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/calendar")
    public String calendar(Model model) {
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
