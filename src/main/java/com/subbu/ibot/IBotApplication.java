package com.subbu.ibot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.github.seratch.jslack.springboot", "com.subbu.ibot"})
public class IBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(IBotApplication.class, args);
    }

}
