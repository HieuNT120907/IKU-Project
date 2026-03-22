package com.example.nguyentrunghieu_th03575.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CustomErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
