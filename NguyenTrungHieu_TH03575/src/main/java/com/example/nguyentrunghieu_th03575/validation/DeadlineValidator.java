package com.example.nguyentrunghieu_th03575.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DeadlineValidator implements ConstraintValidator<ValidDeadline, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        return value.isAfter(LocalDate.now());
    }
}
