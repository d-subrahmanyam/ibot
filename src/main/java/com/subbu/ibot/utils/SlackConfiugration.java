package com.subbu.ibot.utils;

import com.github.seratch.jslack.Slack;

public interface SlackConfiugration {

    public String accessToken = "xoxp-661309753600-663151321767-690654058705-b990cbd74e29bb8183c3c63ce22f6999";
    public String botAccesstoken = "xoxb-661309753600-690654061953-xbfAv3ys43Q08IPeh3wyscON";
    public String signingSecret = "ef79030a70f48e1fea7017edae9188b7";
    public Slack slack = Slack.getInstance();
}
