package com.oadl.spring.exception.custom;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ProblemException {
  public NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message);
  }
}
