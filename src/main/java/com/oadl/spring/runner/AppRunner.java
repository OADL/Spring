package com.oadl.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner, ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
      log.info("Custom Log: Application Runner");
    }

    @Override
    public void run(String... args) throws Exception {
      log.info("Custom Log: Command Line Runner");
    }
}
