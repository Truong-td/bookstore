package com.truongtd.bookstore.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NumericStringValidator.class})
public @interface NumbericString {
    String message() default "{error.numeric}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
