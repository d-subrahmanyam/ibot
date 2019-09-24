package com.subbu.ibot.web.handlers;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest;
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse;
import com.github.seratch.jslack.app_backend.events.handler.MessageHandler;
import com.github.seratch.jslack.app_backend.events.payload.MessagePayload;
import com.github.seratch.jslack.springboot.annotations.SlackEvent;
import com.subbu.ibot.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Slf4j
@SlackEvent
public class IBotMessageHandler extends MessageHandler {

    @Autowired
    private Slack slack;

    @Autowired
    private AppProperties appProperties;

    @Override
    public void handle(MessagePayload messagePayload) {
        log.debug("messagePayload - {}", messagePayload.toString());
        try {
            if (slack == null) {
                log.debug("seems like the slack instance hasnt been initialized");
            }
            if(messagePayload.getEvent().getUser()!=null || !messagePayload.getEvent().getSubtype().equalsIgnoreCase("bot_message")) {
                ChatPostMessageResponse chatPostMessageResponse = slack.methods().chatPostMessage(
                        ChatPostMessageRequest.builder()
                                .token(appProperties.getAccessToken())
                                .channel(messagePayload.getEvent().getChannel())
                                .text("Hola!!!")
                                .build()
                );
            } else {
                log.debug("seems like this was the bot message event, so ignore processing...");
            }
        } catch (IOException ioe) {
            log.error("IOException while processing appMentionPayload - \n{}", ExceptionUtils.getStackTrace(ioe));
        } catch (SlackApiException sae) {
            log.error("SlackApiException while processing appMentionPayload - \n{}", ExceptionUtils.getStackTrace(sae));
        }
    }
}
