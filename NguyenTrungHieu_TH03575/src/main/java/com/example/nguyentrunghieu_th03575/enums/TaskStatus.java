package com.example.nguyentrunghieu_th03575.enums;

import lombok.Getter;

@Getter
public enum TaskStatus {
    TODO("Chờ thực hiện"),
    IN_PROGRESS("Đang triển khai"),
    DONE("Đã hoàn thành");

    private final String displayValue;

    TaskStatus(String displayValue) {
        this.displayValue = displayValue;
    }
}
