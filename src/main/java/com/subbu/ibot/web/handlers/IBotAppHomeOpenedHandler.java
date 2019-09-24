package com.subbu.ibot.web.handlers;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest;
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse;
import com.github.seratch.jslack.app_backend.events.handler.AppHomeOpenedHandler;
import com.github.seratch.jslack.app_backend.events.payload.AppHomeOpenedPayload;
import com.github.seratch.jslack.springboot.annotations.SlackEvent;
import com.subbu.ibot.config.AppProperties;
import com.subbu.ibot.utils.SlackTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Slf4j
@SlackEvent
public class IBotAppHomeOpenedHandler extends AppHomeOpenedHandler {

    @Autowired
    private Slack slack;

    @Autowired
    private AppProperties appProperties;

    @Override
    public void handle(AppHomeOpenedPayload appHomeOpenedPayload) {
        log.debug("appHomeOpenedPayload - {}", appHomeOpenedPayload.toString());
        try {
            if (slack == null) {
                log.debug("seems like the slack instance hasnt been initialized");
            }
            ChatPostMessageResponse chatPostMessageResponse = slack.methods().chatPostMessage (
                    ChatPostMessageRequest.builder()
                            .token(appProperties.getAccessToken())
                            .channel(appHomeOpenedPayload.getEvent().getChannel())
                            .blocksAsString(SlackTemplateUtils.getTemplate("payload-welcome.json"))
                            .mrkdwn(true)
                            .build()
            );
        } catch (IOException ioe) {
            log.error("IOException while processing appMentionPayload - \n{}", ExceptionUtils.getStackTrace(ioe));
        } catch (SlackApiException sae) {
            log.error("SlackApiException while processing appMentionPayload - \n{}", ExceptionUtils.getStackTrace(sae));
        }
    }

}
