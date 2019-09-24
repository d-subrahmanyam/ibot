package com.subbu.ibot.web.handlers;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest;
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse;
import com.github.seratch.jslack.app_backend.events.handler.AppMentionHandler;
import com.github.seratch.jslack.app_backend.events.payload.AppMentionPayload;
import com.github.seratch.jslack.springboot.annotations.SlackEvent;
import com.subbu.ibot.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Slf4j
@SlackEvent
public class IBotAppMentionHandler extends AppMentionHandler {

    @Autowired
    private Slack slack;

    @Autowired
    private AppProperties appProperties;

    @Override
    public void handle(AppMentionPayload appMentionPayload) {
        log.debug("appMentionPayload - {}", appMentionPayload.toString());
        try {
            ChatPostMessageResponse chatPostMessageResponse = slack.methods().chatPostMessage(
                    ChatPostMessageRequest.builder()
                            .token(appProperties.getAccessToken())
                            .channel(appMentionPayload.getEvent().getChannel())
                            .text("Hola!!!")
                            .build()
            );
        } catch (IOException ioe) {
            log.error("IOException while processing appMentionPayload - \n{}", ExceptionUtils.getStackTrace(ioe));
        } catch (SlackApiException sae) {
            log.error("SlackApiException while processing appMentionPayload - \n{}", ExceptionUtils.getStackTrace(sae));
        }
    }
}
