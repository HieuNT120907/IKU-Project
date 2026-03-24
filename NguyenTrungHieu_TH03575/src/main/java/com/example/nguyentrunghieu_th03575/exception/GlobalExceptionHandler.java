package com.example.nguyentrunghieu_th03575.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErroes = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErroes.put(fieldName, errorMessage);
        });
        Map<String, Object> response = new HashMap<>();
        response.put("code",400);
        response.put("message","Dữ liệu đầu vào không hợp lệ!");
        response.put("data", validationErroes);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomResourceNotFound.class)
    public ResponseEntity<Object> handleResourceNotFoundException(CustomResourceNotFound ex){
        Map<String, Object> response = new HashMap<>();
        response.put("code",HttpStatus.NOT_FOUND.value());
        response.put("message",ex.getMessage());
        response.put("data",null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("code",400);
        response.put("message",ex.getMessage());
        response.put("data",null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        Map<String, Object> response = new HashMap<>();
        response.put("code",500);
        response.put("message","Đã xảy ra lỗi hệ thống: " + ex.getMessage());
        response.put("data",null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
