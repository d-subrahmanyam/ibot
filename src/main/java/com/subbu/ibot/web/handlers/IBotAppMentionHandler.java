package com.subbu.ibot.web.handlers;

import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest;
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse;
import com.github.seratch.jslack.app_backend.events.handler.AppMentionHandler;
import com.github.seratch.jslack.app_backend.events.payload.AppMentionPayload;
import com.subbu.ibot.utils.SlackConfiugration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;

@Slf4j
public class IBotAppMentionHandler extends AppMentionHandler implements SlackConfiugration {

    @Override
    public void handle(AppMentionPayload appMentionPayload) {
        log.debug("appMentionPayload - {}", appMentionPayload.toString());
        try {
            if (slack == null) {
                log.debug("seems like the slack instance hasnt been initialized");
            }
            ChatPostMessageResponse chatPostMessageResponse = slack.methods().chatPostMessage(
                    ChatPostMessageRequest.builder()
                            .token(accessToken)
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
