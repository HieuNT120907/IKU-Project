package com.example.nguyentrunghieu_th03575.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DeadlineValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDeadline {
    String message() default "Deadline (Ngày đặt) phải lớn hơn ngày hiện tại!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
