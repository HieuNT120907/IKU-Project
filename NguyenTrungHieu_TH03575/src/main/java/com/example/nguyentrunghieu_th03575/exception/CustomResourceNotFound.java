package com.example.nguyentrunghieu_th03575.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomResourceNotFound extends RuntimeException {
    public CustomResourceNotFound(String message) {super(message);}
}
