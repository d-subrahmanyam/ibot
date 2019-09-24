package com.subbu.ibot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AppProperties {

    @Value("${ACCESS_TOKEN}")
    private String accessToken;

    @Value("${BOT_ACCESS_TOKEN}")
    private String botAccessToken;

    @Value("${SLACK_SIGNING_SECRET}")
    private String slackSigningSecret;

    @Value("${VERIFY_SLACK_SIGNATURE:true}")
    private boolean verifySlackSignature;

    @Value("${SLACK_EVENT_CHANNEL}")
    private String slackEventChannel;
}
