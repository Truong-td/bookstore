package com.truongtd.bookstore.api.validation;

import com.truongtd.bookstore.api.response.ApiResponse;

import java.lang.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateFormat.DateFormatValidator.class})
@Documented
public @interface DateFormat {
    String message() default "{error.numeric}";

    String format() default "YYYY-MM-DD HH:mm:ss";

    Class<?>[] groups() default {};

    Class<? extends ApiResponse.Payload>[] payload() default {};

    class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

        private String format;

        @Override
        public void initialize(DateFormat constraintAnnotation) {
            format = constraintAnnotation.format();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (value != null) {
                SimpleDateFormat formatter = new SimpleDateFormat(format);
                Date date = null;
                try {
                    date = formatter.parse(value);
                    if (!value.equals(formatter.format(date))) {
                        date = null;
                    }
                } catch (ParseException e) {
                }
                return date != null;
            }
            return true;
        }
    }
}
