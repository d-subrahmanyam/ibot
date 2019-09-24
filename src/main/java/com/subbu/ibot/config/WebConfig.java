package com.subbu.ibot.config;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.springboot.web.filters.SlackEventFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<SlackEventFilter> slackEventFilterFilterRegistrationBean(){
        FilterRegistrationBean<SlackEventFilter>  slackEventFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        slackEventFilterFilterRegistrationBean.addUrlPatterns("/ibot");
        slackEventFilterFilterRegistrationBean.setFilter(new SlackEventFilter());
        return slackEventFilterFilterRegistrationBean;
    }

    @Bean
    public Slack slack() {
        return Slack.getInstance();
    }
}
