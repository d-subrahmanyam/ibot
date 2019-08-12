package com.subbu.ibot.utils;

import com.github.seratch.jslack.Slack;

public interface SlackConfiugration {

    public String accessToken = "<please replace this with your accessToken>";
    public String botAccesstoken = "<please replace this with your botAccessToken>";
    public String signingSecret = "<please replace this with your signing-secret>";
    public Slack slack = Slack.getInstance();
}
