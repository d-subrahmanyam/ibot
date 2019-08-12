package com.subbu.ibot.web.servlets;

import com.github.seratch.jslack.app_backend.events.EventsDispatcher;
import com.github.seratch.jslack.app_backend.events.servlet.SlackEventsApiServlet;
import com.subbu.ibot.web.handlers.IBotAppHomeOpenedHandler;
import com.subbu.ibot.web.handlers.IBotAppMentionHandler;
import com.subbu.ibot.web.handlers.IBotMessageHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IBotServlet extends SlackEventsApiServlet {

    @Override
    protected void setupDispatcher(EventsDispatcher eventsDispatcher) {
        eventsDispatcher.register(new IBotAppMentionHandler());
        eventsDispatcher.register(new IBotMessageHandler());
        eventsDispatcher.register(new IBotAppHomeOpenedHandler());
    }
}
