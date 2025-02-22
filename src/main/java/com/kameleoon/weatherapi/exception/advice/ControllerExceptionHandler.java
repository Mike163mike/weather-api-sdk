package com.kameleoon.weatherapi.exception.advice;

import com.kameleoon.weatherapi.conrtroller.WeatherReportController;
import com.kameleoon.weatherapi.exception.ExceptionResponse;
import com.kameleoon.weatherapi.exception.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionHandler {

    public static final String INVALID_FIELD_VALUES = "Invalid field values";

//    @ExceptionHandler(EmailNotUniqueException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public BadValidationResponse emailNotUnique(EmailNotUniqueException e) {
//        return new BadValidationResponse(
//                e.getMessage(),
//                INVALID_FIELD_VALUES,
//                List.of("email")
//        );
//    }
//
//    @ExceptionHandler(FindingException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ExceptionResponse findingException(FindingException e) {
//        return new ExceptionResponse("%s finding failure".formatted(e.getClazz()), concatMessages(e),
//                getSource(e.getSourceClazz(), e.getSourceMethod()));
//    }
//
//    @ExceptionHandler(DragException.class)
//    public ResponseEntity<ExceptionResponse> dragException(DragException e) {
//        return ResponseEntity
//                .status(e.getResponseStatus() != null ? e.getResponseStatus() : HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ExceptionResponse("%s drag failure".formatted(e.getClazz()), concatMessages(e),
//                        getSource(e.getSourceClazz(), e.getSourceMethod())));
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        String errorMessage = "Validation failed: " + Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return ResponseEntity
                .status(e.getStatusCode())
                .body(new ExceptionResponse(errorMessage, e.getCause().getMessage(),
                        WeatherReportController.class.getSimpleName()));
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ExceptionResponse> handleResponseException(ResponseException e) {
        return ResponseEntity
                .status(e.getResponseStatus())
                .body(new ExceptionResponse(e.getMessage(), e.getSourceClazz(), e.getSourceMethod()));
        }
}
