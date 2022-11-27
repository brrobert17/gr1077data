package com.example.gr1077data.serviceTest;

import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    EventService eventService;
    @Autowired
    EventRepo eventRepo;
}
