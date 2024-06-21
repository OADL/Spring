package com.oadl.spring.exception.custom;

import org.springframework.http.HttpStatus;

public class ProblemException extends RuntimeException {
  private HttpStatus status;

  ProblemException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
