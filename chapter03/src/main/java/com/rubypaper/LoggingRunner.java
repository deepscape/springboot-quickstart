package com.rubypaper;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingRunner implements ApplicationRunner {

    // private Logger logger = LoggerFactory.getLogger(LoggingRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.trace("TRACE Log Msg");
        log.debug("DEBUG Log Msg");
        log.info("INFO Log Msg");
        log.warn("WARN Log Msg");
        log.error("ERROR Log Msg");
    }
}
