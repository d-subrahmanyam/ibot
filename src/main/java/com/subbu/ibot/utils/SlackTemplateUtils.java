package com.subbu.ibot.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
public class SlackTemplateUtils {

    public static String getTemplate(String filename) throws IOException {
        String _filename = String.format("classpath:slack/json/%s", filename);
        String content = FileUtils.readFileToString(ResourceUtils.getFile(_filename), "UTF-8");
        log.debug("template content - \n{}", content);
        return content;
    }
}
