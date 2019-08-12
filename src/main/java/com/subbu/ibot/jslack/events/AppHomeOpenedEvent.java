package com.subbu.ibot.jslack.events;

import com.github.seratch.jslack.api.model.event.Event;
import lombok.Data;

@Data
public class AppHomeOpenedEvent implements Event {

    public static final String TYPE_NAME = "app_home_opened";

    private final String type = TYPE_NAME;
    private String user;
    private String channel;

}