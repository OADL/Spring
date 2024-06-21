package com.oadl.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Interceptor {

  @Before("execution(* com.oadl.spring.controller.*.*(..))")
  public void aspectBefore() throws Throwable {
    log.info("Custom Log: Aspect before Request");
  }

}
