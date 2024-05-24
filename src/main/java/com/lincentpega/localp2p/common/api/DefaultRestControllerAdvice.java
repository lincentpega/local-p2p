package com.lincentpega.localp2p.common.api;

import com.lincentpega.localp2p.common.exceptions.LogicException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@Log4j2
@RestControllerAdvice
public class DefaultRestControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        if (ex.hasFieldErrors()) {
            List<ValidationError> validationErrors = ex.getFieldErrors().stream()
                    .map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
                    .toList();
            return ResponseEntity.badRequest().body(validationErrors);
        }
        List<ErrorResponse> errors = ex.getAllErrors().stream()
                .map(error -> new ErrorResponse(error.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(LogicException.class)
    public ResponseEntity<?> handleLogicException(LogicException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResourceFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error(e);
        return ResponseEntity.internalServerError().build();
    }
}
