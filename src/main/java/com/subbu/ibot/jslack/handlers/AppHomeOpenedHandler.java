package com.subbu.ibot.jslack.handlers;

import com.github.seratch.jslack.app_backend.events.EventHandler;
import com.subbu.ibot.jslack.events.AppHomeOpenedEvent;
import com.subbu.ibot.jslack.payloads.AppHomeOpenedPayload;

public abstract class AppHomeOpenedHandler extends EventHandler<AppHomeOpenedPayload> {

    @Override
    public String getEventType() {
        return AppHomeOpenedEvent.TYPE_NAME;
    }
}
