package com.subbu.ibot.web.controllers;

import com.subbu.ibot.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Slf4j
@RestController
public class SlackApiController {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private AppProperties appProperties;

    @PostMapping("/ibot")
    public void handleSlackEvent(@RequestBody String json) {
        eventBus.notify("slackEventOccured", Event.wrap(json));
    }
}
