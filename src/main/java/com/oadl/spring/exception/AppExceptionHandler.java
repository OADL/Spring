package com.oadl.spring.exception;

import com.oadl.spring.exception.custom.ProblemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler {

  @ExceptionHandler(ProblemException.class)
  public ResponseEntity<Object> handleProblemException(ProblemException exception) {
    return ResponseEntity.status(exception.getStatus()).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \""+exception.getMessage()+ "\"}");
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<Object> handleAccessDeniedException(Exception exception) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \""+exception.getMessage()+ "\"}");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleException(Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \""+exception.getMessage()+ "\"}");
  }
}
