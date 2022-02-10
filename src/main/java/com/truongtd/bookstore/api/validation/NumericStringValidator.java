package com.truongtd.bookstore.api.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumericStringValidator implements ConstraintValidator<NumbericString, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.isEmpty(str)) {
            if (!str.matches("[0-9]+")) {
                return false;
            }
        }
        return true;
    }
}
