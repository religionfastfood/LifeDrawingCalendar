package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.config.InsecureSecurityConfig;
import com.example.lifedrawingcalendar.model.Event;
import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
@Import(InsecureSecurityConfig.class)
public class EventControllerTest {

    @MockitoBean
    EventService eventService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    public void testList() throws Exception {
        List<Event> events = Arrays.asList(
                new Event(1L, "event name", "event location", LocalDateTime.parse("2026-03-05T07:00:00"),
                        new User().withFirstName("Chris"),
                        new User().withFirstName("Chris")
                )
        );

        when(eventService.list()).thenReturn(events);

        ResultActions result = mockMvc.perform(get("")
                .header("HX-Request", "true")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}
