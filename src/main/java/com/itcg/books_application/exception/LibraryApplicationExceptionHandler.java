package com.itcg.books_application.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LibraryApplicationExceptionHandler {
  @ExceptionHandler(value = BookNotFoundException.class)
  public ResponseEntity<String> handleBookNotFound(RuntimeException exception) {
    return ResponseEntity.badRequest().body(exception.getMessage());
  }
}
